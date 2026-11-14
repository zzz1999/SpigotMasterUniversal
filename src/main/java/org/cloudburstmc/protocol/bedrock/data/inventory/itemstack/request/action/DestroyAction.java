package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.action;

import org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.ItemStackRequestSlotData;

public final class DestroyAction implements ItemStackRequestAction {
   private final int count;
   private final ItemStackRequestSlotData source;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.DESTROY;
   }

   public DestroyAction(final int count, final ItemStackRequestSlotData source) {
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
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DestroyAction)) {
         return false;
      }

      DestroyAction other = (DestroyAction)o;
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
      return "DestroyAction(count=" + this.getCount() + ", source=" + this.getSource() + ")";
   }
}
