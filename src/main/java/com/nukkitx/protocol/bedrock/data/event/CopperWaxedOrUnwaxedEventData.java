package com.nukkitx.protocol.bedrock.data.event;

import com.nukkitx.protocol.bedrock.data.definitions.BlockDefinition;

public class CopperWaxedOrUnwaxedEventData implements EventData {
   private final BlockDefinition definition;

   @Override
   public EventDataType getType() {
      return EventDataType.COPPER_WAXED_OR_UNWAXED;
   }

   public CopperWaxedOrUnwaxedEventData(BlockDefinition definition) {
      this.definition = definition;
   }

   public BlockDefinition getDefinition() {
      return this.definition;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CopperWaxedOrUnwaxedEventData)) {
         return false;
      }

      CopperWaxedOrUnwaxedEventData other = (CopperWaxedOrUnwaxedEventData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$definition = this.getDefinition();
      Object other$definition = other.getDefinition();
      return this$definition == null ? other$definition == null : this$definition.equals(other$definition);
   }

   protected boolean canEqual(Object other) {
      return other instanceof CopperWaxedOrUnwaxedEventData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $definition = this.getDefinition();
      return result * 59 + ($definition == null ? 43 : $definition.hashCode());
   }

   @Override
   public String toString() {
      return "CopperWaxedOrUnwaxedEventData(definition=" + this.getDefinition() + ")";
   }
}
