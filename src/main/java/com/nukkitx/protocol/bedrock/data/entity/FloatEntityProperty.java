package com.nukkitx.protocol.bedrock.data.entity;

public final class FloatEntityProperty implements EntityProperty {
   private final int index;
   private final float value;

   public FloatEntityProperty(int index, float value) {
      this.index = index;
      this.value = value;
   }

   @Override
   public int getIndex() {
      return this.index;
   }

   public float getValue() {
      return this.value;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FloatEntityProperty)) {
         return false;
      }

      FloatEntityProperty other = (FloatEntityProperty)o;
      return this.getIndex() != other.getIndex() ? false : Float.compare(this.getValue(), other.getValue()) == 0;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getIndex();
      return result * 59 + Float.floatToIntBits(this.getValue());
   }

   @Override
   public String toString() {
      return "FloatEntityProperty(index=" + this.getIndex() + ", value=" + this.getValue() + ")";
   }
}
