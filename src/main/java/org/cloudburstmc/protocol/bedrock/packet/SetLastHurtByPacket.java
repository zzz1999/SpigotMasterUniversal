package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

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

   public SetLastHurtByPacket clone() {
      try {
         return (SetLastHurtByPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getEntityTypeId() {
      return this.entityTypeId;
   }

   public void setEntityTypeId(final int entityTypeId) {
      this.entityTypeId = entityTypeId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetLastHurtByPacket)) {
         return false;
      }

      SetLastHurtByPacket other = (SetLastHurtByPacket)o;
      return !other.canEqual(this) ? false : this.entityTypeId == other.entityTypeId;
   }

   protected boolean canEqual(final Object other) {
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
