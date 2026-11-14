package org.cloudburstmc.netty.handler.codec.raknet.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import org.cloudburstmc.netty.channel.raknet.RakChildChannel;
import org.cloudburstmc.netty.channel.raknet.RakServerChannel;
import org.cloudburstmc.netty.channel.raknet.config.RakMetrics;

public class RakServerRouteHandler extends ChannelDuplexHandler {
   public static final String NAME = "rak-server-route-handler";
   private final RakServerChannel parent;

   public RakServerRouteHandler(RakServerChannel parent) {
      this.parent = parent;
   }

   @Override
   public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
      if (!(msg instanceof DatagramPacket)) {
         ctx.fireChannelRead(msg);
      } else {
         DatagramPacket packet = (DatagramPacket)msg;

         try {
            RakChildChannel channel = this.parent.getChildChannel(packet.sender());
            if (channel != null) {
               RakMetrics metrics = channel.config().getMetrics();
               if (metrics != null) {
                  metrics.bytesIn(packet.content().readableBytes());
               }

               ByteBuf buffer = packet.content().retain();
               channel.rakPipeline().fireChannelRead(buffer).fireChannelReadComplete();
               return;
            }

            ctx.fireChannelRead(packet.retain());
         } finally {
            packet.release();
         }
      }
   }
}
