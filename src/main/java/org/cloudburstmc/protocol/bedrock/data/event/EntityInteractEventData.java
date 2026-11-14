package org.cloudburstmc.protocol.bedrock.data.event;

public final class EntityInteractEventData implements EventData {
   private final long interactedEntityID;
   private final int interactionType;
   private final int legacyEntityTypeId;
   private final int variant;
   private final int paletteColor;

   @Override
   public EventDataType getType() {
      return EventDataType.ENTITY_INTERACT;
   }

   public EntityInteractEventData(
      final long interactedEntityID, final int interactionType, final int legacyEntityTypeId, final int variant, final int paletteColor
   ) {
      this.interactedEntityID = interactedEntityID;
      this.interactionType = interactionType;
      this.legacyEntityTypeId = legacyEntityTypeId;
      this.variant = variant;
      this.paletteColor = paletteColor;
   }

   public long getInteractedEntityID() {
      return this.interactedEntityID;
   }

   public int getInteractionType() {
      return this.interactionType;
   }

   public int getLegacyEntityTypeId() {
      return this.legacyEntityTypeId;
   }

   public int getVariant() {
      return this.variant;
   }

   public int getPaletteColor() {
      return this.paletteColor;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof EntityInteractEventData)) {
         return false;
      } else {
         EntityInteractEventData other = (EntityInteractEventData)o;
         if (this.getInteractedEntityID() != other.getInteractedEntityID()) {
            return false;
         } else if (this.getInteractionType() != other.getInteractionType()) {
            return false;
         } else if (this.getLegacyEntityTypeId() != other.getLegacyEntityTypeId()) {
            return false;
         } else {
            return this.getVariant() != other.getVariant() ? false : this.getPaletteColor() == other.getPaletteColor();
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $interactedEntityID = this.getInteractedEntityID();
      result = result * 59 + (int)($interactedEntityID >>> 32 ^ $interactedEntityID);
      result = result * 59 + this.getInteractionType();
      result = result * 59 + this.getLegacyEntityTypeId();
      result = result * 59 + this.getVariant();
      return result * 59 + this.getPaletteColor();
   }

   @Override
   public String toString() {
      return "EntityInteractEventData(interactedEntityID="
         + this.getInteractedEntityID()
         + ", interactionType="
         + this.getInteractionType()
         + ", legacyEntityTypeId="
         + this.getLegacyEntityTypeId()
         + ", variant="
         + this.getVariant()
         + ", paletteColor="
         + this.getPaletteColor()
         + ")";
   }
}
