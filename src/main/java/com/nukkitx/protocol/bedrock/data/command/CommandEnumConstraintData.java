package com.nukkitx.protocol.bedrock.data.command;

import java.util.Arrays;

public final class CommandEnumConstraintData {
   private final String option;
   private final CommandEnumData enumData;
   private final CommandEnumConstraintType[] constraints;

   public CommandEnumConstraintData(String option, CommandEnumData enumData, CommandEnumConstraintType[] constraints) {
      this.option = option;
      this.enumData = enumData;
      this.constraints = constraints;
   }

   public String getOption() {
      return this.option;
   }

   public CommandEnumData getEnumData() {
      return this.enumData;
   }

   public CommandEnumConstraintType[] getConstraints() {
      return this.constraints;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CommandEnumConstraintData)) {
         return false;
      } else {
         CommandEnumConstraintData other = (CommandEnumConstraintData)o;
         Object this$option = this.getOption();
         Object other$option = other.getOption();
         if (this$option == null ? other$option == null : this$option.equals(other$option)) {
            Object this$enumData = this.getEnumData();
            Object other$enumData = other.getEnumData();
            return (this$enumData == null ? other$enumData == null : this$enumData.equals(other$enumData))
               ? Arrays.deepEquals(this.getConstraints(), other.getConstraints())
               : false;
         } else {
            return false;
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $option = this.getOption();
      result = result * 59 + ($option == null ? 43 : $option.hashCode());
      Object $enumData = this.getEnumData();
      result = result * 59 + ($enumData == null ? 43 : $enumData.hashCode());
      return result * 59 + Arrays.deepHashCode(this.getConstraints());
   }

   @Override
   public String toString() {
      return "CommandEnumConstraintData(option="
         + this.getOption()
         + ", enumData="
         + this.getEnumData()
         + ", constraints="
         + Arrays.deepToString(this.getConstraints())
         + ")";
   }
}
