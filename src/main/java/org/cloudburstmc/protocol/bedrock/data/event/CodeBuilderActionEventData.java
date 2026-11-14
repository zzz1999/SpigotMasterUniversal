package org.cloudburstmc.protocol.bedrock.data.event;

public class CodeBuilderActionEventData implements EventData {
   private final String action;

   @Override
   public EventDataType getType() {
      return EventDataType.CODE_BUILDER_ACTION;
   }

   public CodeBuilderActionEventData(final String action) {
      this.action = action;
   }

   public String getAction() {
      return this.action;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CodeBuilderActionEventData)) {
         return false;
      }

      CodeBuilderActionEventData other = (CodeBuilderActionEventData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$action = this.getAction();
      Object other$action = other.getAction();
      return this$action == null ? other$action == null : this$action.equals(other$action);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CodeBuilderActionEventData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $action = this.getAction();
      return result * 59 + ($action == null ? 43 : $action.hashCode());
   }

   @Override
   public String toString() {
      return "CodeBuilderActionEventData(action=" + this.getAction() + ")";
   }
}
