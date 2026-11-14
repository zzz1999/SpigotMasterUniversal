package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.GameType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class UpdatePlayerGameTypePacket implements BedrockPacket {
   private GameType gameType;
   private long entityId;
   private long tick;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.UPDATE_PLAYER_GAME_TYPE;
   }

   public UpdatePlayerGameTypePacket clone() {
      try {
         return (UpdatePlayerGameTypePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public GameType getGameType() {
      return this.gameType;
   }

   public long getEntityId() {
      return this.entityId;
   }

   public long getTick() {
      return this.tick;
   }

   public void setGameType(final GameType gameType) {
      this.gameType = gameType;
   }

   public void setEntityId(final long entityId) {
      this.entityId = entityId;
   }

   public void setTick(final long tick) {
      this.tick = tick;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UpdatePlayerGameTypePacket)) {
         return false;
      }

      UpdatePlayerGameTypePacket other = (UpdatePlayerGameTypePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getEntityId() != other.getEntityId()) {
         return false;
      }

      if (this.getTick() != other.getTick()) {
         return false;
      }

      Object this$gameType = this.getGameType();
      Object other$gameType = other.getGameType();
      return this$gameType == null ? other$gameType == null : this$gameType.equals(other$gameType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UpdatePlayerGameTypePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $entityId = this.getEntityId();
      result = result * 59 + (int)($entityId >>> 32 ^ $entityId);
      long $tick = this.getTick();
      result = result * 59 + (int)($tick >>> 32 ^ $tick);
      Object $gameType = this.getGameType();
      return result * 59 + ($gameType == null ? 43 : $gameType.hashCode());
   }

   @Override
   public String toString() {
      return "UpdatePlayerGameTypePacket(gameType=" + this.gameType + ", entityId=" + this.entityId + ", tick=" + this.tick + ")";
   }
}
