package com.nukkitx.protocol.bedrock.data.definitions;

public class SimpleItemDefinition implements ItemDefinition {
   private final String identifier;
   private final int runtimeId;
   private final boolean componentBased;

   public SimpleItemDefinition(String identifier, int runtimeId, boolean componentBased) {
      this.identifier = identifier;
      this.runtimeId = runtimeId;
      this.componentBased = componentBased;
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
   public boolean isComponentBased() {
      return this.componentBased;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SimpleItemDefinition)) {
         return false;
      }

      SimpleItemDefinition other = (SimpleItemDefinition)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getRuntimeId() != other.getRuntimeId()) {
         return false;
      }

      if (this.isComponentBased() != other.isComponentBased()) {
         return false;
      }

      Object this$identifier = this.getIdentifier();
      Object other$identifier = other.getIdentifier();
      return this$identifier == null ? other$identifier == null : this$identifier.equals(other$identifier);
   }

   protected boolean canEqual(Object other) {
      return other instanceof SimpleItemDefinition;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getRuntimeId();
      result = result * 59 + (this.isComponentBased() ? 79 : 97);
      Object $identifier = this.getIdentifier();
      return result * 59 + ($identifier == null ? 43 : $identifier.hashCode());
   }

   @Override
   public String toString() {
      return "SimpleItemDefinition(identifier="
         + this.getIdentifier()
         + ", runtimeId="
         + this.getRuntimeId()
         + ", componentBased="
         + this.isComponentBased()
         + ")";
   }
}
