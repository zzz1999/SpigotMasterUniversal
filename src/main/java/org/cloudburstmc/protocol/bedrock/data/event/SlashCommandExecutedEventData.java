package org.cloudburstmc.protocol.bedrock.data.event;

import java.util.List;

public final class SlashCommandExecutedEventData implements EventData {
   private final String commandName;
   private final int successCount;
   private final List<String> outputMessages;

   @Override
   public EventDataType getType() {
      return EventDataType.SLASH_COMMAND_EXECUTED;
   }

   public SlashCommandExecutedEventData(final String commandName, final int successCount, final List<String> outputMessages) {
      this.commandName = commandName;
      this.successCount = successCount;
      this.outputMessages = outputMessages;
   }

   public String getCommandName() {
      return this.commandName;
   }

   public int getSuccessCount() {
      return this.successCount;
   }

   public List<String> getOutputMessages() {
      return this.outputMessages;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SlashCommandExecutedEventData)) {
         return false;
      } else {
         SlashCommandExecutedEventData other = (SlashCommandExecutedEventData)o;
         if (this.getSuccessCount() != other.getSuccessCount()) {
            return false;
         } else {
            Object this$commandName = this.getCommandName();
            Object other$commandName = other.getCommandName();
            if (this$commandName == null ? other$commandName == null : this$commandName.equals(other$commandName)) {
               Object this$outputMessages = this.getOutputMessages();
               Object other$outputMessages = other.getOutputMessages();
               return this$outputMessages == null ? other$outputMessages == null : this$outputMessages.equals(other$outputMessages);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getSuccessCount();
      Object $commandName = this.getCommandName();
      result = result * 59 + ($commandName == null ? 43 : $commandName.hashCode());
      Object $outputMessages = this.getOutputMessages();
      return result * 59 + ($outputMessages == null ? 43 : $outputMessages.hashCode());
   }

   @Override
   public String toString() {
      return "SlashCommandExecutedEventData(commandName="
         + this.getCommandName()
         + ", successCount="
         + this.getSuccessCount()
         + ", outputMessages="
         + this.getOutputMessages()
         + ")";
   }
}
