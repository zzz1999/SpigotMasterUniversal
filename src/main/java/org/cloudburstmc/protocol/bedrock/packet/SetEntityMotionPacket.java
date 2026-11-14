package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.common.PacketSignal;

public class SetEntityMotionPacket implements BedrockPacket {
   private long runtimeEntityId;
   private Vector3f motion;
   private long tick;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_ENTITY_MOTION;
   }

   public SetEntityMotionPacket clone() {
      try {
         return (SetEntityMotionPacket)super.clone();
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

   public long getTick() {
      return this.tick;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setMotion(final Vector3f motion) {
      this.motion = motion;
   }

   public void setTick(final long tick) {
      this.tick = tick;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetEntityMotionPacket)) {
         return false;
      }

      SetEntityMotionPacket other = (SetEntityMotionPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.tick != other.tick) {
         return false;
      }

      Object this$motion = this.motion;
      Object other$motion = other.motion;
      return this$motion == null ? other$motion == null : this$motion.equals(other$motion);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SetEntityMotionPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      long $tick = this.tick;
      result = result * 59 + (int)($tick >>> 32 ^ $tick);
      Object $motion = this.motion;
      return result * 59 + ($motion == null ? 43 : $motion.hashCode());
   }

   @Override
   public String toString() {
      return "SetEntityMotionPacket(runtimeEntityId=" + this.runtimeEntityId + ", motion=" + this.motion + ", tick=" + this.tick + ")";
   }
}
