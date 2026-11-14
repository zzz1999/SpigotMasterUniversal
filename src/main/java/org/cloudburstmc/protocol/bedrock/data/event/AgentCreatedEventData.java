package org.cloudburstmc.protocol.bedrock.data.event;

public class AgentCreatedEventData implements EventData {
   public static final AgentCreatedEventData INSTANCE = new AgentCreatedEventData();

   @Override
   public EventDataType getType() {
      return EventDataType.AGENT_CREATED;
   }

   private AgentCreatedEventData() {
   }
}
