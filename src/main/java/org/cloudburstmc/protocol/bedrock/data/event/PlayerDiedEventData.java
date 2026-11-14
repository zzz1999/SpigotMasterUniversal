package org.cloudburstmc.protocol.bedrock.data.event;

public final class PlayerDiedEventData implements EventData {
   private final int attackerEntityId;
   private final int attackerVariant;
   private final int entityDamageCause;
   private final boolean inRaid;

   @Override
   public EventDataType getType() {
      return EventDataType.PLAYER_DIED;
   }

   public PlayerDiedEventData(final int attackerEntityId, final int attackerVariant, final int entityDamageCause, final boolean inRaid) {
      this.attackerEntityId = attackerEntityId;
      this.attackerVariant = attackerVariant;
      this.entityDamageCause = entityDamageCause;
      this.inRaid = inRaid;
   }

   public int getAttackerEntityId() {
      return this.attackerEntityId;
   }

   public int getAttackerVariant() {
      return this.attackerVariant;
   }

   public int getEntityDamageCause() {
      return this.entityDamageCause;
   }

   public boolean isInRaid() {
      return this.inRaid;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PlayerDiedEventData)) {
         return false;
      } else {
         PlayerDiedEventData other = (PlayerDiedEventData)o;
         if (this.getAttackerEntityId() != other.getAttackerEntityId()) {
            return false;
         } else if (this.getAttackerVariant() != other.getAttackerVariant()) {
            return false;
         } else {
            return this.getEntityDamageCause() != other.getEntityDamageCause() ? false : this.isInRaid() == other.isInRaid();
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getAttackerEntityId();
      result = result * 59 + this.getAttackerVariant();
      result = result * 59 + this.getEntityDamageCause();
      return result * 59 + (this.isInRaid() ? 79 : 97);
   }

   @Override
   public String toString() {
      return "PlayerDiedEventData(attackerEntityId="
         + this.getAttackerEntityId()
         + ", attackerVariant="
         + this.getAttackerVariant()
         + ", entityDamageCause="
         + this.getEntityDamageCause()
         + ", inRaid="
         + this.isInRaid()
         + ")";
   }
}
