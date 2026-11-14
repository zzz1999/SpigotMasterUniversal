package com.nukkitx.protocol.bedrock.data.definitions;

public final class FeatureDefinition {
   private final String name;
   private final String json;

   public FeatureDefinition(String name, String json) {
      this.name = name;
      this.json = json;
   }

   public String getName() {
      return this.name;
   }

   public String getJson() {
      return this.json;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof FeatureDefinition)) {
         return false;
      } else {
         FeatureDefinition other = (FeatureDefinition)o;
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$json = this.getJson();
            Object other$json = other.getJson();
            return this$json == null ? other$json == null : this$json.equals(other$json);
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
      Object $json = this.getJson();
      return result * 59 + ($json == null ? 43 : $json.hashCode());
   }

   @Override
   public String toString() {
      return "FeatureDefinition(name=" + this.getName() + ", json=" + this.getJson() + ")";
   }
}
