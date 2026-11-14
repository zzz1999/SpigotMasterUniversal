package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class MapCreateLockedCopyPacket implements BedrockPacket {
   private long originalMapId;
   private long newMapId;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.MAP_CREATE_LOCKED_COPY;
   }

   public long getOriginalMapId() {
      return this.originalMapId;
   }

   public long getNewMapId() {
      return this.newMapId;
   }

   public void setOriginalMapId(long originalMapId) {
      this.originalMapId = originalMapId;
   }

   public void setNewMapId(long newMapId) {
      this.newMapId = newMapId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MapCreateLockedCopyPacket)) {
         return false;
      } else {
         MapCreateLockedCopyPacket other = (MapCreateLockedCopyPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            return this.originalMapId != other.originalMapId ? false : this.newMapId == other.newMapId;
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof MapCreateLockedCopyPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $originalMapId = this.originalMapId;
      result = result * 59 + (int)($originalMapId >>> 32 ^ $originalMapId);
      long $newMapId = this.newMapId;
      return result * 59 + (int)($newMapId >>> 32 ^ $newMapId);
   }

   @Override
   public String toString() {
      return "MapCreateLockedCopyPacket(originalMapId=" + this.originalMapId + ", newMapId=" + this.newMapId + ")";
   }
}
