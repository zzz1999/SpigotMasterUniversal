package org.cloudburstmc.protocol.bedrock.data.inventory.crafting;

public final class RecipeIngredient {
   public static final RecipeIngredient EMPTY = new RecipeIngredient(0, 0, 0);
   private final int id;
   private final int auxValue;
   private final int stackSize;

   public static RecipeIngredient of(int id, int auxValue, int stackSize) {
      return id == 0 ? EMPTY : new RecipeIngredient(id, auxValue, stackSize);
   }

   public int getId() {
      return this.id;
   }

   public int getAuxValue() {
      return this.auxValue;
   }

   public int getStackSize() {
      return this.stackSize;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof RecipeIngredient)) {
         return false;
      } else {
         RecipeIngredient other = (RecipeIngredient)o;
         if (this.getId() != other.getId()) {
            return false;
         } else {
            return this.getAuxValue() != other.getAuxValue() ? false : this.getStackSize() == other.getStackSize();
         }
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getId();
      result = result * 59 + this.getAuxValue();
      return result * 59 + this.getStackSize();
   }

   @Override
   public String toString() {
      return "RecipeIngredient(id=" + this.getId() + ", auxValue=" + this.getAuxValue() + ", stackSize=" + this.getStackSize() + ")";
   }

   private RecipeIngredient(final int id, final int auxValue, final int stackSize) {
      this.id = id;
      this.auxValue = auxValue;
      this.stackSize = stackSize;
   }
}
