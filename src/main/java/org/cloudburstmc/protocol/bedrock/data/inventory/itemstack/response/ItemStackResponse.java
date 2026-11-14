package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.response;

import java.util.List;

public final class ItemStackResponse {
   @Deprecated
   private final boolean success;
   private final ItemStackResponseStatus result;
   private final int requestId;
   private final List<ItemStackResponseContainer> containers;

   @Deprecated
   public ItemStackResponse(boolean success, int requestId, List<ItemStackResponseContainer> containers) {
      this.success = success;
      this.requestId = requestId;
      this.containers = containers;
      this.result = success ? ItemStackResponseStatus.OK : ItemStackResponseStatus.ERROR;
   }

   public ItemStackResponse(ItemStackResponseStatus result, int requestId, List<ItemStackResponseContainer> containers) {
      this.result = result;
      this.requestId = requestId;
      this.containers = containers;
      this.success = false;
   }

   @Deprecated
   public boolean isSuccess() {
      return this.success;
   }

   public ItemStackResponseStatus getResult() {
      return this.result;
   }

   public int getRequestId() {
      return this.requestId;
   }

   public List<ItemStackResponseContainer> getContainers() {
      return this.containers;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ItemStackResponse)) {
         return false;
      } else {
         ItemStackResponse other = (ItemStackResponse)o;
         if (this.isSuccess() != other.isSuccess()) {
            return false;
         } else if (this.getRequestId() != other.getRequestId()) {
            return false;
         } else {
            Object this$result = this.getResult();
            Object other$result = other.getResult();
            if (this$result == null ? other$result == null : this$result.equals(other$result)) {
               Object this$containers = this.getContainers();
               Object other$containers = other.getContainers();
               return this$containers == null ? other$containers == null : this$containers.equals(other$containers);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isSuccess() ? 79 : 97);
      result = result * 59 + this.getRequestId();
      Object $result = this.getResult();
      result = result * 59 + ($result == null ? 43 : $result.hashCode());
      Object $containers = this.getContainers();
      return result * 59 + ($containers == null ? 43 : $containers.hashCode());
   }

   @Override
   public String toString() {
      return "ItemStackResponse(result=" + this.getResult() + ", requestId=" + this.getRequestId() + ", containers=" + this.getContainers() + ")";
   }
}
