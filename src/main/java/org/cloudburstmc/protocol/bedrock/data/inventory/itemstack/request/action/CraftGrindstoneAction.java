package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.action;

public final class CraftGrindstoneAction implements ItemStackRequestAction {
   private final int recipeNetworkId;
   private final int numberOfRequestedCrafts;
   private final int repairCost;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.CRAFT_REPAIR_AND_DISENCHANT;
   }

   public CraftGrindstoneAction(final int recipeNetworkId, final int numberOfRequestedCrafts, final int repairCost) {
      this.recipeNetworkId = recipeNetworkId;
      this.numberOfRequestedCrafts = numberOfRequestedCrafts;
      this.repairCost = repairCost;
   }

   public int getRecipeNetworkId() {
      return this.recipeNetworkId;
   }

   public int getNumberOfRequestedCrafts() {
      return this.numberOfRequestedCrafts;
   }

   public int getRepairCost() {
      return this.repairCost;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CraftGrindstoneAction)) {
         return false;
      } else {
         CraftGrindstoneAction other = (CraftGrindstoneAction)o;
         if (this.getRecipeNetworkId() != other.getRecipeNetworkId()) {
            return false;
         } else {
            return this.getNumberOfRequestedCrafts() != other.getNumberOfRequestedCrafts() ? false : this.getRepairCost() == other.getRepairCost();
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getRecipeNetworkId();
      result = result * 59 + this.getNumberOfRequestedCrafts();
      return result * 59 + this.getRepairCost();
   }

   @Override
   public String toString() {
      return "CraftGrindstoneAction(recipeNetworkId="
         + this.getRecipeNetworkId()
         + ", numberOfRequestedCrafts="
         + this.getNumberOfRequestedCrafts()
         + ", repairCost="
         + this.getRepairCost()
         + ")";
   }
}
