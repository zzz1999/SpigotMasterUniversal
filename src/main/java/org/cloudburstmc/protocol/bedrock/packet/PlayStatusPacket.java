package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class PlayStatusPacket implements BedrockPacket {
   private PlayStatusPacket.Status status;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAY_STATUS;
   }

   public PlayStatusPacket clone() {
      try {
         return (PlayStatusPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public PlayStatusPacket.Status getStatus() {
      return this.status;
   }

   public void setStatus(final PlayStatusPacket.Status status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlayStatusPacket)) {
         return false;
      }

      PlayStatusPacket other = (PlayStatusPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$status = this.status;
      Object other$status = other.status;
      return this$status == null ? other$status == null : this$status.equals(other$status);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlayStatusPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $status = this.status;
      return result * 59 + ($status == null ? 43 : $status.hashCode());
   }

   @Override
   public String toString() {
      return "PlayStatusPacket(status=" + this.status + ")";
   }

   public enum Status {
      LOGIN_SUCCESS,
      LOGIN_FAILED_CLIENT_OLD,
      LOGIN_FAILED_SERVER_OLD,
      PLAYER_SPAWN,
      LOGIN_FAILED_INVALID_TENANT,
      LOGIN_FAILED_EDITION_MISMATCH_EDU_TO_VANILLA,
      LOGIN_FAILED_EDITION_MISMATCH_VANILLA_TO_EDU,
      FAILED_SERVER_FULL_SUB_CLIENT,
      EDITOR_TO_VANILLA_MISMATCH,
      VANILLA_TO_EDITOR_MISMATCH;
   }
}
