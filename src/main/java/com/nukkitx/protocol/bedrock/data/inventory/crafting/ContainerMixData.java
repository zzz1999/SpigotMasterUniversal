package com.nukkitx.protocol.bedrock.data.inventory.crafting;

public final class ContainerMixData {
   private final int inputId;
   private final int reagentId;
   private final int outputId;

   public ContainerMixData(int inputId, int reagentId, int outputId) {
      this.inputId = inputId;
      this.reagentId = reagentId;
      this.outputId = outputId;
   }

   public int getInputId() {
      return this.inputId;
   }

   public int getReagentId() {
      return this.reagentId;
   }

   public int getOutputId() {
      return this.outputId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ContainerMixData)) {
         return false;
      } else {
         ContainerMixData other = (ContainerMixData)o;
         if (this.getInputId() != other.getInputId()) {
            return false;
         } else {
            return this.getReagentId() != other.getReagentId() ? false : this.getOutputId() == other.getOutputId();
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getInputId();
      result = result * 59 + this.getReagentId();
      return result * 59 + this.getOutputId();
   }

   @Override
   public String toString() {
      return "ContainerMixData(inputId=" + this.getInputId() + ", reagentId=" + this.getReagentId() + ", outputId=" + this.getOutputId() + ")";
   }
}
