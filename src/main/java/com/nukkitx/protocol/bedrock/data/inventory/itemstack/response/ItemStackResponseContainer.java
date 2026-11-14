package com.nukkitx.protocol.bedrock.data.inventory.itemstack.response;

import com.nukkitx.protocol.bedrock.data.inventory.ContainerSlotType;
import java.util.List;

public final class ItemStackResponseContainer {
   private final ContainerSlotType container;
   private final List<ItemStackResponseSlot> items;

   public ItemStackResponseContainer(ContainerSlotType container, List<ItemStackResponseSlot> items) {
      this.container = container;
      this.items = items;
   }

   public ContainerSlotType getContainer() {
      return this.container;
   }

   public List<ItemStackResponseSlot> getItems() {
      return this.items;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ItemStackResponseContainer)) {
         return false;
      } else {
         ItemStackResponseContainer other = (ItemStackResponseContainer)o;
         Object this$container = this.getContainer();
         Object other$container = other.getContainer();
         if (this$container == null ? other$container == null : this$container.equals(other$container)) {
            Object this$items = this.getItems();
            Object other$items = other.getItems();
            return this$items == null ? other$items == null : this$items.equals(other$items);
         } else {
            return false;
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $container = this.getContainer();
      result = result * 59 + ($container == null ? 43 : $container.hashCode());
      Object $items = this.getItems();
      return result * 59 + ($items == null ? 43 : $items.hashCode());
   }

   @Override
   public String toString() {
      return "ItemStackResponseContainer(container=" + this.getContainer() + ", items=" + this.getItems() + ")";
   }
}
