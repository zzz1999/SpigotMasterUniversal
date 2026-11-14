package com.nukkitx.protocol.bedrock.data;

import com.nukkitx.protocol.common.util.Preconditions;

public class ScoreInfo {
   private final long scoreboardId;
   private final String objectiveId;
   private final int score;
   private final ScoreInfo.ScorerType type;
   private final String name;
   private final long entityId;

   public ScoreInfo(long scoreboardId, String objectiveId, int score) {
      this.scoreboardId = scoreboardId;
      this.objectiveId = objectiveId;
      this.score = score;
      this.type = ScoreInfo.ScorerType.INVALID;
      this.name = null;
      this.entityId = -1L;
   }

   public ScoreInfo(long scoreboardId, String objectiveId, int score, String name) {
      this.scoreboardId = scoreboardId;
      this.objectiveId = objectiveId;
      this.score = score;
      this.type = ScoreInfo.ScorerType.FAKE;
      this.name = name;
      this.entityId = -1L;
   }

   public ScoreInfo(long scoreboardId, String objectiveId, int score, ScoreInfo.ScorerType type, long entityId) {
      Preconditions.checkArgument(type == ScoreInfo.ScorerType.ENTITY || type == ScoreInfo.ScorerType.PLAYER, "Must be player or entity");
      this.scoreboardId = scoreboardId;
      this.objectiveId = objectiveId;
      this.score = score;
      this.type = type;
      this.entityId = entityId;
      this.name = null;
   }

   public long getScoreboardId() {
      return this.scoreboardId;
   }

   public String getObjectiveId() {
      return this.objectiveId;
   }

   public int getScore() {
      return this.score;
   }

   public ScoreInfo.ScorerType getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public long getEntityId() {
      return this.entityId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScoreInfo)) {
         return false;
      }

      ScoreInfo other = (ScoreInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getScoreboardId() != other.getScoreboardId()) {
         return false;
      }

      if (this.getScore() != other.getScore()) {
         return false;
      }

      if (this.getEntityId() != other.getEntityId()) {
         return false;
      }

      Object this$objectiveId = this.getObjectiveId();
      Object other$objectiveId = other.getObjectiveId();
      if (this$objectiveId == null ? other$objectiveId == null : this$objectiveId.equals(other$objectiveId)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof ScoreInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $scoreboardId = this.getScoreboardId();
      result = result * 59 + (int)($scoreboardId >>> 32 ^ $scoreboardId);
      result = result * 59 + this.getScore();
      long $entityId = this.getEntityId();
      result = result * 59 + (int)($entityId >>> 32 ^ $entityId);
      Object $objectiveId = this.getObjectiveId();
      result = result * 59 + ($objectiveId == null ? 43 : $objectiveId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "ScoreInfo(scoreboardId="
         + this.getScoreboardId()
         + ", objectiveId="
         + this.getObjectiveId()
         + ", score="
         + this.getScore()
         + ", type="
         + this.getType()
         + ", name="
         + this.getName()
         + ", entityId="
         + this.getEntityId()
         + ")";
   }

   public enum ScorerType {
      INVALID,
      PLAYER,
      ENTITY,
      FAKE;
   }
}
