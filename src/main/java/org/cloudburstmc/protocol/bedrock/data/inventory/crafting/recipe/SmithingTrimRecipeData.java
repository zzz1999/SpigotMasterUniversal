package org.cloudburstmc.protocol.bedrock.data.inventory.crafting.recipe;

import org.cloudburstmc.protocol.bedrock.data.inventory.crafting.CraftingDataType;
import org.cloudburstmc.protocol.bedrock.data.inventory.descriptor.ItemDescriptorWithCount;

public class SmithingTrimRecipeData implements TaggedCraftingData, IdentifiableRecipeData, NetworkRecipeData {
   private final String id;
   private final ItemDescriptorWithCount base;
   private final ItemDescriptorWithCount addition;
   private final ItemDescriptorWithCount template;
   private final String tag;
   private final int netId;

   @Override
   public CraftingDataType getType() {
      return CraftingDataType.SMITHING_TRIM;
   }

   public static SmithingTrimRecipeData of(
      String id, ItemDescriptorWithCount base, ItemDescriptorWithCount addition, ItemDescriptorWithCount template, String tag, int netId
   ) {
      return new SmithingTrimRecipeData(id, base, addition, template, tag, netId);
   }

   @Override
   public String getId() {
      return this.id;
   }

   public ItemDescriptorWithCount getBase() {
      return this.base;
   }

   public ItemDescriptorWithCount getAddition() {
      return this.addition;
   }

   public ItemDescriptorWithCount getTemplate() {
      return this.template;
   }

   @Override
   public String getTag() {
      return this.tag;
   }

   @Override
   public int getNetId() {
      return this.netId;
   }

   @Override
   public String toString() {
      return "SmithingTrimRecipeData(id="
         + this.getId()
         + ", base="
         + this.getBase()
         + ", addition="
         + this.getAddition()
         + ", template="
         + this.getTemplate()
         + ", tag="
         + this.getTag()
         + ", netId="
         + this.getNetId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SmithingTrimRecipeData)) {
         return false;
      }

      SmithingTrimRecipeData other = (SmithingTrimRecipeData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getNetId() != other.getNetId()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$base = this.getBase();
         Object other$base = other.getBase();
         if (this$base == null ? other$base == null : this$base.equals(other$base)) {
            Object this$addition = this.getAddition();
            Object other$addition = other.getAddition();
            if (this$addition == null ? other$addition == null : this$addition.equals(other$addition)) {
               Object this$template = this.getTemplate();
               Object other$template = other.getTemplate();
               if (this$template == null ? other$template == null : this$template.equals(other$template)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SmithingTrimRecipeData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getNetId();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $base = this.getBase();
      result = result * 59 + ($base == null ? 43 : $base.hashCode());
      Object $addition = this.getAddition();
      result = result * 59 + ($addition == null ? 43 : $addition.hashCode());
      Object $template = this.getTemplate();
      result = result * 59 + ($template == null ? 43 : $template.hashCode());
      Object $tag = this.getTag();
      return result * 59 + ($tag == null ? 43 : $tag.hashCode());
   }

   private SmithingTrimRecipeData(
      final String id,
      final ItemDescriptorWithCount base,
      final ItemDescriptorWithCount addition,
      final ItemDescriptorWithCount template,
      final String tag,
      final int netId
   ) {
      this.id = id;
      this.base = base;
      this.addition = addition;
      this.template = template;
      this.tag = tag;
      this.netId = netId;
   }
}
