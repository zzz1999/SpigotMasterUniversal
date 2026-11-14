package org.cloudburstmc.netty.handler.codec.raknet.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.concurrent.ScheduledFuture;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;
import org.cloudburstmc.netty.channel.raknet.RakChannel;
import org.cloudburstmc.netty.channel.raknet.RakDisconnectReason;
import org.cloudburstmc.netty.channel.raknet.RakOfflineState;
import org.cloudburstmc.netty.channel.raknet.config.RakChannelOption;
import org.cloudburstmc.netty.handler.codec.raknet.common.ConnectedPingHandler;
import org.cloudburstmc.netty.handler.codec.raknet.common.ConnectedPongHandler;
import org.cloudburstmc.netty.handler.codec.raknet.common.DisconnectNotificationHandler;
import org.cloudburstmc.netty.handler.codec.raknet.common.EncapsulatedToMessageHandler;
import org.cloudburstmc.netty.handler.codec.raknet.common.RakAcknowledgeHandler;
import org.cloudburstmc.netty.handler.codec.raknet.common.RakDatagramCodec;
import org.cloudburstmc.netty.handler.codec.raknet.common.RakSessionCodec;
import org.cloudburstmc.netty.util.RakUtils;

public class RakClientOfflineHandler extends SimpleChannelInboundHandler<ByteBuf> {
   public static final String NAME = "rak-client-handler";
   private final RakChannel rakChannel;
   private final ChannelPromise successPromise;
   private ScheduledFuture<?> timeoutFuture;
   private ScheduledFuture<?> retryFuture;
   private RakOfflineState state = RakOfflineState.HANDSHAKE_1;
   private int connectionAttempts;

   public RakClientOfflineHandler(RakChannel rakChannel, ChannelPromise promise) {
      this.rakChannel = rakChannel;
      this.successPromise = promise;
   }

