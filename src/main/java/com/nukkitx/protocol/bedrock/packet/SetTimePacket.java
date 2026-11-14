package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class SetTimePacket implements BedrockPacket {
   private int time;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_TIME;
   }

   public int getTime() {
      return this.time;
   }

   public void setTime(int time) {
      this.time = time;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetTimePacket)) {
         return false;
      }

      SetTimePacket other = (SetTimePacket)o;
      return !other.canEqual(this) ? false : this.time == other.time;
   }

   protected boolean canEqual(Object other) {
      return other instanceof SetTimePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.time;
   }

   @Override
   public String toString() {
      return "SetTimePacket(time=" + this.time + ")";
   }
}
