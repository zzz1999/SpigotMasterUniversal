package org.cloudburstmc.protocol.bedrock.data.event;

public class CarefulRestorationEventData implements EventData {
   public static final CarefulRestorationEventData INSTANCE = new CarefulRestorationEventData();

   @Override
   public EventDataType getType() {
      return EventDataType.CAREFUL_RESTORATION;
   }

   private CarefulRestorationEventData() {
   }
}
