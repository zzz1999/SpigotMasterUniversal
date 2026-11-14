package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class SetLastHurtByPacket implements BedrockPacket {
   private int entityTypeId;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_LAST_HURT_BY;
   }

   public int getEntityTypeId() {
      return this.entityTypeId;
   }

   public void setEntityTypeId(int entityTypeId) {
      this.entityTypeId = entityTypeId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetLastHurtByPacket)) {
         return false;
      }

      SetLastHurtByPacket other = (SetLastHurtByPacket)o;
      return !other.canEqual(this) ? false : this.entityTypeId == other.entityTypeId;
   }

   protected boolean canEqual(Object other) {
      return other instanceof SetLastHurtByPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.entityTypeId;
   }

   @Override
   public String toString() {
      return "SetLastHurtByPacket(entityTypeId=" + this.entityTypeId + ")";
   }
}
