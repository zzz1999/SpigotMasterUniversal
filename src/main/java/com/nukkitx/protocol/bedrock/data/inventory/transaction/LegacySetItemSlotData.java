package com.nukkitx.protocol.bedrock.data.inventory.transaction;

import java.util.Arrays;

public final class LegacySetItemSlotData {
   private final int containerId;
   private final byte[] slots;

   public LegacySetItemSlotData(int containerId, byte[] slots) {
      this.containerId = containerId;
      this.slots = slots;
   }

   public int getContainerId() {
      return this.containerId;
   }

   public byte[] getSlots() {
      return this.slots;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LegacySetItemSlotData)) {
         return false;
      }

      LegacySetItemSlotData other = (LegacySetItemSlotData)o;
      return this.getContainerId() != other.getContainerId() ? false : Arrays.equals(this.getSlots(), other.getSlots());
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getContainerId();
      return result * 59 + Arrays.hashCode(this.getSlots());
   }

   @Override
   public String toString() {
      return "LegacySetItemSlotData(containerId=" + this.getContainerId() + ", slots=" + Arrays.toString(this.getSlots()) + ")";
   }
}
