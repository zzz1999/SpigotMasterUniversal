package com.nukkitx.protocol.bedrock.data.inventory.itemstack.request;

import com.nukkitx.protocol.bedrock.data.inventory.ContainerSlotType;

public final class ItemStackRequestSlotData {
   private final ContainerSlotType container;
   private final int slot;
   private final int stackNetworkId;

   public ItemStackRequestSlotData(ContainerSlotType container, int slot, int stackNetworkId) {
      this.container = container;
      this.slot = slot;
      this.stackNetworkId = stackNetworkId;
   }

   public ContainerSlotType getContainer() {
      return this.container;
   }

   public int getSlot() {
      return this.slot;
   }

   public int getStackNetworkId() {
      return this.stackNetworkId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ItemStackRequestSlotData)) {
         return false;
      }

      ItemStackRequestSlotData other = (ItemStackRequestSlotData)o;
      if (this.getSlot() != other.getSlot()) {
         return false;
      }

      if (this.getStackNetworkId() != other.getStackNetworkId()) {
         return false;
      }

      Object this$container = this.getContainer();
      Object other$container = other.getContainer();
      return this$container == null ? other$container == null : this$container.equals(other$container);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getSlot();
      result = result * 59 + this.getStackNetworkId();
      Object $container = this.getContainer();
      return result * 59 + ($container == null ? 43 : $container.hashCode());
   }

   @Override
   public String toString() {
      return "ItemStackRequestSlotData(container=" + this.getContainer() + ", slot=" + this.getSlot() + ", stackNetworkId=" + this.getStackNetworkId() + ")";
   }
}
