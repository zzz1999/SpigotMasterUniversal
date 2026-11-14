package com.nukkitx.protocol.bedrock.data.entity;

import com.nukkitx.protocol.bedrock.data.inventory.ItemData;
import javax.annotation.Nonnull;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.nbt.NbtMap;

public enum EntityData {
   FLAGS(EntityData.Type.FLAGS, true),
   HEALTH(EntityData.Type.INT),
   VARIANT(EntityData.Type.INT),
   COLOR(EntityData.Type.BYTE),
   NAMETAG(EntityData.Type.STRING),
   OWNER_EID(EntityData.Type.LONG),
   TARGET_EID(EntityData.Type.LONG),
   AIR_SUPPLY(EntityData.Type.SHORT),
   EFFECT_COLOR(EntityData.Type.INT),
   EFFECT_AMBIENT(EntityData.Type.BYTE),
   JUMP_DURATION(EntityData.Type.BYTE),
   HURT_TIME(EntityData.Type.INT),
   HURT_DIRECTION(EntityData.Type.INT),
   ROW_TIME_LEFT(EntityData.Type.FLOAT),
   ROW_TIME_RIGHT(EntityData.Type.FLOAT),
   EXPERIENCE_VALUE(EntityData.Type.INT),
   DISPLAY_ITEM(EntityData.Type.INT),
   DISPLAY_OFFSET(null),
   CUSTOM_DISPLAY(EntityData.Type.BYTE),
   @Deprecated
   SWELL(EntityData.Type.INT),
   @Deprecated
   OLD_SWELL(EntityData.Type.INT),
   @Deprecated
   SWELL_DIRECTION(EntityData.Type.INT),
   CHARGE_AMOUNT(EntityData.Type.BYTE),
   CARRIED_BLOCK(EntityData.Type.INT),
   CLIENT_EVENT(EntityData.Type.BYTE),
   USING_ITEM(EntityData.Type.BYTE),
   PLAYER_FLAGS(EntityData.Type.BYTE),
   PLAYER_INDEX(EntityData.Type.INT),
   BED_POSITION(EntityData.Type.VECTOR3I),
   X_POWER(EntityData.Type.FLOAT),
   Y_POWER(EntityData.Type.FLOAT),
   Z_POWER(EntityData.Type.FLOAT),
   AUX_POWER(null),
   FISH_X(null),
   FISH_Z(null),
   FISH_ANGLE(null),
   POTION_AUX_VALUE(EntityData.Type.SHORT),
   LEASH_HOLDER_EID(EntityData.Type.LONG),
   SCALE(EntityData.Type.FLOAT),
   HAS_NPC_COMPONENT(EntityData.Type.BYTE),
   SKIN_ID(EntityData.Type.INT),
   NPC_SKIN_ID(EntityData.Type.STRING),
   NPC_DATA(null),
   URL_TAG(EntityData.Type.STRING),
   MAX_AIR_SUPPLY(EntityData.Type.SHORT),
   MARK_VARIANT(EntityData.Type.INT),
   CONTAINER_TYPE(EntityData.Type.BYTE),
   CONTAINER_BASE_SIZE(EntityData.Type.INT),
   CONTAINER_STRENGTH_MODIFIER(EntityData.Type.INT),
   BLOCK_TARGET(EntityData.Type.VECTOR3I),
   WITHER_INVULNERABLE_TICKS(EntityData.Type.INT),
   WITHER_TARGET_1(EntityData.Type.LONG),
   WITHER_TARGET_2(EntityData.Type.LONG),
   WITHER_TARGET_3(EntityData.Type.LONG),
   WITHER_AERIAL_ATTACK(EntityData.Type.SHORT),
   BOUNDING_BOX_WIDTH(EntityData.Type.FLOAT),
   BOUNDING_BOX_HEIGHT(EntityData.Type.FLOAT),
   FUSE_LENGTH(EntityData.Type.INT),
   RIDER_SEAT_POSITION(EntityData.Type.VECTOR3F),
   RIDER_ROTATION_LOCKED(EntityData.Type.BYTE),
   RIDER_MAX_ROTATION(EntityData.Type.FLOAT),
   RIDER_MIN_ROTATION(EntityData.Type.BYTE),
   RIDER_ROTATION_OFFSET(EntityData.Type.FLOAT),
   AREA_EFFECT_CLOUD_RADIUS(EntityData.Type.FLOAT),
   AREA_EFFECT_CLOUD_WAITING(EntityData.Type.INT),
   AREA_EFFECT_CLOUD_PARTICLE_ID(EntityData.Type.INT),
   SHULKER_PEAK_HEIGHT(EntityData.Type.INT),
   SHULKER_PEEK_ID(null),
   SHULKER_ATTACH_FACE(EntityData.Type.BYTE),
   SHULKER_ATTACH_POS(EntityData.Type.VECTOR3I),
   TRADE_TARGET_EID(EntityData.Type.LONG),
   COMMAND_BLOCK_ENABLED(EntityData.Type.BYTE),
   COMMAND_BLOCK_COMMAND(EntityData.Type.STRING),
   COMMAND_BLOCK_LAST_OUTPUT(EntityData.Type.STRING),
   COMMAND_BLOCK_TRACK_OUTPUT(EntityData.Type.BYTE),
   CONTROLLING_RIDER_SEAT_INDEX(EntityData.Type.BYTE),
   STRENGTH(EntityData.Type.INT),
   MAX_STRENGTH(EntityData.Type.INT),
   EVOKER_SPELL_COLOR(EntityData.Type.INT),
   LIMITED_LIFE(EntityData.Type.INT),
   ARMOR_STAND_POSE_INDEX(EntityData.Type.INT),
   ENDER_CRYSTAL_TIME_OFFSET(EntityData.Type.INT),
   NAMETAG_ALWAYS_SHOW(EntityData.Type.BYTE),
   COLOR_2(EntityData.Type.BYTE),
   SCORE_TAG(EntityData.Type.STRING),
   BALLOON_ATTACHED_ENTITY(EntityData.Type.LONG),
   PUFFERFISH_SIZE(EntityData.Type.BYTE),
   BOAT_BUBBLE_TIME(EntityData.Type.INT),
   AGENT_ID(EntityData.Type.LONG),
   SITTING_AMOUNT(null),
   SITTING_AMOUNT_PREVIOUS(null),
   EATING_COUNTER(EntityData.Type.INT),
   FLAGS_2(EntityData.Type.FLAGS, true),
   LAYING_AMOUNT(null),
   LAYING_AMOUNT_PREVIOUS(null),
   AREA_EFFECT_CLOUD_DURATION(EntityData.Type.INT),
   AREA_EFFECT_CLOUD_SPAWN_TIME(EntityData.Type.INT),
   AREA_EFFECT_CLOUD_CHANGE_RATE(EntityData.Type.FLOAT),
   AREA_EFFECT_CLOUD_CHANGE_ON_PICKUP(EntityData.Type.FLOAT),
   AREA_EFFECT_CLOUD_COUNT(EntityData.Type.INT),
   INTERACTIVE_TAG(EntityData.Type.STRING),
   TRADE_TIER(EntityData.Type.INT),
   MAX_TRADE_TIER(EntityData.Type.INT),
   TRADE_XP(EntityData.Type.INT),
   SPAWNING_FRAMES(null),
   COMMAND_BLOCK_TICK_DELAY(EntityData.Type.INT),
   COMMAND_BLOCK_EXECUTE_ON_FIRST_TICK(EntityData.Type.BYTE),
   AMBIENT_SOUND_INTERVAL(EntityData.Type.FLOAT),
   AMBIENT_SOUND_INTERVAL_RANGE(EntityData.Type.FLOAT),
   AMBIENT_SOUND_EVENT_NAME(EntityData.Type.STRING),
   FALL_DAMAGE_MULTIPLIER(EntityData.Type.FLOAT),
   NAME_RAW_TEXT(null),
   CAN_RIDE_TARGET(EntityData.Type.BYTE),
   LOW_TIER_CURED_TRADE_DISCOUNT(EntityData.Type.INT),
   HIGH_TIER_CURED_TRADE_DISCOUNT(EntityData.Type.INT),
   NEARBY_CURED_TRADE_DISCOUNT(EntityData.Type.INT),
   NEARBY_CURED_DISCOUNT_TIME_STAMP(EntityData.Type.INT),
   HITBOX(EntityData.Type.NBT),
   IS_BUOYANT(EntityData.Type.BYTE),
   BUOYANCY_DATA(EntityData.Type.STRING),
   FREEZING_EFFECT_STRENGTH(null),
   GOAT_HORN_COUNT(null),
   BASE_RUNTIME_ID(null),
   /** @deprecated */
   DEFINE_PROPERTIES(null),
   UPDATE_PROPERTIES(null),
   MOVEMENT_SOUND_DISTANCE_OFFSET(null),
   HEARTBEAT_INTERVAL_TICKS(EntityData.Type.INT),
   HEARTBEAT_SOUND_EVENT(EntityData.Type.INT);

