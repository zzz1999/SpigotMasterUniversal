package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

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

   public int getGamemode() {
      return this.gamemode;
   }

   public void setGamemode(int gamemode) {
      this.gamemode = gamemode;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetPlayerGameTypePacket)) {
         return false;
      }

      SetPlayerGameTypePacket other = (SetPlayerGameTypePacket)o;
      return !other.canEqual(this) ? false : this.gamemode == other.gamemode;
   }

   protected boolean canEqual(Object other) {
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
