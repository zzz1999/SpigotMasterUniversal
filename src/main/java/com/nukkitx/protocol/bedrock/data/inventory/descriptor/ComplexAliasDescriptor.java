package com.nukkitx.protocol.bedrock.data.inventory.descriptor;

import com.nukkitx.protocol.bedrock.data.inventory.ItemData;

public final class ComplexAliasDescriptor implements ItemDescriptor {
   private final String name;

   @Override
   public ItemDescriptorType getType() {
      return ItemDescriptorType.COMPLEX_ALIAS;
   }

   @Override
   public ItemData.Builder toItem() {
      throw new UnsupportedOperationException();
   }

   public ComplexAliasDescriptor(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ComplexAliasDescriptor)) {
         return false;
      }

      ComplexAliasDescriptor other = (ComplexAliasDescriptor)o;
      Object this$name = this.getName();
      Object other$name = other.getName();
      return this$name == null ? other$name == null : this$name.equals(other$name);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "ComplexAliasDescriptor(name=" + this.getName() + ")";
   }
}
