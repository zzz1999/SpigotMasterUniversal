package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class SetCommandsEnabledPacket implements BedrockPacket {
   private boolean commandsEnabled;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_COMMANDS_ENABLED;
   }

   public SetCommandsEnabledPacket clone() {
      try {
         return (SetCommandsEnabledPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public boolean isCommandsEnabled() {
      return this.commandsEnabled;
   }

   public void setCommandsEnabled(final boolean commandsEnabled) {
      this.commandsEnabled = commandsEnabled;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetCommandsEnabledPacket)) {
         return false;
      }

      SetCommandsEnabledPacket other = (SetCommandsEnabledPacket)o;
      return !other.canEqual(this) ? false : this.commandsEnabled == other.commandsEnabled;
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SetCommandsEnabledPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + (this.commandsEnabled ? 79 : 97);
   }

   @Override
   public String toString() {
      return "SetCommandsEnabledPacket(commandsEnabled=" + this.commandsEnabled + ")";
   }
}
