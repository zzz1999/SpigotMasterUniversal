package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.math.vector.Vector2f;

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

   public Vector2f getInputMotion() {
      return this.inputMotion;
   }

   public boolean isJumping() {
      return this.jumping;
   }

   public boolean isSneaking() {
      return this.sneaking;
   }

   public void setInputMotion(Vector2f inputMotion) {
      this.inputMotion = inputMotion;
   }

   public void setJumping(boolean jumping) {
      this.jumping = jumping;
   }

   public void setSneaking(boolean sneaking) {
      this.sneaking = sneaking;
   }

   @Override
   public boolean equals(Object o) {
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

   protected boolean canEqual(Object other) {
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
