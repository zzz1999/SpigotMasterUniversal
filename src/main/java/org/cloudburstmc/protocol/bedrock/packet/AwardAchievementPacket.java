package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class AwardAchievementPacket implements BedrockPacket {
   private int achievementId;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.AWARD_ACHIEVEMENT;
   }

   public AwardAchievementPacket clone() {
      try {
         return (AwardAchievementPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getAchievementId() {
      return this.achievementId;
   }

   public void setAchievementId(final int achievementId) {
      this.achievementId = achievementId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AwardAchievementPacket)) {
         return false;
      }

      AwardAchievementPacket other = (AwardAchievementPacket)o;
      return !other.canEqual(this) ? false : this.achievementId == other.achievementId;
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AwardAchievementPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.achievementId;
   }

   @Override
   public String toString() {
      return "AwardAchievementPacket(achievementId=" + this.achievementId + ")";
   }
}
