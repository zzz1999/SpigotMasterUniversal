package org.cloudburstmc.protocol.bedrock.data.camera;

import java.awt.Color;

public class CameraFadeInstruction {
   private CameraFadeInstruction.TimeData timeData;
   private Color color;

   public CameraFadeInstruction.TimeData getTimeData() {
      return this.timeData;
   }

   public Color getColor() {
      return this.color;
   }

   public void setTimeData(final CameraFadeInstruction.TimeData timeData) {
      this.timeData = timeData;
   }

   public void setColor(final Color color) {
      this.color = color;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CameraFadeInstruction)) {
         return false;
      } else {
         CameraFadeInstruction other = (CameraFadeInstruction)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$timeData = this.getTimeData();
            Object other$timeData = other.getTimeData();
            if (this$timeData == null ? other$timeData == null : this$timeData.equals(other$timeData)) {
               Object this$color = this.getColor();
               Object other$color = other.getColor();
               return this$color == null ? other$color == null : this$color.equals(other$color);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CameraFadeInstruction;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $timeData = this.getTimeData();
      result = result * 59 + ($timeData == null ? 43 : $timeData.hashCode());
      Object $color = this.getColor();
      return result * 59 + ($color == null ? 43 : $color.hashCode());
   }

   @Override
   public String toString() {
      return "CameraFadeInstruction(timeData=" + this.getTimeData() + ", color=" + this.getColor() + ")";
   }

   public CameraFadeInstruction(final CameraFadeInstruction.TimeData timeData, final Color color) {
      this.timeData = timeData;
      this.color = color;
   }

   public CameraFadeInstruction() {
   }

   public static class TimeData {
      private final float fadeInTime;
      private final float waitTime;
      private final float fadeOutTime;

      public TimeData(final float fadeInTime, final float waitTime, final float fadeOutTime) {
         this.fadeInTime = fadeInTime;
         this.waitTime = waitTime;
         this.fadeOutTime = fadeOutTime;
      }

      public float getFadeInTime() {
         return this.fadeInTime;
      }

      public float getWaitTime() {
         return this.waitTime;
      }

      public float getFadeOutTime() {
         return this.fadeOutTime;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         } else if (!(o instanceof CameraFadeInstruction.TimeData)) {
            return false;
         } else {
            CameraFadeInstruction.TimeData other = (CameraFadeInstruction.TimeData)o;
            if (!other.canEqual(this)) {
               return false;
            } else if (Float.compare(this.getFadeInTime(), other.getFadeInTime()) != 0) {
               return false;
            } else {
               return Float.compare(this.getWaitTime(), other.getWaitTime()) != 0 ? false : Float.compare(this.getFadeOutTime(), other.getFadeOutTime()) == 0;
            }
         }
      }

      protected boolean canEqual(final Object other) {
         return other instanceof CameraFadeInstruction.TimeData;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         result = result * 59 + Float.floatToIntBits(this.getFadeInTime());
         result = result * 59 + Float.floatToIntBits(this.getWaitTime());
         return result * 59 + Float.floatToIntBits(this.getFadeOutTime());
      }

      @Override
      public String toString() {
         return "CameraFadeInstruction.TimeData(fadeInTime="
            + this.getFadeInTime()
            + ", waitTime="
            + this.getWaitTime()
            + ", fadeOutTime="
            + this.getFadeOutTime()
            + ")";
      }
   }
}
