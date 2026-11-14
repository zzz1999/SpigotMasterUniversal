package org.cloudburstmc.netty.handler.codec.raknet.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.DatagramPacket;
import org.cloudburstmc.netty.channel.raknet.RakClientChannel;
import org.cloudburstmc.netty.channel.raknet.config.RakMetrics;

public class RakClientProxyRouteHandler extends ChannelDuplexHandler {
   public static final String NAME = "rak-client-proxy-route-handler";
   private final RakClientChannel channel;

   public RakClientProxyRouteHandler(RakClientChannel channel) {
      this.channel = channel;
   }

   @Override
   public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
      if (!(msg instanceof DatagramPacket)) {
         ctx.fireChannelRead(msg);
      } else {
         DatagramPacket packet = (DatagramPacket)msg;
         RakMetrics metrics = this.channel.config().getMetrics();
         if (metrics != null) {
            metrics.bytesIn(packet.content().readableBytes());
         }

         DatagramPacket datagram = packet.retain();

         try {
            if (packet.sender() != null && !packet.sender().equals(this.channel.remoteAddress())) {
               ctx.fireChannelRead(datagram);
            } else {
               ctx.fireChannelRead(datagram.content());
            }
         } finally {
            datagram.release();
         }
      }
   }

   @Override
   public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
      boolean isDatagram = msg instanceof DatagramPacket;
      if (!isDatagram && !(msg instanceof ByteBuf)) {
         ctx.write(msg, promise);
      } else {
         DatagramPacket datagram = isDatagram ? (DatagramPacket)msg : new DatagramPacket((ByteBuf)msg, this.channel.remoteAddress());
         RakMetrics metrics = this.channel.config().getMetrics();
         if (metrics != null) {
            metrics.bytesOut(datagram.content().readableBytes());
         }

         ctx.write(datagram, promise);
      }
   }
}
