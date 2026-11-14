package org.cloudburstmc.protocol.bedrock.data.event;

public final class AchievementAwardedEventData implements EventData {
   private final int achievementId;

   @Override
   public EventDataType getType() {
      return EventDataType.ACHIEVEMENT_AWARDED;
   }

   public AchievementAwardedEventData(final int achievementId) {
      this.achievementId = achievementId;
   }

   public int getAchievementId() {
      return this.achievementId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AchievementAwardedEventData)) {
         return false;
      }

      AchievementAwardedEventData other = (AchievementAwardedEventData)o;
      return this.getAchievementId() == other.getAchievementId();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.getAchievementId();
   }

   @Override
   public String toString() {
      return "AchievementAwardedEventData(achievementId=" + this.getAchievementId() + ")";
   }
}
