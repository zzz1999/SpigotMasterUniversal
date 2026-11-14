package org.cloudburstmc.netty.handler.codec.raknet.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;
import org.cloudburstmc.netty.channel.raknet.RakChildChannel;
import org.cloudburstmc.netty.channel.raknet.RakPing;
import org.cloudburstmc.netty.channel.raknet.RakServerChannel;
import org.cloudburstmc.netty.channel.raknet.config.RakChannelOption;
import org.cloudburstmc.netty.handler.codec.raknet.AdvancedChannelInboundHandler;
import org.cloudburstmc.netty.util.RakUtils;

public class RakServerOfflineHandler extends AdvancedChannelInboundHandler<DatagramPacket> {
   public static final String NAME = "rak-offline-handler";
   private static final InternalLogger log = InternalLoggerFactory.getInstance(RakServerOfflineHandler.class);
   private final ExpiringMap<InetSocketAddress, Integer> pendingConnections = ExpiringMap.builder()
      .expiration(10L, TimeUnit.SECONDS)
      .expirationPolicy(ExpirationPolicy.CREATED)
      .<Object, Object>expirationListener((key, value) -> ReferenceCountUtil.release(value))
      .build();
   private final ExpiringMap<InetAddress, AtomicInteger> packetsCounter = ExpiringMap.builder()
      .expiration(1L, TimeUnit.SECONDS)
      .expirationPolicy(ExpirationPolicy.CREATED)
      .build();
   private final RakServerChannel channel;

   public RakServerOfflineHandler(RakServerChannel channel) {
      this.channel = channel;
   }

   @Override
   protected boolean acceptInboundMessage(ChannelHandlerContext ctx, Object msg) throws Exception {
      if (!super.acceptInboundMessage(ctx, msg)) {
         return false;
      }

      DatagramPacket packet = (DatagramPacket)msg;
      ByteBuf buf = packet.content();
      if (!buf.isReadable()) {
         return false;
      }

      int startIndex = buf.readerIndex();

      try {
         int packetId = buf.readUnsignedByte();
         switch (packetId) {
            case 1:
               if (buf.isReadable(8)) {
                  buf.readLong();
               }
            case 5:
            case 7:
               break;
            default:
               return false;
         }

         ByteBuf magicBuf = ctx.channel().config().getOption(RakChannelOption.RAK_UNCONNECTED_MAGIC);
         return buf.isReadable(magicBuf.readableBytes()) && ByteBufUtil.equals(buf.readSlice(magicBuf.readableBytes()), magicBuf);
      } finally {
         buf.readerIndex(startIndex);
      }
   }

   protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
      ByteBuf buf = packet.content();
      short packetId = buf.readUnsignedByte();
      ByteBuf magicBuf = ctx.channel().config().getOption(RakChannelOption.RAK_UNCONNECTED_MAGIC);
      long guid = ctx.channel().config().getOption(RakChannelOption.RAK_GUID);
      AtomicInteger counter = this.packetsCounter.computeIfAbsent(packet.sender().getAddress(), s -> new AtomicInteger());
      if (counter.incrementAndGet() > this.channel.config().getUnconnectedPacketLimit()) {
         log.warn("[{}] Sent too many packets per second", packet.sender());
         this.channel.tryBlockAddress(packet.sender().getAddress(), 10L, TimeUnit.SECONDS);
      } else {
         switch (packetId) {
            case 1:
               this.onUnconnectedPing(ctx, packet, magicBuf, guid);
               break;
            case 5:
               this.onOpenConnectionRequest1(ctx, packet, magicBuf, guid);
               break;
            case 7:
               this.onOpenConnectionRequest2(ctx, packet, magicBuf, guid);
         }
      }
   }

   private void onUnconnectedPing(ChannelHandlerContext ctx, DatagramPacket packet, ByteBuf magicBuf, long guid) {
      long pingTime = packet.content().readLong();
      boolean handlePing = ctx.channel().config().getOption(RakChannelOption.RAK_HANDLE_PING);
      if (handlePing) {
         ctx.fireChannelRead(new RakPing(pingTime, packet.sender()));
      } else {
         ByteBuf advertisement = ctx.channel().config().getOption(RakChannelOption.RAK_ADVERTISEMENT);
         int packetLength = 35 + (advertisement != null ? advertisement.readableBytes() : -2);
         ByteBuf out = ctx.alloc().ioBuffer(packetLength);
         out.writeByte(28);
         out.writeLong(pingTime);
         out.writeLong(guid);
         out.writeBytes(magicBuf, magicBuf.readerIndex(), magicBuf.readableBytes());
         if (advertisement != null) {
            out.writeShort(advertisement.readableBytes());
            out.writeBytes(advertisement, advertisement.readerIndex(), advertisement.readableBytes());
         }

         ctx.writeAndFlush(new DatagramPacket(out, packet.sender()));
      }
   }

   private void onOpenConnectionRequest1(ChannelHandlerContext ctx, DatagramPacket packet, ByteBuf magicBuf, long guid) {
      ByteBuf buffer = packet.content();
      InetSocketAddress sender = packet.sender();
      buffer.skipBytes(magicBuf.readableBytes());
      int protocolVersion = buffer.readUnsignedByte();
      int mtu = buffer.readableBytes() + 1 + magicBuf.readableBytes() + 1 + (sender.getAddress() instanceof Inet6Address ? 40 : 20) + 8;
      int[] supportedProtocols = ctx.channel().config().getOption(RakChannelOption.RAK_SUPPORTED_PROTOCOLS);
      if (supportedProtocols != null && Arrays.binarySearch(supportedProtocols, protocolVersion) < 0) {
         int latestVersion = supportedProtocols[supportedProtocols.length - 1];
         this.sendIncompatibleVersion(ctx, packet.sender(), latestVersion, magicBuf, guid);
      } else {
         Integer version = this.pendingConnections.put(sender, protocolVersion);
         if (version != null && log.isTraceEnabled()) {
            log.trace("Received duplicate open connection request 1 from {}", sender);
         }

         ByteBuf replyBuffer = ctx.alloc().ioBuffer(28, 28);
         replyBuffer.writeByte(6);
         replyBuffer.writeBytes(magicBuf, magicBuf.readerIndex(), magicBuf.readableBytes());
         replyBuffer.writeLong(guid);
         replyBuffer.writeBoolean(false);
         replyBuffer.writeShort(
            RakUtils.clamp(mtu, ctx.channel().config().getOption(RakChannelOption.RAK_MIN_MTU), ctx.channel().config().getOption(RakChannelOption.RAK_MAX_MTU))
         );
         ctx.writeAndFlush(new DatagramPacket(replyBuffer, sender));
      }
   }

   private void onOpenConnectionRequest2(ChannelHandlerContext ctx, DatagramPacket packet, ByteBuf magicBuf, long guid) {
      ByteBuf buffer = packet.content();
      InetSocketAddress sender = packet.sender();
      buffer.skipBytes(magicBuf.readableBytes());
      Integer version = this.pendingConnections.remove(sender);
      if (version == null) {
         if (log.isTraceEnabled()) {
            log.trace("Received open connection request 2 from {} without open connection request 1", sender);
         }

         int[] supportedProtocols = ctx.channel().config().getOption(RakChannelOption.RAK_SUPPORTED_PROTOCOLS);
         int latestVersion = supportedProtocols == null ? 11 : supportedProtocols[supportedProtocols.length - 1];
         this.sendIncompatibleVersion(ctx, sender, latestVersion, magicBuf, guid);
      } else {
         InetSocketAddress serverAddress = RakUtils.readAddress(buffer);
         int mtu = buffer.readUnsignedShort();
         long clientGuid = buffer.readLong();
         if (mtu >= ctx.channel().config().getOption(RakChannelOption.RAK_MIN_MTU) && mtu <= ctx.channel().config().getOption(RakChannelOption.RAK_MAX_MTU)) {
            RakServerChannel serverChannel = (RakServerChannel)ctx.channel();
            RakChildChannel channel = serverChannel.createChildChannel(sender, clientGuid, version, mtu);
            if (channel == null) {
               this.sendAlreadyConnected(ctx, sender, magicBuf, guid);
            } else {
               ByteBuf replyBuffer = ctx.alloc().ioBuffer(31);
               replyBuffer.writeByte(8);
               replyBuffer.writeBytes(magicBuf, magicBuf.readerIndex(), magicBuf.readableBytes());
               replyBuffer.writeLong(guid);
               RakUtils.writeAddress(replyBuffer, packet.sender());
               replyBuffer.writeShort(mtu);
               replyBuffer.writeBoolean(false);
               ctx.writeAndFlush(new DatagramPacket(replyBuffer, packet.sender()));
            }
         } else {
            this.sendAlreadyConnected(ctx, sender, magicBuf, guid);
         }
      }
   }

   private void sendIncompatibleVersion(ChannelHandlerContext ctx, InetSocketAddress sender, int protocolVersion, ByteBuf magicBuf, long guid) {
      ByteBuf buffer = ctx.alloc().ioBuffer(26, 26);
      buffer.writeByte(25);
      buffer.writeByte(protocolVersion);
      buffer.writeBytes(magicBuf, magicBuf.readerIndex(), magicBuf.readableBytes());
      buffer.writeLong(guid);
      ctx.writeAndFlush(new DatagramPacket(buffer, sender));
   }

   private void sendAlreadyConnected(ChannelHandlerContext ctx, InetSocketAddress sender, ByteBuf magicBuf, long guid) {
      ByteBuf buffer = ctx.alloc().ioBuffer(25, 25);
      buffer.writeByte(18);
      buffer.writeBytes(magicBuf, magicBuf.readerIndex(), magicBuf.readableBytes());
      buffer.writeLong(guid);
      ctx.writeAndFlush(new DatagramPacket(buffer, sender));
   }
}
