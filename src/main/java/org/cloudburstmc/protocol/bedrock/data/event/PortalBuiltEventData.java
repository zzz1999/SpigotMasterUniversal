package org.cloudburstmc.protocol.bedrock.data.event;

public final class PortalBuiltEventData implements EventData {
   private final int dimensionId;

   @Override
   public EventDataType getType() {
      return EventDataType.PORTAL_BUILT;
   }

   public PortalBuiltEventData(final int dimensionId) {
      this.dimensionId = dimensionId;
   }

   public int getDimensionId() {
      return this.dimensionId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PortalBuiltEventData)) {
         return false;
      }

      PortalBuiltEventData other = (PortalBuiltEventData)o;
      return this.getDimensionId() == other.getDimensionId();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.getDimensionId();
   }

   @Override
   public String toString() {
      return "PortalBuiltEventData(dimensionId=" + this.getDimensionId() + ")";
   }
}
