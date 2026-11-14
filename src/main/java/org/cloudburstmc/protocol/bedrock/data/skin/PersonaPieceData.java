package org.cloudburstmc.protocol.bedrock.data.skin;

public final class PersonaPieceData {
   private final String id;
   private final String type;
   private final String packId;
   private final boolean isDefault;
   private final String productId;

   public PersonaPieceData(final String id, final String type, final String packId, final boolean isDefault, final String productId) {
      this.id = id;
      this.type = type;
      this.packId = packId;
      this.isDefault = isDefault;
      this.productId = productId;
   }

   public String getId() {
      return this.id;
   }

   public String getType() {
      return this.type;
   }

   public String getPackId() {
      return this.packId;
   }

   public boolean isDefault() {
      return this.isDefault;
   }

   public String getProductId() {
      return this.productId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PersonaPieceData)) {
         return false;
      }

      PersonaPieceData other = (PersonaPieceData)o;
      if (this.isDefault() != other.isDefault()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$packId = this.getPackId();
            Object other$packId = other.getPackId();
            if (this$packId == null ? other$packId == null : this$packId.equals(other$packId)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               return this$productId == null ? other$productId == null : this$productId.equals(other$productId);
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

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isDefault() ? 79 : 97);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $packId = this.getPackId();
      result = result * 59 + ($packId == null ? 43 : $packId.hashCode());
      Object $productId = this.getProductId();
      return result * 59 + ($productId == null ? 43 : $productId.hashCode());
   }

   @Override
   public String toString() {
      return "PersonaPieceData(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", packId="
         + this.getPackId()
         + ", isDefault="
         + this.isDefault()
         + ", productId="
         + this.getProductId()
         + ")";
   }
}
