package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.inventory.ItemUseType;
import com.nukkitx.protocol.common.PacketSignal;

public class CompletedUsingItemPacket implements BedrockPacket {
   private int itemId;
   private ItemUseType type;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.COMPLETED_USING_ITEM;
   }

   public int getItemId() {
      return this.itemId;
   }

   public ItemUseType getType() {
      return this.type;
   }

   public void setItemId(int itemId) {
      this.itemId = itemId;
   }

   public void setType(ItemUseType type) {
      this.type = type;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CompletedUsingItemPacket)) {
         return false;
      }

      CompletedUsingItemPacket other = (CompletedUsingItemPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.itemId != other.itemId) {
         return false;
      }

      Object this$type = this.type;
      Object other$type = other.type;
      return this$type == null ? other$type == null : this$type.equals(other$type);
   }

   protected boolean canEqual(Object other) {
      return other instanceof CompletedUsingItemPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.itemId;
      Object $type = this.type;
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "CompletedUsingItemPacket(itemId=" + this.itemId + ", type=" + this.type + ")";
   }
}
