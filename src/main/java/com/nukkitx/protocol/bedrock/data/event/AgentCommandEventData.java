package com.nukkitx.protocol.bedrock.data.event;

public final class AgentCommandEventData implements EventData {
   private final AgentResult result;
   private final String command;
   private final String dataKey;
   private final int dataValue;
   private final String output;

   @Override
   public EventDataType getType() {
      return EventDataType.AGENT_COMMAND;
   }

   public AgentCommandEventData(AgentResult result, String command, String dataKey, int dataValue, String output) {
      this.result = result;
      this.command = command;
      this.dataKey = dataKey;
      this.dataValue = dataValue;
      this.output = output;
   }

   public AgentResult getResult() {
      return this.result;
   }

   public String getCommand() {
      return this.command;
   }

   public String getDataKey() {
      return this.dataKey;
   }

   public int getDataValue() {
      return this.dataValue;
   }

   public String getOutput() {
      return this.output;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AgentCommandEventData)) {
         return false;
      }

      AgentCommandEventData other = (AgentCommandEventData)o;
      if (this.getDataValue() != other.getDataValue()) {
         return false;
      }

      Object this$result = this.getResult();
      Object other$result = other.getResult();
      if (this$result == null ? other$result == null : this$result.equals(other$result)) {
         Object this$command = this.getCommand();
         Object other$command = other.getCommand();
         if (this$command == null ? other$command == null : this$command.equals(other$command)) {
            Object this$dataKey = this.getDataKey();
            Object other$dataKey = other.getDataKey();
            if (this$dataKey == null ? other$dataKey == null : this$dataKey.equals(other$dataKey)) {
               Object this$output = this.getOutput();
               Object other$output = other.getOutput();
               return this$output == null ? other$output == null : this$output.equals(other$output);
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

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getDataValue();
      Object $result = this.getResult();
      result = result * 59 + ($result == null ? 43 : $result.hashCode());
      Object $command = this.getCommand();
      result = result * 59 + ($command == null ? 43 : $command.hashCode());
      Object $dataKey = this.getDataKey();
      result = result * 59 + ($dataKey == null ? 43 : $dataKey.hashCode());
      Object $output = this.getOutput();
      return result * 59 + ($output == null ? 43 : $output.hashCode());
   }

   @Override
   public String toString() {
      return "AgentCommandEventData(result="
         + this.getResult()
         + ", command="
         + this.getCommand()
         + ", dataKey="
         + this.getDataKey()
         + ", dataValue="
         + this.getDataValue()
         + ", output="
         + this.getOutput()
         + ")";
   }
}
