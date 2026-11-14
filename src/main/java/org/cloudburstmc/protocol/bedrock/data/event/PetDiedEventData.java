package org.cloudburstmc.protocol.bedrock.data.event;

public final class PetDiedEventData implements EventData {
   private final boolean ownerKilled;
   private final long killerUniqueEntityId;
   private final long petUniqueEntityId;
   private final int entityDamageCause;
   private final int petEntityType;

   @Override
   public EventDataType getType() {
      return EventDataType.PET_DIED;
   }

   public PetDiedEventData(
      final boolean ownerKilled, final long killerUniqueEntityId, final long petUniqueEntityId, final int entityDamageCause, final int petEntityType
   ) {
      this.ownerKilled = ownerKilled;
      this.killerUniqueEntityId = killerUniqueEntityId;
      this.petUniqueEntityId = petUniqueEntityId;
      this.entityDamageCause = entityDamageCause;
      this.petEntityType = petEntityType;
   }

   public boolean isOwnerKilled() {
      return this.ownerKilled;
   }

   public long getKillerUniqueEntityId() {
      return this.killerUniqueEntityId;
   }

   public long getPetUniqueEntityId() {
      return this.petUniqueEntityId;
   }

   public int getEntityDamageCause() {
      return this.entityDamageCause;
   }

   public int getPetEntityType() {
      return this.petEntityType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PetDiedEventData)) {
         return false;
      } else {
         PetDiedEventData other = (PetDiedEventData)o;
         if (this.isOwnerKilled() != other.isOwnerKilled()) {
            return false;
         } else if (this.getKillerUniqueEntityId() != other.getKillerUniqueEntityId()) {
            return false;
         } else if (this.getPetUniqueEntityId() != other.getPetUniqueEntityId()) {
            return false;
         } else {
            return this.getEntityDamageCause() != other.getEntityDamageCause() ? false : this.getPetEntityType() == other.getPetEntityType();
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isOwnerKilled() ? 79 : 97);
      long $killerUniqueEntityId = this.getKillerUniqueEntityId();
      result = result * 59 + (int)($killerUniqueEntityId >>> 32 ^ $killerUniqueEntityId);
      long $petUniqueEntityId = this.getPetUniqueEntityId();
      result = result * 59 + (int)($petUniqueEntityId >>> 32 ^ $petUniqueEntityId);
      result = result * 59 + this.getEntityDamageCause();
      return result * 59 + this.getPetEntityType();
   }

   @Override
   public String toString() {
      return "PetDiedEventData(ownerKilled="
         + this.isOwnerKilled()
         + ", killerUniqueEntityId="
         + this.getKillerUniqueEntityId()
         + ", petUniqueEntityId="
         + this.getPetUniqueEntityId()
         + ", entityDamageCause="
         + this.getEntityDamageCause()
         + ", petEntityType="
         + this.getPetEntityType()
         + ")";
   }
}
