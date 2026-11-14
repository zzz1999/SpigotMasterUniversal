package org.cloudburstmc.protocol.bedrock.data.inventory.crafting.recipe;

import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;
import org.cloudburstmc.protocol.bedrock.data.inventory.crafting.RecipeUnlockingRequirement;
import org.cloudburstmc.protocol.bedrock.data.inventory.descriptor.ItemDescriptorWithCount;

public interface CraftingRecipeData extends TaggedCraftingData, UniqueCraftingData, IdentifiableRecipeData {
   List<ItemDescriptorWithCount> getIngredients();

   List<ItemData> getResults();

   int getPriority();

   RecipeUnlockingRequirement getRequirement();
}
