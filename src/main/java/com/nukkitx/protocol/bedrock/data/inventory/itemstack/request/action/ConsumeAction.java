package com.nukkitx.protocol.bedrock.data.inventory.itemstack.request.action;

import com.nukkitx.protocol.bedrock.data.inventory.itemstack.request.ItemStackRequestSlotData;

public final class ConsumeAction implements ItemStackRequestAction {
   private final int count;
   private final ItemStackRequestSlotData source;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.CONSUME;
   }

   public ConsumeAction(int count, ItemStackRequestSlotData source) {
      this.count = count;
      this.source = source;
   }

   public int getCount() {
      return this.count;
   }

   public ItemStackRequestSlotData getSource() {
      return this.source;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ConsumeAction)) {
         return false;
      }

      ConsumeAction other = (ConsumeAction)o;
      if (this.getCount() != other.getCount()) {
         return false;
      }

      Object this$source = this.getSource();
      Object other$source = other.getSource();
      return this$source == null ? other$source == null : this$source.equals(other$source);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getCount();
      Object $source = this.getSource();
      return result * 59 + ($source == null ? 43 : $source.hashCode());
   }

   @Override
   public String toString() {
      return "ConsumeAction(count=" + this.getCount() + ", source=" + this.getSource() + ")";
   }
}
