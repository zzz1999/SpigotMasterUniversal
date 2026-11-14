package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.action;

public final class MineBlockAction implements ItemStackRequestAction {
   private final int hotbarSlot;
   private final int predictedDurability;
   private final int stackNetworkId;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.MINE_BLOCK;
   }

   public MineBlockAction(final int hotbarSlot, final int predictedDurability, final int stackNetworkId) {
      this.hotbarSlot = hotbarSlot;
      this.predictedDurability = predictedDurability;
      this.stackNetworkId = stackNetworkId;
   }

   public int getHotbarSlot() {
      return this.hotbarSlot;
   }

   public int getPredictedDurability() {
      return this.predictedDurability;
   }

   public int getStackNetworkId() {
      return this.stackNetworkId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MineBlockAction)) {
         return false;
      } else {
         MineBlockAction other = (MineBlockAction)o;
         if (this.getHotbarSlot() != other.getHotbarSlot()) {
            return false;
         } else {
            return this.getPredictedDurability() != other.getPredictedDurability() ? false : this.getStackNetworkId() == other.getStackNetworkId();
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getHotbarSlot();
      result = result * 59 + this.getPredictedDurability();
      return result * 59 + this.getStackNetworkId();
   }

   @Override
   public String toString() {
      return "MineBlockAction(hotbarSlot="
         + this.getHotbarSlot()
         + ", predictedDurability="
         + this.getPredictedDurability()
         + ", stackNetworkId="
         + this.getStackNetworkId()
         + ")";
   }
}
