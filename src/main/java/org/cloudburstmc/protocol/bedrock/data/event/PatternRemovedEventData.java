package org.cloudburstmc.protocol.bedrock.data.event;

public final class PatternRemovedEventData implements EventData {
   private final int itemId;
   private final int auxValue;
   private final int patternsSize;
   private final int patternIndex;
   private final int patternColor;

   @Override
   public EventDataType getType() {
      return EventDataType.PATTERN_REMOVED;
   }

   public PatternRemovedEventData(final int itemId, final int auxValue, final int patternsSize, final int patternIndex, final int patternColor) {
      this.itemId = itemId;
      this.auxValue = auxValue;
      this.patternsSize = patternsSize;
      this.patternIndex = patternIndex;
      this.patternColor = patternColor;
   }

   public int getItemId() {
      return this.itemId;
   }

   public int getAuxValue() {
      return this.auxValue;
   }

   public int getPatternsSize() {
      return this.patternsSize;
   }

   public int getPatternIndex() {
      return this.patternIndex;
   }

   public int getPatternColor() {
      return this.patternColor;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PatternRemovedEventData)) {
         return false;
      } else {
         PatternRemovedEventData other = (PatternRemovedEventData)o;
         if (this.getItemId() != other.getItemId()) {
            return false;
         } else if (this.getAuxValue() != other.getAuxValue()) {
            return false;
         } else if (this.getPatternsSize() != other.getPatternsSize()) {
            return false;
         } else {
            return this.getPatternIndex() != other.getPatternIndex() ? false : this.getPatternColor() == other.getPatternColor();
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getItemId();
      result = result * 59 + this.getAuxValue();
      result = result * 59 + this.getPatternsSize();
      result = result * 59 + this.getPatternIndex();
      return result * 59 + this.getPatternColor();
   }

   @Override
   public String toString() {
      return "PatternRemovedEventData(itemId="
         + this.getItemId()
         + ", auxValue="
         + this.getAuxValue()
         + ", patternsSize="
         + this.getPatternsSize()
         + ", patternIndex="
         + this.getPatternIndex()
         + ", patternColor="
         + this.getPatternColor()
         + ")";
   }
}
