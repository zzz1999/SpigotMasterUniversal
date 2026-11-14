package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.command.CommandOriginData;
import com.nukkitx.protocol.common.PacketSignal;

public class CommandRequestPacket implements BedrockPacket {
   private String command;
   private CommandOriginData commandOriginData;
   private boolean internal;
   private int version;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.COMMAND_REQUEST;
   }

   public String getCommand() {
      return this.command;
   }

   public CommandOriginData getCommandOriginData() {
      return this.commandOriginData;
   }

   public boolean isInternal() {
      return this.internal;
   }

   public int getVersion() {
      return this.version;
   }

   public void setCommand(String command) {
      this.command = command;
   }

   public void setCommandOriginData(CommandOriginData commandOriginData) {
      this.commandOriginData = commandOriginData;
   }

   public void setInternal(boolean internal) {
      this.internal = internal;
   }

   public void setVersion(int version) {
      this.version = version;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CommandRequestPacket)) {
         return false;
      } else {
         CommandRequestPacket other = (CommandRequestPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.internal != other.internal) {
            return false;
         } else if (this.version != other.version) {
            return false;
         } else {
            Object this$command = this.command;
            Object other$command = other.command;
            if (this$command == null ? other$command == null : this$command.equals(other$command)) {
               Object this$commandOriginData = this.commandOriginData;
               Object other$commandOriginData = other.commandOriginData;
               return this$commandOriginData == null ? other$commandOriginData == null : this$commandOriginData.equals(other$commandOriginData);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof CommandRequestPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.internal ? 79 : 97);
      result = result * 59 + this.version;
      Object $command = this.command;
      result = result * 59 + ($command == null ? 43 : $command.hashCode());
      Object $commandOriginData = this.commandOriginData;
      return result * 59 + ($commandOriginData == null ? 43 : $commandOriginData.hashCode());
   }

   @Override
   public String toString() {
      return "CommandRequestPacket(command="
         + this.command
         + ", commandOriginData="
         + this.commandOriginData
         + ", internal="
         + this.internal
         + ", version="
         + this.version
         + ")";
   }
}
