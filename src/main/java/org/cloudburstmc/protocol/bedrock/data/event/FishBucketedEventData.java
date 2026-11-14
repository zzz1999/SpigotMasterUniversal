package org.cloudburstmc.protocol.bedrock.data.event;

public final class FishBucketedEventData implements EventData {
   private final int pattern;
   private final int preset;
   private final int bucketedEntityType;
   private final boolean releaseEvent;

   @Override
   public EventDataType getType() {
      return EventDataType.FISH_BUCKETED;
   }

   public FishBucketedEventData(final int pattern, final int preset, final int bucketedEntityType, final boolean releaseEvent) {
      this.pattern = pattern;
      this.preset = preset;
      this.bucketedEntityType = bucketedEntityType;
      this.releaseEvent = releaseEvent;
   }

   public int getPattern() {
      return this.pattern;
   }

   public int getPreset() {
      return this.preset;
   }

   public int getBucketedEntityType() {
      return this.bucketedEntityType;
   }

   public boolean isReleaseEvent() {
      return this.releaseEvent;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof FishBucketedEventData)) {
         return false;
      } else {
         FishBucketedEventData other = (FishBucketedEventData)o;
         if (this.getPattern() != other.getPattern()) {
            return false;
         } else if (this.getPreset() != other.getPreset()) {
            return false;
         } else {
            return this.getBucketedEntityType() != other.getBucketedEntityType() ? false : this.isReleaseEvent() == other.isReleaseEvent();
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getPattern();
      result = result * 59 + this.getPreset();
      result = result * 59 + this.getBucketedEntityType();
      return result * 59 + (this.isReleaseEvent() ? 79 : 97);
   }

   @Override
   public String toString() {
      return "FishBucketedEventData(pattern="
         + this.getPattern()
         + ", preset="
         + this.getPreset()
         + ", bucketedEntityType="
         + this.getBucketedEntityType()
         + ", releaseEvent="
         + this.isReleaseEvent()
         + ")";
   }
}
