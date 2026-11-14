package org.cloudburstmc.protocol.bedrock.data.inventory.transaction;

import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;

public final class InventoryActionData {
   private final InventorySource source;
   private final int slot;
   private final ItemData fromItem;
   private final ItemData toItem;
   private final int stackNetworkId;

   public InventoryActionData(InventorySource source, int slot, ItemData fromItem, ItemData toItem) {
      this(source, slot, fromItem, toItem, 0);
   }

   public InventoryActionData reverse() {
      return new InventoryActionData(this.source, this.slot, this.toItem, this.fromItem, this.stackNetworkId);
   }

   public InventorySource getSource() {
      return this.source;
   }

   public int getSlot() {
      return this.slot;
   }

   public ItemData getFromItem() {
      return this.fromItem;
   }

   public ItemData getToItem() {
      return this.toItem;
   }

   public int getStackNetworkId() {
      return this.stackNetworkId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryActionData)) {
         return false;
      }

      InventoryActionData other = (InventoryActionData)o;
      if (this.getSlot() != other.getSlot()) {
         return false;
      }

      if (this.getStackNetworkId() != other.getStackNetworkId()) {
         return false;
      }

      Object this$source = this.getSource();
      Object other$source = other.getSource();
      if (this$source == null ? other$source == null : this$source.equals(other$source)) {
         Object this$fromItem = this.getFromItem();
         Object other$fromItem = other.getFromItem();
         if (this$fromItem == null ? other$fromItem == null : this$fromItem.equals(other$fromItem)) {
            Object this$toItem = this.getToItem();
            Object other$toItem = other.getToItem();
            return this$toItem == null ? other$toItem == null : this$toItem.equals(other$toItem);
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
      result = result * 59 + this.getSlot();
      result = result * 59 + this.getStackNetworkId();
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $fromItem = this.getFromItem();
      result = result * 59 + ($fromItem == null ? 43 : $fromItem.hashCode());
      Object $toItem = this.getToItem();
      return result * 59 + ($toItem == null ? 43 : $toItem.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryActionData(source="
         + this.getSource()
         + ", slot="
         + this.getSlot()
         + ", fromItem="
         + this.getFromItem()
         + ", toItem="
         + this.getToItem()
         + ", stackNetworkId="
         + this.getStackNetworkId()
         + ")";
   }

   public InventoryActionData(final InventorySource source, final int slot, final ItemData fromItem, final ItemData toItem, final int stackNetworkId) {
      this.source = source;
      this.slot = slot;
      this.fromItem = fromItem;
      this.toItem = toItem;
      this.stackNetworkId = stackNetworkId;
   }
}
