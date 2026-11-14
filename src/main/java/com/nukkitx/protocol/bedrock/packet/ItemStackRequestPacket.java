package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.inventory.itemstack.request.ItemStackRequest;
import com.nukkitx.protocol.common.PacketSignal;
import java.util.ArrayList;
import java.util.List;

public class ItemStackRequestPacket implements BedrockPacket {
   private final List<ItemStackRequest> requests = new ArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ITEM_STACK_REQUEST;
   }

   public List<ItemStackRequest> getRequests() {
      return this.requests;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ItemStackRequestPacket)) {
         return false;
      }

      ItemStackRequestPacket other = (ItemStackRequestPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$requests = this.getRequests();
      Object other$requests = other.getRequests();
      return this$requests == null ? other$requests == null : this$requests.equals(other$requests);
   }

   protected boolean canEqual(Object other) {
      return other instanceof ItemStackRequestPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $requests = this.getRequests();
      return result * 59 + ($requests == null ? 43 : $requests.hashCode());
   }

   @Override
   public String toString() {
      return "ItemStackRequestPacket(requests=" + this.requests + ")";
   }
}
