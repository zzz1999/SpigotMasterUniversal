package org.cloudburstmc.protocol.bedrock.data.event;

public class SneakCloseToSculkSensorEventData implements EventData {
   public static final SneakCloseToSculkSensorEventData INSTANCE = new SneakCloseToSculkSensorEventData();

   @Override
   public EventDataType getType() {
      return EventDataType.SNEAK_CLOSE_TO_SCULK_SENSOR;
   }

   private SneakCloseToSculkSensorEventData() {
   }
}
