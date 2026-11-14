package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class SetHealthPacket implements BedrockPacket {
   private int health;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_HEALTH;
   }

   public int getHealth() {
      return this.health;
   }

   public void setHealth(int health) {
      this.health = health;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetHealthPacket)) {
         return false;
      }

      SetHealthPacket other = (SetHealthPacket)o;
      return !other.canEqual(this) ? false : this.health == other.health;
   }

   protected boolean canEqual(Object other) {
      return other instanceof SetHealthPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.health;
   }

   @Override
   public String toString() {
      return "SetHealthPacket(health=" + this.health + ")";
   }
}
