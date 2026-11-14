package org.cloudburstmc.protocol.bedrock.data.structure;

import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.math.vector.Vector3i;

public final class StructureSettings {
   private final String paletteName;
   private final boolean ignoringEntities;
   private final boolean ignoringBlocks;
   private final boolean nonTickingPlayersAndTickingAreasEnabled;
   private final Vector3i size;
   private final Vector3i offset;
   private final long lastEditedByEntityId;
   private final StructureRotation rotation;
   private final StructureMirror mirror;
   private final StructureAnimationMode animationMode;
   private final float animationSeconds;
   private final float integrityValue;
   private final int integritySeed;
   private final Vector3f pivot;

   public StructureSettings(
      final String paletteName,
      final boolean ignoringEntities,
      final boolean ignoringBlocks,
      final boolean nonTickingPlayersAndTickingAreasEnabled,
      final Vector3i size,
      final Vector3i offset,
      final long lastEditedByEntityId,
      final StructureRotation rotation,
      final StructureMirror mirror,
      final StructureAnimationMode animationMode,
      final float animationSeconds,
      final float integrityValue,
      final int integritySeed,
      final Vector3f pivot
   ) {
      this.paletteName = paletteName;
      this.ignoringEntities = ignoringEntities;
      this.ignoringBlocks = ignoringBlocks;
      this.nonTickingPlayersAndTickingAreasEnabled = nonTickingPlayersAndTickingAreasEnabled;
      this.size = size;
      this.offset = offset;
      this.lastEditedByEntityId = lastEditedByEntityId;
      this.rotation = rotation;
      this.mirror = mirror;
      this.animationMode = animationMode;
      this.animationSeconds = animationSeconds;
      this.integrityValue = integrityValue;
      this.integritySeed = integritySeed;
      this.pivot = pivot;
   }

   public String getPaletteName() {
      return this.paletteName;
   }

   public boolean isIgnoringEntities() {
      return this.ignoringEntities;
   }

   public boolean isIgnoringBlocks() {
      return this.ignoringBlocks;
   }

   public boolean isNonTickingPlayersAndTickingAreasEnabled() {
      return this.nonTickingPlayersAndTickingAreasEnabled;
   }

   public Vector3i getSize() {
      return this.size;
   }

   public Vector3i getOffset() {
      return this.offset;
   }

   public long getLastEditedByEntityId() {
      return this.lastEditedByEntityId;
   }

   public StructureRotation getRotation() {
      return this.rotation;
   }

   public StructureMirror getMirror() {
      return this.mirror;
   }

   public StructureAnimationMode getAnimationMode() {
      return this.animationMode;
   }

   public float getAnimationSeconds() {
      return this.animationSeconds;
   }

   public float getIntegrityValue() {
      return this.integrityValue;
   }

   public int getIntegritySeed() {
      return this.integritySeed;
   }

   public Vector3f getPivot() {
      return this.pivot;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StructureSettings)) {
         return false;
      }

      StructureSettings other = (StructureSettings)o;
      if (this.isIgnoringEntities() != other.isIgnoringEntities()) {
         return false;
      }

      if (this.isIgnoringBlocks() != other.isIgnoringBlocks()) {
         return false;
      }

      if (this.isNonTickingPlayersAndTickingAreasEnabled() != other.isNonTickingPlayersAndTickingAreasEnabled()) {
         return false;
      }

      if (this.getLastEditedByEntityId() != other.getLastEditedByEntityId()) {
         return false;
      }

      if (Float.compare(this.getAnimationSeconds(), other.getAnimationSeconds()) != 0) {
         return false;
      }

      if (Float.compare(this.getIntegrityValue(), other.getIntegrityValue()) != 0) {
         return false;
      }

      if (this.getIntegritySeed() != other.getIntegritySeed()) {
         return false;
      }

      Object this$paletteName = this.getPaletteName();
      Object other$paletteName = other.getPaletteName();
      if (this$paletteName == null ? other$paletteName == null : this$paletteName.equals(other$paletteName)) {
         Object this$size = this.getSize();
         Object other$size = other.getSize();
         if (this$size == null ? other$size == null : this$size.equals(other$size)) {
            Object this$offset = this.getOffset();
            Object other$offset = other.getOffset();
            if (this$offset == null ? other$offset == null : this$offset.equals(other$offset)) {
               Object this$rotation = this.getRotation();
               Object other$rotation = other.getRotation();
               if (this$rotation == null ? other$rotation == null : this$rotation.equals(other$rotation)) {
                  Object this$mirror = this.getMirror();
                  Object other$mirror = other.getMirror();
                  if (this$mirror == null ? other$mirror == null : this$mirror.equals(other$mirror)) {
                     Object this$animationMode = this.getAnimationMode();
                     Object other$animationMode = other.getAnimationMode();
                     if (this$animationMode == null ? other$animationMode == null : this$animationMode.equals(other$animationMode)) {
                        Object this$pivot = this.getPivot();
                        Object other$pivot = other.getPivot();
                        return this$pivot == null ? other$pivot == null : this$pivot.equals(other$pivot);
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

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isIgnoringEntities() ? 79 : 97);
      result = result * 59 + (this.isIgnoringBlocks() ? 79 : 97);
      result = result * 59 + (this.isNonTickingPlayersAndTickingAreasEnabled() ? 79 : 97);
      long $lastEditedByEntityId = this.getLastEditedByEntityId();
      result = result * 59 + (int)($lastEditedByEntityId >>> 32 ^ $lastEditedByEntityId);
      result = result * 59 + Float.floatToIntBits(this.getAnimationSeconds());
      result = result * 59 + Float.floatToIntBits(this.getIntegrityValue());
      result = result * 59 + this.getIntegritySeed();
      Object $paletteName = this.getPaletteName();
      result = result * 59 + ($paletteName == null ? 43 : $paletteName.hashCode());
      Object $size = this.getSize();
      result = result * 59 + ($size == null ? 43 : $size.hashCode());
      Object $offset = this.getOffset();
      result = result * 59 + ($offset == null ? 43 : $offset.hashCode());
      Object $rotation = this.getRotation();
      result = result * 59 + ($rotation == null ? 43 : $rotation.hashCode());
      Object $mirror = this.getMirror();
      result = result * 59 + ($mirror == null ? 43 : $mirror.hashCode());
      Object $animationMode = this.getAnimationMode();
      result = result * 59 + ($animationMode == null ? 43 : $animationMode.hashCode());
      Object $pivot = this.getPivot();
      return result * 59 + ($pivot == null ? 43 : $pivot.hashCode());
   }

   @Override
   public String toString() {
      return "StructureSettings(paletteName="
         + this.getPaletteName()
         + ", ignoringEntities="
         + this.isIgnoringEntities()
         + ", ignoringBlocks="
         + this.isIgnoringBlocks()
         + ", nonTickingPlayersAndTickingAreasEnabled="
         + this.isNonTickingPlayersAndTickingAreasEnabled()
         + ", size="
         + this.getSize()
         + ", offset="
         + this.getOffset()
         + ", lastEditedByEntityId="
         + this.getLastEditedByEntityId()
         + ", rotation="
         + this.getRotation()
         + ", mirror="
         + this.getMirror()
         + ", animationMode="
         + this.getAnimationMode()
         + ", animationSeconds="
         + this.getAnimationSeconds()
         + ", integrityValue="
         + this.getIntegrityValue()
         + ", integritySeed="
         + this.getIntegritySeed()
         + ", pivot="
         + this.getPivot()
         + ")";
   }
}
