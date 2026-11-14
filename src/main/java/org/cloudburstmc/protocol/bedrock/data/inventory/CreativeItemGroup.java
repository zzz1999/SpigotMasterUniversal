package org.cloudburstmc.protocol.bedrock.data.inventory;

public class CreativeItemGroup {
   private final CreativeItemCategory category;
   private final String name;
   private final ItemData icon;

   public static CreativeItemGroup.CreativeItemGroupBuilder builder() {
      return new CreativeItemGroup.CreativeItemGroupBuilder();
   }

   public CreativeItemGroup.CreativeItemGroupBuilder toBuilder() {
      return new CreativeItemGroup.CreativeItemGroupBuilder().category(this.category).name(this.name).icon(this.icon);
   }

   public CreativeItemCategory getCategory() {
      return this.category;
   }

   public String getName() {
      return this.name;
   }

   public ItemData getIcon() {
      return this.icon;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CreativeItemGroup)) {
         return false;
      }

      CreativeItemGroup other = (CreativeItemGroup)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$category = this.getCategory();
      Object other$category = other.getCategory();
      if (this$category == null ? other$category == null : this$category.equals(other$category)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$icon = this.getIcon();
            Object other$icon = other.getIcon();
            return this$icon == null ? other$icon == null : this$icon.equals(other$icon);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CreativeItemGroup;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $icon = this.getIcon();
      return result * 59 + ($icon == null ? 43 : $icon.hashCode());
   }

   @Override
   public String toString() {
      return "CreativeItemGroup(category=" + this.getCategory() + ", name=" + this.getName() + ", icon=" + this.getIcon() + ")";
   }

   public CreativeItemGroup(final CreativeItemCategory category, final String name, final ItemData icon) {
      this.category = category;
      this.name = name;
      this.icon = icon;
   }

   public static class CreativeItemGroupBuilder {
      private CreativeItemCategory category;
      private String name;
      private ItemData icon;

      CreativeItemGroupBuilder() {
      }

      public CreativeItemGroup.CreativeItemGroupBuilder category(final CreativeItemCategory category) {
         this.category = category;
         return this;
      }

      public CreativeItemGroup.CreativeItemGroupBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CreativeItemGroup.CreativeItemGroupBuilder icon(final ItemData icon) {
         this.icon = icon;
         return this;
      }

      public CreativeItemGroup build() {
         return new CreativeItemGroup(this.category, this.name, this.icon);
      }

      @Override
      public String toString() {
         return "CreativeItemGroup.CreativeItemGroupBuilder(category=" + this.category + ", name=" + this.name + ", icon=" + this.icon + ")";
      }
   }
}
