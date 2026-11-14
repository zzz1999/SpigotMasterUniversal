package org.cloudburstmc.protocol.bedrock.data.camera;

public class CameraAttachToEntityInstruction {
   private long uniqueEntityId;

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public void setUniqueEntityId(final long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraAttachToEntityInstruction)) {
         return false;
      }

      CameraAttachToEntityInstruction other = (CameraAttachToEntityInstruction)o;
      return !other.canEqual(this) ? false : this.getUniqueEntityId() == other.getUniqueEntityId();
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CameraAttachToEntityInstruction;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueEntityId = this.getUniqueEntityId();
      return result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
   }

   @Override
   public String toString() {
      return "CameraAttachToEntityInstruction(uniqueEntityId=" + this.getUniqueEntityId() + ")";
   }

   public CameraAttachToEntityInstruction(final long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }
}
