package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class RemoveObjectivePacket implements BedrockPacket {
   private String objectiveId;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.REMOVE_OBJECTIVE;
   }

   public String getObjectiveId() {
      return this.objectiveId;
   }

   public void setObjectiveId(String objectiveId) {
      this.objectiveId = objectiveId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RemoveObjectivePacket)) {
         return false;
      }

      RemoveObjectivePacket other = (RemoveObjectivePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$objectiveId = this.objectiveId;
      Object other$objectiveId = other.objectiveId;
      return this$objectiveId == null ? other$objectiveId == null : this$objectiveId.equals(other$objectiveId);
   }

   protected boolean canEqual(Object other) {
      return other instanceof RemoveObjectivePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $objectiveId = this.objectiveId;
      return result * 59 + ($objectiveId == null ? 43 : $objectiveId.hashCode());
   }

   @Override
   public String toString() {
      return "RemoveObjectivePacket(objectiveId=" + this.objectiveId + ")";
   }
}
