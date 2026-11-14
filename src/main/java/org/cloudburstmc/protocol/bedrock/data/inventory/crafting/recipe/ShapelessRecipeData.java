package org.cloudburstmc.protocol.bedrock.data.inventory.crafting.recipe;

import java.util.List;
import java.util.UUID;
import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;
import org.cloudburstmc.protocol.bedrock.data.inventory.crafting.CraftingDataType;
import org.cloudburstmc.protocol.bedrock.data.inventory.crafting.RecipeUnlockingRequirement;
import org.cloudburstmc.protocol.bedrock.data.inventory.descriptor.ItemDescriptorWithCount;
import org.cloudburstmc.protocol.common.util.Preconditions;

public class ShapelessRecipeData implements CraftingRecipeData {
   private final CraftingDataType type;
   private final String id;
   private final List<ItemDescriptorWithCount> ingredients;
   private final List<ItemData> results;
   private final UUID uuid;
   private final String tag;
   private final int priority;
   private final int netId;
   private final RecipeUnlockingRequirement requirement;

   public static ShapelessRecipeData of(
      CraftingDataType type,
      String id,
      List<ItemDescriptorWithCount> ingredients,
      List<ItemData> results,
      UUID uuid,
      String tag,
      int priority,
      int netId,
      RecipeUnlockingRequirement requirement
   ) {
      Preconditions.checkArgument(
         type == CraftingDataType.SHAPELESS || type == CraftingDataType.SHAPELESS_CHEMISTRY || type == CraftingDataType.SHULKER_BOX,
         "type must be SHAPELESS, SHAPELESS_CHEMISTRY or SHULKER_BOX"
      );
      return new ShapelessRecipeData(type, id, ingredients, results, uuid, tag, priority, netId, requirement);
   }

   public static ShapelessRecipeData of(
      CraftingDataType type, String id, List<ItemDescriptorWithCount> ingredients, List<ItemData> results, UUID uuid, String tag, int priority, int netId
   ) {
      return of(type, id, ingredients, results, uuid, tag, priority, netId, RecipeUnlockingRequirement.INVALID);
   }

   public static ShapelessRecipeData shapeless(
      String id,
      List<ItemDescriptorWithCount> ingredients,
      List<ItemData> results,
      UUID uuid,
      String tag,
      int priority,
      int netId,
      RecipeUnlockingRequirement requirement
   ) {
      return of(CraftingDataType.SHAPELESS, id, ingredients, results, uuid, tag, priority, netId, requirement);
   }

   public static ShapelessRecipeData shapelessChemistry(
      String id, List<ItemDescriptorWithCount> ingredients, List<ItemData> results, UUID uuid, String tag, int priority, int netId
   ) {
      return of(CraftingDataType.SHAPELESS_CHEMISTRY, id, ingredients, results, uuid, tag, priority, netId);
   }

   public static ShapelessRecipeData shulkerBox(
      String id, List<ItemDescriptorWithCount> ingredients, List<ItemData> results, UUID uuid, String tag, int priority, int netId
   ) {
      return of(CraftingDataType.SHULKER_BOX, id, ingredients, results, uuid, tag, priority, netId);
   }

   @Override
   public CraftingDataType getType() {
      return this.type;
   }

   @Override
   public String getId() {
      return this.id;
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

   @Override
   public RecipeUnlockingRequirement getRequirement() {
      return this.requirement;
   }

   @Override
   public String toString() {
      return "ShapelessRecipeData(type="
         + this.getType()
         + ", id="
         + this.getId()
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
         + ", requirement="
         + this.getRequirement()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ShapelessRecipeData)) {
         return false;
      }

      ShapelessRecipeData other = (ShapelessRecipeData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getPriority() != other.getPriority()) {
         return false;
      }

      if (this.getNetId() != other.getNetId()) {
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
                     if (this$tag == null ? other$tag == null : this$tag.equals(other$tag)) {
                        Object this$requirement = this.getRequirement();
                        Object other$requirement = other.getRequirement();
                        return this$requirement == null ? other$requirement == null : this$requirement.equals(other$requirement);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ShapelessRecipeData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getPriority();
      result = result * 59 + this.getNetId();
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
      result = result * 59 + ($tag == null ? 43 : $tag.hashCode());
      Object $requirement = this.getRequirement();
      return result * 59 + ($requirement == null ? 43 : $requirement.hashCode());
   }

   private ShapelessRecipeData(
      final CraftingDataType type,
      final String id,
      final List<ItemDescriptorWithCount> ingredients,
      final List<ItemData> results,
      final UUID uuid,
      final String tag,
      final int priority,
      final int netId,
      final RecipeUnlockingRequirement requirement
   ) {
      this.type = type;
      this.id = id;
      this.ingredients = ingredients;
      this.results = results;
      this.uuid = uuid;
      this.tag = tag;
      this.priority = priority;
      this.netId = netId;
      this.requirement = requirement;
   }
}
