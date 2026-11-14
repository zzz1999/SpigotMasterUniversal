package org.cloudburstmc.netty.channel.raknet;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultChannelPipeline;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.cloudburstmc.netty.channel.raknet.packet.EncapsulatedPacket;

public class RakChannelPipeline extends DefaultChannelPipeline {
   private static final InternalLogger log = InternalLoggerFactory.getInstance(RakChannelPipeline.class);
   private final RakChildChannel child;

   protected RakChannelPipeline(Channel parent, RakChildChannel child) {
      super(parent);
      this.child = child;
   }

   @Override
   protected void onUnhandledInboundChannelActive() {
   }

   @Override
   protected void onUnhandledInboundChannelInactive() {
      if (this.child.isActive()) {
         this.child.setActive(false);
         this.child.pipeline().fireChannelInactive();
      }
   }

   @Override
   protected void onUnhandledInboundMessage(ChannelHandlerContext ctx, Object msg) {
      try {
         Object message = msg instanceof EncapsulatedPacket ? ((EncapsulatedPacket)msg).toMessage() : msg;
         ReferenceCountUtil.retain(message);
         if (this.child.eventLoop().inEventLoop()) {
            this.child.pipeline().fireChannelRead(message).fireChannelReadComplete();
         } else {
            this.child.eventLoop().execute(() -> this.child.pipeline().fireChannelRead(message).fireChannelReadComplete());
         }
      } finally {
         ReferenceCountUtil.release(msg);
      }
   }

   @Override
   protected void onUnhandledInboundUserEventTriggered(Object evt) {
      this.child.pipeline().fireUserEventTriggered(evt);
      if (evt instanceof RakDisconnectReason) {
         this.child.close();
      }
   }

   @Override
   protected void onUnhandledInboundException(Throwable cause) {
      log.error("Exception thrown in RakNet pipeline", cause);
   }
}
