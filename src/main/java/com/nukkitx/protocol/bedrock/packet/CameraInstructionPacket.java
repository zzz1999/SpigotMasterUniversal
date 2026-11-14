package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.camera.CameraFadeInstruction;
import com.nukkitx.protocol.bedrock.data.camera.CameraSetInstruction;
import com.nukkitx.protocol.common.PacketSignal;
import com.nukkitx.protocol.common.util.OptionalBoolean;

public class CameraInstructionPacket implements BedrockPacket {
   private CameraSetInstruction setInstruction;
   private CameraFadeInstruction fadeInstruction;
   private OptionalBoolean clear = OptionalBoolean.empty();

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

   public CameraSetInstruction getSetInstruction() {
      return this.setInstruction;
   }

   public CameraFadeInstruction getFadeInstruction() {
      return this.fadeInstruction;
   }

   public OptionalBoolean getClear() {
      return this.clear;
   }

   public void setSetInstruction(CameraSetInstruction setInstruction) {
      this.setInstruction = setInstruction;
   }

   public void setFadeInstruction(CameraFadeInstruction fadeInstruction) {
      this.fadeInstruction = fadeInstruction;
   }

   @Override
   public boolean equals(Object o) {
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
            return this$clear == null ? other$clear == null : this$clear.equals(other$clear);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
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
      return result * 59 + ($clear == null ? 43 : $clear.hashCode());
   }

   @Override
   public String toString() {
      return "CameraInstructionPacket(setInstruction=" + this.setInstruction + ", fadeInstruction=" + this.fadeInstruction + ", clear=" + this.clear + ")";
   }
}
