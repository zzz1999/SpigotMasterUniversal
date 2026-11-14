package org.cloudburstmc.protocol.bedrock.data;

import java.util.Collections;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.attribute.AttributeModifierData;

public final class AttributeData {
   private final String name;
   private final float minimum;
   private final float maximum;
   private final float value;
   private final float defaultMinimum;
   private final float defaultMaximum;
   private final float defaultValue;
   private final List<AttributeModifierData> modifiers;

   public AttributeData(String name, float minimum, float maximum, float value) {
      this(name, minimum, maximum, value, maximum, Collections.emptyList());
   }

   public AttributeData(String name, float minimum, float maximum, float value, float defaultValue) {
      this(name, minimum, maximum, value, defaultValue, Collections.emptyList());
   }

   public AttributeData(String name, float minimum, float maximum, float value, float defaultValue, List<AttributeModifierData> modifiers) {
      this(name, minimum, maximum, value, minimum, maximum, defaultValue, modifiers);
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

   public float getDefaultMinimum() {
      return this.defaultMinimum;
   }

   public float getDefaultMaximum() {
      return this.defaultMaximum;
   }

   public float getDefaultValue() {
      return this.defaultValue;
   }

   public List<AttributeModifierData> getModifiers() {
      return this.modifiers;
   }

   @Override
   public boolean equals(final Object o) {
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
         } else if (Float.compare(this.getDefaultMinimum(), other.getDefaultMinimum()) != 0) {
            return false;
         } else if (Float.compare(this.getDefaultMaximum(), other.getDefaultMaximum()) != 0) {
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
      result = result * 59 + Float.floatToIntBits(this.getDefaultMinimum());
      result = result * 59 + Float.floatToIntBits(this.getDefaultMaximum());
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
         + ", defaultMinimum="
         + this.getDefaultMinimum()
         + ", defaultMaximum="
         + this.getDefaultMaximum()
         + ", defaultValue="
         + this.getDefaultValue()
         + ", modifiers="
         + this.getModifiers()
         + ")";
   }

   public AttributeData(
      final String name,
      final float minimum,
      final float maximum,
      final float value,
      final float defaultMinimum,
      final float defaultMaximum,
      final float defaultValue,
      final List<AttributeModifierData> modifiers
   ) {
      this.name = name;
      this.minimum = minimum;
      this.maximum = maximum;
      this.value = value;
      this.defaultMinimum = defaultMinimum;
      this.defaultMaximum = defaultMaximum;
      this.defaultValue = defaultValue;
      this.modifiers = modifiers;
   }
}
