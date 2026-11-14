package com.nukkitx.protocol.bedrock.data.inventory.itemstack.request.action;

public final class CraftRecipeOptionalAction implements ItemStackRequestAction {
   private final int recipeNetworkId;
   private final int filteredStringIndex;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.CRAFT_RECIPE_OPTIONAL;
   }

   public CraftRecipeOptionalAction(int recipeNetworkId, int filteredStringIndex) {
      this.recipeNetworkId = recipeNetworkId;
      this.filteredStringIndex = filteredStringIndex;
   }

   public int getRecipeNetworkId() {
      return this.recipeNetworkId;
   }

   public int getFilteredStringIndex() {
      return this.filteredStringIndex;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CraftRecipeOptionalAction)) {
         return false;
      }

      CraftRecipeOptionalAction other = (CraftRecipeOptionalAction)o;
      return this.getRecipeNetworkId() != other.getRecipeNetworkId() ? false : this.getFilteredStringIndex() == other.getFilteredStringIndex();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getRecipeNetworkId();
      return result * 59 + this.getFilteredStringIndex();
   }

   @Override
   public String toString() {
      return "CraftRecipeOptionalAction(recipeNetworkId=" + this.getRecipeNetworkId() + ", filteredStringIndex=" + this.getFilteredStringIndex() + ")";
   }
}
