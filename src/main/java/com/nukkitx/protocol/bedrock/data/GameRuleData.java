package com.nukkitx.protocol.bedrock.data;

public final class GameRuleData<T> {
   private final String name;
   private final boolean editable;
   private final T value;

   public GameRuleData(String name, T value) {
      this.name = name;
      this.value = value;
      this.editable = false;
   }

   @Override
   public String toString() {
      return this.name + '=' + this.value;
   }

   public String getName() {
      return this.name;
   }

   public boolean isEditable() {
      return this.editable;
   }

   public T getValue() {
      return this.value;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof GameRuleData)) {
         return false;
      } else {
         GameRuleData<?> other = (GameRuleData<?>)o;
         if (this.isEditable() != other.isEditable()) {
            return false;
         } else {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$value = this.getValue();
               Object other$value = other.getValue();
               return this$value == null ? other$value == null : this$value.equals(other$value);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isEditable() ? 79 : 97);
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   public GameRuleData(String name, boolean editable, T value) {
      this.name = name;
      this.editable = editable;
      this.value = value;
   }
}
