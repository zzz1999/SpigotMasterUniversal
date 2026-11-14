package com.nukkitx.protocol.bedrock.transformer;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.bedrock.data.entity.EntityDataMap;
import com.nukkitx.protocol.common.util.TypeMap;

public final class TypeMapTransformer<T> implements EntityDataTransformer<Integer, T> {
   private final TypeMap<T> typeMap;

   public Integer serialize(BedrockCodecHelper helper, EntityDataMap map, T value) {
      return this.typeMap.getId(value);
   }

   public T deserialize(BedrockCodecHelper helper, EntityDataMap map, Integer value) {
      return this.typeMap.getType(value);
   }

   public TypeMapTransformer(TypeMap<T> typeMap) {
      this.typeMap = typeMap;
   }
}
