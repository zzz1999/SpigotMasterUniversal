package org.cloudburstmc.netty.handler.codec.raknet.common;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.PlatformDependent;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import org.cloudburstmc.netty.channel.raknet.RakChannel;
import org.cloudburstmc.netty.channel.raknet.packet.EncapsulatedPacket;

public class RakUnhandledMessagesQueue extends SimpleChannelInboundHandler<EncapsulatedPacket> {
   public static final String NAME = "rak-unhandled-messages-queue";
   private final RakChannel channel;
   private final Queue<EncapsulatedPacket> messages = PlatformDependent.newMpscQueue();
   private ScheduledFuture<?> future;

   public RakUnhandledMessagesQueue(RakChannel channel) {
      this.channel = channel;
   }

   @Override
   public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
      this.future = ctx.channel().eventLoop().scheduleAtFixedRate(() -> this.trySendMessages(ctx), 0L, 50L, TimeUnit.MILLISECONDS);
   }

   @Override
   public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
      if (this.future != null) {
         this.future.cancel(false);
      }

      EncapsulatedPacket message;
      while ((message = this.messages.poll()) != null) {
         ReferenceCountUtil.release(message);
      }
   }

   private void trySendMessages(ChannelHandlerContext ctx) {
      if (this.channel.isActive()) {
         EncapsulatedPacket message;
         while ((message = this.messages.poll()) != null) {
            ctx.fireChannelRead(message);
         }

         ctx.pipeline().remove(this);
      }
   }

   protected void channelRead0(ChannelHandlerContext ctx, EncapsulatedPacket msg) throws Exception {
      if (!this.channel.isActive()) {
         this.messages.offer(msg.retain());
      } else {
         this.trySendMessages(ctx);
         ctx.fireChannelRead(msg.retain());
      }
   }
}
