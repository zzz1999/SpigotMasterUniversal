package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.common.PacketSignal;

public class SubChunkRequestPacket implements BedrockPacket {
   private int dimension;
   private Vector3i subChunkPosition;
   private List<Vector3i> positionOffsets = new ObjectArrayList<>();

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SUB_CHUNK_REQUEST;
   }

   public SubChunkRequestPacket clone() {
      try {
         return (SubChunkRequestPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getDimension() {
      return this.dimension;
   }

   public Vector3i getSubChunkPosition() {
      return this.subChunkPosition;
   }

   public List<Vector3i> getPositionOffsets() {
      return this.positionOffsets;
   }

   public void setDimension(final int dimension) {
      this.dimension = dimension;
   }

   public void setSubChunkPosition(final Vector3i subChunkPosition) {
      this.subChunkPosition = subChunkPosition;
   }

   public void setPositionOffsets(final List<Vector3i> positionOffsets) {
      this.positionOffsets = positionOffsets;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SubChunkRequestPacket)) {
         return false;
      } else {
         SubChunkRequestPacket other = (SubChunkRequestPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.dimension != other.dimension) {
            return false;
         } else {
            Object this$subChunkPosition = this.subChunkPosition;
            Object other$subChunkPosition = other.subChunkPosition;
            if (this$subChunkPosition == null ? other$subChunkPosition == null : this$subChunkPosition.equals(other$subChunkPosition)) {
               Object this$positionOffsets = this.positionOffsets;
               Object other$positionOffsets = other.positionOffsets;
               return this$positionOffsets == null ? other$positionOffsets == null : this$positionOffsets.equals(other$positionOffsets);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubChunkRequestPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.dimension;
      Object $subChunkPosition = this.subChunkPosition;
      result = result * 59 + ($subChunkPosition == null ? 43 : $subChunkPosition.hashCode());
      Object $positionOffsets = this.positionOffsets;
      return result * 59 + ($positionOffsets == null ? 43 : $positionOffsets.hashCode());
   }

   @Override
   public String toString() {
      return "SubChunkRequestPacket(dimension="
         + this.dimension
         + ", subChunkPosition="
         + this.subChunkPosition
         + ", positionOffsets="
         + this.positionOffsets
         + ")";
   }
}
