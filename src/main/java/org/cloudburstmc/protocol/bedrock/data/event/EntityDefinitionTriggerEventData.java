package org.cloudburstmc.protocol.bedrock.data.event;

public final class EntityDefinitionTriggerEventData implements EventData {
   private final String eventName;

   @Override
   public EventDataType getType() {
      return EventDataType.ENTITY_DEFINITION_TRIGGER;
   }

   public EntityDefinitionTriggerEventData(final String eventName) {
      this.eventName = eventName;
   }

   public String getEventName() {
      return this.eventName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EntityDefinitionTriggerEventData)) {
         return false;
      }

      EntityDefinitionTriggerEventData other = (EntityDefinitionTriggerEventData)o;
      Object this$eventName = this.getEventName();
      Object other$eventName = other.getEventName();
      return this$eventName == null ? other$eventName == null : this$eventName.equals(other$eventName);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $eventName = this.getEventName();
      return result * 59 + ($eventName == null ? 43 : $eventName.hashCode());
   }

   @Override
   public String toString() {
      return "EntityDefinitionTriggerEventData(eventName=" + this.getEventName() + ")";
   }
}
