package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.command.CommandData;
import org.cloudburstmc.protocol.common.PacketSignal;

public class AvailableCommandsPacket implements BedrockPacket {
   private final List<CommandData> commands = new ObjectArrayList<>();

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.AVAILABLE_COMMANDS;
   }

   public AvailableCommandsPacket clone() {
      try {
         return (AvailableCommandsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<CommandData> getCommands() {
      return this.commands;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AvailableCommandsPacket)) {
         return false;
      }

      AvailableCommandsPacket other = (AvailableCommandsPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$commands = this.commands;
      Object other$commands = other.commands;
      return this$commands == null ? other$commands == null : this$commands.equals(other$commands);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AvailableCommandsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $commands = this.commands;
      return result * 59 + ($commands == null ? 43 : $commands.hashCode());
   }

   @Override
   public String toString() {
      return "AvailableCommandsPacket(commands=" + this.commands + ")";
   }
}
