package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.action;

public final class CraftLoomAction implements ItemStackRequestAction {
   private final String patternId;
   private final int timesCrafted;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.CRAFT_LOOM;
   }

   public CraftLoomAction(final String patternId, final int timesCrafted) {
      this.patternId = patternId;
      this.timesCrafted = timesCrafted;
   }

   public String getPatternId() {
      return this.patternId;
   }

   public int getTimesCrafted() {
      return this.timesCrafted;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CraftLoomAction)) {
         return false;
      }

      CraftLoomAction other = (CraftLoomAction)o;
      if (this.getTimesCrafted() != other.getTimesCrafted()) {
         return false;
      }

      Object this$patternId = this.getPatternId();
      Object other$patternId = other.getPatternId();
      return this$patternId == null ? other$patternId == null : this$patternId.equals(other$patternId);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getTimesCrafted();
      Object $patternId = this.getPatternId();
      return result * 59 + ($patternId == null ? 43 : $patternId.hashCode());
   }

   @Override
   public String toString() {
      return "CraftLoomAction(patternId=" + this.getPatternId() + ", timesCrafted=" + this.getTimesCrafted() + ")";
   }
}
