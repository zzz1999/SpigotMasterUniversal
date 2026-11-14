package org.cloudburstmc.protocol.bedrock.data.camera;

import org.cloudburstmc.math.vector.Vector3f;

public class CameraTargetInstruction {
   private Vector3f targetCenterOffset;
   private long uniqueEntityId;

   public Vector3f getTargetCenterOffset() {
      return this.targetCenterOffset;
   }

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public void setTargetCenterOffset(final Vector3f targetCenterOffset) {
      this.targetCenterOffset = targetCenterOffset;
   }

   public void setUniqueEntityId(final long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraTargetInstruction)) {
         return false;
      }

      CameraTargetInstruction other = (CameraTargetInstruction)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getUniqueEntityId() != other.getUniqueEntityId()) {
         return false;
      }

      Object this$targetCenterOffset = this.getTargetCenterOffset();
      Object other$targetCenterOffset = other.getTargetCenterOffset();
      return this$targetCenterOffset == null ? other$targetCenterOffset == null : this$targetCenterOffset.equals(other$targetCenterOffset);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CameraTargetInstruction;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueEntityId = this.getUniqueEntityId();
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      Object $targetCenterOffset = this.getTargetCenterOffset();
      return result * 59 + ($targetCenterOffset == null ? 43 : $targetCenterOffset.hashCode());
   }

   @Override
   public String toString() {
      return "CameraTargetInstruction(targetCenterOffset=" + this.getTargetCenterOffset() + ", uniqueEntityId=" + this.getUniqueEntityId() + ")";
   }

   public CameraTargetInstruction(final Vector3f targetCenterOffset, final long uniqueEntityId) {
      this.targetCenterOffset = targetCenterOffset;
      this.uniqueEntityId = uniqueEntityId;
   }

   public CameraTargetInstruction() {
   }
}
