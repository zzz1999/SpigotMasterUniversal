package org.cloudburstmc.protocol.bedrock.packet;

import java.util.ArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.response.ItemStackResponse;
import org.cloudburstmc.protocol.common.PacketSignal;

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

   public ItemStackResponsePacket clone() {
      try {
         return (ItemStackResponsePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<ItemStackResponse> getEntries() {
      return this.entries;
   }

   @Override
   public boolean equals(final Object o) {
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

   protected boolean canEqual(final Object other) {
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
