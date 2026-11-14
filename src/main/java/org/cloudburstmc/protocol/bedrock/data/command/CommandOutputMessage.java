package org.cloudburstmc.protocol.bedrock.data.command;

import java.util.Arrays;
import lombok.NonNull;

public final class CommandOutputMessage {
   private final boolean internal;
   @NonNull
   private final String messageId;
   @NonNull
   private final String[] parameters;

   public CommandOutputMessage(final boolean internal, @NonNull final String messageId, @NonNull final String[] parameters) {
      if (messageId == null) {
         throw new NullPointerException("messageId is marked non-null but is null");
      }

      if (parameters == null) {
         throw new NullPointerException("parameters is marked non-null but is null");
      }

      this.internal = internal;
      this.messageId = messageId;
      this.parameters = parameters;
   }

   public boolean isInternal() {
      return this.internal;
   }

   @NonNull
   public String getMessageId() {
      return this.messageId;
   }

   @NonNull
   public String[] getParameters() {
      return this.parameters;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CommandOutputMessage)) {
         return false;
      }

      CommandOutputMessage other = (CommandOutputMessage)o;
      if (this.isInternal() != other.isInternal()) {
         return false;
      }

      Object this$messageId = this.getMessageId();
      Object other$messageId = other.getMessageId();
      return (this$messageId == null ? other$messageId == null : this$messageId.equals(other$messageId))
         ? Arrays.deepEquals(this.getParameters(), other.getParameters())
         : false;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isInternal() ? 79 : 97);
      Object $messageId = this.getMessageId();
      result = result * 59 + ($messageId == null ? 43 : $messageId.hashCode());
      return result * 59 + Arrays.deepHashCode(this.getParameters());
   }

   @Override
   public String toString() {
      return "CommandOutputMessage(internal="
         + this.isInternal()
         + ", messageId="
         + this.getMessageId()
         + ", parameters="
         + Arrays.deepToString(this.getParameters())
         + ")";
   }
}
