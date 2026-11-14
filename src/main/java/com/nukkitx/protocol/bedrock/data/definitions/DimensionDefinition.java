package com.nukkitx.protocol.bedrock.data.definitions;

public final class DimensionDefinition {
   private final String id;
   private final int maximumHeight;
   private final int minimumHeight;
   private final int generatorType;

   public DimensionDefinition(String id, int maximumHeight, int minimumHeight, int generatorType) {
      this.id = id;
      this.maximumHeight = maximumHeight;
      this.minimumHeight = minimumHeight;
      this.generatorType = generatorType;
   }

   public String getId() {
      return this.id;
   }

   public int getMaximumHeight() {
      return this.maximumHeight;
   }

   public int getMinimumHeight() {
      return this.minimumHeight;
   }

   public int getGeneratorType() {
      return this.generatorType;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DimensionDefinition)) {
         return false;
      }

      DimensionDefinition other = (DimensionDefinition)o;
      if (this.getMaximumHeight() != other.getMaximumHeight()) {
         return false;
      }

      if (this.getMinimumHeight() != other.getMinimumHeight()) {
         return false;
      }

      if (this.getGeneratorType() != other.getGeneratorType()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      return this$id == null ? other$id == null : this$id.equals(other$id);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getMaximumHeight();
      result = result * 59 + this.getMinimumHeight();
      result = result * 59 + this.getGeneratorType();
      Object $id = this.getId();
      return result * 59 + ($id == null ? 43 : $id.hashCode());
   }

   @Override
   public String toString() {
      return "DimensionDefinition(id="
         + this.getId()
         + ", maximumHeight="
         + this.getMaximumHeight()
         + ", minimumHeight="
         + this.getMinimumHeight()
         + ", generatorType="
         + this.getGeneratorType()
         + ")";
   }
}
