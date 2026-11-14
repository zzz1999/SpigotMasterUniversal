package com.nukkitx.protocol.bedrock.data;

import com.nukkitx.protocol.bedrock.data.attribute.AttributeModifierData;
import java.util.Collections;
import java.util.List;

public final class AttributeData {
   private final String name;
   private final float minimum;
   private final float maximum;
   private final float value;
   private final float defaultValue;
   private final List<AttributeModifierData> modifiers;

   public AttributeData(String name, float minimum, float maximum, float value) {
      this(name, minimum, maximum, value, maximum, Collections.emptyList());
   }

   public AttributeData(String name, float minimum, float maximum, float value, float defaultValue) {
      this(name, minimum, maximum, value, defaultValue, Collections.emptyList());
   }

   public String getName() {
      return this.name;
   }

   public float getMinimum() {
      return this.minimum;
   }

   public float getMaximum() {
      return this.maximum;
   }

   public float getValue() {
      return this.value;
   }

   public float getDefaultValue() {
      return this.defaultValue;
   }

   public List<AttributeModifierData> getModifiers() {
      return this.modifiers;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AttributeData)) {
         return false;
      } else {
         AttributeData other = (AttributeData)o;
         if (Float.compare(this.getMinimum(), other.getMinimum()) != 0) {
            return false;
         } else if (Float.compare(this.getMaximum(), other.getMaximum()) != 0) {
            return false;
         } else if (Float.compare(this.getValue(), other.getValue()) != 0) {
            return false;
         } else if (Float.compare(this.getDefaultValue(), other.getDefaultValue()) != 0) {
            return false;
         } else {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$modifiers = this.getModifiers();
               Object other$modifiers = other.getModifiers();
               return this$modifiers == null ? other$modifiers == null : this$modifiers.equals(other$modifiers);
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
      result = result * 59 + Float.floatToIntBits(this.getMinimum());
      result = result * 59 + Float.floatToIntBits(this.getMaximum());
      result = result * 59 + Float.floatToIntBits(this.getValue());
      result = result * 59 + Float.floatToIntBits(this.getDefaultValue());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $modifiers = this.getModifiers();
      return result * 59 + ($modifiers == null ? 43 : $modifiers.hashCode());
   }

   @Override
   public String toString() {
      return "AttributeData(name="
         + this.getName()
         + ", minimum="
         + this.getMinimum()
         + ", maximum="
         + this.getMaximum()
         + ", value="
         + this.getValue()
         + ", defaultValue="
         + this.getDefaultValue()
         + ", modifiers="
         + this.getModifiers()
         + ")";
   }

   public AttributeData(String name, float minimum, float maximum, float value, float defaultValue, List<AttributeModifierData> modifiers) {
      this.name = name;
      this.minimum = minimum;
      this.maximum = maximum;
      this.value = value;
      this.defaultValue = defaultValue;
      this.modifiers = modifiers;
   }
}
