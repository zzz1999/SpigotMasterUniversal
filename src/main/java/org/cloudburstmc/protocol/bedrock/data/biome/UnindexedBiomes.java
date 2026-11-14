package org.cloudburstmc.protocol.bedrock.data.biome;

import java.util.Map;
import org.cloudburstmc.protocol.common.util.index.Indexable;

final class UnindexedBiomes implements Indexable<Map<String, BiomeDefinitionData>> {
   private final Map<String, BiomeDefinitionData> biomes;

   UnindexedBiomes(Map<String, BiomeDefinitionData> biomes) {
      this.biomes = biomes;
   }

   public Map<String, BiomeDefinitionData> get() {
      return this.biomes;
   }
}
