package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.inventory.ComponentItemData;
import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class ItemComponentPacket implements BedrockPacket {
   private final List<ComponentItemData> items = new ObjectArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ITEM_COMPONENT;
   }

   public List<ComponentItemData> getItems() {
      return this.items;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ItemComponentPacket)) {
         return false;
      }

      ItemComponentPacket other = (ItemComponentPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$items = this.items;
      Object other$items = other.items;
      return this$items == null ? other$items == null : this$items.equals(other$items);
   }

   protected boolean canEqual(Object other) {
      return other instanceof ItemComponentPacket;
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
      return "ItemComponentPacket(items=" + this.items + ")";
   }
}
