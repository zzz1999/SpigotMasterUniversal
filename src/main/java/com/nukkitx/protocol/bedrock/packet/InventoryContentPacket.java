package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.inventory.ItemData;
import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class InventoryContentPacket implements BedrockPacket {
   private List<ItemData> contents = new ObjectArrayList<>();
   private int containerId;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.INVENTORY_CONTENT;
   }

   public List<ItemData> getContents() {
      return this.contents;
   }

   public int getContainerId() {
      return this.containerId;
   }

   public void setContents(List<ItemData> contents) {
      this.contents = contents;
   }

   public void setContainerId(int containerId) {
      this.containerId = containerId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryContentPacket)) {
         return false;
      }

      InventoryContentPacket other = (InventoryContentPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.containerId != other.containerId) {
         return false;
      }

      Object this$contents = this.contents;
      Object other$contents = other.contents;
      return this$contents == null ? other$contents == null : this$contents.equals(other$contents);
   }

   protected boolean canEqual(Object other) {
      return other instanceof InventoryContentPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.containerId;
      Object $contents = this.contents;
      return result * 59 + ($contents == null ? 43 : $contents.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryContentPacket(contents=" + this.contents + ", containerId=" + this.containerId + ")";
   }
}
