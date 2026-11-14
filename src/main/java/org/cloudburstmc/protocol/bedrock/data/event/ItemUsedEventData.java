package org.cloudburstmc.protocol.bedrock.data.event;

public final class ItemUsedEventData implements EventData {
   private final short itemId;
   private final int itemAux;
   private final int useMethod;
   private final int useCount;

   @Override
   public EventDataType getType() {
      return EventDataType.ITEM_USED_EVENT;
   }

   public ItemUsedEventData(final short itemId, final int itemAux, final int useMethod, final int useCount) {
      this.itemId = itemId;
      this.itemAux = itemAux;
      this.useMethod = useMethod;
      this.useCount = useCount;
   }

   public short getItemId() {
      return this.itemId;
   }

   public int getItemAux() {
      return this.itemAux;
   }

   public int getUseMethod() {
      return this.useMethod;
   }

   public int getUseCount() {
      return this.useCount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ItemUsedEventData)) {
         return false;
      } else {
         ItemUsedEventData other = (ItemUsedEventData)o;
         if (this.getItemId() != other.getItemId()) {
            return false;
         } else if (this.getItemAux() != other.getItemAux()) {
            return false;
         } else {
            return this.getUseMethod() != other.getUseMethod() ? false : this.getUseCount() == other.getUseCount();
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getItemId();
      result = result * 59 + this.getItemAux();
      result = result * 59 + this.getUseMethod();
      return result * 59 + this.getUseCount();
   }

   @Override
   public String toString() {
      return "ItemUsedEventData(itemId="
         + this.getItemId()
         + ", itemAux="
         + this.getItemAux()
         + ", useMethod="
         + this.getUseMethod()
         + ", useCount="
         + this.getUseCount()
         + ")";
   }
}
