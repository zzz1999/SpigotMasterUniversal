package org.cloudburstmc.netty.channel.raknet.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import org.cloudburstmc.netty.channel.raknet.RakPriority;
import org.cloudburstmc.netty.channel.raknet.RakReliability;

public final class RakMessage extends DefaultByteBufHolder {
   private final RakReliability reliability;
   private final RakPriority priority;
   private final int channel;

   public RakMessage(ByteBuf payloadBuffer) {
      this(payloadBuffer, RakReliability.RELIABLE_ORDERED, RakPriority.NORMAL, 0);
   }

   public RakMessage(ByteBuf payloadBuffer, RakReliability reliability) {
      this(payloadBuffer, reliability, RakPriority.NORMAL, 0);
   }

   public RakMessage(ByteBuf payloadBuffer, RakReliability reliability, RakPriority priority) {
      this(payloadBuffer, reliability, priority, 0);
   }

   public RakMessage(ByteBuf payloadBuffer, RakReliability reliability, RakPriority priority, int channel) {
      super(payloadBuffer);
      this.reliability = reliability;
      this.priority = priority;
      this.channel = channel;
   }

   public RakReliability reliability() {
      return this.reliability;
   }

   public RakPriority priority() {
      return this.priority;
   }

   public int channel() {
      return this.channel;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }

      if (o != null && this.getClass() == o.getClass()) {
         RakMessage message = (RakMessage)o;
         if (this.reliability != message.reliability) {
            return false;
         } else if (this.priority != message.priority) {
            return false;
         } else {
            return this.channel != message.channel ? false : this.content().equals(message.content());
         }
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      int result = this.reliability.hashCode();
      result = 31 * result + this.priority.hashCode();
      result = 31 * result + this.channel;
      return 31 * result + this.content().hashCode();
   }

   public RakMessage copy() {
      return (RakMessage)super.copy();
   }

   public RakMessage duplicate() {
      return (RakMessage)super.duplicate();
   }

   public RakMessage retainedDuplicate() {
      return (RakMessage)super.retainedDuplicate();
   }

   public RakMessage replace(ByteBuf content) {
      return new RakMessage(content, this.reliability, this.priority, this.channel);
   }

   public RakMessage retain() {
      return (RakMessage)super.retain();
   }

   public RakMessage touch() {
      return (RakMessage)super.touch();
   }

   @Override
   public String toString() {
      return "RakMessage{reliability=" + this.reliability + ", priority=" + this.priority + ", channel=" + this.channel + "}";
   }
}
