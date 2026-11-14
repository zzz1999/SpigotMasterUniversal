package org.cloudburstmc.protocol.bedrock.data.biome;

import org.cloudburstmc.protocol.bedrock.data.definitions.BlockDefinition;

public final class BiomeMesaSurfaceData {
   private final BlockDefinition clayMaterial;
   private final BlockDefinition hardClayMaterial;
   private final boolean brycePillars;
   private final boolean hasForest;

   public BiomeMesaSurfaceData(final BlockDefinition clayMaterial, final BlockDefinition hardClayMaterial, final boolean brycePillars, final boolean hasForest) {
      this.clayMaterial = clayMaterial;
      this.hardClayMaterial = hardClayMaterial;
      this.brycePillars = brycePillars;
      this.hasForest = hasForest;
   }

   public BlockDefinition getClayMaterial() {
      return this.clayMaterial;
   }

   public BlockDefinition getHardClayMaterial() {
      return this.hardClayMaterial;
   }

   public boolean isBrycePillars() {
      return this.brycePillars;
   }

   public boolean isHasForest() {
      return this.hasForest;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BiomeMesaSurfaceData)) {
         return false;
      } else {
         BiomeMesaSurfaceData other = (BiomeMesaSurfaceData)o;
         if (this.isBrycePillars() != other.isBrycePillars()) {
            return false;
         } else if (this.isHasForest() != other.isHasForest()) {
            return false;
         } else {
            Object this$clayMaterial = this.getClayMaterial();
            Object other$clayMaterial = other.getClayMaterial();
            if (this$clayMaterial == null ? other$clayMaterial == null : this$clayMaterial.equals(other$clayMaterial)) {
               Object this$hardClayMaterial = this.getHardClayMaterial();
               Object other$hardClayMaterial = other.getHardClayMaterial();
               return this$hardClayMaterial == null ? other$hardClayMaterial == null : this$hardClayMaterial.equals(other$hardClayMaterial);
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
      result = result * 59 + (this.isBrycePillars() ? 79 : 97);
      result = result * 59 + (this.isHasForest() ? 79 : 97);
      Object $clayMaterial = this.getClayMaterial();
      result = result * 59 + ($clayMaterial == null ? 43 : $clayMaterial.hashCode());
      Object $hardClayMaterial = this.getHardClayMaterial();
      return result * 59 + ($hardClayMaterial == null ? 43 : $hardClayMaterial.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeMesaSurfaceData(clayMaterial="
         + this.getClayMaterial()
         + ", hardClayMaterial="
         + this.getHardClayMaterial()
         + ", brycePillars="
         + this.isBrycePillars()
         + ", hasForest="
         + this.isHasForest()
         + ")";
   }
}
