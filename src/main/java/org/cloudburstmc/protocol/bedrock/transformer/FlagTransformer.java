package org.cloudburstmc.protocol.bedrock.transformer;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.EnumMap;
import java.util.Map.Entry;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataMap;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityFlag;
import org.cloudburstmc.protocol.common.util.TypeMap;

public final class FlagTransformer implements EntityDataTransformer<Long, EnumMap<EntityFlag, Boolean>> {
   private static final InternalLogger log = InternalLoggerFactory.getInstance(FlagTransformer.class);
   private final TypeMap<EntityFlag> typeMap;
   private final int index;

   public Long serialize(BedrockCodecHelper helper, EntityDataMap map, EnumMap<EntityFlag, Boolean> flags) {
      long value = 0L;
      int lower = this.index * 64;
      int upper = lower + 64;
      boolean exists = false;

      for (Entry<EntityFlag, Boolean> entry : flags.entrySet()) {
         EntityFlag flag = entry.getKey();
         Boolean data = entry.getValue();
         if (data != null) {
            int flagIndex = this.typeMap.getId(flag);
            if (flagIndex >= lower && flagIndex < upper) {
               exists = true;
               if (data) {
                  value |= 1L << (flagIndex & 63);
               }
            }
         }
      }

      return exists ? value : null;
   }

   public EnumMap<EntityFlag, Boolean> deserialize(BedrockCodecHelper helper, EntityDataMap map, Long value) {
      EnumMap<EntityFlag, Boolean> flags = map.getOrCreateFlags();
      int lower = this.index * 64;
      int upper = lower + 64;

      for (int i = lower; i < upper; i++) {
         int idx = i & 63;
         EntityFlag flag = this.typeMap.getTypeUnsafe(i);
         boolean set = (value & 1L << idx) != 0L;
         if (flag == null) {
            if (set) {
               log.debug("Unknown entity flag set to true detected with index {}", i);
            }
         } else if (set) {
            flags.put(flag, true);
         } else {
            flags.put(flag, false);
         }
      }

      return flags;
   }

   public FlagTransformer(final TypeMap<EntityFlag> typeMap, final int index) {
      this.typeMap = typeMap;
      this.index = index;
   }
}
