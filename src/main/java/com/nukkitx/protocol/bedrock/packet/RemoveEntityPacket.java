package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

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

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public void setUniqueEntityId(long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RemoveEntityPacket)) {
         return false;
      }

      RemoveEntityPacket other = (RemoveEntityPacket)o;
      return !other.canEqual(this) ? false : this.uniqueEntityId == other.uniqueEntityId;
   }

   protected boolean canEqual(Object other) {
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
