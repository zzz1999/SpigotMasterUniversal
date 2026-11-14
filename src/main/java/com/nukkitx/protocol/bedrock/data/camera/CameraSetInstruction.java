package com.nukkitx.protocol.bedrock.data.camera;

import com.nukkitx.protocol.common.NamedDefinition;
import com.nukkitx.protocol.common.util.OptionalBoolean;
import org.cloudburstmc.math.vector.Vector2f;
import org.cloudburstmc.math.vector.Vector3f;

public class CameraSetInstruction {
   private NamedDefinition preset;
   private CameraSetInstruction.EaseData ease;
   private Vector3f pos;
   private Vector2f rot;
   private Vector3f facing;
   private OptionalBoolean defaultPreset = OptionalBoolean.empty();

   public NamedDefinition getPreset() {
      return this.preset;
   }

   public CameraSetInstruction.EaseData getEase() {
      return this.ease;
   }

   public Vector3f getPos() {
      return this.pos;
   }

   public Vector2f getRot() {
      return this.rot;
   }

   public Vector3f getFacing() {
      return this.facing;
   }

   public OptionalBoolean getDefaultPreset() {
      return this.defaultPreset;
   }

   public void setPreset(NamedDefinition preset) {
      this.preset = preset;
   }

   public void setEase(CameraSetInstruction.EaseData ease) {
      this.ease = ease;
   }

   public void setPos(Vector3f pos) {
      this.pos = pos;
   }

   public void setRot(Vector2f rot) {
      this.rot = rot;
   }

   public void setFacing(Vector3f facing) {
      this.facing = facing;
   }

   public void setDefaultPreset(OptionalBoolean defaultPreset) {
      this.defaultPreset = defaultPreset;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraSetInstruction)) {
         return false;
      }

      CameraSetInstruction other = (CameraSetInstruction)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$preset = this.getPreset();
      Object other$preset = other.getPreset();
      if (this$preset == null ? other$preset == null : this$preset.equals(other$preset)) {
         Object this$ease = this.getEase();
         Object other$ease = other.getEase();
         if (this$ease == null ? other$ease == null : this$ease.equals(other$ease)) {
            Object this$pos = this.getPos();
            Object other$pos = other.getPos();
            if (this$pos == null ? other$pos == null : this$pos.equals(other$pos)) {
               Object this$rot = this.getRot();
               Object other$rot = other.getRot();
               if (this$rot == null ? other$rot == null : this$rot.equals(other$rot)) {
                  Object this$facing = this.getFacing();
                  Object other$facing = other.getFacing();
                  if (this$facing == null ? other$facing == null : this$facing.equals(other$facing)) {
                     Object this$defaultPreset = this.getDefaultPreset();
                     Object other$defaultPreset = other.getDefaultPreset();
                     return this$defaultPreset == null ? other$defaultPreset == null : this$defaultPreset.equals(other$defaultPreset);
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
      return other instanceof CameraSetInstruction;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $preset = this.getPreset();
      result = result * 59 + ($preset == null ? 43 : $preset.hashCode());
      Object $ease = this.getEase();
      result = result * 59 + ($ease == null ? 43 : $ease.hashCode());
      Object $pos = this.getPos();
      result = result * 59 + ($pos == null ? 43 : $pos.hashCode());
      Object $rot = this.getRot();
      result = result * 59 + ($rot == null ? 43 : $rot.hashCode());
      Object $facing = this.getFacing();
      result = result * 59 + ($facing == null ? 43 : $facing.hashCode());
      Object $defaultPreset = this.getDefaultPreset();
      return result * 59 + ($defaultPreset == null ? 43 : $defaultPreset.hashCode());
   }

   @Override
   public String toString() {
      return "CameraSetInstruction(preset="
         + this.getPreset()
         + ", ease="
         + this.getEase()
         + ", pos="
         + this.getPos()
         + ", rot="
         + this.getRot()
         + ", facing="
         + this.getFacing()
         + ", defaultPreset="
         + this.getDefaultPreset()
         + ")";
   }

   public CameraSetInstruction(
      NamedDefinition preset, CameraSetInstruction.EaseData ease, Vector3f pos, Vector2f rot, Vector3f facing, OptionalBoolean defaultPreset
   ) {
      this.preset = preset;
      this.ease = ease;
      this.pos = pos;
      this.rot = rot;
      this.facing = facing;
      this.defaultPreset = defaultPreset;
   }

   public CameraSetInstruction() {
   }

   public static class EaseData {
      private final CameraEase easeType;
      private final float time;

      public EaseData(CameraEase easeType, float time) {
         this.easeType = easeType;
         this.time = time;
      }

      public CameraEase getEaseType() {
         return this.easeType;
      }

      public float getTime() {
         return this.time;
      }

      @Override
      public boolean equals(Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof CameraSetInstruction.EaseData)) {
            return false;
         }

         CameraSetInstruction.EaseData other = (CameraSetInstruction.EaseData)o;
         if (!other.canEqual(this)) {
            return false;
         }

         if (Float.compare(this.getTime(), other.getTime()) != 0) {
            return false;
         }

         Object this$easeType = this.getEaseType();
         Object other$easeType = other.getEaseType();
         return this$easeType == null ? other$easeType == null : this$easeType.equals(other$easeType);
      }

      protected boolean canEqual(Object other) {
         return other instanceof CameraSetInstruction.EaseData;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         result = result * 59 + Float.floatToIntBits(this.getTime());
         Object $easeType = this.getEaseType();
         return result * 59 + ($easeType == null ? 43 : $easeType.hashCode());
      }

      @Override
      public String toString() {
         return "CameraSetInstruction.EaseData(easeType=" + this.getEaseType() + ", time=" + this.getTime() + ")";
      }
   }
}
