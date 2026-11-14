package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.inventory.itemstack.response.ItemStackResponse;
import com.nukkitx.protocol.common.PacketSignal;
import java.util.ArrayList;
import java.util.List;

public class ItemStackResponsePacket implements BedrockPacket {
   private final List<ItemStackResponse> entries = new ArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ITEM_STACK_RESPONSE;
   }

   public List<ItemStackResponse> getEntries() {
      return this.entries;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ItemStackResponsePacket)) {
         return false;
      }

      ItemStackResponsePacket other = (ItemStackResponsePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$entries = this.getEntries();
      Object other$entries = other.getEntries();
      return this$entries == null ? other$entries == null : this$entries.equals(other$entries);
   }

   protected boolean canEqual(Object other) {
      return other instanceof ItemStackResponsePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $entries = this.getEntries();
      return result * 59 + ($entries == null ? 43 : $entries.hashCode());
   }

   @Override
   public String toString() {
      return "ItemStackResponsePacket(entries=" + this.entries + ")";
   }
}
