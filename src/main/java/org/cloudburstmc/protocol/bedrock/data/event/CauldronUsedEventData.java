package org.cloudburstmc.protocol.bedrock.data.event;

public final class CauldronUsedEventData implements EventData {
   private final int potionId;
   private final int color;
   private final int fillLevel;

   @Override
   public EventDataType getType() {
      return EventDataType.CAULDRON_USED;
   }

   public CauldronUsedEventData(final int potionId, final int color, final int fillLevel) {
      this.potionId = potionId;
      this.color = color;
      this.fillLevel = fillLevel;
   }

   public int getPotionId() {
      return this.potionId;
   }

   public int getColor() {
      return this.color;
   }

   public int getFillLevel() {
      return this.fillLevel;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CauldronUsedEventData)) {
         return false;
      } else {
         CauldronUsedEventData other = (CauldronUsedEventData)o;
         if (this.getPotionId() != other.getPotionId()) {
            return false;
         } else {
            return this.getColor() != other.getColor() ? false : this.getFillLevel() == other.getFillLevel();
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getPotionId();
      result = result * 59 + this.getColor();
      return result * 59 + this.getFillLevel();
   }

   @Override
   public String toString() {
      return "CauldronUsedEventData(potionId=" + this.getPotionId() + ", color=" + this.getColor() + ", fillLevel=" + this.getFillLevel() + ")";
   }
}
