package com.nukkitx.protocol.bedrock.data.inventory.itemstack.request;

import com.nukkitx.protocol.bedrock.data.inventory.itemstack.request.action.ItemStackRequestAction;
import java.util.Arrays;

public final class ItemStackRequest {
   private final int requestId;
   private final ItemStackRequestAction[] actions;
   private final String[] filterStrings;
   private final TextProcessingEventOrigin textProcessingEventOrigin;

   public ItemStackRequest(int requestId, ItemStackRequestAction[] actions, String[] filterStrings) {
      this(requestId, actions, filterStrings, TextProcessingEventOrigin.BLOCK_ENTITY_DATA_TEXT);
   }

   public int getRequestId() {
      return this.requestId;
   }

   public ItemStackRequestAction[] getActions() {
      return this.actions;
   }

   public String[] getFilterStrings() {
      return this.filterStrings;
   }

   public TextProcessingEventOrigin getTextProcessingEventOrigin() {
      return this.textProcessingEventOrigin;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ItemStackRequest)) {
         return false;
      }

      ItemStackRequest other = (ItemStackRequest)o;
      if (this.getRequestId() != other.getRequestId()) {
         return false;
      }

      if (!Arrays.deepEquals(this.getActions(), other.getActions())) {
         return false;
      }

      if (!Arrays.deepEquals(this.getFilterStrings(), other.getFilterStrings())) {
         return false;
      }

      Object this$textProcessingEventOrigin = this.getTextProcessingEventOrigin();
      Object other$textProcessingEventOrigin = other.getTextProcessingEventOrigin();
      return this$textProcessingEventOrigin == null
         ? other$textProcessingEventOrigin == null
         : this$textProcessingEventOrigin.equals(other$textProcessingEventOrigin);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getRequestId();
      result = result * 59 + Arrays.deepHashCode(this.getActions());
      result = result * 59 + Arrays.deepHashCode(this.getFilterStrings());
      Object $textProcessingEventOrigin = this.getTextProcessingEventOrigin();
      return result * 59 + ($textProcessingEventOrigin == null ? 43 : $textProcessingEventOrigin.hashCode());
   }

   @Override
   public String toString() {
      return "ItemStackRequest(requestId="
         + this.getRequestId()
         + ", actions="
         + Arrays.deepToString(this.getActions())
         + ", filterStrings="
         + Arrays.deepToString(this.getFilterStrings())
         + ", textProcessingEventOrigin="
         + this.getTextProcessingEventOrigin()
         + ")";
   }

   public ItemStackRequest(int requestId, ItemStackRequestAction[] actions, String[] filterStrings, TextProcessingEventOrigin textProcessingEventOrigin) {
      this.requestId = requestId;
      this.actions = actions;
      this.filterStrings = filterStrings;
      this.textProcessingEventOrigin = textProcessingEventOrigin;
   }
}
