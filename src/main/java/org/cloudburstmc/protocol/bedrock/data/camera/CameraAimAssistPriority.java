package org.cloudburstmc.protocol.bedrock.data.camera;

public class CameraAimAssistPriority {
   private final String name;
   private final int priority;

   public String getName() {
      return this.name;
   }

   public int getPriority() {
      return this.priority;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraAimAssistPriority)) {
         return false;
      }

      CameraAimAssistPriority other = (CameraAimAssistPriority)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getPriority() != other.getPriority()) {
         return false;
      }

      Object this$name = this.getName();
      Object other$name = other.getName();
      return this$name == null ? other$name == null : this$name.equals(other$name);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CameraAimAssistPriority;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getPriority();
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "CameraAimAssistPriority(name=" + this.getName() + ", priority=" + this.getPriority() + ")";
   }

   public CameraAimAssistPriority(final String name, final int priority) {
      this.name = name;
      this.priority = priority;
   }
}
