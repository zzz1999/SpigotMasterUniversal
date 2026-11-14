package org.cloudburstmc.protocol.bedrock.data.entity;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public final class EntityProperties {
   private final List<IntEntityProperty> intProperties = new ObjectArrayList<>();
   private final List<FloatEntityProperty> floatProperties = new ObjectArrayList<>();

   public List<IntEntityProperty> getIntProperties() {
      return this.intProperties;
   }

   public List<FloatEntityProperty> getFloatProperties() {
      return this.floatProperties;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof EntityProperties)) {
         return false;
      } else {
         EntityProperties other = (EntityProperties)o;
         Object this$intProperties = this.getIntProperties();
         Object other$intProperties = other.getIntProperties();
         if (this$intProperties == null ? other$intProperties == null : this$intProperties.equals(other$intProperties)) {
            Object this$floatProperties = this.getFloatProperties();
            Object other$floatProperties = other.getFloatProperties();
            return this$floatProperties == null ? other$floatProperties == null : this$floatProperties.equals(other$floatProperties);
         } else {
            return false;
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $intProperties = this.getIntProperties();
      result = result * 59 + ($intProperties == null ? 43 : $intProperties.hashCode());
      Object $floatProperties = this.getFloatProperties();
      return result * 59 + ($floatProperties == null ? 43 : $floatProperties.hashCode());
   }

   @Override
   public String toString() {
      return "EntityProperties(intProperties=" + this.getIntProperties() + ", floatProperties=" + this.getFloatProperties() + ")";
   }
}
