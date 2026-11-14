package org.cloudburstmc.protocol.bedrock.data.biome;

import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class BiomeDefinitionChunkGenData {
   private final @Nullable BiomeClimateData climate;
   private final @Nullable List<BiomeConsolidatedFeatureData> consolidatedFeatures;
   private final @Nullable BiomeMountainParamsData mountainParams;
   private final @Nullable BiomeSurfaceMaterialAdjustmentData surfaceMaterialAdjustment;
   private final @Nullable BiomeSurfaceMaterialData surfaceMaterial;
   private final boolean hasDefaultOverworldSurface;
   private final boolean hasSwampSurface;
   private final boolean hasFrozenOceanSurface;
   private final boolean hasTheEndSurface;
   private final @Nullable BiomeMesaSurfaceData mesaSurface;
   private final @Nullable BiomeCappedSurfaceData cappedSurface;
   private final @Nullable BiomeOverworldGenRulesData overworldGenRules;
   private final @Nullable BiomeMultinoiseGenRulesData multinoiseGenRules;
   private final @Nullable BiomeLegacyWorldGenRulesData legacyWorldGenRules;
   private final @Nullable BiomeReplacementData biomeReplacementData;

   public BiomeDefinitionChunkGenData(
      final @Nullable BiomeClimateData climate,
      final @Nullable List<BiomeConsolidatedFeatureData> consolidatedFeatures,
      final @Nullable BiomeMountainParamsData mountainParams,
      final @Nullable BiomeSurfaceMaterialAdjustmentData surfaceMaterialAdjustment,
      final @Nullable BiomeSurfaceMaterialData surfaceMaterial,
      final boolean hasDefaultOverworldSurface,
      final boolean hasSwampSurface,
      final boolean hasFrozenOceanSurface,
      final boolean hasTheEndSurface,
      final @Nullable BiomeMesaSurfaceData mesaSurface,
      final @Nullable BiomeCappedSurfaceData cappedSurface,
      final @Nullable BiomeOverworldGenRulesData overworldGenRules,
      final @Nullable BiomeMultinoiseGenRulesData multinoiseGenRules,
      final @Nullable BiomeLegacyWorldGenRulesData legacyWorldGenRules,
      final @Nullable BiomeReplacementData biomeReplacementData
   ) {
      this.climate = climate;
      this.consolidatedFeatures = consolidatedFeatures;
      this.mountainParams = mountainParams;
      this.surfaceMaterialAdjustment = surfaceMaterialAdjustment;
      this.surfaceMaterial = surfaceMaterial;
      this.hasDefaultOverworldSurface = hasDefaultOverworldSurface;
      this.hasSwampSurface = hasSwampSurface;
      this.hasFrozenOceanSurface = hasFrozenOceanSurface;
      this.hasTheEndSurface = hasTheEndSurface;
      this.mesaSurface = mesaSurface;
      this.cappedSurface = cappedSurface;
      this.overworldGenRules = overworldGenRules;
      this.multinoiseGenRules = multinoiseGenRules;
      this.legacyWorldGenRules = legacyWorldGenRules;
      this.biomeReplacementData = biomeReplacementData;
   }

   public @Nullable BiomeClimateData getClimate() {
      return this.climate;
   }

   public @Nullable List<BiomeConsolidatedFeatureData> getConsolidatedFeatures() {
      return this.consolidatedFeatures;
   }

   public @Nullable BiomeMountainParamsData getMountainParams() {
      return this.mountainParams;
   }

   public @Nullable BiomeSurfaceMaterialAdjustmentData getSurfaceMaterialAdjustment() {
      return this.surfaceMaterialAdjustment;
   }

   public @Nullable BiomeSurfaceMaterialData getSurfaceMaterial() {
      return this.surfaceMaterial;
   }

   public boolean isHasDefaultOverworldSurface() {
      return this.hasDefaultOverworldSurface;
   }

   public boolean isHasSwampSurface() {
      return this.hasSwampSurface;
   }

   public boolean isHasFrozenOceanSurface() {
      return this.hasFrozenOceanSurface;
   }

   public boolean isHasTheEndSurface() {
      return this.hasTheEndSurface;
   }

   public @Nullable BiomeMesaSurfaceData getMesaSurface() {
      return this.mesaSurface;
   }

   public @Nullable BiomeCappedSurfaceData getCappedSurface() {
      return this.cappedSurface;
   }

   public @Nullable BiomeOverworldGenRulesData getOverworldGenRules() {
      return this.overworldGenRules;
   }

   public @Nullable BiomeMultinoiseGenRulesData getMultinoiseGenRules() {
      return this.multinoiseGenRules;
   }

   public @Nullable BiomeLegacyWorldGenRulesData getLegacyWorldGenRules() {
      return this.legacyWorldGenRules;
   }

   public @Nullable BiomeReplacementData getBiomeReplacementData() {
      return this.biomeReplacementData;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeDefinitionChunkGenData)) {
         return false;
      }

      BiomeDefinitionChunkGenData other = (BiomeDefinitionChunkGenData)o;
      if (this.isHasDefaultOverworldSurface() != other.isHasDefaultOverworldSurface()) {
         return false;
      }

      if (this.isHasSwampSurface() != other.isHasSwampSurface()) {
         return false;
      }

      if (this.isHasFrozenOceanSurface() != other.isHasFrozenOceanSurface()) {
         return false;
      }

      if (this.isHasTheEndSurface() != other.isHasTheEndSurface()) {
         return false;
      }

      Object this$climate = this.getClimate();
      Object other$climate = other.getClimate();
      if (this$climate == null ? other$climate == null : this$climate.equals(other$climate)) {
         Object this$consolidatedFeatures = this.getConsolidatedFeatures();
         Object other$consolidatedFeatures = other.getConsolidatedFeatures();
         if (this$consolidatedFeatures == null ? other$consolidatedFeatures == null : this$consolidatedFeatures.equals(other$consolidatedFeatures)) {
            Object this$mountainParams = this.getMountainParams();
            Object other$mountainParams = other.getMountainParams();
            if (this$mountainParams == null ? other$mountainParams == null : this$mountainParams.equals(other$mountainParams)) {
               Object this$surfaceMaterialAdjustment = this.getSurfaceMaterialAdjustment();
               Object other$surfaceMaterialAdjustment = other.getSurfaceMaterialAdjustment();
               if (this$surfaceMaterialAdjustment == null
                  ? other$surfaceMaterialAdjustment == null
                  : this$surfaceMaterialAdjustment.equals(other$surfaceMaterialAdjustment)) {
                  Object this$surfaceMaterial = this.getSurfaceMaterial();
                  Object other$surfaceMaterial = other.getSurfaceMaterial();
                  if (this$surfaceMaterial == null ? other$surfaceMaterial == null : this$surfaceMaterial.equals(other$surfaceMaterial)) {
                     Object this$mesaSurface = this.getMesaSurface();
                     Object other$mesaSurface = other.getMesaSurface();
                     if (this$mesaSurface == null ? other$mesaSurface == null : this$mesaSurface.equals(other$mesaSurface)) {
                        Object this$cappedSurface = this.getCappedSurface();
                        Object other$cappedSurface = other.getCappedSurface();
                        if (this$cappedSurface == null ? other$cappedSurface == null : this$cappedSurface.equals(other$cappedSurface)) {
                           Object this$overworldGenRules = this.getOverworldGenRules();
                           Object other$overworldGenRules = other.getOverworldGenRules();
                           if (this$overworldGenRules == null ? other$overworldGenRules == null : this$overworldGenRules.equals(other$overworldGenRules)) {
                              Object this$multinoiseGenRules = this.getMultinoiseGenRules();
                              Object other$multinoiseGenRules = other.getMultinoiseGenRules();
                              if (this$multinoiseGenRules == null ? other$multinoiseGenRules == null : this$multinoiseGenRules.equals(other$multinoiseGenRules)
                                 )
                               {
                                 Object this$legacyWorldGenRules = this.getLegacyWorldGenRules();
                                 Object other$legacyWorldGenRules = other.getLegacyWorldGenRules();
                                 if (this$legacyWorldGenRules == null
                                    ? other$legacyWorldGenRules == null
                                    : this$legacyWorldGenRules.equals(other$legacyWorldGenRules)) {
                                    Object this$biomeReplacementData = this.getBiomeReplacementData();
                                    Object other$biomeReplacementData = other.getBiomeReplacementData();
                                    return this$biomeReplacementData == null
                                       ? other$biomeReplacementData == null
                                       : this$biomeReplacementData.equals(other$biomeReplacementData);
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
      result = result * 59 + (this.isHasDefaultOverworldSurface() ? 79 : 97);
      result = result * 59 + (this.isHasSwampSurface() ? 79 : 97);
      result = result * 59 + (this.isHasFrozenOceanSurface() ? 79 : 97);
      result = result * 59 + (this.isHasTheEndSurface() ? 79 : 97);
      Object $climate = this.getClimate();
      result = result * 59 + ($climate == null ? 43 : $climate.hashCode());
      Object $consolidatedFeatures = this.getConsolidatedFeatures();
      result = result * 59 + ($consolidatedFeatures == null ? 43 : $consolidatedFeatures.hashCode());
      Object $mountainParams = this.getMountainParams();
      result = result * 59 + ($mountainParams == null ? 43 : $mountainParams.hashCode());
      Object $surfaceMaterialAdjustment = this.getSurfaceMaterialAdjustment();
      result = result * 59 + ($surfaceMaterialAdjustment == null ? 43 : $surfaceMaterialAdjustment.hashCode());
      Object $surfaceMaterial = this.getSurfaceMaterial();
      result = result * 59 + ($surfaceMaterial == null ? 43 : $surfaceMaterial.hashCode());
      Object $mesaSurface = this.getMesaSurface();
      result = result * 59 + ($mesaSurface == null ? 43 : $mesaSurface.hashCode());
      Object $cappedSurface = this.getCappedSurface();
      result = result * 59 + ($cappedSurface == null ? 43 : $cappedSurface.hashCode());
      Object $overworldGenRules = this.getOverworldGenRules();
      result = result * 59 + ($overworldGenRules == null ? 43 : $overworldGenRules.hashCode());
      Object $multinoiseGenRules = this.getMultinoiseGenRules();
      result = result * 59 + ($multinoiseGenRules == null ? 43 : $multinoiseGenRules.hashCode());
      Object $legacyWorldGenRules = this.getLegacyWorldGenRules();
      result = result * 59 + ($legacyWorldGenRules == null ? 43 : $legacyWorldGenRules.hashCode());
      Object $biomeReplacementData = this.getBiomeReplacementData();
      return result * 59 + ($biomeReplacementData == null ? 43 : $biomeReplacementData.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeDefinitionChunkGenData(climate="
         + this.getClimate()
         + ", consolidatedFeatures="
         + this.getConsolidatedFeatures()
         + ", mountainParams="
         + this.getMountainParams()
         + ", surfaceMaterialAdjustment="
         + this.getSurfaceMaterialAdjustment()
         + ", surfaceMaterial="
         + this.getSurfaceMaterial()
         + ", hasDefaultOverworldSurface="
         + this.isHasDefaultOverworldSurface()
         + ", hasSwampSurface="
         + this.isHasSwampSurface()
         + ", hasFrozenOceanSurface="
         + this.isHasFrozenOceanSurface()
         + ", hasTheEndSurface="
         + this.isHasTheEndSurface()
         + ", mesaSurface="
         + this.getMesaSurface()
         + ", cappedSurface="
         + this.getCappedSurface()
         + ", overworldGenRules="
         + this.getOverworldGenRules()
         + ", multinoiseGenRules="
         + this.getMultinoiseGenRules()
         + ", legacyWorldGenRules="
         + this.getLegacyWorldGenRules()
         + ", biomeReplacementData="
         + this.getBiomeReplacementData()
         + ")";
   }
}
