package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

@Deprecated
public class ScriptCustomEventPacket implements BedrockPacket {
   private String eventName;
   private String data;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SCRIPT_CUSTOM_EVENT;
   }

   public String getEventName() {
      return this.eventName;
   }

   public String getData() {
      return this.data;
   }

   public void setEventName(String eventName) {
      this.eventName = eventName;
   }

   public void setData(String data) {
      this.data = data;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ScriptCustomEventPacket)) {
         return false;
      } else {
         ScriptCustomEventPacket other = (ScriptCustomEventPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$eventName = this.eventName;
            Object other$eventName = other.eventName;
            if (this$eventName == null ? other$eventName == null : this$eventName.equals(other$eventName)) {
               Object this$data = this.data;
               Object other$data = other.data;
               return this$data == null ? other$data == null : this$data.equals(other$data);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof ScriptCustomEventPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $eventName = this.eventName;
      result = result * 59 + ($eventName == null ? 43 : $eventName.hashCode());
      Object $data = this.data;
      return result * 59 + ($data == null ? 43 : $data.hashCode());
   }

   @Override
   public String toString() {
      return "ScriptCustomEventPacket(eventName=" + this.eventName + ", data=" + this.data + ")";
   }
}
