package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class TakeItemEntityPacket implements BedrockPacket {
   private long itemRuntimeEntityId;
   private long runtimeEntityId;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.TAKE_ITEM_ENTITY;
   }

   public long getItemRuntimeEntityId() {
      return this.itemRuntimeEntityId;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public void setItemRuntimeEntityId(long itemRuntimeEntityId) {
      this.itemRuntimeEntityId = itemRuntimeEntityId;
   }

   public void setRuntimeEntityId(long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TakeItemEntityPacket)) {
         return false;
      } else {
         TakeItemEntityPacket other = (TakeItemEntityPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            return this.itemRuntimeEntityId != other.itemRuntimeEntityId ? false : this.runtimeEntityId == other.runtimeEntityId;
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof TakeItemEntityPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $itemRuntimeEntityId = this.itemRuntimeEntityId;
      result = result * 59 + (int)($itemRuntimeEntityId >>> 32 ^ $itemRuntimeEntityId);
      long $runtimeEntityId = this.runtimeEntityId;
      return result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
   }

   @Override
   public String toString() {
      return "TakeItemEntityPacket(itemRuntimeEntityId=" + this.itemRuntimeEntityId + ", runtimeEntityId=" + this.runtimeEntityId + ")";
   }
}
