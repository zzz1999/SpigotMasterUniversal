package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.bedrock.data.definitions.BlockDefinition;
import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;
import org.cloudburstmc.protocol.bedrock.data.inventory.transaction.InventoryActionData;
import org.cloudburstmc.protocol.bedrock.data.inventory.transaction.InventoryTransactionType;
import org.cloudburstmc.protocol.bedrock.data.inventory.transaction.ItemUseTransaction;
import org.cloudburstmc.protocol.bedrock.data.inventory.transaction.LegacySetItemSlotData;
import org.cloudburstmc.protocol.common.PacketSignal;

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
   private ItemUseTransaction.TriggerType triggerType;
   private ItemUseTransaction.PredictedResult clientInteractPrediction;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.INVENTORY_TRANSACTION;
   }

   public InventoryTransactionPacket clone() {
      try {
         return (InventoryTransactionPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
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

   public ItemUseTransaction.TriggerType getTriggerType() {
      return this.triggerType;
   }

   public ItemUseTransaction.PredictedResult getClientInteractPrediction() {
      return this.clientInteractPrediction;
   }

   public void setLegacyRequestId(final int legacyRequestId) {
      this.legacyRequestId = legacyRequestId;
   }

   public void setTransactionType(final InventoryTransactionType transactionType) {
      this.transactionType = transactionType;
   }

   public void setActionType(final int actionType) {
      this.actionType = actionType;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setBlockPosition(final Vector3i blockPosition) {
      this.blockPosition = blockPosition;
   }

   public void setBlockFace(final int blockFace) {
      this.blockFace = blockFace;
   }

   public void setHotbarSlot(final int hotbarSlot) {
      this.hotbarSlot = hotbarSlot;
   }

   public void setItemInHand(final ItemData itemInHand) {
      this.itemInHand = itemInHand;
   }

   public void setPlayerPosition(final Vector3f playerPosition) {
      this.playerPosition = playerPosition;
   }

   public void setClickPosition(final Vector3f clickPosition) {
      this.clickPosition = clickPosition;
   }

   public void setHeadPosition(final Vector3f headPosition) {
      this.headPosition = headPosition;
   }

   @Deprecated
   public void setUsingNetIds(final boolean usingNetIds) {
      this.usingNetIds = usingNetIds;
   }

   public void setBlockDefinition(final BlockDefinition blockDefinition) {
      this.blockDefinition = blockDefinition;
   }

   public void setTriggerType(final ItemUseTransaction.TriggerType triggerType) {
      this.triggerType = triggerType;
   }

   public void setClientInteractPrediction(final ItemUseTransaction.PredictedResult clientInteractPrediction) {
      this.clientInteractPrediction = clientInteractPrediction;
   }

   @Override
   public boolean equals(final Object o) {
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
                              if (this$blockDefinition == null ? other$blockDefinition == null : this$blockDefinition.equals(other$blockDefinition)) {
                                 Object this$triggerType = this.triggerType;
                                 Object other$triggerType = other.triggerType;
                                 if (this$triggerType == null ? other$triggerType == null : this$triggerType.equals(other$triggerType)) {
                                    Object this$clientInteractPrediction = this.clientInteractPrediction;
                                    Object other$clientInteractPrediction = other.clientInteractPrediction;
                                    return this$clientInteractPrediction == null
                                       ? other$clientInteractPrediction == null
                                       : this$clientInteractPrediction.equals(other$clientInteractPrediction);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
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
      result = result * 59 + ($blockDefinition == null ? 43 : $blockDefinition.hashCode());
      Object $triggerType = this.triggerType;
      result = result * 59 + ($triggerType == null ? 43 : $triggerType.hashCode());
      Object $clientInteractPrediction = this.clientInteractPrediction;
      return result * 59 + ($clientInteractPrediction == null ? 43 : $clientInteractPrediction.hashCode());
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
         + ", triggerType="
         + this.triggerType
         + ", clientInteractPrediction="
         + this.clientInteractPrediction
         + ")";
   }
}
