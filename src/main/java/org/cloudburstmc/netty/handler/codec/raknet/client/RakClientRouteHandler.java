package org.cloudburstmc.netty.handler.codec.raknet.client;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.PromiseCombiner;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import org.cloudburstmc.netty.channel.raknet.RakClientChannel;

public class RakClientRouteHandler extends ChannelDuplexHandler {
   public static final String NAME = "rak-client-route-handler";
   private final RakClientChannel channel;

   public RakClientRouteHandler(RakClientChannel channel) {
      this.channel = channel;
   }

   @Override
   public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
      if (!(remoteAddress instanceof InetSocketAddress)) {
         promise.tryFailure(new IllegalArgumentException("Provided remote address must be InetSocketAddress"));
      } else {
         if (this.channel.parent().isActive()) {
            throw new IllegalStateException("Channel is already bound!");
         }

         ChannelFuture parentFuture = this.channel.parent().connect(remoteAddress, localAddress);
         parentFuture.addListener(
            future -> {
               if (future.isSuccess()) {
                  this.channel
                     .rakPipeline()
                     .addAfter(
                        "rak-unconnected-pong-deencoder", "rak-client-handler", new RakClientOfflineHandler(this.channel, this.channel.getConnectPromise())
                     );
               }
            }
         );
         PromiseCombiner combiner = new PromiseCombiner(this.channel.eventLoop());
         combiner.add(parentFuture);
         combiner.add(this.channel.getConnectPromise());
         combiner.finish(promise);
      }
   }

   @Override
   public void read(ChannelHandlerContext ctx) throws Exception {
   }
}
