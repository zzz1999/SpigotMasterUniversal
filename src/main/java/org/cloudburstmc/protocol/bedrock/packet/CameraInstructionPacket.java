package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.camera.CameraAttachToEntityInstruction;
import org.cloudburstmc.protocol.bedrock.data.camera.CameraFadeInstruction;
import org.cloudburstmc.protocol.bedrock.data.camera.CameraFovInstruction;
import org.cloudburstmc.protocol.bedrock.data.camera.CameraSetInstruction;
import org.cloudburstmc.protocol.bedrock.data.camera.CameraSplineInstruction;
import org.cloudburstmc.protocol.bedrock.data.camera.CameraTargetInstruction;
import org.cloudburstmc.protocol.common.PacketSignal;
import org.cloudburstmc.protocol.common.util.OptionalBoolean;

public class CameraInstructionPacket implements BedrockPacket {
   private CameraSetInstruction setInstruction;
   private CameraFadeInstruction fadeInstruction;
   private OptionalBoolean clear = OptionalBoolean.empty();
   private CameraTargetInstruction targetInstruction;
   private OptionalBoolean removeTarget = OptionalBoolean.empty();
   private CameraFovInstruction fovInstruction;
   private CameraSplineInstruction splineInstruction;
   private CameraAttachToEntityInstruction attachInstruction;
   private OptionalBoolean detachFromEntity = OptionalBoolean.empty();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CAMERA_INSTRUCTION;
   }

   public void setClear(boolean value) {
      this.clear = OptionalBoolean.of(value);
   }

   public void setClear(OptionalBoolean clear) {
      this.clear = clear;
   }

   public CameraInstructionPacket clone() {
      try {
         return (CameraInstructionPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public CameraSetInstruction getSetInstruction() {
      return this.setInstruction;
   }

   public CameraFadeInstruction getFadeInstruction() {
      return this.fadeInstruction;
   }

   public OptionalBoolean getClear() {
      return this.clear;
   }

   public CameraTargetInstruction getTargetInstruction() {
      return this.targetInstruction;
   }

   public OptionalBoolean getRemoveTarget() {
      return this.removeTarget;
   }

   public CameraFovInstruction getFovInstruction() {
      return this.fovInstruction;
   }

   public CameraSplineInstruction getSplineInstruction() {
      return this.splineInstruction;
   }

   public CameraAttachToEntityInstruction getAttachInstruction() {
      return this.attachInstruction;
   }

   public OptionalBoolean getDetachFromEntity() {
      return this.detachFromEntity;
   }

   public void setSetInstruction(final CameraSetInstruction setInstruction) {
      this.setInstruction = setInstruction;
   }

   public void setFadeInstruction(final CameraFadeInstruction fadeInstruction) {
      this.fadeInstruction = fadeInstruction;
   }

   public void setTargetInstruction(final CameraTargetInstruction targetInstruction) {
      this.targetInstruction = targetInstruction;
   }

   public void setRemoveTarget(final OptionalBoolean removeTarget) {
      this.removeTarget = removeTarget;
   }

   public void setFovInstruction(final CameraFovInstruction fovInstruction) {
      this.fovInstruction = fovInstruction;
   }

   public void setSplineInstruction(final CameraSplineInstruction splineInstruction) {
      this.splineInstruction = splineInstruction;
   }

   public void setAttachInstruction(final CameraAttachToEntityInstruction attachInstruction) {
      this.attachInstruction = attachInstruction;
   }

   public void setDetachFromEntity(final OptionalBoolean detachFromEntity) {
      this.detachFromEntity = detachFromEntity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraInstructionPacket)) {
         return false;
      }

      CameraInstructionPacket other = (CameraInstructionPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$setInstruction = this.setInstruction;
      Object other$setInstruction = other.setInstruction;
      if (this$setInstruction == null ? other$setInstruction == null : this$setInstruction.equals(other$setInstruction)) {
         Object this$fadeInstruction = this.fadeInstruction;
         Object other$fadeInstruction = other.fadeInstruction;
         if (this$fadeInstruction == null ? other$fadeInstruction == null : this$fadeInstruction.equals(other$fadeInstruction)) {
            Object this$clear = this.clear;
            Object other$clear = other.clear;
            if (this$clear == null ? other$clear == null : this$clear.equals(other$clear)) {
               Object this$targetInstruction = this.targetInstruction;
               Object other$targetInstruction = other.targetInstruction;
               if (this$targetInstruction == null ? other$targetInstruction == null : this$targetInstruction.equals(other$targetInstruction)) {
                  Object this$removeTarget = this.removeTarget;
                  Object other$removeTarget = other.removeTarget;
                  if (this$removeTarget == null ? other$removeTarget == null : this$removeTarget.equals(other$removeTarget)) {
                     Object this$fovInstruction = this.fovInstruction;
                     Object other$fovInstruction = other.fovInstruction;
                     if (this$fovInstruction == null ? other$fovInstruction == null : this$fovInstruction.equals(other$fovInstruction)) {
                        Object this$splineInstruction = this.splineInstruction;
                        Object other$splineInstruction = other.splineInstruction;
                        if (this$splineInstruction == null ? other$splineInstruction == null : this$splineInstruction.equals(other$splineInstruction)) {
                           Object this$attachInstruction = this.attachInstruction;
                           Object other$attachInstruction = other.attachInstruction;
                           if (this$attachInstruction == null ? other$attachInstruction == null : this$attachInstruction.equals(other$attachInstruction)) {
                              Object this$detachFromEntity = this.detachFromEntity;
                              Object other$detachFromEntity = other.detachFromEntity;
                              return this$detachFromEntity == null ? other$detachFromEntity == null : this$detachFromEntity.equals(other$detachFromEntity);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CameraInstructionPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $setInstruction = this.setInstruction;
      result = result * 59 + ($setInstruction == null ? 43 : $setInstruction.hashCode());
      Object $fadeInstruction = this.fadeInstruction;
      result = result * 59 + ($fadeInstruction == null ? 43 : $fadeInstruction.hashCode());
      Object $clear = this.clear;
      result = result * 59 + ($clear == null ? 43 : $clear.hashCode());
      Object $targetInstruction = this.targetInstruction;
      result = result * 59 + ($targetInstruction == null ? 43 : $targetInstruction.hashCode());
      Object $removeTarget = this.removeTarget;
      result = result * 59 + ($removeTarget == null ? 43 : $removeTarget.hashCode());
      Object $fovInstruction = this.fovInstruction;
      result = result * 59 + ($fovInstruction == null ? 43 : $fovInstruction.hashCode());
      Object $splineInstruction = this.splineInstruction;
      result = result * 59 + ($splineInstruction == null ? 43 : $splineInstruction.hashCode());
      Object $attachInstruction = this.attachInstruction;
      result = result * 59 + ($attachInstruction == null ? 43 : $attachInstruction.hashCode());
      Object $detachFromEntity = this.detachFromEntity;
      return result * 59 + ($detachFromEntity == null ? 43 : $detachFromEntity.hashCode());
   }

   @Override
   public String toString() {
      return "CameraInstructionPacket(setInstruction="
         + this.setInstruction
         + ", fadeInstruction="
         + this.fadeInstruction
         + ", clear="
         + this.clear
         + ", targetInstruction="
         + this.targetInstruction
         + ", removeTarget="
         + this.removeTarget
         + ", fovInstruction="
         + this.fovInstruction
         + ", splineInstruction="
         + this.splineInstruction
         + ", attachInstruction="
         + this.attachInstruction
         + ", detachFromEntity="
         + this.detachFromEntity
         + ")";
   }
}
