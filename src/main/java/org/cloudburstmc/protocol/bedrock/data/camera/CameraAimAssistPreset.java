package org.cloudburstmc.protocol.bedrock.data.camera;

import org.cloudburstmc.math.vector.Vector2f;

public class CameraAimAssistPreset {
   private String identifier;
   private Integer targetMode;
   private Vector2f angle;
   private Float distance;

   public static CameraAimAssistPreset.CameraAimAssistPresetBuilder builder() {
      return new CameraAimAssistPreset.CameraAimAssistPresetBuilder();
   }

   public String getIdentifier() {
      return this.identifier;
   }

   public Integer getTargetMode() {
      return this.targetMode;
   }

   public Vector2f getAngle() {
      return this.angle;
   }

   public Float getDistance() {
      return this.distance;
   }

   public void setIdentifier(final String identifier) {
      this.identifier = identifier;
   }

   public void setTargetMode(final Integer targetMode) {
      this.targetMode = targetMode;
   }

   public void setAngle(final Vector2f angle) {
      this.angle = angle;
   }

   public void setDistance(final Float distance) {
      this.distance = distance;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraAimAssistPreset)) {
         return false;
      }

      CameraAimAssistPreset other = (CameraAimAssistPreset)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$targetMode = this.getTargetMode();
      Object other$targetMode = other.getTargetMode();
      if (this$targetMode == null ? other$targetMode == null : this$targetMode.equals(other$targetMode)) {
         Object this$distance = this.getDistance();
         Object other$distance = other.getDistance();
         if (this$distance == null ? other$distance == null : this$distance.equals(other$distance)) {
            Object this$identifier = this.getIdentifier();
            Object other$identifier = other.getIdentifier();
            if (this$identifier == null ? other$identifier == null : this$identifier.equals(other$identifier)) {
               Object this$angle = this.getAngle();
               Object other$angle = other.getAngle();
               return this$angle == null ? other$angle == null : this$angle.equals(other$angle);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CameraAimAssistPreset;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $targetMode = this.getTargetMode();
      result = result * 59 + ($targetMode == null ? 43 : $targetMode.hashCode());
      Object $distance = this.getDistance();
      result = result * 59 + ($distance == null ? 43 : $distance.hashCode());
      Object $identifier = this.getIdentifier();
      result = result * 59 + ($identifier == null ? 43 : $identifier.hashCode());
      Object $angle = this.getAngle();
      return result * 59 + ($angle == null ? 43 : $angle.hashCode());
   }

   @Override
   public String toString() {
      return "CameraAimAssistPreset(identifier="
         + this.getIdentifier()
         + ", targetMode="
         + this.getTargetMode()
         + ", angle="
         + this.getAngle()
         + ", distance="
         + this.getDistance()
         + ")";
   }

   public CameraAimAssistPreset(final String identifier, final Integer targetMode, final Vector2f angle, final Float distance) {
      this.identifier = identifier;
      this.targetMode = targetMode;
      this.angle = angle;
      this.distance = distance;
   }

   public static class CameraAimAssistPresetBuilder {
      private String identifier;
      private Integer targetMode;
      private Vector2f angle;
      private Float distance;

      CameraAimAssistPresetBuilder() {
      }

      public CameraAimAssistPreset.CameraAimAssistPresetBuilder identifier(final String identifier) {
         this.identifier = identifier;
         return this;
      }

      public CameraAimAssistPreset.CameraAimAssistPresetBuilder targetMode(final Integer targetMode) {
         this.targetMode = targetMode;
         return this;
      }

      public CameraAimAssistPreset.CameraAimAssistPresetBuilder angle(final Vector2f angle) {
         this.angle = angle;
         return this;
      }

      public CameraAimAssistPreset.CameraAimAssistPresetBuilder distance(final Float distance) {
         this.distance = distance;
         return this;
      }

      public CameraAimAssistPreset build() {
         return new CameraAimAssistPreset(this.identifier, this.targetMode, this.angle, this.distance);
      }

      @Override
      public String toString() {
         return "CameraAimAssistPreset.CameraAimAssistPresetBuilder(identifier="
            + this.identifier
            + ", targetMode="
            + this.targetMode
            + ", angle="
            + this.angle
            + ", distance="
            + this.distance
            + ")";
      }
   }
}
