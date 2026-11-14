package org.cloudburstmc.protocol.bedrock.data.skin;

import java.util.List;

public final class PersonaPieceTintData {
   private final String type;
   private final List<String> colors;

   public PersonaPieceTintData(final String type, final List<String> colors) {
      this.type = type;
      this.colors = colors;
   }

   public String getType() {
      return this.type;
   }

   public List<String> getColors() {
      return this.colors;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PersonaPieceTintData)) {
         return false;
      } else {
         PersonaPieceTintData other = (PersonaPieceTintData)o;
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$colors = this.getColors();
            Object other$colors = other.getColors();
            return this$colors == null ? other$colors == null : this$colors.equals(other$colors);
         } else {
            return false;
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $colors = this.getColors();
      return result * 59 + ($colors == null ? 43 : $colors.hashCode());
   }

   @Override
   public String toString() {
      return "PersonaPieceTintData(type=" + this.getType() + ", colors=" + this.getColors() + ")";
   }
}
