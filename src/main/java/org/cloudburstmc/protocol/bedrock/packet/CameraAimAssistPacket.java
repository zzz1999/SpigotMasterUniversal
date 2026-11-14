package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector2f;
import org.cloudburstmc.protocol.bedrock.data.camera.AimAssistAction;
import org.cloudburstmc.protocol.common.PacketSignal;

public class CameraAimAssistPacket implements BedrockPacket {
   private Vector2f viewAngle;
   private float distance;
   private CameraAimAssistPacket.TargetMode targetMode;
   private AimAssistAction action;
   private String presetId;
   private boolean showDebugRender;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CAMERA_AIM_ASSIST;
   }

   public CameraAimAssistPacket clone() {
      try {
         return (CameraAimAssistPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public Vector2f getViewAngle() {
      return this.viewAngle;
   }

   public float getDistance() {
      return this.distance;
   }

   public CameraAimAssistPacket.TargetMode getTargetMode() {
      return this.targetMode;
   }

   public AimAssistAction getAction() {
      return this.action;
   }

   public String getPresetId() {
      return this.presetId;
   }

   public boolean isShowDebugRender() {
      return this.showDebugRender;
   }

   public void setViewAngle(final Vector2f viewAngle) {
      this.viewAngle = viewAngle;
   }

   public void setDistance(final float distance) {
      this.distance = distance;
   }

   public void setTargetMode(final CameraAimAssistPacket.TargetMode targetMode) {
      this.targetMode = targetMode;
   }

   public void setAction(final AimAssistAction action) {
      this.action = action;
   }

   public void setPresetId(final String presetId) {
      this.presetId = presetId;
   }

   public void setShowDebugRender(final boolean showDebugRender) {
      this.showDebugRender = showDebugRender;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraAimAssistPacket)) {
         return false;
      }

      CameraAimAssistPacket other = (CameraAimAssistPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (Float.compare(this.distance, other.distance) != 0) {
         return false;
      }

      if (this.showDebugRender != other.showDebugRender) {
         return false;
      }

      Object this$viewAngle = this.viewAngle;
      Object other$viewAngle = other.viewAngle;
      if (this$viewAngle == null ? other$viewAngle == null : this$viewAngle.equals(other$viewAngle)) {
         Object this$targetMode = this.targetMode;
         Object other$targetMode = other.targetMode;
         if (this$targetMode == null ? other$targetMode == null : this$targetMode.equals(other$targetMode)) {
            Object this$action = this.action;
            Object other$action = other.action;
            if (this$action == null ? other$action == null : this$action.equals(other$action)) {
               Object this$presetId = this.presetId;
               Object other$presetId = other.presetId;
               return this$presetId == null ? other$presetId == null : this$presetId.equals(other$presetId);
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
      return other instanceof CameraAimAssistPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.distance);
      result = result * 59 + (this.showDebugRender ? 79 : 97);
      Object $viewAngle = this.viewAngle;
      result = result * 59 + ($viewAngle == null ? 43 : $viewAngle.hashCode());
      Object $targetMode = this.targetMode;
      result = result * 59 + ($targetMode == null ? 43 : $targetMode.hashCode());
      Object $action = this.action;
      result = result * 59 + ($action == null ? 43 : $action.hashCode());
      Object $presetId = this.presetId;
      return result * 59 + ($presetId == null ? 43 : $presetId.hashCode());
   }

   @Override
   public String toString() {
      return "CameraAimAssistPacket(viewAngle="
         + this.viewAngle
         + ", distance="
         + this.distance
         + ", targetMode="
         + this.targetMode
         + ", action="
         + this.action
         + ", presetId="
         + this.presetId
         + ", showDebugRender="
         + this.showDebugRender
         + ")";
   }

   public enum TargetMode {
      ANGLE,
      DISTANCE;
   }
}
