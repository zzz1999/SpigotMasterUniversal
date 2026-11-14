package com.nukkitx.protocol.bedrock.data;

public class TrimMaterial {
   private final String materialId;
   private final String color;
   private final String itemName;

   public TrimMaterial(String materialId, String color, String itemName) {
      this.materialId = materialId;
      this.color = color;
      this.itemName = itemName;
   }

   public String getMaterialId() {
      return this.materialId;
   }

   public String getColor() {
      return this.color;
   }

   public String getItemName() {
      return this.itemName;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TrimMaterial)) {
         return false;
      }

      TrimMaterial other = (TrimMaterial)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$materialId = this.getMaterialId();
      Object other$materialId = other.getMaterialId();
      if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
         Object this$color = this.getColor();
         Object other$color = other.getColor();
         if (this$color == null ? other$color == null : this$color.equals(other$color)) {
            Object this$itemName = this.getItemName();
            Object other$itemName = other.getItemName();
            return this$itemName == null ? other$itemName == null : this$itemName.equals(other$itemName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof TrimMaterial;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $itemName = this.getItemName();
      return result * 59 + ($itemName == null ? 43 : $itemName.hashCode());
   }

   @Override
   public String toString() {
      return "TrimMaterial(materialId=" + this.getMaterialId() + ", color=" + this.getColor() + ", itemName=" + this.getItemName() + ")";
   }
}
