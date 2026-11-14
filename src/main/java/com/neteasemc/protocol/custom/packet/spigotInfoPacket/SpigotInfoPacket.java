package com.neteasemc.protocol.custom.packet.spigotInfoPacket;

import com.neteasemc.protocol.custom.GeyserBasePacket;
import com.neteasemc.protocol.custom.GeyserBasePacketHandler;
import com.neteasemc.protocol.custom.GeyserPacketType;
import com.nukkitx.protocol.common.PacketSignal;
import org.bukkit.entity.Player;

public class SpigotInfoPacket extends GeyserBasePacket {
   private String spigotVersion = "";

   @Override
   public GeyserPacketType getPacketType() {
      return GeyserPacketType.SPIGOT_INFO;
   }

   @Override
   public PacketSignal handle(GeyserBasePacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public PacketSignal handle(GeyserBasePacketHandler handler, Player player) {
      return handler.handle(this, player);
   }

   public String getSpigotVersion() {
      return this.spigotVersion;
   }

   public void setSpigotVersion(String spigotVersion) {
      this.spigotVersion = spigotVersion;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SpigotInfoPacket)) {
         return false;
      }

      SpigotInfoPacket other = (SpigotInfoPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$spigotVersion = this.spigotVersion;
      Object other$spigotVersion = other.spigotVersion;
      return this$spigotVersion == null ? other$spigotVersion == null : this$spigotVersion.equals(other$spigotVersion);
   }

   @Override
   protected boolean canEqual(Object other) {
      return other instanceof SpigotInfoPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $spigotVersion = this.spigotVersion;
      return result * 59 + ($spigotVersion == null ? 43 : $spigotVersion.hashCode());
   }

   @Override
   public String toString() {
      return "SpigotInfoPacket(spigotVersion=" + this.getSpigotVersion() + ")";
   }
}
