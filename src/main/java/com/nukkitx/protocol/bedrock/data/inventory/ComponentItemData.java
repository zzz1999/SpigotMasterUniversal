package com.nukkitx.protocol.bedrock.data.inventory;

import org.cloudburstmc.nbt.NbtMap;

public final class ComponentItemData {
   private final String name;
   private final NbtMap data;

   public ComponentItemData(String name, NbtMap data) {
      this.name = name;
      this.data = data;
   }

   public String getName() {
      return this.name;
   }

   public NbtMap getData() {
      return this.data;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ComponentItemData)) {
         return false;
      } else {
         ComponentItemData other = (ComponentItemData)o;
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$data = this.getData();
            Object other$data = other.getData();
            return this$data == null ? other$data == null : this$data.equals(other$data);
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
      Object $data = this.getData();
      return result * 59 + ($data == null ? 43 : $data.hashCode());
   }

   @Override
   public String toString() {
      return "ComponentItemData(name=" + this.getName() + ", data=" + this.getData() + ")";
   }
}
