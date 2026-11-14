package com.neteasemc.protocol.custom.packet.customItemPacket;

import com.neteasemc.protocol.custom.GeyserBasePacket;
import com.neteasemc.protocol.custom.GeyserBasePacketHandler;
import com.neteasemc.protocol.custom.GeyserPacketType;
import com.nukkitx.protocol.common.PacketSignal;
import java.util.Map;
import org.bukkit.entity.Player;

public class CustomItemPacket extends GeyserBasePacket {
   private Map<String, String> items;

   @Override
   public GeyserPacketType getPacketType() {
      return GeyserPacketType.CUSTOM_ITEM;
   }

   @Override
   public PacketSignal handle(GeyserBasePacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public PacketSignal handle(GeyserBasePacketHandler handler, Player player) {
      return handler.handle(this, player);
   }

   public Map<String, String> getItems() {
      return this.items;
   }

   public void setItems(Map<String, String> items) {
      this.items = items;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CustomItemPacket)) {
         return false;
      }

      CustomItemPacket other = (CustomItemPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$items = this.items;
      Object other$items = other.items;
      return this$items == null ? other$items == null : this$items.equals(other$items);
   }

   @Override
   protected boolean canEqual(Object other) {
      return other instanceof CustomItemPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $items = this.items;
      return result * 59 + ($items == null ? 43 : $items.hashCode());
   }

   @Override
   public String toString() {
      return "CustomItemPacket(items=" + this.getItems() + ")";
   }
}
