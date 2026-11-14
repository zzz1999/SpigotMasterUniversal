package org.cloudburstmc.protocol.bedrock.transformer;

import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataMap;
import org.cloudburstmc.protocol.common.util.TypeMap;

public final class TypeMapTransformer<T> implements EntityDataTransformer<Integer, T> {
   private final TypeMap<T> typeMap;

   public Integer serialize(BedrockCodecHelper helper, EntityDataMap map, T value) {
      return this.typeMap.getId(value);
   }

   public T deserialize(BedrockCodecHelper helper, EntityDataMap map, Integer value) {
      return this.typeMap.getType(value);
   }

   public TypeMapTransformer(final TypeMap<T> typeMap) {
      this.typeMap = typeMap;
   }
}
