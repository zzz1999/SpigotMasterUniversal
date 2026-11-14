package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class HurtArmorPacket implements BedrockPacket {
   private int cause;
   private int damage;
   private long armorSlots;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.HURT_ARMOR;
   }

   public HurtArmorPacket clone() {
      try {
         return (HurtArmorPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getCause() {
      return this.cause;
   }

   public int getDamage() {
      return this.damage;
   }

   public long getArmorSlots() {
      return this.armorSlots;
   }

   public void setCause(final int cause) {
      this.cause = cause;
   }

   public void setDamage(final int damage) {
      this.damage = damage;
   }

   public void setArmorSlots(final long armorSlots) {
      this.armorSlots = armorSlots;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof HurtArmorPacket)) {
         return false;
      } else {
         HurtArmorPacket other = (HurtArmorPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.cause != other.cause) {
            return false;
         } else {
            return this.damage != other.damage ? false : this.armorSlots == other.armorSlots;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof HurtArmorPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.cause;
      result = result * 59 + this.damage;
      long $armorSlots = this.armorSlots;
      return result * 59 + (int)($armorSlots >>> 32 ^ $armorSlots);
   }

   @Override
   public String toString() {
      return "HurtArmorPacket(cause=" + this.cause + ", damage=" + this.damage + ", armorSlots=" + this.armorSlots + ")";
   }
}
