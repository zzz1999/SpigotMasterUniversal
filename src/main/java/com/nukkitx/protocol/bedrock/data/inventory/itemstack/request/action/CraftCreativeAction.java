package com.nukkitx.protocol.bedrock.data.inventory.itemstack.request.action;

public final class CraftCreativeAction implements ItemStackRequestAction {
   private final int creativeItemNetworkId;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.CRAFT_CREATIVE;
   }

   public CraftCreativeAction(int creativeItemNetworkId) {
      this.creativeItemNetworkId = creativeItemNetworkId;
   }

   public int getCreativeItemNetworkId() {
      return this.creativeItemNetworkId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CraftCreativeAction)) {
         return false;
      }

      CraftCreativeAction other = (CraftCreativeAction)o;
      return this.getCreativeItemNetworkId() == other.getCreativeItemNetworkId();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.getCreativeItemNetworkId();
   }

   @Override
   public String toString() {
      return "CraftCreativeAction(creativeItemNetworkId=" + this.getCreativeItemNetworkId() + ")";
   }
}
