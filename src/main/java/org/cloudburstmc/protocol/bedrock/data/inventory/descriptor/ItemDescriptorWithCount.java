package org.cloudburstmc.protocol.bedrock.data.inventory.descriptor;

import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;

public class ItemDescriptorWithCount {
   public static final ItemDescriptorWithCount EMPTY = new ItemDescriptorWithCount(InvalidDescriptor.INSTANCE, 0);
   private final ItemDescriptor descriptor;
   private final int count;

   public ItemData toItem() {
      return this.descriptor == InvalidDescriptor.INSTANCE ? ItemData.AIR : this.descriptor.toItem().count(this.count).build();
   }

   public static ItemDescriptorWithCount fromItem(ItemData item) {
      return item == ItemData.AIR ? EMPTY : new ItemDescriptorWithCount(new DefaultDescriptor(item.getDefinition(), item.getDamage()), item.getCount());
   }

   public ItemDescriptor getDescriptor() {
      return this.descriptor;
   }

   public int getCount() {
      return this.count;
   }

   @Override
   public String toString() {
      return "ItemDescriptorWithCount(descriptor=" + this.getDescriptor() + ", count=" + this.getCount() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ItemDescriptorWithCount)) {
         return false;
      }

      ItemDescriptorWithCount other = (ItemDescriptorWithCount)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getCount() != other.getCount()) {
         return false;
      }

      Object this$descriptor = this.getDescriptor();
      Object other$descriptor = other.getDescriptor();
      return this$descriptor == null ? other$descriptor == null : this$descriptor.equals(other$descriptor);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ItemDescriptorWithCount;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getCount();
      Object $descriptor = this.getDescriptor();
      return result * 59 + ($descriptor == null ? 43 : $descriptor.hashCode());
   }

   public ItemDescriptorWithCount(final ItemDescriptor descriptor, final int count) {
      this.descriptor = descriptor;
      this.count = count;
   }
}
