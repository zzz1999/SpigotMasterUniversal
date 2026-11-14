package org.cloudburstmc.protocol.bedrock.data.definitions;

import java.util.TreeMap;
import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.protocol.common.NamedDefinition;

public class SimpleBlockDefinition implements BlockDefinition, NamedDefinition {
   private final String identifier;
   private final int runtimeId;
   private final NbtMap state;
   private transient String persistentIdentifier;

   public String getPersistentIdentifier() {
      if (this.persistentIdentifier == null) {
         StringBuilder builder = new StringBuilder(this.getIdentifier());
         if (!this.getState().isEmpty()) {
            TreeMap<String, String> properties = new TreeMap<>();
            NbtMap states = this.getState().getCompound("states");

            for (String stateName : states.keySet()) {
               String value = states.get(stateName).toString();
               properties.put(stateName, value);
            }

            properties.forEach((name, state) -> builder.append("|").append(name).append("=").append(state));
         }

         this.persistentIdentifier = builder.toString();
      }

      return this.persistentIdentifier;
   }

   public SimpleBlockDefinition(final String identifier, final int runtimeId, final NbtMap state) {
      this.identifier = identifier;
      this.runtimeId = runtimeId;
      this.state = state;
   }

   @Override
   public String getIdentifier() {
      return this.identifier;
   }

   @Override
   public int getRuntimeId() {
      return this.runtimeId;
   }

   public NbtMap getState() {
      return this.state;
   }

   public void setPersistentIdentifier(final String persistentIdentifier) {
      this.persistentIdentifier = persistentIdentifier;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SimpleBlockDefinition)) {
         return false;
      } else {
         SimpleBlockDefinition other = (SimpleBlockDefinition)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.getRuntimeId() != other.getRuntimeId()) {
            return false;
         } else {
            Object this$identifier = this.getIdentifier();
            Object other$identifier = other.getIdentifier();
            if (this$identifier == null ? other$identifier == null : this$identifier.equals(other$identifier)) {
               Object this$state = this.getState();
               Object other$state = other.getState();
               return this$state == null ? other$state == null : this$state.equals(other$state);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SimpleBlockDefinition;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getRuntimeId();
      Object $identifier = this.getIdentifier();
      result = result * 59 + ($identifier == null ? 43 : $identifier.hashCode());
      Object $state = this.getState();
      return result * 59 + ($state == null ? 43 : $state.hashCode());
   }

   @Override
   public String toString() {
      return "SimpleBlockDefinition(identifier="
         + this.getIdentifier()
         + ", runtimeId="
         + this.getRuntimeId()
         + ", state="
         + this.getState()
         + ", persistentIdentifier="
         + this.getPersistentIdentifier()
         + ")";
   }
}
