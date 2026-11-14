package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class AnimatePacket implements BedrockPacket {
   private float rowingTime;
   private AnimatePacket.Action action;
   private long runtimeEntityId;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ANIMATE;
   }

   public float getRowingTime() {
      return this.rowingTime;
   }

   public AnimatePacket.Action getAction() {
      return this.action;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public void setRowingTime(float rowingTime) {
      this.rowingTime = rowingTime;
   }

   public void setAction(AnimatePacket.Action action) {
      this.action = action;
   }

   public void setRuntimeEntityId(long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AnimatePacket)) {
         return false;
      }

      AnimatePacket other = (AnimatePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (Float.compare(this.rowingTime, other.rowingTime) != 0) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      Object this$action = this.action;
      Object other$action = other.action;
      return this$action == null ? other$action == null : this$action.equals(other$action);
   }

   protected boolean canEqual(Object other) {
      return other instanceof AnimatePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.rowingTime);
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      Object $action = this.action;
      return result * 59 + ($action == null ? 43 : $action.hashCode());
   }

   @Override
   public String toString() {
      return "AnimatePacket(rowingTime=" + this.rowingTime + ", action=" + this.action + ", runtimeEntityId=" + this.runtimeEntityId + ")";
   }

   public enum Action {
      NO_ACTION,
      SWING_ARM,
      WAKE_UP,
      CRITICAL_HIT,
      MAGIC_CRITICAL_HIT,
      ROW_RIGHT,
      ROW_LEFT;
   }
}
