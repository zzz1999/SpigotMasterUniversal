package com.nukkitx.protocol.bedrock.data.command;

import java.util.Arrays;

public class CommandOverloadData {
   private final boolean chaining;
   private final CommandParamData[] overloads;

   public CommandOverloadData(boolean chaining, CommandParamData[] overloads) {
      this.chaining = chaining;
      this.overloads = overloads;
   }

   public boolean isChaining() {
      return this.chaining;
   }

   public CommandParamData[] getOverloads() {
      return this.overloads;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CommandOverloadData)) {
         return false;
      } else {
         CommandOverloadData other = (CommandOverloadData)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            return this.isChaining() != other.isChaining() ? false : Arrays.deepEquals(this.getOverloads(), other.getOverloads());
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof CommandOverloadData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isChaining() ? 79 : 97);
      return result * 59 + Arrays.deepHashCode(this.getOverloads());
   }

   @Override
   public String toString() {
      return "CommandOverloadData(chaining=" + this.isChaining() + ", overloads=" + Arrays.deepToString(this.getOverloads()) + ")";
   }
}
