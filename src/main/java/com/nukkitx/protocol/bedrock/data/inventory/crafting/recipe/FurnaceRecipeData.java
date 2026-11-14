package com.nukkitx.protocol.bedrock.data.inventory.crafting.recipe;

import com.nukkitx.protocol.bedrock.data.inventory.ItemData;
import com.nukkitx.protocol.bedrock.data.inventory.crafting.CraftingDataType;
import com.nukkitx.protocol.common.util.Preconditions;

public class FurnaceRecipeData implements TaggedCraftingData {
   private final CraftingDataType type;
   private final int inputId;
   private final int inputData;
   private final ItemData result;
   private final String tag;

   public boolean hasData() {
      return this.type == CraftingDataType.FURNACE_DATA;
   }

   public static FurnaceRecipeData of(CraftingDataType type, int inputId, int inputData, ItemData result, String tag) {
      Preconditions.checkArgument(type == CraftingDataType.FURNACE || type == CraftingDataType.FURNACE_DATA, "type must be FURNACE or FURNACE_DATA");
      return new FurnaceRecipeData(type, inputId, inputData, result, tag);
   }

   public static FurnaceRecipeData of(int inputId, ItemData result, String tag) {
      return new FurnaceRecipeData(CraftingDataType.FURNACE, inputId, -1, result, tag);
   }

   public static FurnaceRecipeData of(int inputId, int inputData, ItemData result, String tag) {
      return new FurnaceRecipeData(CraftingDataType.FURNACE_DATA, inputId, inputData, result, tag);
   }

   @Override
   public CraftingDataType getType() {
      return this.type;
   }

   public int getInputId() {
      return this.inputId;
   }

   public int getInputData() {
      return this.inputData;
   }

   public ItemData getResult() {
      return this.result;
   }

   @Override
   public String getTag() {
      return this.tag;
   }

   @Override
   public String toString() {
      return "FurnaceRecipeData(type="
         + this.getType()
         + ", inputId="
         + this.getInputId()
         + ", inputData="
         + this.getInputData()
         + ", result="
         + this.getResult()
         + ", tag="
         + this.getTag()
         + ")";
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FurnaceRecipeData)) {
         return false;
      }

      FurnaceRecipeData other = (FurnaceRecipeData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getInputId() != other.getInputId()) {
         return false;
      }

      if (this.getInputData() != other.getInputData()) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$result = this.getResult();
         Object other$result = other.getResult();
         if (this$result == null ? other$result == null : this$result.equals(other$result)) {
            Object this$tag = this.getTag();
            Object other$tag = other.getTag();
            return this$tag == null ? other$tag == null : this$tag.equals(other$tag);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof FurnaceRecipeData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getInputId();
      result = result * 59 + this.getInputData();
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $result = this.getResult();
      result = result * 59 + ($result == null ? 43 : $result.hashCode());
      Object $tag = this.getTag();
      return result * 59 + ($tag == null ? 43 : $tag.hashCode());
   }

   private FurnaceRecipeData(CraftingDataType type, int inputId, int inputData, ItemData result, String tag) {
      this.type = type;
      this.inputId = inputId;
      this.inputData = inputData;
      this.result = result;
      this.tag = tag;
   }
}
