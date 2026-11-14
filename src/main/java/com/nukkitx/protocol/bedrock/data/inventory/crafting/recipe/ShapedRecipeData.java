package com.nukkitx.protocol.bedrock.data.inventory.crafting.recipe;

import com.nukkitx.protocol.bedrock.data.inventory.ItemData;
import com.nukkitx.protocol.bedrock.data.inventory.crafting.CraftingDataType;
import com.nukkitx.protocol.bedrock.data.inventory.descriptor.ItemDescriptorWithCount;
import com.nukkitx.protocol.common.util.Preconditions;
import java.util.List;
import java.util.UUID;

public class ShapedRecipeData implements CraftingRecipeData {
   private final CraftingDataType type;
   private final String id;
   private final int width;
   private final int height;
   private final List<ItemDescriptorWithCount> ingredients;
   private final List<ItemData> results;
   private final UUID uuid;
   private final String tag;
   private final int priority;
   private final int netId;
   private final boolean assumeSymetry;

   public static ShapedRecipeData of(
      CraftingDataType type,
      String id,
      int width,
      int height,
      List<ItemDescriptorWithCount> ingredients,
      List<ItemData> results,
      UUID uuid,
      String tag,
      int priority,
      int netId
   ) {
      Preconditions.checkArgument(type == CraftingDataType.SHAPED || type == CraftingDataType.SHAPED_CHEMISTRY, "type must be SHAPED or SHAPED_CHEMISTRY");
      return new ShapedRecipeData(type, id, width, height, ingredients, results, uuid, tag, priority, netId, false);
   }

   public static ShapedRecipeData of(
      CraftingDataType type,
      String id,
      int width,
      int height,
      List<ItemDescriptorWithCount> ingredients,
      List<ItemData> results,
      UUID uuid,
      String tag,
      int priority,
      int netId,
      boolean assumeSymetry
   ) {
      Preconditions.checkArgument(type == CraftingDataType.SHAPED || type == CraftingDataType.SHAPED_CHEMISTRY, "type must be SHAPED or SHAPED_CHEMISTRY");
      return new ShapedRecipeData(type, id, width, height, ingredients, results, uuid, tag, priority, netId, assumeSymetry);
   }

   public static ShapedRecipeData shaped(
      String id,
      int width,
      int height,
      List<ItemDescriptorWithCount> ingredients,
      List<ItemData> results,
      UUID uuid,
      String tag,
      int priority,
      int netId,
      boolean assumeSymetry
   ) {
      return of(CraftingDataType.SHAPED, id, width, height, ingredients, results, uuid, tag, priority, netId, assumeSymetry);
   }

   public static ShapedRecipeData shapedChemistry(
      String id,
      int width,
      int height,
      List<ItemDescriptorWithCount> ingredients,
      List<ItemData> results,
      UUID uuid,
      String tag,
      int priority,
      int netId,
      boolean assumeSymetry
   ) {
      return of(CraftingDataType.SHAPED_CHEMISTRY, id, width, height, ingredients, results, uuid, tag, priority, netId, assumeSymetry);
   }

   @Override
   public CraftingDataType getType() {
      return this.type;
   }

   @Override
   public String getId() {
      return this.id;
   }

   public int getWidth() {
      return this.width;
   }

   public int getHeight() {
      return this.height;
   }

   @Override
   public List<ItemDescriptorWithCount> getIngredients() {
      return this.ingredients;
   }

   @Override
   public List<ItemData> getResults() {
      return this.results;
   }

   @Override
   public UUID getUuid() {
      return this.uuid;
   }

   @Override
   public String getTag() {
      return this.tag;
   }

   @Override
   public int getPriority() {
      return this.priority;
   }

   @Override
   public int getNetId() {
      return this.netId;
   }

   public boolean isAssumeSymetry() {
      return this.assumeSymetry;
   }

   @Override
   public String toString() {
      return "ShapedRecipeData(type="
         + this.getType()
         + ", id="
         + this.getId()
         + ", width="
         + this.getWidth()
         + ", height="
         + this.getHeight()
         + ", ingredients="
         + this.getIngredients()
         + ", results="
         + this.getResults()
         + ", uuid="
         + this.getUuid()
         + ", tag="
         + this.getTag()
         + ", priority="
         + this.getPriority()
         + ", netId="
         + this.getNetId()
         + ", assumeSymetry="
         + this.isAssumeSymetry()
         + ")";
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ShapedRecipeData)) {
         return false;
      }

      ShapedRecipeData other = (ShapedRecipeData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getWidth() != other.getWidth()) {
         return false;
      }

      if (this.getHeight() != other.getHeight()) {
         return false;
      }

      if (this.getPriority() != other.getPriority()) {
         return false;
      }

      if (this.getNetId() != other.getNetId()) {
         return false;
      }

      if (this.isAssumeSymetry() != other.isAssumeSymetry()) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$id = this.getId();
         Object other$id = other.getId();
         if (this$id == null ? other$id == null : this$id.equals(other$id)) {
            Object this$ingredients = this.getIngredients();
            Object other$ingredients = other.getIngredients();
            if (this$ingredients == null ? other$ingredients == null : this$ingredients.equals(other$ingredients)) {
               Object this$results = this.getResults();
               Object other$results = other.getResults();
               if (this$results == null ? other$results == null : this$results.equals(other$results)) {
                  Object this$uuid = this.getUuid();
                  Object other$uuid = other.getUuid();
                  if (this$uuid == null ? other$uuid == null : this$uuid.equals(other$uuid)) {
                     Object this$tag = this.getTag();
                     Object other$tag = other.getTag();
                     return this$tag == null ? other$tag == null : this$tag.equals(other$tag);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof ShapedRecipeData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getWidth();
      result = result * 59 + this.getHeight();
      result = result * 59 + this.getPriority();
      result = result * 59 + this.getNetId();
      result = result * 59 + (this.isAssumeSymetry() ? 79 : 97);
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $ingredients = this.getIngredients();
      result = result * 59 + ($ingredients == null ? 43 : $ingredients.hashCode());
      Object $results = this.getResults();
      result = result * 59 + ($results == null ? 43 : $results.hashCode());
      Object $uuid = this.getUuid();
      result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
      Object $tag = this.getTag();
      return result * 59 + ($tag == null ? 43 : $tag.hashCode());
   }

   private ShapedRecipeData(
      CraftingDataType type,
      String id,
      int width,
      int height,
      List<ItemDescriptorWithCount> ingredients,
      List<ItemData> results,
      UUID uuid,
      String tag,
      int priority,
      int netId,
      boolean assumeSymetry
   ) {
      this.type = type;
      this.id = id;
      this.width = width;
      this.height = height;
      this.ingredients = ingredients;
      this.results = results;
      this.uuid = uuid;
      this.tag = tag;
      this.priority = priority;
      this.netId = netId;
      this.assumeSymetry = assumeSymetry;
   }
}
