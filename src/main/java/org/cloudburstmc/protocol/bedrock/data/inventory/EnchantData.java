package org.cloudburstmc.protocol.bedrock.data.inventory;

public final class EnchantData {
   private final int type;
   private final int level;

   public EnchantData(final int type, final int level) {
      this.type = type;
      this.level = level;
   }

   public int getType() {
      return this.type;
   }

   public int getLevel() {
      return this.level;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnchantData)) {
         return false;
      }

      EnchantData other = (EnchantData)o;
      return this.getType() != other.getType() ? false : this.getLevel() == other.getLevel();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getType();
      return result * 59 + this.getLevel();
   }

   @Override
   public String toString() {
      return "EnchantData(type=" + this.getType() + ", level=" + this.getLevel() + ")";
   }
}
