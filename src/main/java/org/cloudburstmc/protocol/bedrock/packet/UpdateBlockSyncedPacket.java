package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.BlockSyncType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class UpdateBlockSyncedPacket extends UpdateBlockPacket {
   private long runtimeEntityId;
   private BlockSyncType entityBlockSyncType;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.UPDATE_BLOCK_SYNCED;
   }

   @Override
   public String toString() {
      return "UpdateBlockSyncedPacket(runtimeEntityId="
         + this.runtimeEntityId
         + ", entityBlockSyncType="
         + this.entityBlockSyncType
         + ", flags="
         + this.flags
         + ", blockPosition="
         + this.blockPosition
         + ", definition="
         + this.definition
         + ", dataLayer="
         + this.dataLayer
         + ")";
   }

   public UpdateBlockSyncedPacket clone() {
      return (UpdateBlockSyncedPacket)super.clone();
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public BlockSyncType getEntityBlockSyncType() {
      return this.entityBlockSyncType;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setEntityBlockSyncType(final BlockSyncType entityBlockSyncType) {
      this.entityBlockSyncType = entityBlockSyncType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UpdateBlockSyncedPacket)) {
         return false;
      }

      UpdateBlockSyncedPacket other = (UpdateBlockSyncedPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      Object this$entityBlockSyncType = this.entityBlockSyncType;
      Object other$entityBlockSyncType = other.entityBlockSyncType;
      return this$entityBlockSyncType == null ? other$entityBlockSyncType == null : this$entityBlockSyncType.equals(other$entityBlockSyncType);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof UpdateBlockSyncedPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      Object $entityBlockSyncType = this.entityBlockSyncType;
      return result * 59 + ($entityBlockSyncType == null ? 43 : $entityBlockSyncType.hashCode());
   }
}
