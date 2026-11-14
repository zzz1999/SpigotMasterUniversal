package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.response;

import lombok.NonNull;

public class ItemStackResponseSlot {
   private int slot;
   private int hotbarSlot;
   private int count;
   private int stackNetworkId;
   @NonNull
   private String customName;
   private int durabilityCorrection;
   private String filteredCustomName = "";

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

   public String getFilteredCustomName() {
      return this.filteredCustomName;
   }

   public void setSlot(final int slot) {
      this.slot = slot;
   }

   public void setHotbarSlot(final int hotbarSlot) {
      this.hotbarSlot = hotbarSlot;
   }

   public void setCount(final int count) {
      this.count = count;
   }

   public void setStackNetworkId(final int stackNetworkId) {
      this.stackNetworkId = stackNetworkId;
   }

   public void setCustomName(@NonNull final String customName) {
      if (customName == null) {
         throw new NullPointerException("customName is marked non-null but is null");
      }

      this.customName = customName;
   }

   public void setDurabilityCorrection(final int durabilityCorrection) {
      this.durabilityCorrection = durabilityCorrection;
   }

   public void setFilteredCustomName(final String filteredCustomName) {
      this.filteredCustomName = filteredCustomName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ItemStackResponseSlot)) {
         return false;
      } else {
         ItemStackResponseSlot other = (ItemStackResponseSlot)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.getSlot() != other.getSlot()) {
            return false;
         } else if (this.getHotbarSlot() != other.getHotbarSlot()) {
            return false;
         } else if (this.getCount() != other.getCount()) {
            return false;
         } else if (this.getStackNetworkId() != other.getStackNetworkId()) {
            return false;
         } else if (this.getDurabilityCorrection() != other.getDurabilityCorrection()) {
            return false;
         } else {
            Object this$customName = this.getCustomName();
            Object other$customName = other.getCustomName();
            if (this$customName == null ? other$customName == null : this$customName.equals(other$customName)) {
               Object this$filteredCustomName = this.getFilteredCustomName();
               Object other$filteredCustomName = other.getFilteredCustomName();
               return this$filteredCustomName == null ? other$filteredCustomName == null : this$filteredCustomName.equals(other$filteredCustomName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ItemStackResponseSlot;
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
      result = result * 59 + ($customName == null ? 43 : $customName.hashCode());
      Object $filteredCustomName = this.getFilteredCustomName();
      return result * 59 + ($filteredCustomName == null ? 43 : $filteredCustomName.hashCode());
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
         + ", filteredCustomName="
         + this.getFilteredCustomName()
         + ")";
   }

   public ItemStackResponseSlot() {
   }

   public ItemStackResponseSlot(
      final int slot,
      final int hotbarSlot,
      final int count,
      final int stackNetworkId,
      @NonNull final String customName,
      final int durabilityCorrection,
      final String filteredCustomName
   ) {
      if (customName == null) {
         throw new NullPointerException("customName is marked non-null but is null");
      }

      this.slot = slot;
      this.hotbarSlot = hotbarSlot;
      this.count = count;
      this.stackNetworkId = stackNetworkId;
      this.customName = customName;
      this.durabilityCorrection = durabilityCorrection;
      this.filteredCustomName = filteredCustomName;
   }
}
