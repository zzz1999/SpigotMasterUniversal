package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class AgentAnimationPacket implements BedrockPacket {
   private byte animation;
   private long runtimeEntityId;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.AGENT_ANIMATION;
   }

   public byte getAnimation() {
      return this.animation;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public void setAnimation(byte animation) {
      this.animation = animation;
   }

   public void setRuntimeEntityId(long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AgentAnimationPacket)) {
         return false;
      } else {
         AgentAnimationPacket other = (AgentAnimationPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            return this.animation != other.animation ? false : this.runtimeEntityId == other.runtimeEntityId;
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof AgentAnimationPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.animation;
      long $runtimeEntityId = this.runtimeEntityId;
      return result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
   }

   @Override
   public String toString() {
      return "AgentAnimationPacket(animation=" + this.animation + ", runtimeEntityId=" + this.runtimeEntityId + ")";
   }
}
