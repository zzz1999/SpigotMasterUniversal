package org.cloudburstmc.protocol.bedrock.data.inventory.descriptor;

import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;

public class InvalidDescriptor implements ItemDescriptor {
   public static final InvalidDescriptor INSTANCE = new InvalidDescriptor();

   @Override
   public ItemDescriptorType getType() {
      return ItemDescriptorType.INVALID;
   }

   @Override
   public ItemData.Builder toItem() {
      throw new UnsupportedOperationException();
   }

   @Override
   public String toString() {
      return "InvalidDescriptor()";
   }

   private InvalidDescriptor() {
   }
}
