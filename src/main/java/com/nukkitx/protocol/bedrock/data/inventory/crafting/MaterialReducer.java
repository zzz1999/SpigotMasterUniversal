package com.nukkitx.protocol.bedrock.data.inventory.crafting;

import com.nukkitx.protocol.bedrock.data.definitions.ItemDefinition;
import it.unimi.dsi.fastutil.objects.Object2IntMap;

public final class MaterialReducer {
   private final int inputId;
   private final Object2IntMap<ItemDefinition> itemCounts;

   public MaterialReducer(int inputId, Object2IntMap<ItemDefinition> itemCounts) {
      this.inputId = inputId;
      this.itemCounts = itemCounts;
   }

   public int getInputId() {
      return this.inputId;
   }

   public Object2IntMap<ItemDefinition> getItemCounts() {
      return this.itemCounts;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialReducer)) {
         return false;
      }

      MaterialReducer other = (MaterialReducer)o;
      if (this.getInputId() != other.getInputId()) {
         return false;
      }

      Object this$itemCounts = this.getItemCounts();
      Object other$itemCounts = other.getItemCounts();
      return this$itemCounts == null ? other$itemCounts == null : this$itemCounts.equals(other$itemCounts);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getInputId();
      Object $itemCounts = this.getItemCounts();
      return result * 59 + ($itemCounts == null ? 43 : $itemCounts.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialReducer(inputId=" + this.getInputId() + ", itemCounts=" + this.getItemCounts() + ")";
   }
}
