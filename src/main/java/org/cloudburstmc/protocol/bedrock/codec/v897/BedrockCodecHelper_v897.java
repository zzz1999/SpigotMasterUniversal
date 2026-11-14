package org.cloudburstmc.protocol.bedrock.codec.v897;

import io.netty.buffer.ByteBuf;
import java.util.UUID;
import org.cloudburstmc.protocol.bedrock.codec.EntityDataTypeMap;
import org.cloudburstmc.protocol.bedrock.codec.v844.BedrockCodecHelper_v844;
import org.cloudburstmc.protocol.bedrock.data.Ability;
import org.cloudburstmc.protocol.bedrock.data.command.CommandOriginData;
import org.cloudburstmc.protocol.bedrock.data.command.CommandOriginType;
import org.cloudburstmc.protocol.bedrock.data.inventory.ContainerSlotType;
import org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.TextProcessingEventOrigin;
import org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.action.ItemStackRequestActionType;
import org.cloudburstmc.protocol.common.util.Preconditions;
import org.cloudburstmc.protocol.common.util.TypeMap;

public class BedrockCodecHelper_v897 extends BedrockCodecHelper_v844 {
   public BedrockCodecHelper_v897(
      EntityDataTypeMap entityData,
      TypeMap<Class<?>> gameRulesTypes,
      TypeMap<ItemStackRequestActionType> stackRequestActionTypes,
      TypeMap<ContainerSlotType> containerSlotTypes,
      TypeMap<Ability> abilities,
      TypeMap<TextProcessingEventOrigin> textProcessingEventOrigins
   ) {
      super(entityData, gameRulesTypes, stackRequestActionTypes, containerSlotTypes, abilities, textProcessingEventOrigins);
   }

   @Override
   public CommandOriginData readCommandOrigin(ByteBuf buffer) {
      this.readString(buffer);
      CommandOriginType origin = CommandOriginType.PLAYER;
      UUID uuid = this.readUuid(buffer);
      String requestId = this.readString(buffer);
      long playerId = buffer.readLongLE();
      return new CommandOriginData(origin, uuid, requestId, playerId);
   }

   @Override
   public void writeCommandOrigin(ByteBuf buffer, CommandOriginData originData) {
      Preconditions.checkNotNull(originData, "commandOriginData");
      this.writeString(buffer, "player");
      this.writeUuid(buffer, originData.getUuid());
      this.writeString(buffer, originData.getRequestId());
      buffer.writeLongLE(originData.getPlayerId());
   }
}
