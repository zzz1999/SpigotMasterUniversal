package org.cloudburstmc.protocol.bedrock.data.inventory;

public final class FullContainerName {
   private final ContainerSlotType container;
   private final Integer dynamicId;

   public FullContainerName(final ContainerSlotType container, final Integer dynamicId) {
      this.container = container;
      this.dynamicId = dynamicId;
   }

   public ContainerSlotType getContainer() {
      return this.container;
   }

   public Integer getDynamicId() {
      return this.dynamicId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof FullContainerName)) {
         return false;
      } else {
         FullContainerName other = (FullContainerName)o;
         Object this$dynamicId = this.getDynamicId();
         Object other$dynamicId = other.getDynamicId();
         if (this$dynamicId == null ? other$dynamicId == null : this$dynamicId.equals(other$dynamicId)) {
            Object this$container = this.getContainer();
            Object other$container = other.getContainer();
            return this$container == null ? other$container == null : this$container.equals(other$container);
         } else {
            return false;
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dynamicId = this.getDynamicId();
      result = result * 59 + ($dynamicId == null ? 43 : $dynamicId.hashCode());
      Object $container = this.getContainer();
      return result * 59 + ($container == null ? 43 : $container.hashCode());
   }

   @Override
   public String toString() {
      return "FullContainerName(container=" + this.getContainer() + ", dynamicId=" + this.getDynamicId() + ")";
   }
}
