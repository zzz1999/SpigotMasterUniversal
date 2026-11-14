package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class SetDisplayObjectivePacket implements BedrockPacket {
   private String displaySlot;
   private String objectiveId;
   private CharSequence displayName;
   private String criteria;
   private int sortOrder;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_DISPLAY_OBJECTIVE;
   }

   public SetDisplayObjectivePacket clone() {
      try {
         return (SetDisplayObjectivePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getDisplayName() {
      return this.getDisplayName(String.class);
   }

   public <T extends CharSequence> T getDisplayName(Class<T> type) {
      return type.cast(this.displayName);
   }

   public String getDisplaySlot() {
      return this.displaySlot;
   }

   public String getObjectiveId() {
      return this.objectiveId;
   }

   public String getCriteria() {
      return this.criteria;
   }

   public int getSortOrder() {
      return this.sortOrder;
   }

   public void setDisplaySlot(final String displaySlot) {
      this.displaySlot = displaySlot;
   }

   public void setObjectiveId(final String objectiveId) {
      this.objectiveId = objectiveId;
   }

   public void setDisplayName(final CharSequence displayName) {
      this.displayName = displayName;
   }

   public void setCriteria(final String criteria) {
      this.criteria = criteria;
   }

   public void setSortOrder(final int sortOrder) {
      this.sortOrder = sortOrder;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetDisplayObjectivePacket)) {
         return false;
      }

      SetDisplayObjectivePacket other = (SetDisplayObjectivePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.sortOrder != other.sortOrder) {
         return false;
      }

      Object this$displaySlot = this.displaySlot;
      Object other$displaySlot = other.displaySlot;
      if (this$displaySlot == null ? other$displaySlot == null : this$displaySlot.equals(other$displaySlot)) {
         Object this$objectiveId = this.objectiveId;
         Object other$objectiveId = other.objectiveId;
         if (this$objectiveId == null ? other$objectiveId == null : this$objectiveId.equals(other$objectiveId)) {
            Object this$displayName = this.displayName;
            Object other$displayName = other.displayName;
            if (this$displayName == null ? other$displayName == null : this$displayName.equals(other$displayName)) {
               Object this$criteria = this.criteria;
               Object other$criteria = other.criteria;
               return this$criteria == null ? other$criteria == null : this$criteria.equals(other$criteria);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SetDisplayObjectivePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.sortOrder;
      Object $displaySlot = this.displaySlot;
      result = result * 59 + ($displaySlot == null ? 43 : $displaySlot.hashCode());
      Object $objectiveId = this.objectiveId;
      result = result * 59 + ($objectiveId == null ? 43 : $objectiveId.hashCode());
      Object $displayName = this.displayName;
      result = result * 59 + ($displayName == null ? 43 : $displayName.hashCode());
      Object $criteria = this.criteria;
      return result * 59 + ($criteria == null ? 43 : $criteria.hashCode());
   }

   @Override
   public String toString() {
      return "SetDisplayObjectivePacket(displaySlot="
         + this.displaySlot
         + ", objectiveId="
         + this.objectiveId
         + ", displayName="
         + this.displayName
         + ", criteria="
         + this.criteria
         + ", sortOrder="
         + this.sortOrder
         + ")";
   }
}
