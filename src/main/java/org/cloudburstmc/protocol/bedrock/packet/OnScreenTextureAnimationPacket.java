package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

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

   public OnScreenTextureAnimationPacket clone() {
      try {
         return (OnScreenTextureAnimationPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getEffectId() {
      return this.effectId;
   }

   public void setEffectId(final long effectId) {
      this.effectId = effectId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OnScreenTextureAnimationPacket)) {
         return false;
      }

      OnScreenTextureAnimationPacket other = (OnScreenTextureAnimationPacket)o;
      return !other.canEqual(this) ? false : this.effectId == other.effectId;
   }

   protected boolean canEqual(final Object other) {
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
