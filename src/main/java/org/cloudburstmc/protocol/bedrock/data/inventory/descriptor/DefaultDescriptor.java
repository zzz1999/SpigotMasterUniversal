package org.cloudburstmc.protocol.bedrock.data.inventory.descriptor;

import org.cloudburstmc.protocol.bedrock.data.definitions.ItemDefinition;
import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;

public final class DefaultDescriptor implements ItemDescriptor {
   private final ItemDefinition itemId;
   private final int auxValue;

   @Override
   public ItemDescriptorType getType() {
      return ItemDescriptorType.DEFAULT;
   }

   @Override
   public ItemData.Builder toItem() {
      return ItemData.builder().definition(this.itemId).damage(this.auxValue);
   }

   public DefaultDescriptor(final ItemDefinition itemId, final int auxValue) {
      this.itemId = itemId;
      this.auxValue = auxValue;
   }

   public ItemDefinition getItemId() {
      return this.itemId;
   }

   public int getAuxValue() {
      return this.auxValue;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DefaultDescriptor)) {
         return false;
      }

      DefaultDescriptor other = (DefaultDescriptor)o;
      if (this.getAuxValue() != other.getAuxValue()) {
         return false;
      }

      Object this$itemId = this.getItemId();
      Object other$itemId = other.getItemId();
      return this$itemId == null ? other$itemId == null : this$itemId.equals(other$itemId);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getAuxValue();
      Object $itemId = this.getItemId();
      return result * 59 + ($itemId == null ? 43 : $itemId.hashCode());
   }

   @Override
   public String toString() {
      return "DefaultDescriptor(itemId=" + this.getItemId() + ", auxValue=" + this.getAuxValue() + ")";
   }
}
