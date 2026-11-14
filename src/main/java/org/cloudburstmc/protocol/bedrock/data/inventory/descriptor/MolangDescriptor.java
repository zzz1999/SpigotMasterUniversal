package org.cloudburstmc.protocol.bedrock.data.inventory.descriptor;

import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;

public final class MolangDescriptor implements ItemDescriptor {
   private final String tagExpression;
   private final int molangVersion;

   @Override
   public ItemDescriptorType getType() {
      return ItemDescriptorType.MOLANG;
   }

   @Override
   public ItemData.Builder toItem() {
      throw new UnsupportedOperationException();
   }

   public MolangDescriptor(final String tagExpression, final int molangVersion) {
      this.tagExpression = tagExpression;
      this.molangVersion = molangVersion;
   }

   public String getTagExpression() {
      return this.tagExpression;
   }

   public int getMolangVersion() {
      return this.molangVersion;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MolangDescriptor)) {
         return false;
      }

      MolangDescriptor other = (MolangDescriptor)o;
      if (this.getMolangVersion() != other.getMolangVersion()) {
         return false;
      }

      Object this$tagExpression = this.getTagExpression();
      Object other$tagExpression = other.getTagExpression();
      return this$tagExpression == null ? other$tagExpression == null : this$tagExpression.equals(other$tagExpression);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getMolangVersion();
      Object $tagExpression = this.getTagExpression();
      return result * 59 + ($tagExpression == null ? 43 : $tagExpression.hashCode());
   }

   @Override
   public String toString() {
      return "MolangDescriptor(tagExpression=" + this.getTagExpression() + ", molangVersion=" + this.getMolangVersion() + ")";
   }
}
