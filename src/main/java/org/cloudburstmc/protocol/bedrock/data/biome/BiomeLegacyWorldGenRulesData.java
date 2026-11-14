package org.cloudburstmc.protocol.bedrock.data.biome;

import java.util.List;

public final class BiomeLegacyWorldGenRulesData {
   private final List<BiomeConditionalTransformationData> legacyPreHills;

   public BiomeLegacyWorldGenRulesData(final List<BiomeConditionalTransformationData> legacyPreHills) {
      this.legacyPreHills = legacyPreHills;
   }

   public List<BiomeConditionalTransformationData> getLegacyPreHills() {
      return this.legacyPreHills;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeLegacyWorldGenRulesData)) {
         return false;
      }

      BiomeLegacyWorldGenRulesData other = (BiomeLegacyWorldGenRulesData)o;
      Object this$legacyPreHills = this.getLegacyPreHills();
      Object other$legacyPreHills = other.getLegacyPreHills();
      return this$legacyPreHills == null ? other$legacyPreHills == null : this$legacyPreHills.equals(other$legacyPreHills);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $legacyPreHills = this.getLegacyPreHills();
      return result * 59 + ($legacyPreHills == null ? 43 : $legacyPreHills.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeLegacyWorldGenRulesData(legacyPreHills=" + this.getLegacyPreHills() + ")";
   }
}
