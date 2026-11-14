package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.definitions.ItemDefinition;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ItemComponentPacket implements BedrockPacket {
   private final List<ItemDefinition> items = new ObjectArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ITEM_COMPONENT;
   }

   public ItemComponentPacket clone() {
      try {
         return (ItemComponentPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<ItemDefinition> getItems() {
      return this.items;
   }

   @Override
   public boolean equals(final Object o) {
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

   protected boolean canEqual(final Object other) {
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
