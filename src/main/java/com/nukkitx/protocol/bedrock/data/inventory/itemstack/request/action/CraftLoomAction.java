package com.nukkitx.protocol.bedrock.data.inventory.itemstack.request.action;

public final class CraftLoomAction implements ItemStackRequestAction {
   private final String patternId;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.CRAFT_LOOM;
   }

   public CraftLoomAction(String patternId) {
      this.patternId = patternId;
   }

   public String getPatternId() {
      return this.patternId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CraftLoomAction)) {
         return false;
      }

      CraftLoomAction other = (CraftLoomAction)o;
      Object this$patternId = this.getPatternId();
      Object other$patternId = other.getPatternId();
      return this$patternId == null ? other$patternId == null : this$patternId.equals(other$patternId);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $patternId = this.getPatternId();
      return result * 59 + ($patternId == null ? 43 : $patternId.hashCode());
   }

   @Override
   public String toString() {
      return "CraftLoomAction(patternId=" + this.getPatternId() + ")";
   }
}
