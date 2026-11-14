package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.response;

import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.inventory.ContainerSlotType;
import org.cloudburstmc.protocol.bedrock.data.inventory.FullContainerName;

public final class ItemStackResponseContainer {
   /** @deprecated */
   private final ContainerSlotType container;
   private final List<ItemStackResponseSlot> items;
   private final FullContainerName containerName;

   public ItemStackResponseContainer(final ContainerSlotType container, final List<ItemStackResponseSlot> items, final FullContainerName containerName) {
      this.container = container;
      this.items = items;
      this.containerName = containerName;
   }

   @Deprecated
   public ContainerSlotType getContainer() {
      return this.container;
   }

   public List<ItemStackResponseSlot> getItems() {
      return this.items;
   }

   public FullContainerName getContainerName() {
      return this.containerName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ItemStackResponseContainer)) {
         return false;
      }

      ItemStackResponseContainer other = (ItemStackResponseContainer)o;
      Object this$container = this.getContainer();
      Object other$container = other.getContainer();
      if (this$container == null ? other$container == null : this$container.equals(other$container)) {
         Object this$items = this.getItems();
         Object other$items = other.getItems();
         if (this$items == null ? other$items == null : this$items.equals(other$items)) {
            Object this$containerName = this.getContainerName();
            Object other$containerName = other.getContainerName();
            return this$containerName == null ? other$containerName == null : this$containerName.equals(other$containerName);
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
      Object $container = this.getContainer();
      result = result * 59 + ($container == null ? 43 : $container.hashCode());
      Object $items = this.getItems();
      result = result * 59 + ($items == null ? 43 : $items.hashCode());
      Object $containerName = this.getContainerName();
      return result * 59 + ($containerName == null ? 43 : $containerName.hashCode());
   }

   @Override
   public String toString() {
      return "ItemStackResponseContainer(container=" + this.getContainer() + ", items=" + this.getItems() + ", containerName=" + this.getContainerName() + ")";
   }
}
