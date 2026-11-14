package org.cloudburstmc.protocol.bedrock.data.camera;

public class CameraFovInstruction {
   private float fov;
   private float easeTime;
   private CameraEase easeType;
   private boolean clear;

   public float getFov() {
      return this.fov;
   }

   public float getEaseTime() {
      return this.easeTime;
   }

   public CameraEase getEaseType() {
      return this.easeType;
   }

   public boolean isClear() {
      return this.clear;
   }

   public void setFov(final float fov) {
      this.fov = fov;
   }

   public void setEaseTime(final float easeTime) {
      this.easeTime = easeTime;
   }

   public void setEaseType(final CameraEase easeType) {
      this.easeType = easeType;
   }

   public void setClear(final boolean clear) {
      this.clear = clear;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraFovInstruction)) {
         return false;
      }

      CameraFovInstruction other = (CameraFovInstruction)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (Float.compare(this.getFov(), other.getFov()) != 0) {
         return false;
      }

      if (Float.compare(this.getEaseTime(), other.getEaseTime()) != 0) {
         return false;
      }

      if (this.isClear() != other.isClear()) {
         return false;
      }

      Object this$easeType = this.getEaseType();
      Object other$easeType = other.getEaseType();
      return this$easeType == null ? other$easeType == null : this$easeType.equals(other$easeType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CameraFovInstruction;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.getFov());
      result = result * 59 + Float.floatToIntBits(this.getEaseTime());
      result = result * 59 + (this.isClear() ? 79 : 97);
      Object $easeType = this.getEaseType();
      return result * 59 + ($easeType == null ? 43 : $easeType.hashCode());
   }

   @Override
   public String toString() {
      return "CameraFovInstruction(fov="
         + this.getFov()
         + ", easeTime="
         + this.getEaseTime()
         + ", easeType="
         + this.getEaseType()
         + ", clear="
         + this.isClear()
         + ")";
   }

   public CameraFovInstruction(final float fov, final float easeTime, final CameraEase easeType, final boolean clear) {
      this.fov = fov;
      this.easeTime = easeTime;
      this.easeType = easeType;
      this.clear = clear;
   }

   public CameraFovInstruction() {
   }
}
