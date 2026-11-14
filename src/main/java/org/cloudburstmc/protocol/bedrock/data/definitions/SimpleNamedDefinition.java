package org.cloudburstmc.protocol.bedrock.data.definitions;

import org.cloudburstmc.protocol.common.NamedDefinition;

public final class SimpleNamedDefinition implements NamedDefinition {
   private final String identifier;
   private final int runtimeId;

   public SimpleNamedDefinition(final String identifier, final int runtimeId) {
      this.identifier = identifier;
      this.runtimeId = runtimeId;
   }

   @Override
   public String getIdentifier() {
      return this.identifier;
   }

   @Override
   public int getRuntimeId() {
      return this.runtimeId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SimpleNamedDefinition)) {
         return false;
      }

      SimpleNamedDefinition other = (SimpleNamedDefinition)o;
      if (this.getRuntimeId() != other.getRuntimeId()) {
         return false;
      }

      Object this$identifier = this.getIdentifier();
      Object other$identifier = other.getIdentifier();
      return this$identifier == null ? other$identifier == null : this$identifier.equals(other$identifier);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getRuntimeId();
      Object $identifier = this.getIdentifier();
      return result * 59 + ($identifier == null ? 43 : $identifier.hashCode());
   }

   @Override
   public String toString() {
      return "SimpleNamedDefinition(identifier=" + this.getIdentifier() + ", runtimeId=" + this.getRuntimeId() + ")";
   }
}