   private final EntityData.Type type;
   private final boolean flags;

   EntityData(EntityData.Type type) {
      this.type = type;
      this.flags = false;
   }

   public EntityData.Type getType() {
      return this.type;
   }

   public boolean isFlags() {
      return this.flags;
   }

   EntityData(EntityData.Type type, boolean flags) {
      this.type = type;
      this.flags = flags;
   }

   public enum Type {
      FLAGS,
      BYTE,
      SHORT,
      INT,
      FLOAT,
      STRING,
      NBT,
      VECTOR3I,
      LONG,
      VECTOR3F;

      @Nonnull
      public static EntityData.Type from(Object o) {
         if (o instanceof EntityFlags) {
            return FLAGS;
         } else if (o instanceof Byte) {
            return BYTE;
         } else if (o instanceof Short) {
            return SHORT;
         } else if (o instanceof Integer) {
            return INT;
         } else if (o instanceof Float) {
            return FLOAT;
         } else if (o instanceof String) {
            return STRING;
         } else if (o instanceof ItemData || o instanceof NbtMap) {
            return NBT;
         } else if (o instanceof Vector3i) {
            return VECTOR3I;
         } else if (o instanceof Long) {
            return LONG;
         } else if (o instanceof Vector3f) {
            return VECTOR3F;
         } else {
            throw new IllegalArgumentException("Invalid type");
         }
      }
   }
}
