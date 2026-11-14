package com.neteasemc.protocol.custom.packet.neteaseJsonPacket;

import com.neteasemc.protocol.custom.GeyserBasePacket;
import com.neteasemc.protocol.custom.GeyserBasePacketHandler;
import com.neteasemc.protocol.custom.GeyserPacketType;
import com.nukkitx.protocol.common.PacketSignal;
import org.bukkit.entity.Player;

public class NeteaseJsonPacket extends GeyserBasePacket {
   String jsonString;

   public NeteaseJsonPacket() {
   }

   public NeteaseJsonPacket(String jsoString) {
      this.jsonString = jsoString;
   }

   @Override
   public GeyserPacketType getPacketType() {
      return GeyserPacketType.NETEASE_JSON;
   }

   @Override
   public PacketSignal handle(GeyserBasePacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public PacketSignal handle(GeyserBasePacketHandler handler, Player player) {
      return handler.handle(this, player);
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NeteaseJsonPacket)) {
         return false;
      }

      NeteaseJsonPacket other = (NeteaseJsonPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$jsonString = this.jsonString;
      Object other$jsonString = other.jsonString;
      return this$jsonString == null ? other$jsonString == null : this$jsonString.equals(other$jsonString);
   }

   @Override
   protected boolean canEqual(Object other) {
      return other instanceof NeteaseJsonPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $jsonString = this.jsonString;
      return result * 59 + ($jsonString == null ? 43 : $jsonString.hashCode());
   }

   @Override
   public String toString() {
      return "NeteaseJsonPacket(jsonString=" + this.getJsonString() + ")";
   }

   public String getJsonString() {
      return this.jsonString;
   }

   public void setJsonString(String jsonString) {
      this.jsonString = jsonString;
   }
}
