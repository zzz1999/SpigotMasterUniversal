package org.cloudburstmc.protocol.bedrock.data.event;

import org.cloudburstmc.protocol.bedrock.data.BlockInteractionType;

public final class ComposterInteractEventData implements EventData {
   private final BlockInteractionType blockInteractionType;
   private final int itemId;

   @Override
   public EventDataType getType() {
      return EventDataType.COMPOSTER_INTERACT;
   }

   public ComposterInteractEventData(final BlockInteractionType blockInteractionType, final int itemId) {
      this.blockInteractionType = blockInteractionType;
      this.itemId = itemId;
   }

   public BlockInteractionType getBlockInteractionType() {
      return this.blockInteractionType;
   }

   public int getItemId() {
      return this.itemId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ComposterInteractEventData)) {
         return false;
      }

      ComposterInteractEventData other = (ComposterInteractEventData)o;
      if (this.getItemId() != other.getItemId()) {
         return false;
      }

      Object this$blockInteractionType = this.getBlockInteractionType();
      Object other$blockInteractionType = other.getBlockInteractionType();
      return this$blockInteractionType == null ? other$blockInteractionType == null : this$blockInteractionType.equals(other$blockInteractionType);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getItemId();
      Object $blockInteractionType = this.getBlockInteractionType();
      return result * 59 + ($blockInteractionType == null ? 43 : $blockInteractionType.hashCode());
   }

   @Override
   public String toString() {
      return "ComposterInteractEventData(blockInteractionType=" + this.getBlockInteractionType() + ", itemId=" + this.getItemId() + ")";
   }
}
