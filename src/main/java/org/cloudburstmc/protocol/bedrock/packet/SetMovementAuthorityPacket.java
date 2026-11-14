package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.AuthoritativeMovementMode;
import org.cloudburstmc.protocol.common.PacketSignal;

public class SetMovementAuthorityPacket implements BedrockPacket {
   private AuthoritativeMovementMode movementMode;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_MOVEMENT_AUTHORITY;
   }

   public SetMovementAuthorityPacket clone() {
      try {
         return (SetMovementAuthorityPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public AuthoritativeMovementMode getMovementMode() {
      return this.movementMode;
   }

   public void setMovementMode(final AuthoritativeMovementMode movementMode) {
      this.movementMode = movementMode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetMovementAuthorityPacket)) {
         return false;
      }

      SetMovementAuthorityPacket other = (SetMovementAuthorityPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$movementMode = this.movementMode;
      Object other$movementMode = other.movementMode;
      return this$movementMode == null ? other$movementMode == null : this$movementMode.equals(other$movementMode);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SetMovementAuthorityPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $movementMode = this.movementMode;
      return result * 59 + ($movementMode == null ? 43 : $movementMode.hashCode());
   }

   @Override
   public String toString() {
      return "SetMovementAuthorityPacket(movementMode=" + this.movementMode + ")";
   }
}
