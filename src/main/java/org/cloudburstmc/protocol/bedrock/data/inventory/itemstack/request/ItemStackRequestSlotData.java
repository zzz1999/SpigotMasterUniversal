package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request;

import org.cloudburstmc.protocol.bedrock.data.inventory.ContainerSlotType;
import org.cloudburstmc.protocol.bedrock.data.inventory.FullContainerName;

public final class ItemStackRequestSlotData {
   /** @deprecated */
   private final ContainerSlotType container;
   private final int slot;
   private final int stackNetworkId;
   private final FullContainerName containerName;

   public ItemStackRequestSlotData(final ContainerSlotType container, final int slot, final int stackNetworkId, final FullContainerName containerName) {
      this.container = container;
      this.slot = slot;
      this.stackNetworkId = stackNetworkId;
      this.containerName = containerName;
   }

   @Deprecated
   public ContainerSlotType getContainer() {
      return this.container;
   }

   public int getSlot() {
      return this.slot;
   }

   public int getStackNetworkId() {
      return this.stackNetworkId;
   }

   public FullContainerName getContainerName() {
      return this.containerName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ItemStackRequestSlotData)) {
         return false;
      } else {
         ItemStackRequestSlotData other = (ItemStackRequestSlotData)o;
         if (this.getSlot() != other.getSlot()) {
            return false;
         } else if (this.getStackNetworkId() != other.getStackNetworkId()) {
            return false;
         } else {
            Object this$container = this.getContainer();
            Object other$container = other.getContainer();
            if (this$container == null ? other$container == null : this$container.equals(other$container)) {
               Object this$containerName = this.getContainerName();
               Object other$containerName = other.getContainerName();
               return this$containerName == null ? other$containerName == null : this$containerName.equals(other$containerName);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getSlot();
      result = result * 59 + this.getStackNetworkId();
      Object $container = this.getContainer();
      result = result * 59 + ($container == null ? 43 : $container.hashCode());
      Object $containerName = this.getContainerName();
      return result * 59 + ($containerName == null ? 43 : $containerName.hashCode());
   }

   @Override
   public String toString() {
      return "ItemStackRequestSlotData(container="
         + this.getContainer()
         + ", slot="
         + this.getSlot()
         + ", stackNetworkId="
         + this.getStackNetworkId()
         + ", containerName="
         + this.getContainerName()
         + ")";
   }
}
