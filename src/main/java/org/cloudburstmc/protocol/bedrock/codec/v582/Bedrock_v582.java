package org.cloudburstmc.protocol.bedrock.codec.v582;

import org.cloudburstmc.protocol.bedrock.codec.BedrockCodec;
import org.cloudburstmc.protocol.bedrock.codec.v291.serializer.LevelEventSerializer_v291;
import org.cloudburstmc.protocol.bedrock.codec.v361.serializer.LevelEventGenericSerializer_v361;
import org.cloudburstmc.protocol.bedrock.codec.v448.serializer.AvailableCommandsSerializer_v448;
import org.cloudburstmc.protocol.bedrock.codec.v575.BedrockCodecHelper_v575;
import org.cloudburstmc.protocol.bedrock.codec.v575.Bedrock_v575;
import org.cloudburstmc.protocol.bedrock.codec.v582.serializer.CompressedBiomeDefinitionListSerializer_v582;
import org.cloudburstmc.protocol.bedrock.codec.v582.serializer.CraftingDataSerializer_v582;
import org.cloudburstmc.protocol.bedrock.codec.v582.serializer.OpenSignSerializer_v582;
import org.cloudburstmc.protocol.bedrock.codec.v582.serializer.RequestChunkRadiusSerializer_v582;
import org.cloudburstmc.protocol.bedrock.codec.v582.serializer.StartGameSerializer_v582;
import org.cloudburstmc.protocol.bedrock.codec.v582.serializer.TrimDataSerializer_v582;
import org.cloudburstmc.protocol.bedrock.data.LevelEvent;
import org.cloudburstmc.protocol.bedrock.data.LevelEventType;
import org.cloudburstmc.protocol.bedrock.data.PacketRecipient;
import org.cloudburstmc.protocol.bedrock.data.command.CommandParam;
import org.cloudburstmc.protocol.bedrock.data.inventory.ContainerSlotType;
import org.cloudburstmc.protocol.bedrock.packet.AvailableCommandsPacket;
import org.cloudburstmc.protocol.bedrock.packet.CompressedBiomeDefinitionListPacket;
import org.cloudburstmc.protocol.bedrock.packet.CraftingDataPacket;
import org.cloudburstmc.protocol.bedrock.packet.LevelEventGenericPacket;
import org.cloudburstmc.protocol.bedrock.packet.LevelEventPacket;
import org.cloudburstmc.protocol.bedrock.packet.OpenSignPacket;
import org.cloudburstmc.protocol.bedrock.packet.RequestChunkRadiusPacket;
import org.cloudburstmc.protocol.bedrock.packet.StartGamePacket;
import org.cloudburstmc.protocol.bedrock.packet.TrimDataPacket;
import org.cloudburstmc.protocol.common.util.TypeMap;

public class Bedrock_v582 extends Bedrock_v575 {
   protected static final TypeMap<ContainerSlotType> CONTAINER_SLOT_TYPES = Bedrock_v575.CONTAINER_SLOT_TYPES
      .toBuilder()
      .insert(61, ContainerSlotType.SMITHING_TABLE_TEMPLATE)
      .build();
   protected static final TypeMap<LevelEventType> LEVEL_EVENTS = Bedrock_v575.LEVEL_EVENTS
      .toBuilder()
      .insert(1067, LevelEvent.SOUND_AMETHYST_RESONATE)
      .insert(3603, LevelEvent.PARTICLE_BREAK_BLOCK_DOWN)
      .insert(3604, LevelEvent.PARTICLE_BREAK_BLOCK_UP)
      .insert(3605, LevelEvent.PARTICLE_BREAK_BLOCK_NORTH)
      .insert(3606, LevelEvent.PARTICLE_BREAK_BLOCK_SOUTH)
      .insert(3607, LevelEvent.PARTICLE_BREAK_BLOCK_WEST)
      .insert(3608, LevelEvent.PARTICLE_BREAK_BLOCK_EAST)
      .insert(3609, LevelEvent.ALL_PLAYERS_SLEEPING)
      .insert(16384, PARTICLE_TYPES)
      .remove(9800)
      .insert(9810, LevelEvent.JUMP_PREVENTED)
      .build();
   protected static final TypeMap<CommandParam> COMMAND_PARAMS = Bedrock_v575.COMMAND_PARAMS
      .toBuilder()
      .shift(32, 5)
      .insert(32, CommandParam.PERMISSION)
      .insert(33, CommandParam.PERMISSIONS)
      .insert(34, CommandParam.PERMISSION_SELECTOR)
      .insert(35, CommandParam.PERMISSION_ELEMENT)
      .insert(36, CommandParam.PERMISSION_ELEMENTS)
      .build();
   public static final BedrockCodec CODEC = Bedrock_v575.CODEC
      .toBuilder()
      .raknetProtocolVersion(11)
      .protocolVersion(582)
      .minecraftVersion("1.19.80")
      .helper(
         () -> new BedrockCodecHelper_v575(
            ENTITY_DATA, GAME_RULE_TYPES, ITEM_STACK_REQUEST_TYPES, CONTAINER_SLOT_TYPES, PLAYER_ABILITIES, TEXT_PROCESSING_ORIGINS
         )
      )
      .updateSerializer(StartGamePacket.class, new StartGameSerializer_v582())
      .updateSerializer(RequestChunkRadiusPacket.class, RequestChunkRadiusSerializer_v582.INSTANCE)
      .updateSerializer(CraftingDataPacket.class, new CraftingDataSerializer_v582())
      .updateSerializer(LevelEventPacket.class, new LevelEventSerializer_v291(LEVEL_EVENTS))
      .updateSerializer(LevelEventGenericPacket.class, new LevelEventGenericSerializer_v361(LEVEL_EVENTS))
      .updateSerializer(AvailableCommandsPacket.class, new AvailableCommandsSerializer_v448(COMMAND_PARAMS))
      .registerPacket(CompressedBiomeDefinitionListPacket::new, CompressedBiomeDefinitionListSerializer_v582.INSTANCE, 301, PacketRecipient.CLIENT)
      .registerPacket(TrimDataPacket::new, TrimDataSerializer_v582.INSTANCE, 302, PacketRecipient.CLIENT)
      .registerPacket(OpenSignPacket::new, OpenSignSerializer_v582.INSTANCE, 303, PacketRecipient.CLIENT)
      .build();
}
