package org.cloudburstmc.protocol.bedrock.data.camera;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class CameraAimAssistCategories {
   private String identifier;
   private final List<CameraAimAssistCategory> categories = new ObjectArrayList<>();

   public String getIdentifier() {
      return this.identifier;
   }

   public List<CameraAimAssistCategory> getCategories() {
      return this.categories;
   }

   public void setIdentifier(final String identifier) {
      this.identifier = identifier;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CameraAimAssistCategories)) {
         return false;
      } else {
         CameraAimAssistCategories other = (CameraAimAssistCategories)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$identifier = this.getIdentifier();
            Object other$identifier = other.getIdentifier();
            if (this$identifier == null ? other$identifier == null : this$identifier.equals(other$identifier)) {
               Object this$categories = this.getCategories();
               Object other$categories = other.getCategories();
               return this$categories == null ? other$categories == null : this$categories.equals(other$categories);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CameraAimAssistCategories;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $identifier = this.getIdentifier();
      result = result * 59 + ($identifier == null ? 43 : $identifier.hashCode());
      Object $categories = this.getCategories();
      return result * 59 + ($categories == null ? 43 : $categories.hashCode());
   }

   @Override
   public String toString() {
      return "CameraAimAssistCategories(identifier=" + this.getIdentifier() + ", categories=" + this.getCategories() + ")";
   }
}
