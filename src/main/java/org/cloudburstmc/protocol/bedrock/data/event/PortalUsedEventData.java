package org.cloudburstmc.protocol.bedrock.data.event;

public final class PortalUsedEventData implements EventData {
   private final int fromDimensionId;
   private final int toDimensionId;

   @Override
   public EventDataType getType() {
      return EventDataType.PORTAL_USED;
   }

   public PortalUsedEventData(final int fromDimensionId, final int toDimensionId) {
      this.fromDimensionId = fromDimensionId;
      this.toDimensionId = toDimensionId;
   }

   public int getFromDimensionId() {
      return this.fromDimensionId;
   }

   public int getToDimensionId() {
      return this.toDimensionId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PortalUsedEventData)) {
         return false;
      }

      PortalUsedEventData other = (PortalUsedEventData)o;
      return this.getFromDimensionId() != other.getFromDimensionId() ? false : this.getToDimensionId() == other.getToDimensionId();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getFromDimensionId();
      return result * 59 + this.getToDimensionId();
   }

   @Override
   public String toString() {
      return "PortalUsedEventData(fromDimensionId=" + this.getFromDimensionId() + ", toDimensionId=" + this.getToDimensionId() + ")";
   }
}
