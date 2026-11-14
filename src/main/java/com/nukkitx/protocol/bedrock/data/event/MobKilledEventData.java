package com.nukkitx.protocol.bedrock.data.event;

public final class MobKilledEventData implements EventData {
   private final long killerUniqueEntityId;
   private final long victimUniqueEntityId;
   private final int killerEntityType;
   private final int entityDamageCause;
   private int villagerTradeTier = -1;
   private String villagerDisplayName = "";

   @Override
   public EventDataType getType() {
      return EventDataType.MOB_KILLED;
   }

   public long getKillerUniqueEntityId() {
      return this.killerUniqueEntityId;
   }

   public long getVictimUniqueEntityId() {
      return this.victimUniqueEntityId;
   }

   public int getKillerEntityType() {
      return this.killerEntityType;
   }

   public int getEntityDamageCause() {
      return this.entityDamageCause;
   }

   public int getVillagerTradeTier() {
      return this.villagerTradeTier;
   }

   public String getVillagerDisplayName() {
      return this.villagerDisplayName;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MobKilledEventData)) {
         return false;
      }

      MobKilledEventData other = (MobKilledEventData)o;
      if (this.getKillerUniqueEntityId() != other.getKillerUniqueEntityId()) {
         return false;
      }

      if (this.getVictimUniqueEntityId() != other.getVictimUniqueEntityId()) {
         return false;
      }

      if (this.getKillerEntityType() != other.getKillerEntityType()) {
         return false;
      }

      if (this.getEntityDamageCause() != other.getEntityDamageCause()) {
         return false;
      }

      if (this.getVillagerTradeTier() != other.getVillagerTradeTier()) {
         return false;
      }

      Object this$villagerDisplayName = this.getVillagerDisplayName();
      Object other$villagerDisplayName = other.getVillagerDisplayName();
      return this$villagerDisplayName == null ? other$villagerDisplayName == null : this$villagerDisplayName.equals(other$villagerDisplayName);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $killerUniqueEntityId = this.getKillerUniqueEntityId();
      result = result * 59 + (int)($killerUniqueEntityId >>> 32 ^ $killerUniqueEntityId);
      long $victimUniqueEntityId = this.getVictimUniqueEntityId();
      result = result * 59 + (int)($victimUniqueEntityId >>> 32 ^ $victimUniqueEntityId);
      result = result * 59 + this.getKillerEntityType();
      result = result * 59 + this.getEntityDamageCause();
      result = result * 59 + this.getVillagerTradeTier();
      Object $villagerDisplayName = this.getVillagerDisplayName();
      return result * 59 + ($villagerDisplayName == null ? 43 : $villagerDisplayName.hashCode());
   }

   @Override
   public String toString() {
      return "MobKilledEventData(killerUniqueEntityId="
         + this.getKillerUniqueEntityId()
         + ", victimUniqueEntityId="
         + this.getVictimUniqueEntityId()
         + ", killerEntityType="
         + this.getKillerEntityType()
         + ", entityDamageCause="
         + this.getEntityDamageCause()
         + ", villagerTradeTier="
         + this.getVillagerTradeTier()
         + ", villagerDisplayName="
         + this.getVillagerDisplayName()
         + ")";
   }

   public MobKilledEventData(long killerUniqueEntityId, long victimUniqueEntityId, int killerEntityType, int entityDamageCause) {
      this.killerUniqueEntityId = killerUniqueEntityId;
      this.victimUniqueEntityId = victimUniqueEntityId;
      this.killerEntityType = killerEntityType;
      this.entityDamageCause = entityDamageCause;
   }

   public MobKilledEventData(
      long killerUniqueEntityId, long victimUniqueEntityId, int killerEntityType, int entityDamageCause, int villagerTradeTier, String villagerDisplayName
   ) {
      this.killerUniqueEntityId = killerUniqueEntityId;
      this.victimUniqueEntityId = victimUniqueEntityId;
      this.killerEntityType = killerEntityType;
      this.entityDamageCause = entityDamageCause;
      this.villagerTradeTier = villagerTradeTier;
      this.villagerDisplayName = villagerDisplayName;
   }
}
