package com.nukkitx.protocol.bedrock.data.inventory.itemstack.request.action;

public final class CraftRecipeAction implements RecipeItemStackRequestAction {
   private final int recipeNetworkId;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.CRAFT_RECIPE;
   }

   public CraftRecipeAction(int recipeNetworkId) {
      this.recipeNetworkId = recipeNetworkId;
   }

   @Override
   public int getRecipeNetworkId() {
      return this.recipeNetworkId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CraftRecipeAction)) {
         return false;
      }

      CraftRecipeAction other = (CraftRecipeAction)o;
      return this.getRecipeNetworkId() == other.getRecipeNetworkId();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.getRecipeNetworkId();
   }

   @Override
   public String toString() {
      return "CraftRecipeAction(recipeNetworkId=" + this.getRecipeNetworkId() + ")";
   }
}
