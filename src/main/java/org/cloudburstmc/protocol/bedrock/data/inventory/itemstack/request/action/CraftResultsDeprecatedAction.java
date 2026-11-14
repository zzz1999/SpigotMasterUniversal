package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.action;

import java.util.Arrays;
import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;

public final class CraftResultsDeprecatedAction implements ItemStackRequestAction {
   private final ItemData[] resultItems;
   private final int timesCrafted;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.CRAFT_RESULTS_DEPRECATED;
   }

   public CraftResultsDeprecatedAction(final ItemData[] resultItems, final int timesCrafted) {
      this.resultItems = resultItems;
      this.timesCrafted = timesCrafted;
   }

   public ItemData[] getResultItems() {
      return this.resultItems;
   }

   public int getTimesCrafted() {
      return this.timesCrafted;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CraftResultsDeprecatedAction)) {
         return false;
      }

      CraftResultsDeprecatedAction other = (CraftResultsDeprecatedAction)o;
      return this.getTimesCrafted() != other.getTimesCrafted() ? false : Arrays.deepEquals(this.getResultItems(), other.getResultItems());
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getTimesCrafted();
      return result * 59 + Arrays.deepHashCode(this.getResultItems());
   }

   @Override
   public String toString() {
      return "CraftResultsDeprecatedAction(resultItems=" + Arrays.deepToString(this.getResultItems()) + ", timesCrafted=" + this.getTimesCrafted() + ")";
   }
}
