package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.inventory.crafting.ContainerMixData;
import org.cloudburstmc.protocol.bedrock.data.inventory.crafting.MaterialReducer;
import org.cloudburstmc.protocol.bedrock.data.inventory.crafting.PotionMixData;
import org.cloudburstmc.protocol.bedrock.data.inventory.crafting.recipe.RecipeData;
import org.cloudburstmc.protocol.common.PacketSignal;

public class CraftingDataPacket implements BedrockPacket {
   private final List<RecipeData> craftingData = new ObjectArrayList<>();
   private final List<PotionMixData> potionMixData = new ObjectArrayList<>();
   private final List<ContainerMixData> containerMixData = new ObjectArrayList<>();
   private final List<MaterialReducer> materialReducers = new ObjectArrayList<>();
   private boolean cleanRecipes;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CRAFTING_DATA;
   }

   public CraftingDataPacket clone() {
      try {
         return (CraftingDataPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<RecipeData> getCraftingData() {
      return this.craftingData;
   }

   public List<PotionMixData> getPotionMixData() {
      return this.potionMixData;
   }

   public List<ContainerMixData> getContainerMixData() {
      return this.containerMixData;
   }

   public List<MaterialReducer> getMaterialReducers() {
      return this.materialReducers;
   }

   public boolean isCleanRecipes() {
      return this.cleanRecipes;
   }

   public void setCleanRecipes(final boolean cleanRecipes) {
      this.cleanRecipes = cleanRecipes;
   }

   @Override
   public String toString() {
      return "CraftingDataPacket(craftingData="
         + this.craftingData
         + ", potionMixData="
         + this.potionMixData
         + ", containerMixData="
         + this.containerMixData
         + ", materialReducers="
         + this.materialReducers
         + ", cleanRecipes="
         + this.cleanRecipes
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CraftingDataPacket)) {
         return false;
      }

      CraftingDataPacket other = (CraftingDataPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.cleanRecipes != other.cleanRecipes) {
         return false;
      }

      Object this$craftingData = this.craftingData;
      Object other$craftingData = other.craftingData;
      if (this$craftingData == null ? other$craftingData == null : this$craftingData.equals(other$craftingData)) {
         Object this$potionMixData = this.potionMixData;
         Object other$potionMixData = other.potionMixData;
         if (this$potionMixData == null ? other$potionMixData == null : this$potionMixData.equals(other$potionMixData)) {
            Object this$containerMixData = this.containerMixData;
            Object other$containerMixData = other.containerMixData;
            if (this$containerMixData == null ? other$containerMixData == null : this$containerMixData.equals(other$containerMixData)) {
               Object this$materialReducers = this.materialReducers;
               Object other$materialReducers = other.materialReducers;
               return this$materialReducers == null ? other$materialReducers == null : this$materialReducers.equals(other$materialReducers);
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
      return other instanceof CraftingDataPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.cleanRecipes ? 79 : 97);
      Object $craftingData = this.craftingData;
      result = result * 59 + ($craftingData == null ? 43 : $craftingData.hashCode());
      Object $potionMixData = this.potionMixData;
      result = result * 59 + ($potionMixData == null ? 43 : $potionMixData.hashCode());
      Object $containerMixData = this.containerMixData;
      result = result * 59 + ($containerMixData == null ? 43 : $containerMixData.hashCode());
      Object $materialReducers = this.materialReducers;
      return result * 59 + ($materialReducers == null ? 43 : $materialReducers.hashCode());
   }
}