   @Override
   public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
      Channel channel = ctx.channel();
      long timeout = this.rakChannel.config().getOption(RakChannelOption.RAK_CONNECT_TIMEOUT);
      this.timeoutFuture = channel.eventLoop().schedule(this::onTimeout, timeout, TimeUnit.MILLISECONDS);
      this.retryFuture = channel.eventLoop().scheduleAtFixedRate(() -> this.onRetryAttempt(channel), 0L, 1L, TimeUnit.SECONDS);
      this.successPromise.addListener(future -> safeCancel(this.timeoutFuture, channel));
      this.successPromise.addListener(future -> safeCancel(this.retryFuture, channel));
      this.retryFuture.addListener(future -> {
         if (future.cause() != null) {
            this.successPromise.tryFailure(future.cause());
         }
      });
   }

   @Override
   public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
      safeCancel(this.timeoutFuture, ctx.channel());
      safeCancel(this.retryFuture, ctx.channel());
   }

   private void onRetryAttempt(Channel channel) {
      switch (this.state) {
         case HANDSHAKE_1:
            this.sendOpenConnectionRequest1(channel);
            this.connectionAttempts++;
            break;
         case HANDSHAKE_2:
            this.sendOpenConnectionRequest2(channel);
      }
   }

   private void onTimeout() {
      this.successPromise.tryFailure(new ConnectTimeoutException());
   }

   private void onSuccess(ChannelHandlerContext ctx) {
      RakSessionCodec sessionCodec = new RakSessionCodec(this.rakChannel);
      ctx.pipeline().addAfter("rak-client-handler", "rak-datagram-codec", new RakDatagramCodec());
      ctx.pipeline().addAfter("rak-datagram-codec", "rak-acknowledge-handler", new RakAcknowledgeHandler(sessionCodec));
      ctx.pipeline().addAfter("rak-acknowledge-handler", "rak-session-codec", sessionCodec);
      ctx.pipeline().addAfter("rak-session-codec", "rak-connected-ping-handler", new ConnectedPingHandler());
      ctx.pipeline().addAfter("rak-connected-ping-handler", "rak-connected-pong-handler", new ConnectedPongHandler(sessionCodec));
      ctx.pipeline().addAfter("rak-connected-pong-handler", "rak-disconnect-notification-handler", DisconnectNotificationHandler.INSTANCE);
      ctx.pipeline().addAfter("rak-disconnect-notification-handler", "encapsulated-to-message", EncapsulatedToMessageHandler.INSTANCE);
      ctx.pipeline()
         .addAfter(
            "rak-disconnect-notification-handler", "rak-client-online-initial-handler", new RakClientOnlineInitialHandler(this.rakChannel, this.successPromise)
         );
      ctx.pipeline().fireChannelActive();
   }

   protected void channelRead0(ChannelHandlerContext ctx, ByteBuf buf) throws Exception {
      if (buf.isReadable()) {
         if (this.state == RakOfflineState.HANDSHAKE_COMPLETED) {
            ctx.fireChannelRead(buf.retain());
         } else {
            short packetId = buf.readUnsignedByte();
            ByteBuf magicBuf = this.rakChannel.config().getOption(RakChannelOption.RAK_UNCONNECTED_MAGIC);
            if (buf.isReadable(magicBuf.readableBytes()) && ByteBufUtil.equals(buf.readSlice(magicBuf.readableBytes()), magicBuf)) {
               switch (packetId) {
                  case 6:
                     this.onOpenConnectionReply1(ctx, buf);
                     return;
                  case 8:
                     this.onOpenConnectionReply2(ctx, buf);
                     this.onSuccess(ctx);
                     return;
                  case 18:
                     this.rakChannel.pipeline().fireUserEventTriggered(RakDisconnectReason.ALREADY_CONNECTED);
                     this.successPromise.tryFailure(new ChannelException("Already connected"));
                     return;
                  case 20:
                     this.rakChannel.pipeline().fireUserEventTriggered(RakDisconnectReason.NO_FREE_INCOMING_CONNECTIONS);
                     this.successPromise.tryFailure(new ChannelException("No free incoming connections"));
                     return;
                  case 25:
                     this.rakChannel.pipeline().fireUserEventTriggered(RakDisconnectReason.INCOMPATIBLE_PROTOCOL_VERSION);
                     this.successPromise.tryFailure(new IllegalStateException("Incompatible raknet version"));
                     return;
                  case 26:
                     this.rakChannel.pipeline().fireUserEventTriggered(RakDisconnectReason.IP_RECENTLY_CONNECTED);
                     this.successPromise.tryFailure(new ChannelException("Address recently connected"));
                     return;
               }
            } else {
               this.successPromise.tryFailure(new CorruptedFrameException("RakMagic does not match"));
            }
         }
      }
   }

   private void onOpenConnectionReply1(ChannelHandlerContext ctx, ByteBuf buffer) {
      long serverGuid = buffer.readLong();
      boolean security = buffer.readBoolean();
      int mtu = buffer.readShort();
      if (security) {
         this.successPromise.tryFailure(new SecurityException());
      } else {
         this.rakChannel.config().setOption(RakChannelOption.RAK_MTU, mtu);
         this.rakChannel.config().setOption(RakChannelOption.RAK_REMOTE_GUID, serverGuid);
         this.state = RakOfflineState.HANDSHAKE_2;
         this.sendOpenConnectionRequest2(ctx.channel());
      }
   }

   private void onOpenConnectionReply2(ChannelHandlerContext ctx, ByteBuf buffer) {
      buffer.readLong();
      RakUtils.readAddress(buffer);
      int mtu = buffer.readShort();
      buffer.readBoolean();
      this.rakChannel.config().setOption(RakChannelOption.RAK_MTU, mtu);
      this.state = RakOfflineState.HANDSHAKE_COMPLETED;
   }

   private void sendOpenConnectionRequest1(Channel channel) {
      int mtuDiff = 91;
      int mtuSize = this.rakChannel.config().getOption(RakChannelOption.RAK_MTU) - this.connectionAttempts * mtuDiff;
      if (mtuSize < 576) {
         mtuSize = 576;
      }

      ByteBuf magicBuf = this.rakChannel.config().getOption(RakChannelOption.RAK_UNCONNECTED_MAGIC);
      int rakVersion = this.rakChannel.config().getOption(RakChannelOption.RAK_PROTOCOL_VERSION);
      InetSocketAddress address = (InetSocketAddress)this.rakChannel.remoteAddress();
      ByteBuf request = channel.alloc().ioBuffer(mtuSize);
      request.writeByte(5);
      request.writeBytes(magicBuf.slice(), magicBuf.readableBytes());
      request.writeByte(rakVersion);
      request.writeZero(mtuSize - 1 - magicBuf.readableBytes() - 1 - (address.getAddress() instanceof Inet6Address ? 40 : 20) - 8);
      channel.writeAndFlush(request);
   }

   private void sendOpenConnectionRequest2(Channel channel) {
      int mtuSize = this.rakChannel.config().getOption(RakChannelOption.RAK_MTU);
      ByteBuf magicBuf = this.rakChannel.config().getOption(RakChannelOption.RAK_UNCONNECTED_MAGIC);
      ByteBuf request = channel.alloc().ioBuffer(34);
      request.writeByte(7);
      request.writeBytes(magicBuf, magicBuf.readerIndex(), magicBuf.readableBytes());
      RakUtils.writeAddress(request, (InetSocketAddress)channel.remoteAddress());
      request.writeShort(mtuSize);
      request.writeLong(this.rakChannel.config().getOption(RakChannelOption.RAK_GUID));
      channel.writeAndFlush(request);
   }

   private static void safeCancel(ScheduledFuture<?> future, Channel channel) {
      channel.eventLoop().execute(() -> {
         if (!future.isCancelled()) {
            future.cancel(false);
         }
      });
   }
}
