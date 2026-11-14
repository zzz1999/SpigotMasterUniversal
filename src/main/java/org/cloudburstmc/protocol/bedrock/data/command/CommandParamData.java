package org.cloudburstmc.protocol.bedrock.data.command;

import java.util.EnumSet;
import java.util.Set;

public class CommandParamData {
   private String name;
   private boolean optional;
   private CommandEnumData enumData;
   private CommandParam type;
   private String postfix;
   private final Set<CommandParamOption> options = EnumSet.noneOf(CommandParamOption.class);

   public String getName() {
      return this.name;
   }

   public boolean isOptional() {
      return this.optional;
   }

   public CommandEnumData getEnumData() {
      return this.enumData;
   }

   public CommandParam getType() {
      return this.type;
   }

   public String getPostfix() {
      return this.postfix;
   }

   public Set<CommandParamOption> getOptions() {
      return this.options;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setOptional(final boolean optional) {
      this.optional = optional;
   }

   public void setEnumData(final CommandEnumData enumData) {
      this.enumData = enumData;
   }

   public void setType(final CommandParam type) {
      this.type = type;
   }

   public void setPostfix(final String postfix) {
      this.postfix = postfix;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CommandParamData)) {
         return false;
      }

      CommandParamData other = (CommandParamData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isOptional() != other.isOptional()) {
         return false;
      }

      Object this$name = this.getName();
      Object other$name = other.getName();
      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
         Object this$enumData = this.getEnumData();
         Object other$enumData = other.getEnumData();
         if (this$enumData == null ? other$enumData == null : this$enumData.equals(other$enumData)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$postfix = this.getPostfix();
               Object other$postfix = other.getPostfix();
               if (this$postfix == null ? other$postfix == null : this$postfix.equals(other$postfix)) {
                  Object this$options = this.getOptions();
                  Object other$options = other.getOptions();
                  return this$options == null ? other$options == null : this$options.equals(other$options);
               } else {
                  return false;
               }
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

   protected boolean canEqual(final Object other) {
      return other instanceof CommandParamData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isOptional() ? 79 : 97);
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $enumData = this.getEnumData();
      result = result * 59 + ($enumData == null ? 43 : $enumData.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $postfix = this.getPostfix();
      result = result * 59 + ($postfix == null ? 43 : $postfix.hashCode());
      Object $options = this.getOptions();
      return result * 59 + ($options == null ? 43 : $options.hashCode());
   }

   @Override
   public String toString() {
      return "CommandParamData(name="
         + this.getName()
         + ", optional="
         + this.isOptional()
         + ", enumData="
         + this.getEnumData()
         + ", type="
         + this.getType()
         + ", postfix="
         + this.getPostfix()
         + ", options="
         + this.getOptions()
         + ")";
   }
}
