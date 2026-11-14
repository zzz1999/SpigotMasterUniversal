package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.action;

public interface RecipeItemStackRequestAction extends ItemStackRequestAction {
   int getRecipeNetworkId();

   int getNumberOfRequestedCrafts();
}
