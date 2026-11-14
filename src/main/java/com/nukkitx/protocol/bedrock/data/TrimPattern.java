package com.nukkitx.protocol.bedrock.data;

public class TrimPattern {
   private final String itemName;
   private final String patternId;

   public TrimPattern(String itemName, String patternId) {
      this.itemName = itemName;
      this.patternId = patternId;
   }

   public String getItemName() {
      return this.itemName;
   }

   public String getPatternId() {
      return this.patternId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TrimPattern)) {
         return false;
      } else {
         TrimPattern other = (TrimPattern)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$itemName = this.getItemName();
            Object other$itemName = other.getItemName();
            if (this$itemName == null ? other$itemName == null : this$itemName.equals(other$itemName)) {
               Object this$patternId = this.getPatternId();
               Object other$patternId = other.getPatternId();
               return this$patternId == null ? other$patternId == null : this$patternId.equals(other$patternId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof TrimPattern;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $itemName = this.getItemName();
      result = result * 59 + ($itemName == null ? 43 : $itemName.hashCode());
      Object $patternId = this.getPatternId();
      return result * 59 + ($patternId == null ? 43 : $patternId.hashCode());
   }

   @Override
   public String toString() {
      return "TrimPattern(itemName=" + this.getItemName() + ", patternId=" + this.getPatternId() + ")";
   }
}
