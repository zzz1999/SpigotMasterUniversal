package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.inventory.ContainerSlotType;
import org.cloudburstmc.protocol.bedrock.data.inventory.FullContainerName;
import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;
import org.cloudburstmc.protocol.common.PacketSignal;

public class InventorySlotPacket implements BedrockPacket {
   private int containerId;
   private int slot;
   private ItemData item;
   private FullContainerName containerNameData = new FullContainerName(ContainerSlotType.ANVIL_INPUT, null);
   /** @deprecated */
   private int dynamicContainerSize;
   private ItemData storageItem = ItemData.AIR;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.INVENTORY_SLOT;
   }

   public InventorySlotPacket clone() {
      try {
         return (InventorySlotPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getContainerId() {
      return this.containerId;
   }

   public int getSlot() {
      return this.slot;
   }

   public ItemData getItem() {
      return this.item;
   }

   public FullContainerName getContainerNameData() {
      return this.containerNameData;
   }

   @Deprecated
   public int getDynamicContainerSize() {
      return this.dynamicContainerSize;
   }

   public ItemData getStorageItem() {
      return this.storageItem;
   }

   public void setContainerId(final int containerId) {
      this.containerId = containerId;
   }

   public void setSlot(final int slot) {
      this.slot = slot;
   }

   public void setItem(final ItemData item) {
      this.item = item;
   }

   public void setContainerNameData(final FullContainerName containerNameData) {
      this.containerNameData = containerNameData;
   }

   @Deprecated
   public void setDynamicContainerSize(final int dynamicContainerSize) {
      this.dynamicContainerSize = dynamicContainerSize;
   }

   public void setStorageItem(final ItemData storageItem) {
      this.storageItem = storageItem;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventorySlotPacket)) {
         return false;
      }

      InventorySlotPacket other = (InventorySlotPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.containerId != other.containerId) {
         return false;
      }

      if (this.slot != other.slot) {
         return false;
      }

      if (this.dynamicContainerSize != other.dynamicContainerSize) {
         return false;
      }

      Object this$item = this.item;
      Object other$item = other.item;
      if (this$item == null ? other$item == null : this$item.equals(other$item)) {
         Object this$containerNameData = this.containerNameData;
         Object other$containerNameData = other.containerNameData;
         if (this$containerNameData == null ? other$containerNameData == null : this$containerNameData.equals(other$containerNameData)) {
            Object this$storageItem = this.storageItem;
            Object other$storageItem = other.storageItem;
            return this$storageItem == null ? other$storageItem == null : this$storageItem.equals(other$storageItem);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InventorySlotPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.containerId;
      result = result * 59 + this.slot;
      result = result * 59 + this.dynamicContainerSize;
      Object $item = this.item;
      result = result * 59 + ($item == null ? 43 : $item.hashCode());
      Object $containerNameData = this.containerNameData;
      result = result * 59 + ($containerNameData == null ? 43 : $containerNameData.hashCode());
      Object $storageItem = this.storageItem;
      return result * 59 + ($storageItem == null ? 43 : $storageItem.hashCode());
   }

   @Override
   public String toString() {
      return "InventorySlotPacket(containerId="
         + this.containerId
         + ", slot="
         + this.slot
         + ", item="
         + this.item
         + ", containerNameData="
         + this.containerNameData
         + ", dynamicContainerSize="
         + this.dynamicContainerSize
         + ", storageItem="
         + this.storageItem
         + ")";
   }
}
