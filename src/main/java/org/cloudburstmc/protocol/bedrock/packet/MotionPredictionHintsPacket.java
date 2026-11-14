package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.common.PacketSignal;

public class MotionPredictionHintsPacket implements BedrockPacket {
   private long runtimeEntityId;
   private Vector3f motion;
   private boolean onGround;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_ENTITY_MOTION_PLUS;
   }

   public MotionPredictionHintsPacket clone() {
      try {
         return (MotionPredictionHintsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public Vector3f getMotion() {
      return this.motion;
   }

   public boolean isOnGround() {
      return this.onGround;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setMotion(final Vector3f motion) {
      this.motion = motion;
   }

   public void setOnGround(final boolean onGround) {
      this.onGround = onGround;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MotionPredictionHintsPacket)) {
         return false;
      }

      MotionPredictionHintsPacket other = (MotionPredictionHintsPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.onGround != other.onGround) {
         return false;
      }

      Object this$motion = this.motion;
      Object other$motion = other.motion;
      return this$motion == null ? other$motion == null : this$motion.equals(other$motion);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MotionPredictionHintsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + (this.onGround ? 79 : 97);
      Object $motion = this.motion;
      return result * 59 + ($motion == null ? 43 : $motion.hashCode());
   }

   @Override
   public String toString() {
      return "MotionPredictionHintsPacket(runtimeEntityId=" + this.runtimeEntityId + ", motion=" + this.motion + ", onGround=" + this.onGround + ")";
   }
}
