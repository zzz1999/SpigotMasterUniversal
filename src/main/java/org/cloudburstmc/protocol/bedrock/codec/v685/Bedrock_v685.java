package org.cloudburstmc.protocol.bedrock.codec.v685;

import org.cloudburstmc.protocol.bedrock.codec.BedrockCodec;
import org.cloudburstmc.protocol.bedrock.codec.EntityDataTypeMap;
import org.cloudburstmc.protocol.bedrock.codec.v291.serializer.LevelEventSerializer_v291;
import org.cloudburstmc.protocol.bedrock.codec.v291.serializer.LevelSoundEvent1Serializer_v291;
import org.cloudburstmc.protocol.bedrock.codec.v313.serializer.LevelSoundEvent2Serializer_v313;
import org.cloudburstmc.protocol.bedrock.codec.v332.serializer.LevelSoundEventSerializer_v332;
import org.cloudburstmc.protocol.bedrock.codec.v361.serializer.LevelEventGenericSerializer_v361;
import org.cloudburstmc.protocol.bedrock.codec.v575.BedrockCodecHelper_v575;
import org.cloudburstmc.protocol.bedrock.codec.v594.serializer.AvailableCommandsSerializer_v594;
import org.cloudburstmc.protocol.bedrock.codec.v671.Bedrock_v671;
import org.cloudburstmc.protocol.bedrock.codec.v685.serializer.AwardAchievementSerializer_v685;
import org.cloudburstmc.protocol.bedrock.codec.v685.serializer.CodeBuilderSourceSerializer_v685;
import org.cloudburstmc.protocol.bedrock.codec.v685.serializer.ContainerCloseSerializer_v685;
import org.cloudburstmc.protocol.bedrock.codec.v685.serializer.CraftingDataSerializer_v685;
import org.cloudburstmc.protocol.bedrock.codec.v685.serializer.EventSerializer_v685;
import org.cloudburstmc.protocol.bedrock.codec.v685.serializer.StartGameSerializer_v685;
import org.cloudburstmc.protocol.bedrock.codec.v685.serializer.TextSerializer_v685;
import org.cloudburstmc.protocol.bedrock.data.LevelEvent;
import org.cloudburstmc.protocol.bedrock.data.LevelEventType;
import org.cloudburstmc.protocol.bedrock.data.PacketRecipient;
import org.cloudburstmc.protocol.bedrock.data.ParticleType;
import org.cloudburstmc.protocol.bedrock.data.SoundEvent;
import org.cloudburstmc.protocol.bedrock.data.command.CommandParam;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataFormat;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataTypes;
import org.cloudburstmc.protocol.bedrock.packet.AvailableCommandsPacket;
import org.cloudburstmc.protocol.bedrock.packet.AwardAchievementPacket;
import org.cloudburstmc.protocol.bedrock.packet.CodeBuilderSourcePacket;
import org.cloudburstmc.protocol.bedrock.packet.ContainerClosePacket;
import org.cloudburstmc.protocol.bedrock.packet.CraftingDataPacket;
import org.cloudburstmc.protocol.bedrock.packet.EventPacket;
import org.cloudburstmc.protocol.bedrock.packet.LevelEventGenericPacket;
import org.cloudburstmc.protocol.bedrock.packet.LevelEventPacket;
import org.cloudburstmc.protocol.bedrock.packet.LevelSoundEvent1Packet;
import org.cloudburstmc.protocol.bedrock.packet.LevelSoundEvent2Packet;
import org.cloudburstmc.protocol.bedrock.packet.LevelSoundEventPacket;
import org.cloudburstmc.protocol.bedrock.packet.StartGamePacket;
import org.cloudburstmc.protocol.bedrock.packet.TextPacket;
import org.cloudburstmc.protocol.bedrock.packet.TickSyncPacket;
import org.cloudburstmc.protocol.common.util.TypeMap;

