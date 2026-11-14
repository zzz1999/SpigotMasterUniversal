package org.cloudburstmc.protocol.bedrock.data.inventory.crafting;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.inventory.descriptor.ItemDescriptorWithCount;

public final class RecipeUnlockingRequirement {
   public static final RecipeUnlockingRequirement INVALID = new RecipeUnlockingRequirement(RecipeUnlockingRequirement.UnlockingContext.NONE);
   private final RecipeUnlockingRequirement.UnlockingContext context;
   private final List<ItemDescriptorWithCount> ingredients = new ObjectArrayList<>();

   public boolean isInvalid() {
      return this.ingredients.isEmpty() && this.context.equals(RecipeUnlockingRequirement.UnlockingContext.NONE);
   }

   public RecipeUnlockingRequirement(final RecipeUnlockingRequirement.UnlockingContext context) {
      this.context = context;
   }

   public RecipeUnlockingRequirement.UnlockingContext getContext() {
      return this.context;
   }

   public List<ItemDescriptorWithCount> getIngredients() {
      return this.ingredients;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof RecipeUnlockingRequirement)) {
         return false;
      } else {
         RecipeUnlockingRequirement other = (RecipeUnlockingRequirement)o;
         Object this$context = this.getContext();
         Object other$context = other.getContext();
         if (this$context == null ? other$context == null : this$context.equals(other$context)) {
            Object this$ingredients = this.getIngredients();
            Object other$ingredients = other.getIngredients();
            return this$ingredients == null ? other$ingredients == null : this$ingredients.equals(other$ingredients);
         } else {
            return false;
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $context = this.getContext();
      result = result * 59 + ($context == null ? 43 : $context.hashCode());
      Object $ingredients = this.getIngredients();
      return result * 59 + ($ingredients == null ? 43 : $ingredients.hashCode());
   }

   @Override
   public String toString() {
      return "RecipeUnlockingRequirement(context=" + this.getContext() + ", ingredients=" + this.getIngredients() + ")";
   }

   public enum UnlockingContext {
      NONE,
      ALWAYS_UNLOCKED,
      PLAYER_IN_WATER,
      PLAYER_HAS_MANY_ITEMS;

      private static final RecipeUnlockingRequirement.UnlockingContext[] VALUES = values();

      public static RecipeUnlockingRequirement.UnlockingContext from(int id) {
         return VALUES[id];
      }
   }
}
