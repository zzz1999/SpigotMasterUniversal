package org.cloudburstmc.protocol.bedrock.data.event;

public class CodeBuilderScoreboardEventData implements EventData {
   private final String objectiveName;
   private final int score;

   @Override
   public EventDataType getType() {
      return EventDataType.CODE_BUILDER_SCOREBOARD;
   }

   public CodeBuilderScoreboardEventData(final String objectiveName, final int score) {
      this.objectiveName = objectiveName;
      this.score = score;
   }

   public String getObjectiveName() {
      return this.objectiveName;
   }

   public int getScore() {
      return this.score;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CodeBuilderScoreboardEventData)) {
         return false;
      }

      CodeBuilderScoreboardEventData other = (CodeBuilderScoreboardEventData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getScore() != other.getScore()) {
         return false;
      }

      Object this$objectiveName = this.getObjectiveName();
      Object other$objectiveName = other.getObjectiveName();
      return this$objectiveName == null ? other$objectiveName == null : this$objectiveName.equals(other$objectiveName);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CodeBuilderScoreboardEventData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getScore();
      Object $objectiveName = this.getObjectiveName();
      return result * 59 + ($objectiveName == null ? 43 : $objectiveName.hashCode());
   }

   @Override
   public String toString() {
      return "CodeBuilderScoreboardEventData(objectiveName=" + this.getObjectiveName() + ", score=" + this.getScore() + ")";
   }
}