public class Bedrock_v685 extends Bedrock_v671 {
   protected static final TypeMap<ParticleType> PARTICLE_TYPES = Bedrock_v671.PARTICLE_TYPES.toBuilder().insert(93, ParticleType.OMINOUS_ITEM_SPAWNER).build();
   protected static final TypeMap<SoundEvent> SOUND_EVENTS = Bedrock_v671.SOUND_EVENTS
      .toBuilder()
      .insert(516, SoundEvent.TRIAL_SPAWNER_CHARGE_ACTIVATE)
      .insert(517, SoundEvent.TRIAL_SPAWNER_AMBIENT_OMINOUS)
      .insert(518, SoundEvent.OMINOUS_ITEM_SPAWNER_SPAWN_ITEM)
      .insert(519, SoundEvent.OMINOUS_BOTTLE_END_USE)
      .replace(521, SoundEvent.OMINOUS_ITEM_SPAWNER_SPAWN_ITEM_BEGIN)
      .insert(523, SoundEvent.APPLY_EFFECT_BAD_OMEN)
      .insert(524, SoundEvent.APPLY_EFFECT_RAID_OMEN)
      .insert(525, SoundEvent.APPLY_EFFECT_TRIAL_OMEN)
      .insert(526, SoundEvent.OMINOUS_ITEM_SPAWNER_ABOUT_TO_SPAWN_ITEM)
      .insert(527, SoundEvent.RECORD_CREATOR)
      .insert(528, SoundEvent.RECORD_CREATOR_MUSIC_BOX)
      .insert(529, SoundEvent.RECORD_PRECIPICE)
      .insert(530, SoundEvent.UNDEFINED)
      .build();
   protected static final TypeMap<CommandParam> COMMAND_PARAMS = Bedrock_v671.COMMAND_PARAMS
      .toBuilder()
      .remove(134217728)
      .insert(88, CommandParam.CODE_BUILDER_ARG)
      .insert(89, CommandParam.CODE_BUILDER_ARGS)
      .insert(90, CommandParam.CODE_BUILDER_SELECT_PARAM)
      .insert(91, CommandParam.CODE_BUILDER_SELECTOR)
      .insert(134217728, CommandParam.CHAINED_COMMAND)
      .build();
   protected static final EntityDataTypeMap ENTITY_DATA = Bedrock_v671.ENTITY_DATA
      .toBuilder()
      .insert(EntityDataTypes.VISIBLE_MOB_EFFECTS, 131, EntityDataFormat.LONG)
      .build();
   protected static final TypeMap<LevelEventType> LEVEL_EVENTS = Bedrock_v671.LEVEL_EVENTS
      .toBuilder()
      .insert(16384, PARTICLE_TYPES)
      .replace(3615, LevelEvent.PARTICLE_TRIAL_SPAWNER_DETECTION_CHARGED)
      .insert(3616, LevelEvent.PARTICLE_TRIAL_SPAWNER_BECOME_CHARGED)
      .insert(3617, LevelEvent.ALL_PLAYERS_SLEEPING)
      .insert(9814, LevelEvent.ANIMATION_SPAWN_COBWEB)
      .insert(9815, LevelEvent.PARTICLE_SMASH_ATTACK_GROUND_DUST)
      .build();
   public static final BedrockCodec CODEC = Bedrock_v671.CODEC
      .toBuilder()
      .raknetProtocolVersion(11)
      .protocolVersion(685)
      .minecraftVersion("1.21.0")
      .helper(
         () -> new BedrockCodecHelper_v575(
            ENTITY_DATA, GAME_RULE_TYPES, ITEM_STACK_REQUEST_TYPES, CONTAINER_SLOT_TYPES, PLAYER_ABILITIES, TEXT_PROCESSING_ORIGINS
         )
      )
      .updateSerializer(LevelEventPacket.class, new LevelEventSerializer_v291(LEVEL_EVENTS))
      .updateSerializer(LevelEventGenericPacket.class, new LevelEventGenericSerializer_v361(LEVEL_EVENTS))
      .updateSerializer(AvailableCommandsPacket.class, new AvailableCommandsSerializer_v594(COMMAND_PARAMS))
      .updateSerializer(LevelSoundEvent1Packet.class, new LevelSoundEvent1Serializer_v291(SOUND_EVENTS))
      .updateSerializer(LevelSoundEvent2Packet.class, new LevelSoundEvent2Serializer_v313(SOUND_EVENTS))
      .updateSerializer(LevelSoundEventPacket.class, new LevelSoundEventSerializer_v332(SOUND_EVENTS))
      .updateSerializer(ContainerClosePacket.class, ContainerCloseSerializer_v685.INSTANCE)
      .updateSerializer(CraftingDataPacket.class, CraftingDataSerializer_v685.INSTANCE)
      .updateSerializer(CodeBuilderSourcePacket.class, CodeBuilderSourceSerializer_v685.INSTANCE)
      .updateSerializer(EventPacket.class, EventSerializer_v685.INSTANCE)
      .updateSerializer(StartGamePacket.class, StartGameSerializer_v685.INSTANCE)
      .updateSerializer(TextPacket.class, TextSerializer_v685.INSTANCE)
      .registerPacket(AwardAchievementPacket::new, AwardAchievementSerializer_v685.INSTANCE, 309, PacketRecipient.CLIENT)
      .deregisterPacket(TickSyncPacket.class)
      .build();
}
