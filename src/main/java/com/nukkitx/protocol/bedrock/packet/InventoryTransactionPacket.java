package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.definitions.BlockDefinition;
import com.nukkitx.protocol.bedrock.data.inventory.ItemData;
import com.nukkitx.protocol.bedrock.data.inventory.transaction.InventoryActionData;
import com.nukkitx.protocol.bedrock.data.inventory.transaction.InventoryTransactionType;
import com.nukkitx.protocol.bedrock.data.inventory.transaction.LegacySetItemSlotData;
import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.math.vector.Vector3i;

public class InventoryTransactionPacket implements BedrockPacket {
   private int legacyRequestId;
   private final List<LegacySetItemSlotData> legacySlots = new ObjectArrayList<>();
   private final List<InventoryActionData> actions = new ObjectArrayList<>();
   private InventoryTransactionType transactionType;
   private int actionType;
   private long runtimeEntityId;
   private Vector3i blockPosition;
   private int blockFace;
   private int hotbarSlot;
   private ItemData itemInHand;
   private Vector3f playerPosition;
   private Vector3f clickPosition;
   private Vector3f headPosition;
   @Deprecated
   private boolean usingNetIds;
   private BlockDefinition blockDefinition;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.INVENTORY_TRANSACTION;
   }

   public int getLegacyRequestId() {
      return this.legacyRequestId;
   }

   public List<LegacySetItemSlotData> getLegacySlots() {
      return this.legacySlots;
   }

   public List<InventoryActionData> getActions() {
      return this.actions;
   }

   public InventoryTransactionType getTransactionType() {
      return this.transactionType;
   }

   public int getActionType() {
      return this.actionType;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public Vector3i getBlockPosition() {
      return this.blockPosition;
   }

   public int getBlockFace() {
      return this.blockFace;
   }

   public int getHotbarSlot() {
      return this.hotbarSlot;
   }

   public ItemData getItemInHand() {
      return this.itemInHand;
   }

   public Vector3f getPlayerPosition() {
      return this.playerPosition;
   }

   public Vector3f getClickPosition() {
      return this.clickPosition;
   }

   public Vector3f getHeadPosition() {
      return this.headPosition;
   }

   @Deprecated
   public boolean isUsingNetIds() {
      return this.usingNetIds;
   }

   public BlockDefinition getBlockDefinition() {
      return this.blockDefinition;
   }

   public void setLegacyRequestId(int legacyRequestId) {
      this.legacyRequestId = legacyRequestId;
   }

   public void setTransactionType(InventoryTransactionType transactionType) {
      this.transactionType = transactionType;
   }

   public void setActionType(int actionType) {
      this.actionType = actionType;
   }

   public void setRuntimeEntityId(long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setBlockPosition(Vector3i blockPosition) {
      this.blockPosition = blockPosition;
   }

   public void setBlockFace(int blockFace) {
      this.blockFace = blockFace;
   }

   public void setHotbarSlot(int hotbarSlot) {
      this.hotbarSlot = hotbarSlot;
   }

   public void setItemInHand(ItemData itemInHand) {
      this.itemInHand = itemInHand;
   }

   public void setPlayerPosition(Vector3f playerPosition) {
      this.playerPosition = playerPosition;
   }

   public void setClickPosition(Vector3f clickPosition) {
      this.clickPosition = clickPosition;
   }

   public void setHeadPosition(Vector3f headPosition) {
      this.headPosition = headPosition;
   }

   @Deprecated
   public void setUsingNetIds(boolean usingNetIds) {
      this.usingNetIds = usingNetIds;
   }

   public void setBlockDefinition(BlockDefinition blockDefinition) {
      this.blockDefinition = blockDefinition;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryTransactionPacket)) {
         return false;
      }

      InventoryTransactionPacket other = (InventoryTransactionPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.legacyRequestId != other.legacyRequestId) {
         return false;
      }

      if (this.actionType != other.actionType) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.blockFace != other.blockFace) {
         return false;
      }

      if (this.hotbarSlot != other.hotbarSlot) {
         return false;
      }

      if (this.usingNetIds != other.usingNetIds) {
         return false;
      }

      Object this$legacySlots = this.legacySlots;
      Object other$legacySlots = other.legacySlots;
      if (this$legacySlots == null ? other$legacySlots == null : this$legacySlots.equals(other$legacySlots)) {
         Object this$actions = this.actions;
         Object other$actions = other.actions;
         if (this$actions == null ? other$actions == null : this$actions.equals(other$actions)) {
            Object this$transactionType = this.transactionType;
            Object other$transactionType = other.transactionType;
            if (this$transactionType == null ? other$transactionType == null : this$transactionType.equals(other$transactionType)) {
               Object this$blockPosition = this.blockPosition;
               Object other$blockPosition = other.blockPosition;
               if (this$blockPosition == null ? other$blockPosition == null : this$blockPosition.equals(other$blockPosition)) {
                  Object this$itemInHand = this.itemInHand;
                  Object other$itemInHand = other.itemInHand;
                  if (this$itemInHand == null ? other$itemInHand == null : this$itemInHand.equals(other$itemInHand)) {
                     Object this$playerPosition = this.playerPosition;
                     Object other$playerPosition = other.playerPosition;
                     if (this$playerPosition == null ? other$playerPosition == null : this$playerPosition.equals(other$playerPosition)) {
                        Object this$clickPosition = this.clickPosition;
                        Object other$clickPosition = other.clickPosition;
                        if (this$clickPosition == null ? other$clickPosition == null : this$clickPosition.equals(other$clickPosition)) {
                           Object this$headPosition = this.headPosition;
                           Object other$headPosition = other.headPosition;
                           if (this$headPosition == null ? other$headPosition == null : this$headPosition.equals(other$headPosition)) {
                              Object this$blockDefinition = this.blockDefinition;
                              Object other$blockDefinition = other.blockDefinition;
                              return this$blockDefinition == null ? other$blockDefinition == null : this$blockDefinition.equals(other$blockDefinition);
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof InventoryTransactionPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.legacyRequestId;
      result = result * 59 + this.actionType;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + this.blockFace;
      result = result * 59 + this.hotbarSlot;
      result = result * 59 + (this.usingNetIds ? 79 : 97);
      Object $legacySlots = this.legacySlots;
      result = result * 59 + ($legacySlots == null ? 43 : $legacySlots.hashCode());
      Object $actions = this.actions;
      result = result * 59 + ($actions == null ? 43 : $actions.hashCode());
      Object $transactionType = this.transactionType;
      result = result * 59 + ($transactionType == null ? 43 : $transactionType.hashCode());
      Object $blockPosition = this.blockPosition;
      result = result * 59 + ($blockPosition == null ? 43 : $blockPosition.hashCode());
      Object $itemInHand = this.itemInHand;
      result = result * 59 + ($itemInHand == null ? 43 : $itemInHand.hashCode());
      Object $playerPosition = this.playerPosition;
      result = result * 59 + ($playerPosition == null ? 43 : $playerPosition.hashCode());
      Object $clickPosition = this.clickPosition;
      result = result * 59 + ($clickPosition == null ? 43 : $clickPosition.hashCode());
      Object $headPosition = this.headPosition;
      result = result * 59 + ($headPosition == null ? 43 : $headPosition.hashCode());
      Object $blockDefinition = this.blockDefinition;
      return result * 59 + ($blockDefinition == null ? 43 : $blockDefinition.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryTransactionPacket(legacyRequestId="
         + this.legacyRequestId
         + ", legacySlots="
         + this.legacySlots
         + ", actions="
         + this.actions
         + ", transactionType="
         + this.transactionType
         + ", actionType="
         + this.actionType
         + ", runtimeEntityId="
         + this.runtimeEntityId
         + ", blockPosition="
         + this.blockPosition
         + ", blockFace="
         + this.blockFace
         + ", hotbarSlot="
         + this.hotbarSlot
         + ", itemInHand="
         + this.itemInHand
         + ", playerPosition="
         + this.playerPosition
         + ", clickPosition="
         + this.clickPosition
         + ", headPosition="
         + this.headPosition
         + ", usingNetIds="
         + this.usingNetIds
         + ", blockDefinition="
         + this.blockDefinition
         + ")";
   }
}
