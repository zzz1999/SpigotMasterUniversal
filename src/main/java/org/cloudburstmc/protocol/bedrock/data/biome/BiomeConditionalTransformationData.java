package org.cloudburstmc.protocol.bedrock.data.biome;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.List;
import org.cloudburstmc.protocol.common.util.index.Indexable;
import org.cloudburstmc.protocol.common.util.index.Unindexed;

public final class BiomeConditionalTransformationData {
   private final List<BiomeWeightedData> weightedBiomes;
   private final transient Indexable<String> conditionJson;
   private final long minPassingNeighbors;

   @JsonCreator
   public BiomeConditionalTransformationData(List<BiomeWeightedData> weightedBiomes, String conditionJson, long minPassingNeighbors) {
      this.weightedBiomes = weightedBiomes;
      this.conditionJson = new Unindexed<>(conditionJson);
      this.minPassingNeighbors = minPassingNeighbors;
   }

   public String getConditionJson() {
      return this.conditionJson.get();
   }

   public List<BiomeWeightedData> getWeightedBiomes() {
      return this.weightedBiomes;
   }

   public long getMinPassingNeighbors() {
      return this.minPassingNeighbors;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeConditionalTransformationData)) {
         return false;
      }

      BiomeConditionalTransformationData other = (BiomeConditionalTransformationData)o;
      if (this.getMinPassingNeighbors() != other.getMinPassingNeighbors()) {
         return false;
      }

      Object this$weightedBiomes = this.getWeightedBiomes();
      Object other$weightedBiomes = other.getWeightedBiomes();
      return this$weightedBiomes == null ? other$weightedBiomes == null : this$weightedBiomes.equals(other$weightedBiomes);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $minPassingNeighbors = this.getMinPassingNeighbors();
      result = result * 59 + (int)($minPassingNeighbors >>> 32 ^ $minPassingNeighbors);
      Object $weightedBiomes = this.getWeightedBiomes();
      return result * 59 + ($weightedBiomes == null ? 43 : $weightedBiomes.hashCode());
   }

   @Override
   public String toString() {
      return "BiomeConditionalTransformationData(weightedBiomes="
         + this.getWeightedBiomes()
         + ", conditionJson="
         + this.getConditionJson()
         + ", minPassingNeighbors="
         + this.getMinPassingNeighbors()
         + ")";
   }

   @Deprecated
   public BiomeConditionalTransformationData(
      final List<BiomeWeightedData> weightedBiomes, final Indexable<String> conditionJson, final long minPassingNeighbors
   ) {
      this.weightedBiomes = weightedBiomes;
      this.conditionJson = conditionJson;
      this.minPassingNeighbors = minPassingNeighbors;
   }
}
