package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class SetLocalPlayerAsInitializedPacket implements BedrockPacket {
   private long runtimeEntityId;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_LOCAL_PLAYER_AS_INITIALIZED;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public void setRuntimeEntityId(long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetLocalPlayerAsInitializedPacket)) {
         return false;
      }

      SetLocalPlayerAsInitializedPacket other = (SetLocalPlayerAsInitializedPacket)o;
      return !other.canEqual(this) ? false : this.runtimeEntityId == other.runtimeEntityId;
   }

   protected boolean canEqual(Object other) {
      return other instanceof SetLocalPlayerAsInitializedPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      return result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
   }

   @Override
   public String toString() {
      return "SetLocalPlayerAsInitializedPacket(runtimeEntityId=" + this.runtimeEntityId + ")";
   }
}
