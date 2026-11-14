package org.cloudburstmc.protocol.bedrock.data;

import org.cloudburstmc.nbt.NbtMap;

public final class BlockPropertyData {
   private final String name;
   private final NbtMap properties;

   public BlockPropertyData(final String name, final NbtMap properties) {
      this.name = name;
      this.properties = properties;
   }

   public String getName() {
      return this.name;
   }

   public NbtMap getProperties() {
      return this.properties;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BlockPropertyData)) {
         return false;
      } else {
         BlockPropertyData other = (BlockPropertyData)o;
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$properties = this.getProperties();
            Object other$properties = other.getProperties();
            return this$properties == null ? other$properties == null : this$properties.equals(other$properties);
         } else {
            return false;
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $properties = this.getProperties();
      return result * 59 + ($properties == null ? 43 : $properties.hashCode());
   }

   @Override
   public String toString() {
      return "BlockPropertyData(name=" + this.getName() + ", properties=" + this.getProperties() + ")";
   }
}
