package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class OnScreenTextureAnimationPacket implements BedrockPacket {
   private long effectId;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ON_SCREEN_TEXTURE_ANIMATION;
   }

   public long getEffectId() {
      return this.effectId;
   }

   public void setEffectId(long effectId) {
      this.effectId = effectId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OnScreenTextureAnimationPacket)) {
         return false;
      }

      OnScreenTextureAnimationPacket other = (OnScreenTextureAnimationPacket)o;
      return !other.canEqual(this) ? false : this.effectId == other.effectId;
   }

   protected boolean canEqual(Object other) {
      return other instanceof OnScreenTextureAnimationPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $effectId = this.effectId;
      return result * 59 + (int)($effectId >>> 32 ^ $effectId);
   }

   @Override
   public String toString() {
      return "OnScreenTextureAnimationPacket(effectId=" + this.effectId + ")";
   }
}
