package org.cloudburstmc.protocol.bedrock.data.command;

import java.util.UUID;

public final class CommandOriginData {
   private final CommandOriginType origin;
   private final UUID uuid;
   private final String requestId;
   private final long playerId;

   public CommandOriginData(final CommandOriginType origin, final UUID uuid, final String requestId, final long playerId) {
      this.origin = origin;
      this.uuid = uuid;
      this.requestId = requestId;
      this.playerId = playerId;
   }

   public CommandOriginType getOrigin() {
      return this.origin;
   }

   public UUID getUuid() {
      return this.uuid;
   }

   public String getRequestId() {
      return this.requestId;
   }

   public long getPlayerId() {
      return this.playerId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CommandOriginData)) {
         return false;
      }

      CommandOriginData other = (CommandOriginData)o;
      if (this.getPlayerId() != other.getPlayerId()) {
         return false;
      }

      Object this$origin = this.getOrigin();
      Object other$origin = other.getOrigin();
      if (this$origin == null ? other$origin == null : this$origin.equals(other$origin)) {
         Object this$uuid = this.getUuid();
         Object other$uuid = other.getUuid();
         if (this$uuid == null ? other$uuid == null : this$uuid.equals(other$uuid)) {
            Object this$requestId = this.getRequestId();
            Object other$requestId = other.getRequestId();
            return this$requestId == null ? other$requestId == null : this$requestId.equals(other$requestId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $playerId = this.getPlayerId();
      result = result * 59 + (int)($playerId >>> 32 ^ $playerId);
      Object $origin = this.getOrigin();
      result = result * 59 + ($origin == null ? 43 : $origin.hashCode());
      Object $uuid = this.getUuid();
      result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
      Object $requestId = this.getRequestId();
      return result * 59 + ($requestId == null ? 43 : $requestId.hashCode());
   }

   @Override
   public String toString() {
      return "CommandOriginData(origin="
         + this.getOrigin()
         + ", uuid="
         + this.getUuid()
         + ", requestId="
         + this.getRequestId()
         + ", playerId="
         + this.getPlayerId()
         + ")";
   }
}
