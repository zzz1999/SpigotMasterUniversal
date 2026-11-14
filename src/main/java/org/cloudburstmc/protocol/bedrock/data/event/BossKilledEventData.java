package org.cloudburstmc.protocol.bedrock.data.event;

public final class BossKilledEventData implements EventData {
   private final long bossUniqueEntityId;
   private final int playerPartySize;
   private final int bossEntityType;

   @Override
   public EventDataType getType() {
      return EventDataType.BOSS_KILLED;
   }

   public BossKilledEventData(final long bossUniqueEntityId, final int playerPartySize, final int bossEntityType) {
      this.bossUniqueEntityId = bossUniqueEntityId;
      this.playerPartySize = playerPartySize;
      this.bossEntityType = bossEntityType;
   }

   public long getBossUniqueEntityId() {
      return this.bossUniqueEntityId;
   }

   public int getPlayerPartySize() {
      return this.playerPartySize;
   }

   public int getBossEntityType() {
      return this.bossEntityType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BossKilledEventData)) {
         return false;
      } else {
         BossKilledEventData other = (BossKilledEventData)o;
         if (this.getBossUniqueEntityId() != other.getBossUniqueEntityId()) {
            return false;
         } else {
            return this.getPlayerPartySize() != other.getPlayerPartySize() ? false : this.getBossEntityType() == other.getBossEntityType();
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $bossUniqueEntityId = this.getBossUniqueEntityId();
      result = result * 59 + (int)($bossUniqueEntityId >>> 32 ^ $bossUniqueEntityId);
      result = result * 59 + this.getPlayerPartySize();
      return result * 59 + this.getBossEntityType();
   }

   @Override
   public String toString() {
      return "BossKilledEventData(bossUniqueEntityId="
         + this.getBossUniqueEntityId()
         + ", playerPartySize="
         + this.getPlayerPartySize()
         + ", bossEntityType="
         + this.getBossEntityType()
         + ")";
   }
}
