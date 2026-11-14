package org.cloudburstmc.protocol.bedrock.data.camera;

public class CameraAimAssistItemSettings {
   private final String itemId;
   private final String category;

   public String getItemId() {
      return this.itemId;
   }

   public String getCategory() {
      return this.category;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CameraAimAssistItemSettings)) {
         return false;
      } else {
         CameraAimAssistItemSettings other = (CameraAimAssistItemSettings)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$itemId = this.getItemId();
            Object other$itemId = other.getItemId();
            if (this$itemId == null ? other$itemId == null : this$itemId.equals(other$itemId)) {
               Object this$category = this.getCategory();
               Object other$category = other.getCategory();
               return this$category == null ? other$category == null : this$category.equals(other$category);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CameraAimAssistItemSettings;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $itemId = this.getItemId();
      result = result * 59 + ($itemId == null ? 43 : $itemId.hashCode());
      Object $category = this.getCategory();
      return result * 59 + ($category == null ? 43 : $category.hashCode());
   }

   @Override
   public String toString() {
      return "CameraAimAssistItemSettings(itemId=" + this.getItemId() + ", category=" + this.getCategory() + ")";
   }

   public CameraAimAssistItemSettings(final String itemId, final String category) {
      this.itemId = itemId;
      this.category = category;
   }
}
