package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

/** @deprecated */
public class RiderJumpPacket implements BedrockPacket {
   private int jumpStrength;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.RIDER_JUMP;
   }

   public RiderJumpPacket clone() {
      try {
         return (RiderJumpPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getJumpStrength() {
      return this.jumpStrength;
   }

   public void setJumpStrength(final int jumpStrength) {
      this.jumpStrength = jumpStrength;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RiderJumpPacket)) {
         return false;
      }

      RiderJumpPacket other = (RiderJumpPacket)o;
      return !other.canEqual(this) ? false : this.jumpStrength == other.jumpStrength;
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RiderJumpPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.jumpStrength;
   }

   @Override
   public String toString() {
      return "RiderJumpPacket(jumpStrength=" + this.jumpStrength + ")";
   }
}
