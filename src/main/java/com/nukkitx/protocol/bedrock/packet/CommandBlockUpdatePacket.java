package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.CommandBlockMode;
import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.math.vector.Vector3i;

public class CommandBlockUpdatePacket implements BedrockPacket {
   private boolean block;
   private Vector3i blockPosition;
   private CommandBlockMode mode;
   private boolean redstoneMode;
   private boolean conditional;
   private long minecartRuntimeEntityId;
   private String command;
   private String lastOutput;
   private String name;
   private boolean outputTracked;
   private long tickDelay;
   private boolean executingOnFirstTick;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.COMMAND_BLOCK_UPDATE;
   }

   public boolean isBlock() {
      return this.block;
   }

   public Vector3i getBlockPosition() {
      return this.blockPosition;
   }

   public CommandBlockMode getMode() {
      return this.mode;
   }

   public boolean isRedstoneMode() {
      return this.redstoneMode;
   }

   public boolean isConditional() {
      return this.conditional;
   }

   public long getMinecartRuntimeEntityId() {
      return this.minecartRuntimeEntityId;
   }

   public String getCommand() {
      return this.command;
   }

   public String getLastOutput() {
      return this.lastOutput;
   }

   public String getName() {
      return this.name;
   }

   public boolean isOutputTracked() {
      return this.outputTracked;
   }

   public long getTickDelay() {
      return this.tickDelay;
   }

   public boolean isExecutingOnFirstTick() {
      return this.executingOnFirstTick;
   }

   public void setBlock(boolean block) {
      this.block = block;
   }

   public void setBlockPosition(Vector3i blockPosition) {
      this.blockPosition = blockPosition;
   }

   public void setMode(CommandBlockMode mode) {
      this.mode = mode;
   }

   public void setRedstoneMode(boolean redstoneMode) {
      this.redstoneMode = redstoneMode;
   }

   public void setConditional(boolean conditional) {
      this.conditional = conditional;
   }

   public void setMinecartRuntimeEntityId(long minecartRuntimeEntityId) {
      this.minecartRuntimeEntityId = minecartRuntimeEntityId;
   }

   public void setCommand(String command) {
      this.command = command;
   }

   public void setLastOutput(String lastOutput) {
      this.lastOutput = lastOutput;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setOutputTracked(boolean outputTracked) {
      this.outputTracked = outputTracked;
   }

   public void setTickDelay(long tickDelay) {
      this.tickDelay = tickDelay;
   }

   public void setExecutingOnFirstTick(boolean executingOnFirstTick) {
      this.executingOnFirstTick = executingOnFirstTick;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CommandBlockUpdatePacket)) {
         return false;
      }

      CommandBlockUpdatePacket other = (CommandBlockUpdatePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.block != other.block) {
         return false;
      }

      if (this.redstoneMode != other.redstoneMode) {
         return false;
      }

      if (this.conditional != other.conditional) {
         return false;
      }

      if (this.minecartRuntimeEntityId != other.minecartRuntimeEntityId) {
         return false;
      }

      if (this.outputTracked != other.outputTracked) {
         return false;
      }

      if (this.tickDelay != other.tickDelay) {
         return false;
      }

      if (this.executingOnFirstTick != other.executingOnFirstTick) {
         return false;
      }

      Object this$blockPosition = this.blockPosition;
      Object other$blockPosition = other.blockPosition;
      if (this$blockPosition == null ? other$blockPosition == null : this$blockPosition.equals(other$blockPosition)) {
         Object this$mode = this.mode;
         Object other$mode = other.mode;
         if (this$mode == null ? other$mode == null : this$mode.equals(other$mode)) {
            Object this$command = this.command;
            Object other$command = other.command;
            if (this$command == null ? other$command == null : this$command.equals(other$command)) {
               Object this$lastOutput = this.lastOutput;
               Object other$lastOutput = other.lastOutput;
               if (this$lastOutput == null ? other$lastOutput == null : this$lastOutput.equals(other$lastOutput)) {
                  Object this$name = this.name;
                  Object other$name = other.name;
                  return this$name == null ? other$name == null : this$name.equals(other$name);
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof CommandBlockUpdatePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.block ? 79 : 97);
      result = result * 59 + (this.redstoneMode ? 79 : 97);
      result = result * 59 + (this.conditional ? 79 : 97);
      long $minecartRuntimeEntityId = this.minecartRuntimeEntityId;
      result = result * 59 + (int)($minecartRuntimeEntityId >>> 32 ^ $minecartRuntimeEntityId);
      result = result * 59 + (this.outputTracked ? 79 : 97);
      long $tickDelay = this.tickDelay;
      result = result * 59 + (int)($tickDelay >>> 32 ^ $tickDelay);
      result = result * 59 + (this.executingOnFirstTick ? 79 : 97);
      Object $blockPosition = this.blockPosition;
      result = result * 59 + ($blockPosition == null ? 43 : $blockPosition.hashCode());
      Object $mode = this.mode;
      result = result * 59 + ($mode == null ? 43 : $mode.hashCode());
      Object $command = this.command;
      result = result * 59 + ($command == null ? 43 : $command.hashCode());
      Object $lastOutput = this.lastOutput;
      result = result * 59 + ($lastOutput == null ? 43 : $lastOutput.hashCode());
      Object $name = this.name;
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "CommandBlockUpdatePacket(block="
         + this.block
         + ", blockPosition="
         + this.blockPosition
         + ", mode="
         + this.mode
         + ", redstoneMode="
         + this.redstoneMode
         + ", conditional="
         + this.conditional
         + ", minecartRuntimeEntityId="
         + this.minecartRuntimeEntityId
         + ", command="
         + this.command
         + ", lastOutput="
         + this.lastOutput
         + ", name="
         + this.name
         + ", outputTracked="
         + this.outputTracked
         + ", tickDelay="
         + this.tickDelay
         + ", executingOnFirstTick="
         + this.executingOnFirstTick
         + ")";
   }
}
