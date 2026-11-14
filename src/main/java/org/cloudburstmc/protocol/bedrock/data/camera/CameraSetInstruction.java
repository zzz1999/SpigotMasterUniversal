package org.cloudburstmc.protocol.bedrock.data.camera;

import org.cloudburstmc.math.vector.Vector2f;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.common.NamedDefinition;
import org.cloudburstmc.protocol.common.util.OptionalBoolean;

public class CameraSetInstruction {
   private NamedDefinition preset;
   private CameraSetInstruction.EaseData ease;
   private Vector3f pos;
   private Vector2f rot;
   private Vector3f facing;
   private Vector2f viewOffset;
   private Vector3f entityOffset;
   private OptionalBoolean defaultPreset;
   private boolean removeIgnoreStartingValues;

   private static OptionalBoolean $default$defaultPreset() {
      return OptionalBoolean.empty();
   }

   public static CameraSetInstruction.CameraSetInstructionBuilder builder() {
      return new CameraSetInstruction.CameraSetInstructionBuilder();
   }

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

   public Vector2f getViewOffset() {
      return this.viewOffset;
   }

   public Vector3f getEntityOffset() {
      return this.entityOffset;
   }

   public OptionalBoolean getDefaultPreset() {
      return this.defaultPreset;
   }

   public boolean isRemoveIgnoreStartingValues() {
      return this.removeIgnoreStartingValues;
   }

   public void setPreset(final NamedDefinition preset) {
      this.preset = preset;
   }

   public void setEase(final CameraSetInstruction.EaseData ease) {
      this.ease = ease;
   }

   public void setPos(final Vector3f pos) {
      this.pos = pos;
   }

   public void setRot(final Vector2f rot) {
      this.rot = rot;
   }

   public void setFacing(final Vector3f facing) {
      this.facing = facing;
   }

   public void setViewOffset(final Vector2f viewOffset) {
      this.viewOffset = viewOffset;
   }

   public void setEntityOffset(final Vector3f entityOffset) {
      this.entityOffset = entityOffset;
   }

   public void setDefaultPreset(final OptionalBoolean defaultPreset) {
      this.defaultPreset = defaultPreset;
   }

   public void setRemoveIgnoreStartingValues(final boolean removeIgnoreStartingValues) {
      this.removeIgnoreStartingValues = removeIgnoreStartingValues;
   }

