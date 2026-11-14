package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.action;

public final class CraftRecipeAction implements RecipeItemStackRequestAction {
   private final int recipeNetworkId;
   private final int numberOfRequestedCrafts;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.CRAFT_RECIPE;
   }

   public CraftRecipeAction(final int recipeNetworkId, final int numberOfRequestedCrafts) {
      this.recipeNetworkId = recipeNetworkId;
      this.numberOfRequestedCrafts = numberOfRequestedCrafts;
   }

   @Override
   public int getRecipeNetworkId() {
      return this.recipeNetworkId;
   }

   @Override
   public int getNumberOfRequestedCrafts() {
      return this.numberOfRequestedCrafts;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CraftRecipeAction)) {
         return false;
      }

      CraftRecipeAction other = (CraftRecipeAction)o;
      return this.getRecipeNetworkId() != other.getRecipeNetworkId() ? false : this.getNumberOfRequestedCrafts() == other.getNumberOfRequestedCrafts();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getRecipeNetworkId();
      return result * 59 + this.getNumberOfRequestedCrafts();
   }

   @Override
   public String toString() {
      return "CraftRecipeAction(recipeNetworkId=" + this.getRecipeNetworkId() + ", numberOfRequestedCrafts=" + this.getNumberOfRequestedCrafts() + ")";
   }
}
