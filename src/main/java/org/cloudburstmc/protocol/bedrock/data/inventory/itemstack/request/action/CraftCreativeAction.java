package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.action;

public final class CraftCreativeAction implements ItemStackRequestAction {
   private final int creativeItemNetworkId;
   private final int numberOfRequestedCrafts;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.CRAFT_CREATIVE;
   }

   public CraftCreativeAction(final int creativeItemNetworkId, final int numberOfRequestedCrafts) {
      this.creativeItemNetworkId = creativeItemNetworkId;
      this.numberOfRequestedCrafts = numberOfRequestedCrafts;
   }

   public int getCreativeItemNetworkId() {
      return this.creativeItemNetworkId;
   }

   public int getNumberOfRequestedCrafts() {
      return this.numberOfRequestedCrafts;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CraftCreativeAction)) {
         return false;
      }

      CraftCreativeAction other = (CraftCreativeAction)o;
      return this.getCreativeItemNetworkId() != other.getCreativeItemNetworkId()
         ? false
         : this.getNumberOfRequestedCrafts() == other.getNumberOfRequestedCrafts();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getCreativeItemNetworkId();
      return result * 59 + this.getNumberOfRequestedCrafts();
   }

   @Override
   public String toString() {
      return "CraftCreativeAction(creativeItemNetworkId="
         + this.getCreativeItemNetworkId()
         + ", numberOfRequestedCrafts="
         + this.getNumberOfRequestedCrafts()
         + ")";
   }
}