   @Override
   public boolean equals(final Object o) {
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

      if (this.isRemoveIgnoreStartingValues() != other.isRemoveIgnoreStartingValues()) {
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
                     Object this$viewOffset = this.getViewOffset();
                     Object other$viewOffset = other.getViewOffset();
                     if (this$viewOffset == null ? other$viewOffset == null : this$viewOffset.equals(other$viewOffset)) {
                        Object this$entityOffset = this.getEntityOffset();
                        Object other$entityOffset = other.getEntityOffset();
                        if (this$entityOffset == null ? other$entityOffset == null : this$entityOffset.equals(other$entityOffset)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CameraSetInstruction;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isRemoveIgnoreStartingValues() ? 79 : 97);
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
      Object $viewOffset = this.getViewOffset();
      result = result * 59 + ($viewOffset == null ? 43 : $viewOffset.hashCode());
      Object $entityOffset = this.getEntityOffset();
      result = result * 59 + ($entityOffset == null ? 43 : $entityOffset.hashCode());
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
         + ", viewOffset="
         + this.getViewOffset()
         + ", entityOffset="
         + this.getEntityOffset()
         + ", defaultPreset="
         + this.getDefaultPreset()
         + ", removeIgnoreStartingValues="
         + this.isRemoveIgnoreStartingValues()
         + ")";
   }

   public CameraSetInstruction(
      final NamedDefinition preset,
      final CameraSetInstruction.EaseData ease,
      final Vector3f pos,
      final Vector2f rot,
      final Vector3f facing,
      final Vector2f viewOffset,
      final Vector3f entityOffset,
      final OptionalBoolean defaultPreset,
      final boolean removeIgnoreStartingValues
   ) {
      this.preset = preset;
      this.ease = ease;
      this.pos = pos;
      this.rot = rot;
      this.facing = facing;
      this.viewOffset = viewOffset;
      this.entityOffset = entityOffset;
      this.defaultPreset = defaultPreset;
      this.removeIgnoreStartingValues = removeIgnoreStartingValues;
   }

   public CameraSetInstruction() {
      this.defaultPreset = $default$defaultPreset();
   }

   public static class CameraSetInstructionBuilder {
      private NamedDefinition preset;
      private CameraSetInstruction.EaseData ease;
      private Vector3f pos;
      private Vector2f rot;
      private Vector3f facing;
      private Vector2f viewOffset;
      private Vector3f entityOffset;
      private boolean defaultPreset$set;
      private OptionalBoolean defaultPreset$value;
      private boolean removeIgnoreStartingValues;

      CameraSetInstructionBuilder() {
      }

      public CameraSetInstruction.CameraSetInstructionBuilder preset(final NamedDefinition preset) {
         this.preset = preset;
         return this;
      }

      public CameraSetInstruction.CameraSetInstructionBuilder ease(final CameraSetInstruction.EaseData ease) {
         this.ease = ease;
         return this;
      }

      public CameraSetInstruction.CameraSetInstructionBuilder pos(final Vector3f pos) {
         this.pos = pos;
         return this;
      }

      public CameraSetInstruction.CameraSetInstructionBuilder rot(final Vector2f rot) {
         this.rot = rot;
         return this;
      }

      public CameraSetInstruction.CameraSetInstructionBuilder facing(final Vector3f facing) {
         this.facing = facing;
         return this;
      }

      public CameraSetInstruction.CameraSetInstructionBuilder viewOffset(final Vector2f viewOffset) {
         this.viewOffset = viewOffset;
         return this;
      }

      public CameraSetInstruction.CameraSetInstructionBuilder entityOffset(final Vector3f entityOffset) {
         this.entityOffset = entityOffset;
         return this;
      }

      public CameraSetInstruction.CameraSetInstructionBuilder defaultPreset(final OptionalBoolean defaultPreset) {
         this.defaultPreset$value = defaultPreset;
         this.defaultPreset$set = true;
         return this;
      }

      public CameraSetInstruction.CameraSetInstructionBuilder removeIgnoreStartingValues(final boolean removeIgnoreStartingValues) {
         this.removeIgnoreStartingValues = removeIgnoreStartingValues;
         return this;
      }

      public CameraSetInstruction build() {
         OptionalBoolean defaultPreset$value = this.defaultPreset$value;
         if (!this.defaultPreset$set) {
            defaultPreset$value = CameraSetInstruction.$default$defaultPreset();
         }

         return new CameraSetInstruction(
            this.preset, this.ease, this.pos, this.rot, this.facing, this.viewOffset, this.entityOffset, defaultPreset$value, this.removeIgnoreStartingValues
         );
      }

      @Override
      public String toString() {
         return "CameraSetInstruction.CameraSetInstructionBuilder(preset="
            + this.preset
            + ", ease="
            + this.ease
            + ", pos="
            + this.pos
            + ", rot="
            + this.rot
            + ", facing="
            + this.facing
            + ", viewOffset="
            + this.viewOffset
            + ", entityOffset="
            + this.entityOffset
            + ", defaultPreset$value="
            + this.defaultPreset$value
            + ", removeIgnoreStartingValues="
            + this.removeIgnoreStartingValues
            + ")";
      }
   }

   public static class EaseData {
      private final CameraEase easeType;
      private final float time;

      public EaseData(final CameraEase easeType, final float time) {
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
      public boolean equals(final Object o) {
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

      protected boolean canEqual(final Object other) {
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
