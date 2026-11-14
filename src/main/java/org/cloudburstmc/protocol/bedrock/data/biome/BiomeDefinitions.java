package org.cloudburstmc.protocol.bedrock.data.biome;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Map;
import org.cloudburstmc.protocol.common.util.index.Indexable;

public final class BiomeDefinitions {
   private final transient Indexable<Map<String, BiomeDefinitionData>> definitions;

   @JsonCreator
   public BiomeDefinitions(Map<String, BiomeDefinitionData> definitions) {
      this.definitions = new UnindexedBiomes(definitions);
   }

   public Map<String, BiomeDefinitionData> getDefinitions() {
      return this.definitions.get();
   }

   @Override
   public boolean equals(final Object o) {
      return o == this ? true : o instanceof BiomeDefinitions;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "BiomeDefinitions(definitions=" + this.getDefinitions() + ")";
   }

   @Deprecated
   public BiomeDefinitions(final Indexable<Map<String, BiomeDefinitionData>> definitions) {
      this.definitions = definitions;
   }
}
