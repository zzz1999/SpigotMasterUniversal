package org.cloudburstmc.protocol.bedrock.data.biome;

import java.util.List;

public final class BiomeOverworldGenRulesData {
   private final List<BiomeWeightedData> hillsTransformations;
   private final List<BiomeWeightedData> mutateTransformations;
   private final List<BiomeWeightedData> riverTransformations;
   private final List<BiomeWeightedData> shoreTransformations;
   private final List<BiomeConditionalTransformationData> preHillsEdgeTransformations;
   private final List<BiomeConditionalTransformationData> postShoreTransformations;
   private final List<BiomeWeightedTemperatureData> climateTransformations;

   public BiomeOverworldGenRulesData(
      final List<BiomeWeightedData> hillsTransformations,
      final List<BiomeWeightedData> mutateTransformations,
      final List<BiomeWeightedData> riverTransformations,
      final List<BiomeWeightedData> shoreTransformations,
      final List<BiomeConditionalTransformationData> preHillsEdgeTransformations,
      final List<BiomeConditionalTransformationData> postShoreTransformations,
      final List<BiomeWeightedTemperatureData> climateTransformations
   ) {
      this.hillsTransformations = hillsTransformations;
      this.mutateTransformations = mutateTransformations;
      this.riverTransformations = riverTransformations;
      this.shoreTransformations = shoreTransformations;
      this.preHillsEdgeTransformations = preHillsEdgeTransformations;
      this.postShoreTransformations = postShoreTransformations;
      this.climateTransformations = climateTransformations;
   }

   public List<BiomeWeightedData> getHillsTransformations() {
      return this.hillsTransformations;
   }

   public List<BiomeWeightedData> getMutateTransformations() {
      return this.mutateTransformations;
   }

   public List<BiomeWeightedData> getRiverTransformations() {
      return this.riverTransformations;
   }

   public List<BiomeWeightedData> getShoreTransformations() {
      return this.shoreTransformations;
   }

   public List<BiomeConditionalTransformationData> getPreHillsEdgeTransformations() {
      return this.preHillsEdgeTransformations;
   }

   public List<BiomeConditionalTransformationData> getPostShoreTransformations() {
      return this.postShoreTransformations;
   }

   public List<BiomeWeightedTemperatureData> getClimateTransformations() {
      return this.climateTransformations;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeOverworldGenRulesData)) {
         return false;
      }

      BiomeOverworldGenRulesData other = (BiomeOverworldGenRulesData)o;
      Object this$hillsTransformations = this.getHillsTransformations();
      Object other$hillsTransformations = other.getHillsTransformations();
      if (this$hillsTransformations == null ? other$hillsTransformations == null : this$hillsTransformations.equals(other$hillsTransformations)) {
         Object this$mutateTransformations = this.getMutateTransformations();
         Object other$mutateTransformations = other.getMutateTransformations();
         if (this$mutateTransformations == null ? other$mutateTransformations == null : this$mutateTransformations.equals(other$mutateTransformations)) {
            Object this$riverTransformations = this.getRiverTransformations();
            Object other$riverTransformations = other.getRiverTransformations();
            if (this$riverTransformations == null ? other$riverTransformations == null : this$riverTransformations.equals(other$riverTransformations)) {
               Object this$shoreTransformations = this.getShoreTransformations();
               Object other$shoreTransformations = other.getShoreTransformations();
               if (this$shoreTransformations == null ? other$shoreTransformations == null : this$shoreTransformations.equals(other$shoreTransformations)) {
                  Object this$preHillsEdgeTransformations = this.getPreHillsEdgeTransformations();
                  Object other$preHillsEdgeTransformations = other.getPreHillsEdgeTransformations();
                  if (this$preHillsEdgeTransformations == null
                     ? other$preHillsEdgeTransformations == null
                     : this$preHillsEdgeTransformations.equals(other$preHillsEdgeTransformations)) {
                     Object this$postShoreTransformations = this.getPostShoreTransformations();
                     Object other$postShoreTransformations = other.getPostShoreTransformations();
                     if (this$postShoreTransformations == null
                        ? other$postShoreTransformations == null
                        : this$postShoreTransformations.equals(other$postShoreTransformations)) {
                        Object this$climateTransformations = this.getClimateTransformations();
                        Object other$climateTransformations = other.getClimateTransformations();
                        return this$climateTransformations == null
                           ? other$climateTransformations == null
                           : this$climateTransformations.equals(other$climateTransformations);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $hillsTransformations = this.getHillsTransformations();
      result = result * 59 + ($hillsTransformations == null ? 43 : $hillsTransformations.hashCode());
      Object $mutateTransformations = this.getMutateTransformations();
      result = result * 59 + ($mutateTransformations == null ? 43 : $mutateTransformations.hashCode());
      Object $riverTransformations = this.getRiverTransformations();
      result = result * 59 + ($riverTransformations == null ? 43 : $riverTransformations.hashCode());
      Object $shoreTransformations = this.getShoreTransformations();
      result = result * 59 + ($shoreTransformations == null ? 43 : $shoreTransformations.hashCode());
      Object $preHillsEdgeTransformations = this.getPreHillsEdgeTransformations();
      result = result * 59 + ($preHillsEdgeTransformations == null ? 43 : $preHillsEdgeTransformations.hashCode());
      Object $postShoreTransformations = this.getPostShoreTransformations();
      result = result * 59 + ($postShoreTransformations == null ? 43 : $postShoreTransformations.hashCode());
      Object $climateTransformations = this.getClimateTransformations();
      return result * 59 + ($climateTransformations == null ? 43 : $climateTransformations.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeOverworldGenRulesData(hillsTransformations="
         + this.getHillsTransformations()
         + ", mutateTransformations="
         + this.getMutateTransformations()
         + ", riverTransformations="
         + this.getRiverTransformations()
         + ", shoreTransformations="
         + this.getShoreTransformations()
         + ", preHillsEdgeTransformations="
         + this.getPreHillsEdgeTransformations()
         + ", postShoreTransformations="
         + this.getPostShoreTransformations()
         + ", climateTransformations="
         + this.getClimateTransformations()
         + ")";
   }
}
