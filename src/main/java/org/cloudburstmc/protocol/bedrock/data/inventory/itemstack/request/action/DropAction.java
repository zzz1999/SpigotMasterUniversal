package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.action;

import org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.ItemStackRequestSlotData;

public final class DropAction implements ItemStackRequestAction {
   private final int count;
   private final ItemStackRequestSlotData source;
   private final boolean randomly;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.DROP;
   }

   public DropAction(final int count, final ItemStackRequestSlotData source, final boolean randomly) {
      this.count = count;
      this.source = source;
      this.randomly = randomly;
   }

   public int getCount() {
      return this.count;
   }

   public ItemStackRequestSlotData getSource() {
      return this.source;
   }

   public boolean isRandomly() {
      return this.randomly;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DropAction)) {
         return false;
      }

      DropAction other = (DropAction)o;
      if (this.getCount() != other.getCount()) {
         return false;
      }

      if (this.isRandomly() != other.isRandomly()) {
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
      result = result * 59 + (this.isRandomly() ? 79 : 97);
      Object $source = this.getSource();
      return result * 59 + ($source == null ? 43 : $source.hashCode());
   }

   @Override
   public String toString() {
      return "DropAction(count=" + this.getCount() + ", source=" + this.getSource() + ", randomly=" + this.isRandomly() + ")";
   }
}
