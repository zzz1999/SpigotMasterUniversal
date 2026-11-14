package org.cloudburstmc.protocol.bedrock.data.command;

import java.util.Map;
import java.util.Set;

public final class CommandEnumData {
   private final String name;
   private final Map<String, Set<CommandEnumConstraint>> values;
   private final boolean isSoft;

   public CommandEnumData(final String name, final Map<String, Set<CommandEnumConstraint>> values, final boolean isSoft) {
      this.name = name;
      this.values = values;
      this.isSoft = isSoft;
   }

   public String getName() {
      return this.name;
   }

   public Map<String, Set<CommandEnumConstraint>> getValues() {
      return this.values;
   }

   public boolean isSoft() {
      return this.isSoft;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CommandEnumData)) {
         return false;
      } else {
         CommandEnumData other = (CommandEnumData)o;
         if (this.isSoft() != other.isSoft()) {
            return false;
         } else {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$values = this.getValues();
               Object other$values = other.getValues();
               return this$values == null ? other$values == null : this$values.equals(other$values);
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
      result = result * 59 + (this.isSoft() ? 79 : 97);
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $values = this.getValues();
      return result * 59 + ($values == null ? 43 : $values.hashCode());
   }

   @Override
   public String toString() {
      return "CommandEnumData(name=" + this.getName() + ", values=" + this.getValues() + ", isSoft=" + this.isSoft() + ")";
   }
}
