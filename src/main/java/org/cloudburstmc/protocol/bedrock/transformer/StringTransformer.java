package org.cloudburstmc.protocol.bedrock.transformer;

import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataMap;

public class StringTransformer implements EntityDataTransformer<String, CharSequence> {
   public static final StringTransformer INSTANCE = new StringTransformer();

   public String serialize(BedrockCodecHelper helper, EntityDataMap map, CharSequence value) {
      return value instanceof String ? (String)value : helper.getTextConverter().serialize(value);
   }

   public CharSequence deserialize(BedrockCodecHelper helper, EntityDataMap map, String value) {
      return helper.getTextConverter().deserialize(value);
   }

   private StringTransformer() {
   }
}
