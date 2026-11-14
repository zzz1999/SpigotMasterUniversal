package com.nukkitx.protocol.bedrock.data.entity;

public final class IntEntityProperty implements EntityProperty {
   private final int index;
   private final int value;

   public IntEntityProperty(int index, int value) {
      this.index = index;
      this.value = value;
   }

   @Override
   public int getIndex() {
      return this.index;
   }

   public int getValue() {
      return this.value;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof IntEntityProperty)) {
         return false;
      }

      IntEntityProperty other = (IntEntityProperty)o;
      return this.getIndex() != other.getIndex() ? false : this.getValue() == other.getValue();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getIndex();
      return result * 59 + this.getValue();
   }

   @Override
   public String toString() {
      return "IntEntityProperty(index=" + this.getIndex() + ", value=" + this.getValue() + ")";
   }
}
