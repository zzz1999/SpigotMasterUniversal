package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.common.PacketSignal;

public class SetSpawnPositionPacket implements BedrockPacket {
   private SetSpawnPositionPacket.Type spawnType;
   private Vector3i blockPosition;
   private int dimensionId;
   private Vector3i spawnPosition = Vector3i.from(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
   @Deprecated
   private boolean spawnForced;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_SPAWN_POSITION;
   }

   public SetSpawnPositionPacket clone() {
      try {
         return (SetSpawnPositionPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public SetSpawnPositionPacket.Type getSpawnType() {
      return this.spawnType;
   }

   public Vector3i getBlockPosition() {
      return this.blockPosition;
   }

   public int getDimensionId() {
      return this.dimensionId;
   }

   public Vector3i getSpawnPosition() {
      return this.spawnPosition;
   }

   @Deprecated
   public boolean isSpawnForced() {
      return this.spawnForced;
   }

   public void setSpawnType(final SetSpawnPositionPacket.Type spawnType) {
      this.spawnType = spawnType;
   }

   public void setBlockPosition(final Vector3i blockPosition) {
      this.blockPosition = blockPosition;
   }

   public void setDimensionId(final int dimensionId) {
      this.dimensionId = dimensionId;
   }

   public void setSpawnPosition(final Vector3i spawnPosition) {
      this.spawnPosition = spawnPosition;
   }

   @Deprecated
   public void setSpawnForced(final boolean spawnForced) {
      this.spawnForced = spawnForced;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetSpawnPositionPacket)) {
         return false;
      }

      SetSpawnPositionPacket other = (SetSpawnPositionPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.dimensionId != other.dimensionId) {
         return false;
      }

      if (this.spawnForced != other.spawnForced) {
         return false;
      }

      Object this$spawnType = this.spawnType;
      Object other$spawnType = other.spawnType;
      if (this$spawnType == null ? other$spawnType == null : this$spawnType.equals(other$spawnType)) {
         Object this$blockPosition = this.blockPosition;
         Object other$blockPosition = other.blockPosition;
         if (this$blockPosition == null ? other$blockPosition == null : this$blockPosition.equals(other$blockPosition)) {
            Object this$spawnPosition = this.spawnPosition;
            Object other$spawnPosition = other.spawnPosition;
            return this$spawnPosition == null ? other$spawnPosition == null : this$spawnPosition.equals(other$spawnPosition);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SetSpawnPositionPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.dimensionId;
      result = result * 59 + (this.spawnForced ? 79 : 97);
      Object $spawnType = this.spawnType;
      result = result * 59 + ($spawnType == null ? 43 : $spawnType.hashCode());
      Object $blockPosition = this.blockPosition;
      result = result * 59 + ($blockPosition == null ? 43 : $blockPosition.hashCode());
      Object $spawnPosition = this.spawnPosition;
      return result * 59 + ($spawnPosition == null ? 43 : $spawnPosition.hashCode());
   }

   @Override
   public String toString() {
      return "SetSpawnPositionPacket(spawnType="
         + this.spawnType
         + ", blockPosition="
         + this.blockPosition
         + ", dimensionId="
         + this.dimensionId
         + ", spawnPosition="
         + this.spawnPosition
         + ", spawnForced="
         + this.spawnForced
         + ")";
   }

   public enum Type {
      PLAYER_SPAWN,
      WORLD_SPAWN;
   }
}
