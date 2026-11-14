package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.action;

public final class LabTableCombineAction implements ItemStackRequestAction {
   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.LAB_TABLE_COMBINE;
   }

   @Override
   public boolean equals(final Object o) {
      return o == this ? true : o instanceof LabTableCombineAction;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "LabTableCombineAction()";
   }
}
