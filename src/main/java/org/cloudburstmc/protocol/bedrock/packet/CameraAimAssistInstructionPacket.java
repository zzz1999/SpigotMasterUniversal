package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.camera.AimAssistAction;
import org.cloudburstmc.protocol.common.PacketSignal;

public class CameraAimAssistInstructionPacket implements BedrockPacket {
   private String presetId;
   private AimAssistAction action;
   private boolean allowAimAssist;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CAMERA_AIM_ASSIST_INSTRUCTION;
   }

   public CameraAimAssistInstructionPacket clone() {
      try {
         return (CameraAimAssistInstructionPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getPresetId() {
      return this.presetId;
   }

   public AimAssistAction getAction() {
      return this.action;
   }

   public boolean isAllowAimAssist() {
      return this.allowAimAssist;
   }

   public void setPresetId(final String presetId) {
      this.presetId = presetId;
   }

   public void setAction(final AimAssistAction action) {
      this.action = action;
   }

   public void setAllowAimAssist(final boolean allowAimAssist) {
      this.allowAimAssist = allowAimAssist;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CameraAimAssistInstructionPacket)) {
         return false;
      } else {
         CameraAimAssistInstructionPacket other = (CameraAimAssistInstructionPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.allowAimAssist != other.allowAimAssist) {
            return false;
         } else {
            Object this$presetId = this.presetId;
            Object other$presetId = other.presetId;
            if (this$presetId == null ? other$presetId == null : this$presetId.equals(other$presetId)) {
               Object this$action = this.action;
               Object other$action = other.action;
               return this$action == null ? other$action == null : this$action.equals(other$action);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CameraAimAssistInstructionPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.allowAimAssist ? 79 : 97);
      Object $presetId = this.presetId;
      result = result * 59 + ($presetId == null ? 43 : $presetId.hashCode());
      Object $action = this.action;
      return result * 59 + ($action == null ? 43 : $action.hashCode());
   }

   @Override
   public String toString() {
      return "CameraAimAssistInstructionPacket(presetId=" + this.presetId + ", action=" + this.action + ", allowAimAssist=" + this.allowAimAssist + ")";
   }
}
