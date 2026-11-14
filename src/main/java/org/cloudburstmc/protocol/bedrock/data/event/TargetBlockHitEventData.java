package org.cloudburstmc.protocol.bedrock.data.event;

public class TargetBlockHitEventData implements EventData {
   private final int redstoneLevel;

   @Override
   public EventDataType getType() {
      return EventDataType.TARGET_BLOCK_HIT;
   }

   public TargetBlockHitEventData(final int redstoneLevel) {
      this.redstoneLevel = redstoneLevel;
   }

   public int getRedstoneLevel() {
      return this.redstoneLevel;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TargetBlockHitEventData)) {
         return false;
      }

      TargetBlockHitEventData other = (TargetBlockHitEventData)o;
      return !other.canEqual(this) ? false : this.getRedstoneLevel() == other.getRedstoneLevel();
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TargetBlockHitEventData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.getRedstoneLevel();
   }

   @Override
   public String toString() {
      return "TargetBlockHitEventData(redstoneLevel=" + this.getRedstoneLevel() + ")";
   }
}
