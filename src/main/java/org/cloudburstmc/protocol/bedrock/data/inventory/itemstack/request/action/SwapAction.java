package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.action;

import org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.ItemStackRequestSlotData;

public final class SwapAction implements ItemStackRequestAction {
   private final ItemStackRequestSlotData source;
   private final ItemStackRequestSlotData destination;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.SWAP;
   }

   public SwapAction(final ItemStackRequestSlotData source, final ItemStackRequestSlotData destination) {
      this.source = source;
      this.destination = destination;
   }

   public ItemStackRequestSlotData getSource() {
      return this.source;
   }

   public ItemStackRequestSlotData getDestination() {
      return this.destination;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SwapAction)) {
         return false;
      } else {
         SwapAction other = (SwapAction)o;
         Object this$source = this.getSource();
         Object other$source = other.getSource();
         if (this$source == null ? other$source == null : this$source.equals(other$source)) {
            Object this$destination = this.getDestination();
            Object other$destination = other.getDestination();
            return this$destination == null ? other$destination == null : this$destination.equals(other$destination);
         } else {
            return false;
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $destination = this.getDestination();
      return result * 59 + ($destination == null ? 43 : $destination.hashCode());
   }

   @Override
   public String toString() {
      return "SwapAction(source=" + this.getSource() + ", destination=" + this.getDestination() + ")";
   }
}
