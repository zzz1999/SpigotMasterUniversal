package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.NpcRequestType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class NpcRequestPacket implements BedrockPacket {
   private long runtimeEntityId;
   private NpcRequestType requestType;
   private String command;
   private int actionType;
   private String sceneName;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.NPC_REQUEST;
   }

   public NpcRequestPacket clone() {
      try {
         return (NpcRequestPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public NpcRequestType getRequestType() {
      return this.requestType;
   }

   public String getCommand() {
      return this.command;
   }

   public int getActionType() {
      return this.actionType;
   }

   public String getSceneName() {
      return this.sceneName;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setRequestType(final NpcRequestType requestType) {
      this.requestType = requestType;
   }

   public void setCommand(final String command) {
      this.command = command;
   }

   public void setActionType(final int actionType) {
      this.actionType = actionType;
   }

   public void setSceneName(final String sceneName) {
      this.sceneName = sceneName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NpcRequestPacket)) {
         return false;
      }

      NpcRequestPacket other = (NpcRequestPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.actionType != other.actionType) {
         return false;
      }

      Object this$requestType = this.requestType;
      Object other$requestType = other.requestType;
      if (this$requestType == null ? other$requestType == null : this$requestType.equals(other$requestType)) {
         Object this$command = this.command;
         Object other$command = other.command;
         if (this$command == null ? other$command == null : this$command.equals(other$command)) {
            Object this$sceneName = this.sceneName;
            Object other$sceneName = other.sceneName;
            return this$sceneName == null ? other$sceneName == null : this$sceneName.equals(other$sceneName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NpcRequestPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + this.actionType;
      Object $requestType = this.requestType;
      result = result * 59 + ($requestType == null ? 43 : $requestType.hashCode());
      Object $command = this.command;
      result = result * 59 + ($command == null ? 43 : $command.hashCode());
      Object $sceneName = this.sceneName;
      return result * 59 + ($sceneName == null ? 43 : $sceneName.hashCode());
   }

   @Override
   public String toString() {
      return "NpcRequestPacket(runtimeEntityId="
         + this.runtimeEntityId
         + ", requestType="
         + this.requestType
         + ", command="
         + this.command
         + ", actionType="
         + this.actionType
         + ", sceneName="
         + this.sceneName
         + ")";
   }
}
