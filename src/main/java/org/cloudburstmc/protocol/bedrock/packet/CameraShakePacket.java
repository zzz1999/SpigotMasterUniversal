package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.CameraShakeAction;
import org.cloudburstmc.protocol.bedrock.data.CameraShakeType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class CameraShakePacket implements BedrockPacket {
   private float intensity;
   private float duration;
   private CameraShakeType shakeType;
   private CameraShakeAction shakeAction;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CAMERA_SHAKE;
   }

   public CameraShakePacket clone() {
      try {
         return (CameraShakePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public float getIntensity() {
      return this.intensity;
   }

   public float getDuration() {
      return this.duration;
   }

   public CameraShakeType getShakeType() {
      return this.shakeType;
   }

   public CameraShakeAction getShakeAction() {
      return this.shakeAction;
   }

   public void setIntensity(final float intensity) {
      this.intensity = intensity;
   }

   public void setDuration(final float duration) {
      this.duration = duration;
   }

   public void setShakeType(final CameraShakeType shakeType) {
      this.shakeType = shakeType;
   }

   public void setShakeAction(final CameraShakeAction shakeAction) {
      this.shakeAction = shakeAction;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CameraShakePacket)) {
         return false;
      } else {
         CameraShakePacket other = (CameraShakePacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (Float.compare(this.intensity, other.intensity) != 0) {
            return false;
         } else if (Float.compare(this.duration, other.duration) != 0) {
            return false;
         } else {
            Object this$shakeType = this.shakeType;
            Object other$shakeType = other.shakeType;
            if (this$shakeType == null ? other$shakeType == null : this$shakeType.equals(other$shakeType)) {
               Object this$shakeAction = this.shakeAction;
               Object other$shakeAction = other.shakeAction;
               return this$shakeAction == null ? other$shakeAction == null : this$shakeAction.equals(other$shakeAction);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CameraShakePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.intensity);
      result = result * 59 + Float.floatToIntBits(this.duration);
      Object $shakeType = this.shakeType;
      result = result * 59 + ($shakeType == null ? 43 : $shakeType.hashCode());
      Object $shakeAction = this.shakeAction;
      return result * 59 + ($shakeAction == null ? 43 : $shakeAction.hashCode());
   }

   @Override
   public String toString() {
      return "CameraShakePacket(intensity="
         + this.intensity
         + ", duration="
         + this.duration
         + ", shakeType="
         + this.shakeType
         + ", shakeAction="
         + this.shakeAction
         + ")";
   }
}
