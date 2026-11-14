package com.nukkitx.protocol.bedrock.data.event;

public final class BellUsedEventData implements EventData {
   private final int itemId;

   @Override
   public EventDataType getType() {
      return EventDataType.BELL_USED;
   }

   public BellUsedEventData(int itemId) {
      this.itemId = itemId;
   }

   public int getItemId() {
      return this.itemId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BellUsedEventData)) {
         return false;
      }

      BellUsedEventData other = (BellUsedEventData)o;
      return this.getItemId() == other.getItemId();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.getItemId();
   }

   @Override
   public String toString() {
      return "BellUsedEventData(itemId=" + this.getItemId() + ")";
   }
}
