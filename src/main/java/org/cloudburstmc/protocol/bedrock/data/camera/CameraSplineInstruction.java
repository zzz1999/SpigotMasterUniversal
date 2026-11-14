package org.cloudburstmc.protocol.bedrock.data.camera;

import java.util.List;
import org.cloudburstmc.math.vector.Vector2f;
import org.cloudburstmc.math.vector.Vector3f;

public class CameraSplineInstruction {
   private float totalTime;
   private CameraSplineType type;
   private List<Vector3f> curve;
   private List<Vector2f> progressKeyFrames;
   private List<CameraSplineInstruction.SplineRotationOption> rotationOption;

   public float getTotalTime() {
      return this.totalTime;
   }

   public CameraSplineType getType() {
      return this.type;
   }

   public List<Vector3f> getCurve() {
      return this.curve;
   }

   public List<Vector2f> getProgressKeyFrames() {
      return this.progressKeyFrames;
   }

   public List<CameraSplineInstruction.SplineRotationOption> getRotationOption() {
      return this.rotationOption;
   }

   public void setTotalTime(final float totalTime) {
      this.totalTime = totalTime;
   }

   public void setType(final CameraSplineType type) {
      this.type = type;
   }

   public void setCurve(final List<Vector3f> curve) {
      this.curve = curve;
   }

   public void setProgressKeyFrames(final List<Vector2f> progressKeyFrames) {
      this.progressKeyFrames = progressKeyFrames;
   }

   public void setRotationOption(final List<CameraSplineInstruction.SplineRotationOption> rotationOption) {
      this.rotationOption = rotationOption;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraSplineInstruction)) {
         return false;
      }

      CameraSplineInstruction other = (CameraSplineInstruction)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (Float.compare(this.getTotalTime(), other.getTotalTime()) != 0) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$curve = this.getCurve();
         Object other$curve = other.getCurve();
         if (this$curve == null ? other$curve == null : this$curve.equals(other$curve)) {
            Object this$progressKeyFrames = this.getProgressKeyFrames();
            Object other$progressKeyFrames = other.getProgressKeyFrames();
            if (this$progressKeyFrames == null ? other$progressKeyFrames == null : this$progressKeyFrames.equals(other$progressKeyFrames)) {
               Object this$rotationOption = this.getRotationOption();
               Object other$rotationOption = other.getRotationOption();
               return this$rotationOption == null ? other$rotationOption == null : this$rotationOption.equals(other$rotationOption);
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
      return other instanceof CameraSplineInstruction;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.getTotalTime());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $curve = this.getCurve();
      result = result * 59 + ($curve == null ? 43 : $curve.hashCode());
      Object $progressKeyFrames = this.getProgressKeyFrames();
      result = result * 59 + ($progressKeyFrames == null ? 43 : $progressKeyFrames.hashCode());
      Object $rotationOption = this.getRotationOption();
      return result * 59 + ($rotationOption == null ? 43 : $rotationOption.hashCode());
   }

   @Override
   public String toString() {
      return "CameraSplineInstruction(totalTime="
         + this.getTotalTime()
         + ", type="
         + this.getType()
         + ", curve="
         + this.getCurve()
         + ", progressKeyFrames="
         + this.getProgressKeyFrames()
         + ", rotationOption="
         + this.getRotationOption()
         + ")";
   }

   public CameraSplineInstruction(
      final float totalTime,
      final CameraSplineType type,
      final List<Vector3f> curve,
      final List<Vector2f> progressKeyFrames,
      final List<CameraSplineInstruction.SplineRotationOption> rotationOption
   ) {
      this.totalTime = totalTime;
      this.type = type;
      this.curve = curve;
      this.progressKeyFrames = progressKeyFrames;
      this.rotationOption = rotationOption;
   }

   public static class SplineRotationOption {
      private Vector3f keyFrameValues;
      private float keyFrameTimes;

      public Vector3f getKeyFrameValues() {
         return this.keyFrameValues;
      }

      public float getKeyFrameTimes() {
         return this.keyFrameTimes;
      }

      public void setKeyFrameValues(final Vector3f keyFrameValues) {
         this.keyFrameValues = keyFrameValues;
      }

      public void setKeyFrameTimes(final float keyFrameTimes) {
         this.keyFrameTimes = keyFrameTimes;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof CameraSplineInstruction.SplineRotationOption)) {
            return false;
         }

         CameraSplineInstruction.SplineRotationOption other = (CameraSplineInstruction.SplineRotationOption)o;
         if (!other.canEqual(this)) {
            return false;
         }

         if (Float.compare(this.getKeyFrameTimes(), other.getKeyFrameTimes()) != 0) {
            return false;
         }

         Object this$keyFrameValues = this.getKeyFrameValues();
         Object other$keyFrameValues = other.getKeyFrameValues();
         return this$keyFrameValues == null ? other$keyFrameValues == null : this$keyFrameValues.equals(other$keyFrameValues);
      }

      protected boolean canEqual(final Object other) {
         return other instanceof CameraSplineInstruction.SplineRotationOption;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         result = result * 59 + Float.floatToIntBits(this.getKeyFrameTimes());
         Object $keyFrameValues = this.getKeyFrameValues();
         return result * 59 + ($keyFrameValues == null ? 43 : $keyFrameValues.hashCode());
      }

      @Override
      public String toString() {
         return "CameraSplineInstruction.SplineRotationOption(keyFrameValues=" + this.getKeyFrameValues() + ", keyFrameTimes=" + this.getKeyFrameTimes() + ")";
      }

      public SplineRotationOption(final Vector3f keyFrameValues, final float keyFrameTimes) {
         this.keyFrameValues = keyFrameValues;
         this.keyFrameTimes = keyFrameTimes;
      }
   }
}
