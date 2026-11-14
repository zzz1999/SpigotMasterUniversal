package com.nukkitx.protocol.bedrock.data.inventory.itemstack.request.action;

public final class BeaconPaymentAction implements ItemStackRequestAction {
   private final int primaryEffect;
   private final int secondaryEffect;

   @Override
   public ItemStackRequestActionType getType() {
      return ItemStackRequestActionType.BEACON_PAYMENT;
   }

   public BeaconPaymentAction(int primaryEffect, int secondaryEffect) {
      this.primaryEffect = primaryEffect;
      this.secondaryEffect = secondaryEffect;
   }

   public int getPrimaryEffect() {
      return this.primaryEffect;
   }

   public int getSecondaryEffect() {
      return this.secondaryEffect;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BeaconPaymentAction)) {
         return false;
      }

      BeaconPaymentAction other = (BeaconPaymentAction)o;
      return this.getPrimaryEffect() != other.getPrimaryEffect() ? false : this.getSecondaryEffect() == other.getSecondaryEffect();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getPrimaryEffect();
      return result * 59 + this.getSecondaryEffect();
   }

   @Override
   public String toString() {
      return "BeaconPaymentAction(primaryEffect=" + this.getPrimaryEffect() + ", secondaryEffect=" + this.getSecondaryEffect() + ")";
   }
}
