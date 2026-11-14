package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.SimpleEventType;
import com.nukkitx.protocol.common.PacketSignal;

public class SimpleEventPacket implements BedrockPacket {
   private SimpleEventType event;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SIMPLE_EVENT;
   }

   public SimpleEventType getEvent() {
      return this.event;
   }

   public void setEvent(SimpleEventType event) {
      this.event = event;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SimpleEventPacket)) {
         return false;
      }

      SimpleEventPacket other = (SimpleEventPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$event = this.event;
      Object other$event = other.event;
      return this$event == null ? other$event == null : this$event.equals(other$event);
   }

   protected boolean canEqual(Object other) {
      return other instanceof SimpleEventPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $event = this.event;
      return result * 59 + ($event == null ? 43 : $event.hashCode());
   }

   @Override
   public String toString() {
      return "SimpleEventPacket(event=" + this.event + ")";
   }
}
