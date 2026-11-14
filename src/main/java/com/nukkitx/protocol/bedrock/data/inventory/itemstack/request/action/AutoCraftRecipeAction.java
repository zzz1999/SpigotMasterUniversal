package com.nukkitx.protocol.bedrock.data.inventory.itemstack.request.action;

import com.nukkitx.protocol.bedrock.data.inventory.descriptor.ItemDescriptorWithCount;
import java.util.List;

public final class AutoCraftRecipeAction implements RecipeItemStackRequestAction {
   private final int recipeNetworkId;
   private final int timesCrafted;
   private final List<ItemDescriptorWithCount> ingredients;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.CRAFT_RECIPE_AUTO;
   }

   public AutoCraftRecipeAction(int recipeNetworkId, int timesCrafted, List<ItemDescriptorWithCount> ingredients) {
      this.recipeNetworkId = recipeNetworkId;
      this.timesCrafted = timesCrafted;
      this.ingredients = ingredients;
   }

   @Override
   public int getRecipeNetworkId() {
      return this.recipeNetworkId;
   }

   public int getTimesCrafted() {
      return this.timesCrafted;
   }

   public List<ItemDescriptorWithCount> getIngredients() {
      return this.ingredients;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AutoCraftRecipeAction)) {
         return false;
      }

      AutoCraftRecipeAction other = (AutoCraftRecipeAction)o;
      if (this.getRecipeNetworkId() != other.getRecipeNetworkId()) {
         return false;
      }

      if (this.getTimesCrafted() != other.getTimesCrafted()) {
         return false;
      }

      Object this$ingredients = this.getIngredients();
      Object other$ingredients = other.getIngredients();
      return this$ingredients == null ? other$ingredients == null : this$ingredients.equals(other$ingredients);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getRecipeNetworkId();
      result = result * 59 + this.getTimesCrafted();
      Object $ingredients = this.getIngredients();
      return result * 59 + ($ingredients == null ? 43 : $ingredients.hashCode());
   }

   @Override
   public String toString() {
      return "AutoCraftRecipeAction(recipeNetworkId="
         + this.getRecipeNetworkId()
         + ", timesCrafted="
         + this.getTimesCrafted()
         + ", ingredients="
         + this.getIngredients()
         + ")";
   }
}
