package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.ee.LessonAction;
import org.cloudburstmc.protocol.common.PacketSignal;

public class LessonProgressPacket implements BedrockPacket {
   private LessonAction action;
   private int score;
   private String activityId;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.LESSON_PROGRESS;
   }

   public LessonProgressPacket clone() {
      try {
         return (LessonProgressPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public LessonAction getAction() {
      return this.action;
   }

   public int getScore() {
      return this.score;
   }

   public String getActivityId() {
      return this.activityId;
   }

   public void setAction(final LessonAction action) {
      this.action = action;
   }

   public void setScore(final int score) {
      this.score = score;
   }

   public void setActivityId(final String activityId) {
      this.activityId = activityId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof LessonProgressPacket)) {
         return false;
      } else {
         LessonProgressPacket other = (LessonProgressPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.score != other.score) {
            return false;
         } else {
            Object this$action = this.action;
            Object other$action = other.action;
            if (this$action == null ? other$action == null : this$action.equals(other$action)) {
               Object this$activityId = this.activityId;
               Object other$activityId = other.activityId;
               return this$activityId == null ? other$activityId == null : this$activityId.equals(other$activityId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof LessonProgressPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.score;
      Object $action = this.action;
      result = result * 59 + ($action == null ? 43 : $action.hashCode());
      Object $activityId = this.activityId;
      return result * 59 + ($activityId == null ? 43 : $activityId.hashCode());
   }

   @Override
   public String toString() {
      return "LessonProgressPacket(action=" + this.action + ", score=" + this.score + ", activityId=" + this.activityId + ")";
   }
}
