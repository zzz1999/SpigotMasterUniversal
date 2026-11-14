package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class RemoveEntityPacket implements BedrockPacket {
   private long uniqueEntityId;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.REMOVE_ENTITY;
   }

   public RemoveEntityPacket clone() {
      try {
         return (RemoveEntityPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public void setUniqueEntityId(final long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RemoveEntityPacket)) {
         return false;
      }

      RemoveEntityPacket other = (RemoveEntityPacket)o;
      return !other.canEqual(this) ? false : this.uniqueEntityId == other.uniqueEntityId;
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RemoveEntityPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueEntityId = this.uniqueEntityId;
      return result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
   }

   @Override
   public String toString() {
      return "RemoveEntityPacket(uniqueEntityId=" + this.uniqueEntityId + ")";
   }
}
