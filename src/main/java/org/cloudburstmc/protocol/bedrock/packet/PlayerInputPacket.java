package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector2f;
import org.cloudburstmc.protocol.common.PacketSignal;

/** @deprecated */
public class PlayerInputPacket implements BedrockPacket {
   private Vector2f inputMotion;
   private boolean jumping;
   private boolean sneaking;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAYER_INPUT;
   }

   public PlayerInputPacket clone() {
      try {
         return (PlayerInputPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public Vector2f getInputMotion() {
      return this.inputMotion;
   }

   public boolean isJumping() {
      return this.jumping;
   }

   public boolean isSneaking() {
      return this.sneaking;
   }

   public void setInputMotion(final Vector2f inputMotion) {
      this.inputMotion = inputMotion;
   }

   public void setJumping(final boolean jumping) {
      this.jumping = jumping;
   }

   public void setSneaking(final boolean sneaking) {
      this.sneaking = sneaking;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlayerInputPacket)) {
         return false;
      }

      PlayerInputPacket other = (PlayerInputPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.jumping != other.jumping) {
         return false;
      }

      if (this.sneaking != other.sneaking) {
         return false;
      }

      Object this$inputMotion = this.inputMotion;
      Object other$inputMotion = other.inputMotion;
      return this$inputMotion == null ? other$inputMotion == null : this$inputMotion.equals(other$inputMotion);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlayerInputPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.jumping ? 79 : 97);
      result = result * 59 + (this.sneaking ? 79 : 97);
      Object $inputMotion = this.inputMotion;
      return result * 59 + ($inputMotion == null ? 43 : $inputMotion.hashCode());
   }

   @Override
   public String toString() {
      return "PlayerInputPacket(inputMotion=" + this.inputMotion + ", jumping=" + this.jumping + ", sneaking=" + this.sneaking + ")";
   }
}
