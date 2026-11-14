package org.cloudburstmc.netty.handler.codec.raknet.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicInteger;
import org.cloudburstmc.netty.channel.raknet.RakChildChannel;
import org.cloudburstmc.netty.channel.raknet.RakConstants;
import org.cloudburstmc.netty.channel.raknet.RakDisconnectReason;
import org.cloudburstmc.netty.channel.raknet.RakPriority;
import org.cloudburstmc.netty.channel.raknet.RakReliability;
import org.cloudburstmc.netty.channel.raknet.config.RakServerChannelConfig;
import org.cloudburstmc.netty.channel.raknet.packet.EncapsulatedPacket;
import org.cloudburstmc.netty.channel.raknet.packet.RakMessage;
import org.cloudburstmc.netty.util.RakUtils;

@ChannelHandler.Sharable
public class RakServerOnlineInitialHandler extends SimpleChannelInboundHandler<EncapsulatedPacket> {
   public static final String NAME = "rak-server-online-initial-handler";
   private static final InternalLogger log = InternalLoggerFactory.getInstance(RakServerOnlineInitialHandler.class);
   private final RakChildChannel channel;
   private final AtomicInteger retriesCounter = new AtomicInteger(5);

   public RakServerOnlineInitialHandler(RakChildChannel channel) {
      this.channel = channel;
   }

   protected void channelRead0(ChannelHandlerContext ctx, EncapsulatedPacket message) throws Exception {
      ByteBuf buf = message.getBuffer();
      int packetId = buf.getUnsignedByte(buf.readerIndex());
      switch (packetId) {
         case 9:
            this.onConnectionRequest(ctx, buf);
            break;
         case 19:
            buf.skipBytes(1);
            ctx.pipeline().remove(this);
            this.channel.eventLoop().execute(() -> {
               this.channel.setActive(true);
               this.channel.pipeline().fireChannelActive();
            });
            break;
         default:
            ctx.fireChannelRead(message.retain());
      }
   }

   private void onConnectionRequest(ChannelHandlerContext ctx, ByteBuf buffer) {
      buffer.skipBytes(1);
      long guid = this.channel.config().getGuid();
      long serverGuid = buffer.readLong();
      long timestamp = buffer.readLong();
      boolean security = buffer.readBoolean();
      if (this.retriesCounter.decrementAndGet() < 0) {
         this.sendConnectionRequestFailed(ctx, guid);
         log.warn("[{}] Connection request failed due to too many retries", this.channel.remoteAddress());
      } else if (serverGuid == guid && !security) {
         this.sendConnectionRequestAccepted(ctx, timestamp);
      } else {
         this.sendConnectionRequestFailed(ctx, guid);
      }
   }

   private void sendConnectionRequestAccepted(ChannelHandlerContext ctx, long time) {
      InetSocketAddress address = this.channel.remoteAddress();
      boolean ipv6 = address.getAddress() instanceof Inet6Address;
      ByteBuf outBuf = ctx.alloc().ioBuffer(ipv6 ? 628 : 166);
      outBuf.writeByte(16);
      RakUtils.writeAddress(outBuf, address);
      outBuf.writeShort(0);

      for (InetSocketAddress socketAddress : ipv6 ? RakConstants.LOCAL_IP_ADDRESSES_V6 : RakConstants.LOCAL_IP_ADDRESSES_V4) {
         RakUtils.writeAddress(outBuf, socketAddress);
      }

      outBuf.writeLong(time);
      outBuf.writeLong(System.currentTimeMillis());
      ctx.writeAndFlush(new RakMessage(outBuf, RakReliability.UNRELIABLE, RakPriority.IMMEDIATE));
   }

   private void sendConnectionRequestFailed(ChannelHandlerContext ctx, long guid) {
      ByteBuf magicBuf = ((RakServerChannelConfig)ctx.channel().config()).getUnconnectedMagic();
      int length = 9 + magicBuf.readableBytes();
      ByteBuf reply = ctx.alloc().ioBuffer(length);
      reply.writeByte(17);
      reply.writeBytes(magicBuf, magicBuf.readerIndex(), magicBuf.readableBytes());
      reply.writeLong(guid);
      this.sendRaw(ctx, reply);
      ctx.fireUserEventTriggered(RakDisconnectReason.CONNECTION_REQUEST_FAILED).close();
   }

   private void sendRaw(ChannelHandlerContext ctx, ByteBuf buf) {
      ctx.pipeline().context("rak-session-codec").writeAndFlush(buf);
   }
}
