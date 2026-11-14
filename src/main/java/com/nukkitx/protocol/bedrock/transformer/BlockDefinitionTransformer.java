package com.nukkitx.protocol.bedrock.transformer;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.bedrock.data.definitions.BlockDefinition;
import com.nukkitx.protocol.bedrock.data.entity.EntityDataMap;
import com.nukkitx.protocol.common.util.DefinitionUtils;

public class BlockDefinitionTransformer implements EntityDataTransformer<Integer, BlockDefinition> {
   public Integer serialize(BedrockCodecHelper helper, EntityDataMap map, BlockDefinition value) {
      return helper.getBlockDefinitions() == null ? value.getRuntimeId() : DefinitionUtils.checkDefinition(helper.getBlockDefinitions(), value).getRuntimeId();
   }

   public BlockDefinition deserialize(BedrockCodecHelper helper, EntityDataMap map, Integer value) {
      return helper.getBlockDefinitions() == null ? null : helper.getBlockDefinitions().getDefinition(value);
   }
}
