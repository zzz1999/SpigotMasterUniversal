package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class ChunkRadiusUpdatedPacket implements BedrockPacket {
   private int radius;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CHUNK_RADIUS_UPDATED;
   }

   public ChunkRadiusUpdatedPacket clone() {
      try {
         return (ChunkRadiusUpdatedPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getRadius() {
      return this.radius;
   }

   public void setRadius(final int radius) {
      this.radius = radius;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ChunkRadiusUpdatedPacket)) {
         return false;
      }

      ChunkRadiusUpdatedPacket other = (ChunkRadiusUpdatedPacket)o;
      return !other.canEqual(this) ? false : this.radius == other.radius;
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ChunkRadiusUpdatedPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.radius;
   }

   @Override
   public String toString() {
      return "ChunkRadiusUpdatedPacket(radius=" + this.radius + ")";
   }
}
