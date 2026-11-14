package org.cloudburstmc.protocol.bedrock.data.inventory.descriptor;

import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;

public final class DeferredDescriptor implements ItemDescriptor {
   private final String fullName;
   private final int auxValue;

   @Override
   public ItemDescriptorType getType() {
      return ItemDescriptorType.DEFERRED;
   }

   @Override
   public ItemData.Builder toItem() {
      throw new UnsupportedOperationException();
   }

   public DeferredDescriptor(final String fullName, final int auxValue) {
      this.fullName = fullName;
      this.auxValue = auxValue;
   }

   public String getFullName() {
      return this.fullName;
   }

   public int getAuxValue() {
      return this.auxValue;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeferredDescriptor)) {
         return false;
      }

      DeferredDescriptor other = (DeferredDescriptor)o;
      if (this.getAuxValue() != other.getAuxValue()) {
         return false;
      }

      Object this$fullName = this.getFullName();
      Object other$fullName = other.getFullName();
      return this$fullName == null ? other$fullName == null : this$fullName.equals(other$fullName);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getAuxValue();
      Object $fullName = this.getFullName();
      return result * 59 + ($fullName == null ? 43 : $fullName.hashCode());
   }

   @Override
   public String toString() {
      return "DeferredDescriptor(fullName=" + this.getFullName() + ", auxValue=" + this.getAuxValue() + ")";
   }
}
