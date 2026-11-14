package org.cloudburstmc.protocol.bedrock.data.event;

import org.cloudburstmc.protocol.bedrock.data.definitions.ItemDefinition;

public class PiglinBarterEventData implements EventData {
   private final ItemDefinition definition;
   private final boolean targetingPlayer;

   @Override
   public EventDataType getType() {
      return EventDataType.PIGLIN_BARTER;
   }

   public PiglinBarterEventData(final ItemDefinition definition, final boolean targetingPlayer) {
      this.definition = definition;
      this.targetingPlayer = targetingPlayer;
   }

   public ItemDefinition getDefinition() {
      return this.definition;
   }

   public boolean isTargetingPlayer() {
      return this.targetingPlayer;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PiglinBarterEventData)) {
         return false;
      }

      PiglinBarterEventData other = (PiglinBarterEventData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isTargetingPlayer() != other.isTargetingPlayer()) {
         return false;
      }

      Object this$definition = this.getDefinition();
      Object other$definition = other.getDefinition();
      return this$definition == null ? other$definition == null : this$definition.equals(other$definition);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PiglinBarterEventData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isTargetingPlayer() ? 79 : 97);
      Object $definition = this.getDefinition();
      return result * 59 + ($definition == null ? 43 : $definition.hashCode());
   }

   @Override
   public String toString() {
      return "PiglinBarterEventData(definition=" + this.getDefinition() + ", targetingPlayer=" + this.isTargetingPlayer() + ")";
   }
}
