package org.cloudburstmc.protocol.bedrock.data.command;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class ChainedSubCommandData {
   private final String name;
   private final List<ChainedSubCommandData.Value> values = new ObjectArrayList<>();

   public ChainedSubCommandData(final String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }

   public List<ChainedSubCommandData.Value> getValues() {
      return this.values;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ChainedSubCommandData)) {
         return false;
      } else {
         ChainedSubCommandData other = (ChainedSubCommandData)o;
         if (!other.canEqual(this)) {
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

   protected boolean canEqual(final Object other) {
      return other instanceof ChainedSubCommandData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $values = this.getValues();
      return result * 59 + ($values == null ? 43 : $values.hashCode());
   }

   @Override
   public String toString() {
      return "ChainedSubCommandData(name=" + this.getName() + ", values=" + this.getValues() + ")";
   }

   public static class Value {
      private final String first;
      private final String second;

      public Value(final String first, final String second) {
         this.first = first;
         this.second = second;
      }

      public String getFirst() {
         return this.first;
      }

      public String getSecond() {
         return this.second;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         } else if (!(o instanceof ChainedSubCommandData.Value)) {
            return false;
         } else {
            ChainedSubCommandData.Value other = (ChainedSubCommandData.Value)o;
            if (!other.canEqual(this)) {
               return false;
            } else {
               Object this$first = this.getFirst();
               Object other$first = other.getFirst();
               if (this$first == null ? other$first == null : this$first.equals(other$first)) {
                  Object this$second = this.getSecond();
                  Object other$second = other.getSecond();
                  return this$second == null ? other$second == null : this$second.equals(other$second);
               } else {
                  return false;
               }
            }
         }
      }

      protected boolean canEqual(final Object other) {
         return other instanceof ChainedSubCommandData.Value;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         Object $first = this.getFirst();
         result = result * 59 + ($first == null ? 43 : $first.hashCode());
         Object $second = this.getSecond();
         return result * 59 + ($second == null ? 43 : $second.hashCode());
      }

      @Override
      public String toString() {
         return "ChainedSubCommandData.Value(first=" + this.getFirst() + ", second=" + this.getSecond() + ")";
      }
   }
}
