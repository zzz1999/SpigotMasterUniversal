package org.cloudburstmc.protocol.bedrock.data.biome;

import it.unimi.dsi.fastutil.ints.IntObjectPair;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.cloudburstmc.protocol.common.util.index.Indexable;

public final class IndexedBiomes implements Indexable<Map<String, BiomeDefinitionData>> {
   private final List<IntObjectPair<BiomeDefinitionData>> biomes;
   private final List<String> values;
   private Map<String, BiomeDefinitionData> cached;

   public IndexedBiomes(List<IntObjectPair<BiomeDefinitionData>> biomes, List<String> values) {
      this.biomes = biomes;
      this.values = values;
   }

   public Map<String, BiomeDefinitionData> get() {
      if (this.cached != null) {
         return this.cached;
      }

      Map<String, BiomeDefinitionData> map = new LinkedHashMap<>();

      for (IntObjectPair<BiomeDefinitionData> pair : this.biomes) {
         map.put(this.values.get(pair.firstInt()), pair.second());
      }

      return this.cached = map;
   }
}
