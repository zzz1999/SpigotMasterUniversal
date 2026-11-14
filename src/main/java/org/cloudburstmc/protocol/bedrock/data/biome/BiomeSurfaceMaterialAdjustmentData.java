package org.cloudburstmc.protocol.bedrock.data.biome;

import java.util.List;

public final class BiomeSurfaceMaterialAdjustmentData {
   private final List<BiomeElementData> biomeElements;

   public BiomeSurfaceMaterialAdjustmentData(final List<BiomeElementData> biomeElements) {
      this.biomeElements = biomeElements;
   }

   public List<BiomeElementData> getBiomeElements() {
      return this.biomeElements;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeSurfaceMaterialAdjustmentData)) {
         return false;
      }

      BiomeSurfaceMaterialAdjustmentData other = (BiomeSurfaceMaterialAdjustmentData)o;
      Object this$biomeElements = this.getBiomeElements();
      Object other$biomeElements = other.getBiomeElements();
      return this$biomeElements == null ? other$biomeElements == null : this$biomeElements.equals(other$biomeElements);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $biomeElements = this.getBiomeElements();
      return result * 59 + ($biomeElements == null ? 43 : $biomeElements.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeSurfaceMaterialAdjustmentData(biomeElements=" + this.getBiomeElements() + ")";
   }
}
