package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.inventory.ContainerSlotType;
import org.cloudburstmc.protocol.bedrock.data.inventory.FullContainerName;
import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;
import org.cloudburstmc.protocol.common.PacketSignal;

public class InventoryContentPacket implements BedrockPacket {
   private List<ItemData> contents = new ObjectArrayList<>();
   private int containerId;
   private FullContainerName containerNameData = new FullContainerName(ContainerSlotType.ANVIL_INPUT, null);
   /** @deprecated */
   private int dynamicContainerSize;
   private ItemData storageItem = ItemData.AIR;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.INVENTORY_CONTENT;
   }

   public InventoryContentPacket clone() {
      try {
         return (InventoryContentPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<ItemData> getContents() {
      return this.contents;
   }

   public int getContainerId() {
      return this.containerId;
   }

   public FullContainerName getContainerNameData() {
      return this.containerNameData;
   }

   @Deprecated
   public int getDynamicContainerSize() {
      return this.dynamicContainerSize;
   }

   public ItemData getStorageItem() {
      return this.storageItem;
   }

   public void setContents(final List<ItemData> contents) {
      this.contents = contents;
   }

   public void setContainerId(final int containerId) {
      this.containerId = containerId;
   }

   public void setContainerNameData(final FullContainerName containerNameData) {
      this.containerNameData = containerNameData;
   }

   @Deprecated
   public void setDynamicContainerSize(final int dynamicContainerSize) {
      this.dynamicContainerSize = dynamicContainerSize;
   }

   public void setStorageItem(final ItemData storageItem) {
      this.storageItem = storageItem;
   }

   @Override
   public boolean equals(final Object o) {
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

      if (this.dynamicContainerSize != other.dynamicContainerSize) {
         return false;
      }

      Object this$contents = this.contents;
      Object other$contents = other.contents;
      if (this$contents == null ? other$contents == null : this$contents.equals(other$contents)) {
         Object this$containerNameData = this.containerNameData;
         Object other$containerNameData = other.containerNameData;
         if (this$containerNameData == null ? other$containerNameData == null : this$containerNameData.equals(other$containerNameData)) {
            Object this$storageItem = this.storageItem;
            Object other$storageItem = other.storageItem;
            return this$storageItem == null ? other$storageItem == null : this$storageItem.equals(other$storageItem);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InventoryContentPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.containerId;
      result = result * 59 + this.dynamicContainerSize;
      Object $contents = this.contents;
      result = result * 59 + ($contents == null ? 43 : $contents.hashCode());
      Object $containerNameData = this.containerNameData;
      result = result * 59 + ($containerNameData == null ? 43 : $containerNameData.hashCode());
      Object $storageItem = this.storageItem;
      return result * 59 + ($storageItem == null ? 43 : $storageItem.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryContentPacket(contents="
         + this.contents
         + ", containerId="
         + this.containerId
         + ", containerNameData="
         + this.containerNameData
         + ", dynamicContainerSize="
         + this.dynamicContainerSize
         + ", storageItem="
         + this.storageItem
         + ")";
   }
}
