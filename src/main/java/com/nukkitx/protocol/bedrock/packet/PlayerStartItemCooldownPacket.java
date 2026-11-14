package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class PlayerStartItemCooldownPacket implements BedrockPacket {
   private String itemCategory;
   private int cooldownDuration;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAYER_START_ITEM_COOLDOWN;
   }

   public String getItemCategory() {
      return this.itemCategory;
   }

   public int getCooldownDuration() {
      return this.cooldownDuration;
   }

   public void setItemCategory(String itemCategory) {
      this.itemCategory = itemCategory;
   }

   public void setCooldownDuration(int cooldownDuration) {
      this.cooldownDuration = cooldownDuration;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlayerStartItemCooldownPacket)) {
         return false;
      }

      PlayerStartItemCooldownPacket other = (PlayerStartItemCooldownPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.cooldownDuration != other.cooldownDuration) {
         return false;
      }

      Object this$itemCategory = this.itemCategory;
      Object other$itemCategory = other.itemCategory;
      return this$itemCategory == null ? other$itemCategory == null : this$itemCategory.equals(other$itemCategory);
   }

   protected boolean canEqual(Object other) {
      return other instanceof PlayerStartItemCooldownPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.cooldownDuration;
      Object $itemCategory = this.itemCategory;
      return result * 59 + ($itemCategory == null ? 43 : $itemCategory.hashCode());
   }

   @Override
   public String toString() {
      return "PlayerStartItemCooldownPacket(itemCategory=" + this.itemCategory + ", cooldownDuration=" + this.cooldownDuration + ")";
   }
}
