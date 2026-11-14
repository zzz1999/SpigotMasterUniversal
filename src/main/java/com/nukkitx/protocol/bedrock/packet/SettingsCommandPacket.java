package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class SettingsCommandPacket implements BedrockPacket {
   private String command;
   private boolean suppressingOutput;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SETTINGS_COMMAND;
   }

   public String getCommand() {
      return this.command;
   }

   public boolean isSuppressingOutput() {
      return this.suppressingOutput;
   }

   public void setCommand(String command) {
      this.command = command;
   }

   public void setSuppressingOutput(boolean suppressingOutput) {
      this.suppressingOutput = suppressingOutput;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SettingsCommandPacket)) {
         return false;
      }

      SettingsCommandPacket other = (SettingsCommandPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.suppressingOutput != other.suppressingOutput) {
         return false;
      }

      Object this$command = this.command;
      Object other$command = other.command;
      return this$command == null ? other$command == null : this$command.equals(other$command);
   }

   protected boolean canEqual(Object other) {
      return other instanceof SettingsCommandPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.suppressingOutput ? 79 : 97);
      Object $command = this.command;
      return result * 59 + ($command == null ? 43 : $command.hashCode());
   }

   @Override
   public String toString() {
      return "SettingsCommandPacket(command=" + this.command + ", suppressingOutput=" + this.suppressingOutput + ")";
   }
}
