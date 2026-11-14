package com.nukkitx.protocol.bedrock.data.event;

public class ExtractHoneyEventData implements EventData {
   public static final ExtractHoneyEventData INSTANCE = new ExtractHoneyEventData();

   @Override
   public EventDataType getType() {
      return EventDataType.EXTRACT_HONEY;
   }

   private ExtractHoneyEventData() {
   }
}
