package org.cloudburstmc.protocol.bedrock.data.inventory.descriptor;

import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;

public final class ItemTagDescriptor implements ItemDescriptor {
   private final String itemTag;

   @Override
   public ItemDescriptorType getType() {
      return ItemDescriptorType.ITEM_TAG;
   }

   @Override
   public ItemData.Builder toItem() {
      throw new UnsupportedOperationException();
   }

   public ItemTagDescriptor(final String itemTag) {
      this.itemTag = itemTag;
   }

   public String getItemTag() {
      return this.itemTag;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ItemTagDescriptor)) {
         return false;
      }

      ItemTagDescriptor other = (ItemTagDescriptor)o;
      Object this$itemTag = this.getItemTag();
      Object other$itemTag = other.getItemTag();
      return this$itemTag == null ? other$itemTag == null : this$itemTag.equals(other$itemTag);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $itemTag = this.getItemTag();
      return result * 59 + ($itemTag == null ? 43 : $itemTag.hashCode());
   }

   @Override
   public String toString() {
      return "ItemTagDescriptor(itemTag=" + this.getItemTag() + ")";
   }
}
