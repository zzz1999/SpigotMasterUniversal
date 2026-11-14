package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.common.PacketSignal;

public class AnvilDamagePacket implements BedrockPacket {
   private int damage;
   private Vector3i position;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ANVIL_DAMAGE;
   }

   public AnvilDamagePacket clone() {
      try {
         return (AnvilDamagePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getDamage() {
      return this.damage;
   }

   public Vector3i getPosition() {
      return this.position;
   }

   public void setDamage(final int damage) {
      this.damage = damage;
   }

   public void setPosition(final Vector3i position) {
      this.position = position;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AnvilDamagePacket)) {
         return false;
      }

      AnvilDamagePacket other = (AnvilDamagePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.damage != other.damage) {
         return false;
      }

      Object this$position = this.position;
      Object other$position = other.position;
      return this$position == null ? other$position == null : this$position.equals(other$position);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AnvilDamagePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.damage;
      Object $position = this.position;
      return result * 59 + ($position == null ? 43 : $position.hashCode());
   }

   @Override
   public String toString() {
      return "AnvilDamagePacket(damage=" + this.damage + ", position=" + this.position + ")";
   }
}
