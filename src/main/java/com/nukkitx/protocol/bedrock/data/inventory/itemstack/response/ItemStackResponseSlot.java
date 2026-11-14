package com.nukkitx.protocol.bedrock.data.inventory.itemstack.response;

import lombok.NonNull;

public final class ItemStackResponseSlot {
   private final int slot;
   private final int hotbarSlot;
   private final int count;
   private final int stackNetworkId;
   @NonNull
   private final String customName;
   private final int durabilityCorrection;

   public ItemStackResponseSlot(int slot, int hotbarSlot, int count, int stackNetworkId, @NonNull String customName, int durabilityCorrection) {
      if (customName == null) {
         throw new NullPointerException("customName is marked non-null but is null");
      }

      this.slot = slot;
      this.hotbarSlot = hotbarSlot;
      this.count = count;
      this.stackNetworkId = stackNetworkId;
      this.customName = customName;
      this.durabilityCorrection = durabilityCorrection;
   }

   public int getSlot() {
      return this.slot;
   }

   public int getHotbarSlot() {
      return this.hotbarSlot;
   }

   public int getCount() {
      return this.count;
   }

   public int getStackNetworkId() {
      return this.stackNetworkId;
   }

   @NonNull
   public String getCustomName() {
      return this.customName;
   }

   public int getDurabilityCorrection() {
      return this.durabilityCorrection;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ItemStackResponseSlot)) {
         return false;
      }

      ItemStackResponseSlot other = (ItemStackResponseSlot)o;
      if (this.getSlot() != other.getSlot()) {
         return false;
      }

      if (this.getHotbarSlot() != other.getHotbarSlot()) {
         return false;
      }

      if (this.getCount() != other.getCount()) {
         return false;
      }

      if (this.getStackNetworkId() != other.getStackNetworkId()) {
         return false;
      }

      if (this.getDurabilityCorrection() != other.getDurabilityCorrection()) {
         return false;
      }

      Object this$customName = this.getCustomName();
      Object other$customName = other.getCustomName();
      return this$customName == null ? other$customName == null : this$customName.equals(other$customName);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getSlot();
      result = result * 59 + this.getHotbarSlot();
      result = result * 59 + this.getCount();
      result = result * 59 + this.getStackNetworkId();
      result = result * 59 + this.getDurabilityCorrection();
      Object $customName = this.getCustomName();
      return result * 59 + ($customName == null ? 43 : $customName.hashCode());
   }

   @Override
   public String toString() {
      return "ItemStackResponseSlot(slot="
         + this.getSlot()
         + ", hotbarSlot="
         + this.getHotbarSlot()
         + ", count="
         + this.getCount()
         + ", stackNetworkId="
         + this.getStackNetworkId()
         + ", customName="
         + this.getCustomName()
         + ", durabilityCorrection="
         + this.getDurabilityCorrection()
         + ")";
   }
}
