package org.cloudburstmc.protocol.bedrock.data.inventory;

public class CreativeItemData {
   private final ItemData item;
   private final int netId;
   private final int groupId;

   public static CreativeItemData.CreativeItemDataBuilder builder() {
      return new CreativeItemData.CreativeItemDataBuilder();
   }

   public CreativeItemData.CreativeItemDataBuilder toBuilder() {
      return new CreativeItemData.CreativeItemDataBuilder().item(this.item).netId(this.netId).groupId(this.groupId);
   }

   public ItemData getItem() {
      return this.item;
   }

   public int getNetId() {
      return this.netId;
   }

   public int getGroupId() {
      return this.groupId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CreativeItemData)) {
         return false;
      }

      CreativeItemData other = (CreativeItemData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getNetId() != other.getNetId()) {
         return false;
      }

      if (this.getGroupId() != other.getGroupId()) {
         return false;
      }

      Object this$item = this.getItem();
      Object other$item = other.getItem();
      return this$item == null ? other$item == null : this$item.equals(other$item);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CreativeItemData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getNetId();
      result = result * 59 + this.getGroupId();
      Object $item = this.getItem();
      return result * 59 + ($item == null ? 43 : $item.hashCode());
   }

   @Override
   public String toString() {
      return "CreativeItemData(item=" + this.getItem() + ", netId=" + this.getNetId() + ", groupId=" + this.getGroupId() + ")";
   }

   public CreativeItemData(final ItemData item, final int netId, final int groupId) {
      this.item = item;
      this.netId = netId;
      this.groupId = groupId;
   }

   public static class CreativeItemDataBuilder {
      private ItemData item;
      private int netId;
      private int groupId;

      CreativeItemDataBuilder() {
      }

      public CreativeItemData.CreativeItemDataBuilder item(final ItemData item) {
         this.item = item;
         return this;
      }

      public CreativeItemData.CreativeItemDataBuilder netId(final int netId) {
         this.netId = netId;
         return this;
      }

      public CreativeItemData.CreativeItemDataBuilder groupId(final int groupId) {
         this.groupId = groupId;
         return this;
      }

      public CreativeItemData build() {
         return new CreativeItemData(this.item, this.netId, this.groupId);
      }

      @Override
      public String toString() {
         return "CreativeItemData.CreativeItemDataBuilder(item=" + this.item + ", netId=" + this.netId + ", groupId=" + this.groupId + ")";
      }
   }
}
