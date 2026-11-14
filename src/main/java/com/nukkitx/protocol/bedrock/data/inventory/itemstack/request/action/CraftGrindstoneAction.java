package com.nukkitx.protocol.bedrock.data.inventory.itemstack.request.action;

public final class CraftGrindstoneAction implements ItemStackRequestAction {
   private final int recipeNetworkId;
   private final int repairCost;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.CRAFT_REPAIR_AND_DISENCHANT;
   }

   public CraftGrindstoneAction(int recipeNetworkId, int repairCost) {
      this.recipeNetworkId = recipeNetworkId;
      this.repairCost = repairCost;
   }

   public int getRecipeNetworkId() {
      return this.recipeNetworkId;
   }

   public int getRepairCost() {
      return this.repairCost;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CraftGrindstoneAction)) {
         return false;
      }

      CraftGrindstoneAction other = (CraftGrindstoneAction)o;
      return this.getRecipeNetworkId() != other.getRecipeNetworkId() ? false : this.getRepairCost() == other.getRepairCost();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getRecipeNetworkId();
      return result * 59 + this.getRepairCost();
   }

   @Override
   public String toString() {
      return "CraftGrindstoneAction(recipeNetworkId=" + this.getRecipeNetworkId() + ", repairCost=" + this.getRepairCost() + ")";
   }
}
