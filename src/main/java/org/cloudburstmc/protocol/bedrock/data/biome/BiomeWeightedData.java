package org.cloudburstmc.protocol.bedrock.data.biome;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.cloudburstmc.protocol.common.util.index.Indexable;
import org.cloudburstmc.protocol.common.util.index.Unindexed;

public final class BiomeWeightedData {
   private final transient Indexable<String> biome;
   private final int weight;

   @JsonCreator
   public BiomeWeightedData(String biome, int weight) {
      this.biome = new Unindexed<>(biome);
      this.weight = weight;
   }

   public String getBiome() {
      return this.biome.get();
   }

   public int getWeight() {
      return this.weight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiomeWeightedData)) {
         return false;
      }

      BiomeWeightedData other = (BiomeWeightedData)o;
      return this.getWeight() == other.getWeight();
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + this.getWeight();
   }

   @Override
   public String toString() {
      return "BiomeWeightedData(biome=" + this.getBiome() + ", weight=" + this.getWeight() + ")";
   }

   @Deprecated
   public BiomeWeightedData(final Indexable<String> biome, final int weight) {
      this.biome = biome;
      this.weight = weight;
   }
}
