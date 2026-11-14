package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.ee.AgentActionType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class AgentActionEventPacket implements BedrockPacket {
   private String requestId;
   private AgentActionType actionType;
   private String responseJson;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.AGENT_ACTION_EVENT;
   }

   public AgentActionEventPacket clone() {
      try {
         return (AgentActionEventPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getRequestId() {
      return this.requestId;
   }

   public AgentActionType getActionType() {
      return this.actionType;
   }

   public String getResponseJson() {
      return this.responseJson;
   }

   public void setRequestId(final String requestId) {
      this.requestId = requestId;
   }

   public void setActionType(final AgentActionType actionType) {
      this.actionType = actionType;
   }

   public void setResponseJson(final String responseJson) {
      this.responseJson = responseJson;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AgentActionEventPacket)) {
         return false;
      }

      AgentActionEventPacket other = (AgentActionEventPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$requestId = this.requestId;
      Object other$requestId = other.requestId;
      if (this$requestId == null ? other$requestId == null : this$requestId.equals(other$requestId)) {
         Object this$actionType = this.actionType;
         Object other$actionType = other.actionType;
         if (this$actionType == null ? other$actionType == null : this$actionType.equals(other$actionType)) {
            Object this$responseJson = this.responseJson;
            Object other$responseJson = other.responseJson;
            return this$responseJson == null ? other$responseJson == null : this$responseJson.equals(other$responseJson);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AgentActionEventPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $requestId = this.requestId;
      result = result * 59 + ($requestId == null ? 43 : $requestId.hashCode());
      Object $actionType = this.actionType;
      result = result * 59 + ($actionType == null ? 43 : $actionType.hashCode());
      Object $responseJson = this.responseJson;
      return result * 59 + ($responseJson == null ? 43 : $responseJson.hashCode());
   }

   @Override
   public String toString() {
      return "AgentActionEventPacket(requestId=" + this.requestId + ", actionType=" + this.actionType + ", responseJson=" + this.responseJson + ")";
   }
}
