package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.common.PacketSignal;

public class OpenSignPacket implements BedrockPacket {
   private Vector3i position;
   private boolean frontSide;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.OPEN_SIGN;
   }

   public OpenSignPacket clone() {
      try {
         return (OpenSignPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public Vector3i getPosition() {
      return this.position;
   }

   public boolean isFrontSide() {
      return this.frontSide;
   }

   public void setPosition(final Vector3i position) {
      this.position = position;
   }

   public void setFrontSide(final boolean frontSide) {
      this.frontSide = frontSide;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OpenSignPacket)) {
         return false;
      }

      OpenSignPacket other = (OpenSignPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.frontSide != other.frontSide) {
         return false;
      }

      Object this$position = this.position;
      Object other$position = other.position;
      return this$position == null ? other$position == null : this$position.equals(other$position);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OpenSignPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.frontSide ? 79 : 97);
      Object $position = this.position;
      return result * 59 + ($position == null ? 43 : $position.hashCode());
   }

   @Override
   public String toString() {
      return "OpenSignPacket(position=" + this.position + ", frontSide=" + this.frontSide + ")";
   }
}
