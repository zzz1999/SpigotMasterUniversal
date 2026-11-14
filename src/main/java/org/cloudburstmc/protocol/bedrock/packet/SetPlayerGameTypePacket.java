package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class SetPlayerGameTypePacket implements BedrockPacket {
   private int gamemode;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_PLAYER_GAME_TYPE;
   }

   public SetPlayerGameTypePacket clone() {
      try {
         return (SetPlayerGameTypePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getGamemode() {
      return this.gamemode;
   }

   public void setGamemode(final int gamemode) {
      this.gamemode = gamemode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetPlayerGameTypePacket)) {
         return false;
      }

      SetPlayerGameTypePacket other = (SetPlayerGameTypePacket)o;
      return !other.canEqual(this) ? false : this.gamemode == other.gamemode;
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SetPlayerGameTypePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.gamemode;
   }

   @Override
   public String toString() {
      return "SetPlayerGameTypePacket(gamemode=" + this.gamemode + ")";
   }
}
