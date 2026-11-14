package org.cloudburstmc.protocol.bedrock.data;

public final class ExperimentData {
   private final String name;
   private final boolean enabled;

   public ExperimentData(final String name, final boolean enabled) {
      this.name = name;
      this.enabled = enabled;
   }

   public String getName() {
      return this.name;
   }

   public boolean isEnabled() {
      return this.enabled;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ExperimentData)) {
         return false;
      }

      ExperimentData other = (ExperimentData)o;
      if (this.isEnabled() != other.isEnabled()) {
         return false;
      }

      Object this$name = this.getName();
      Object other$name = other.getName();
      return this$name == null ? other$name == null : this$name.equals(other$name);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isEnabled() ? 79 : 97);
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "ExperimentData(name=" + this.getName() + ", enabled=" + this.isEnabled() + ")";
   }
}
