package com.nukkitx.protocol.bedrock.data.inventory.itemstack.request.action;

public final class CraftNonImplementedAction implements ItemStackRequestAction {
   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.CRAFT_NON_IMPLEMENTED_DEPRECATED;
   }

   @Override
   public boolean equals(Object o) {
      return o == this ? true : o instanceof CraftNonImplementedAction;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "CraftNonImplementedAction()";
   }
}
