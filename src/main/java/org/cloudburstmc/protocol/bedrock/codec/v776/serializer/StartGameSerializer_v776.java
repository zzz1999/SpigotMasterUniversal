package org.cloudburstmc.protocol.bedrock.codec.v776.serializer;

import io.netty.buffer.ByteBuf;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.v685.serializer.StartGameSerializer_v685;
import org.cloudburstmc.protocol.bedrock.data.definitions.ItemDefinition;

public class StartGameSerializer_v776 extends StartGameSerializer_v685 {
   public static final StartGameSerializer_v776 INSTANCE = new StartGameSerializer_v776();

   @Override
   protected void writeItemDefinitions(ByteBuf buffer, BedrockCodecHelper helper, List<ItemDefinition> definitions) {
   }

   @Override
   protected void readItemDefinitions(ByteBuf buffer, BedrockCodecHelper helper, List<ItemDefinition> definitions) {
   }

   protected StartGameSerializer_v776() {
   }
}
