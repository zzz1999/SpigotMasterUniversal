package com.nukkitx.protocol.bedrock.data.camera;

import com.nukkitx.protocol.common.util.OptionalBoolean;
import org.cloudburstmc.math.vector.Vector3f;

public class CameraPreset {
   private String identifier;
   private String parentPreset = "";
   private Vector3f pos;
   private Float yaw;
   private Float pitch;
   private CameraAudioListener listener;
   private OptionalBoolean playEffect;

   public String getIdentifier() {
      return this.identifier;
   }

   public String getParentPreset() {
      return this.parentPreset;
   }

   public Vector3f getPos() {
      return this.pos;
   }

   public Float getYaw() {
      return this.yaw;
   }

   public Float getPitch() {
      return this.pitch;
   }

   public CameraAudioListener getListener() {
      return this.listener;
   }

   public OptionalBoolean getPlayEffect() {
      return this.playEffect;
   }

   public void setIdentifier(String identifier) {
      this.identifier = identifier;
   }

   public void setParentPreset(String parentPreset) {
      this.parentPreset = parentPreset;
   }

   public void setPos(Vector3f pos) {
      this.pos = pos;
   }

   public void setYaw(Float yaw) {
      this.yaw = yaw;
   }

   public void setPitch(Float pitch) {
      this.pitch = pitch;
   }

   public void setListener(CameraAudioListener listener) {
      this.listener = listener;
   }

   public void setPlayEffect(OptionalBoolean playEffect) {
      this.playEffect = playEffect;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraPreset)) {
         return false;
      }

      CameraPreset other = (CameraPreset)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yaw = this.getYaw();
      Object other$yaw = other.getYaw();
      if (this$yaw == null ? other$yaw == null : this$yaw.equals(other$yaw)) {
         Object this$pitch = this.getPitch();
         Object other$pitch = other.getPitch();
         if (this$pitch == null ? other$pitch == null : this$pitch.equals(other$pitch)) {
            Object this$identifier = this.getIdentifier();
            Object other$identifier = other.getIdentifier();
            if (this$identifier == null ? other$identifier == null : this$identifier.equals(other$identifier)) {
               Object this$parentPreset = this.getParentPreset();
               Object other$parentPreset = other.getParentPreset();
               if (this$parentPreset == null ? other$parentPreset == null : this$parentPreset.equals(other$parentPreset)) {
                  Object this$pos = this.getPos();
                  Object other$pos = other.getPos();
                  if (this$pos == null ? other$pos == null : this$pos.equals(other$pos)) {
                     Object this$listener = this.getListener();
                     Object other$listener = other.getListener();
                     if (this$listener == null ? other$listener == null : this$listener.equals(other$listener)) {
                        Object this$playEffect = this.getPlayEffect();
                        Object other$playEffect = other.getPlayEffect();
                        return this$playEffect == null ? other$playEffect == null : this$playEffect.equals(other$playEffect);
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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

   protected boolean canEqual(Object other) {
      return other instanceof CameraPreset;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yaw = this.getYaw();
      result = result * 59 + ($yaw == null ? 43 : $yaw.hashCode());
      Object $pitch = this.getPitch();
      result = result * 59 + ($pitch == null ? 43 : $pitch.hashCode());
      Object $identifier = this.getIdentifier();
      result = result * 59 + ($identifier == null ? 43 : $identifier.hashCode());
      Object $parentPreset = this.getParentPreset();
      result = result * 59 + ($parentPreset == null ? 43 : $parentPreset.hashCode());
      Object $pos = this.getPos();
      result = result * 59 + ($pos == null ? 43 : $pos.hashCode());
      Object $listener = this.getListener();
      result = result * 59 + ($listener == null ? 43 : $listener.hashCode());
      Object $playEffect = this.getPlayEffect();
      return result * 59 + ($playEffect == null ? 43 : $playEffect.hashCode());
   }

   @Override
   public String toString() {
      return "CameraPreset(identifier="
         + this.getIdentifier()
         + ", parentPreset="
         + this.getParentPreset()
         + ", pos="
         + this.getPos()
         + ", yaw="
         + this.getYaw()
         + ", pitch="
         + this.getPitch()
         + ", listener="
         + this.getListener()
         + ", playEffect="
         + this.getPlayEffect()
         + ")";
   }

   public CameraPreset(String identifier, String parentPreset, Vector3f pos, Float yaw, Float pitch, CameraAudioListener listener, OptionalBoolean playEffect) {
      this.identifier = identifier;
      this.parentPreset = parentPreset;
      this.pos = pos;
      this.yaw = yaw;
      this.pitch = pitch;
      this.listener = listener;
      this.playEffect = playEffect;
   }

   public CameraPreset() {
   }
}
