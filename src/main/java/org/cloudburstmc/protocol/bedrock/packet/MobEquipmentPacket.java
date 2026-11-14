package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;
import org.cloudburstmc.protocol.common.PacketSignal;

public class MobEquipmentPacket implements BedrockPacket {
   private long runtimeEntityId;
   private ItemData item;
   private int inventorySlot;
   private int hotbarSlot;
   private int containerId;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.MOB_EQUIPMENT;
   }

   public MobEquipmentPacket clone() {
      try {
         return (MobEquipmentPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public ItemData getItem() {
      return this.item;
   }

   public int getInventorySlot() {
      return this.inventorySlot;
   }

   public int getHotbarSlot() {
      return this.hotbarSlot;
   }

   public int getContainerId() {
      return this.containerId;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setItem(final ItemData item) {
      this.item = item;
   }

   public void setInventorySlot(final int inventorySlot) {
      this.inventorySlot = inventorySlot;
   }

   public void setHotbarSlot(final int hotbarSlot) {
      this.hotbarSlot = hotbarSlot;
   }

   public void setContainerId(final int containerId) {
      this.containerId = containerId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MobEquipmentPacket)) {
         return false;
      }

      MobEquipmentPacket other = (MobEquipmentPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.inventorySlot != other.inventorySlot) {
         return false;
      }

      if (this.hotbarSlot != other.hotbarSlot) {
         return false;
      }

      if (this.containerId != other.containerId) {
         return false;
      }

      Object this$item = this.item;
      Object other$item = other.item;
      return this$item == null ? other$item == null : this$item.equals(other$item);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MobEquipmentPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + this.inventorySlot;
      result = result * 59 + this.hotbarSlot;
      result = result * 59 + this.containerId;
      Object $item = this.item;
      return result * 59 + ($item == null ? 43 : $item.hashCode());
   }

   @Override
   public String toString() {
      return "MobEquipmentPacket(runtimeEntityId="
         + this.runtimeEntityId
         + ", item="
         + this.item
         + ", inventorySlot="
         + this.inventorySlot
         + ", hotbarSlot="
         + this.hotbarSlot
         + ", containerId="
         + this.containerId
         + ")";
   }
}
