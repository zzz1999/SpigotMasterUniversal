package org.cloudburstmc.protocol.bedrock.codec.v361;

import io.netty.buffer.ByteBuf;
import java.util.LinkedList;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.bedrock.codec.EntityDataTypeMap;
import org.cloudburstmc.protocol.bedrock.codec.v340.BedrockCodecHelper_v340;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataFormat;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataMap;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataType;
import org.cloudburstmc.protocol.bedrock.data.structure.StructureAnimationMode;
import org.cloudburstmc.protocol.bedrock.data.structure.StructureMirror;
import org.cloudburstmc.protocol.bedrock.data.structure.StructureRotation;
import org.cloudburstmc.protocol.bedrock.data.structure.StructureSettings;
import org.cloudburstmc.protocol.bedrock.transformer.EntityDataTransformer;
import org.cloudburstmc.protocol.common.util.Preconditions;
import org.cloudburstmc.protocol.common.util.TypeMap;
import org.cloudburstmc.protocol.common.util.VarInts;

public class BedrockCodecHelper_v361 extends BedrockCodecHelper_v340 {
   public BedrockCodecHelper_v361(EntityDataTypeMap entityData, TypeMap<Class<?>> gameRulesTypes) {
      super(entityData, gameRulesTypes);
   }

   @Override
   public void readEntityData(ByteBuf buffer, EntityDataMap entityDataMap) {
      Preconditions.checkNotNull(entityDataMap, "entityDataMap");
      int length = VarInts.readUnsignedInt(buffer);
      Preconditions.checkArgument(
         this.encodingSettings.maxListSize() <= 0 || length <= this.encodingSettings.maxListSize(), "Entity data size is too big: %s", length
      );

      for (int i = 0; i < length; i++) {
         int id = VarInts.readUnsignedInt(buffer);
         int formatId = VarInts.readUnsignedInt(buffer);
         EntityDataFormat format = EntityDataFormat.values()[formatId];
         Object value;
         switch (format) {
            case BYTE:
               value = buffer.readByte();
               break;
            case SHORT:
               value = buffer.readShortLE();
               break;
            case INT:
               value = VarInts.readInt(buffer);
               break;
            case FLOAT:
               value = buffer.readFloatLE();
               break;
            case STRING:
               value = this.readString(buffer);
               break;
            case NBT:
               value = this.readTag(buffer, Object.class);
               break;
            case VECTOR3I:
               value = this.readVector3i(buffer);
               break;
            case LONG:
               value = VarInts.readLong(buffer);
               break;
            case VECTOR3F:
               value = this.readVector3f(buffer);
               break;
            default:
               throw new IllegalArgumentException("Unknown entity data type received");
         }

         EntityDataTypeMap.Definition<?>[] definitions = this.entityData.fromId(id, format);
         if (definitions != null) {
            for (EntityDataTypeMap.Definition<?> definition : definitions) {
               EntityDataTransformer<Object, ?> transformer = (EntityDataTransformer<Object, ?>)definition.getTransformer();
               Object transformedValue = transformer.deserialize(this, entityDataMap, value);
               if (transformedValue != null) {
                  entityDataMap.put(definition.getType(), transformedValue);
               }
            }
         } else {
            log.debug("Unknown entity data: {} type {} value {}", id, format, value);
         }
      }
   }

   @Override
   public void writeEntityData(ByteBuf buffer, EntityDataMap entityDataMap) {
      Preconditions.checkNotNull(entityDataMap, "entityDataMap");
      List<Entry<EntityDataTypeMap.Definition<?>, Object>> serializedEntries = new LinkedList<>();

      for (Entry<EntityDataType<?>, Object> entry : entityDataMap.entrySet()) {
         EntityDataTypeMap.Definition<?> definition = this.entityData.fromType(entry.getKey());

         try {
            Object value = ((EntityDataTransformer<?, Object>)definition.getTransformer()).serialize(this, entityDataMap, entry.getValue());
            if (value != null) {
               serializedEntries.add(new SimpleEntry<>(definition, value));
            }
         } catch (Exception e) {
            throw new IllegalArgumentException("Failed to encode EntityData " + definition.getId() + " of " + definition.getType().getTypeName(), e);
         }
      }

      VarInts.writeUnsignedInt(buffer, serializedEntries.size());

      for (Entry<EntityDataTypeMap.Definition<?>, Object> entry : serializedEntries) {
         EntityDataTypeMap.Definition<?> definition = entry.getKey();
         Object value = entry.getValue();
         VarInts.writeUnsignedInt(buffer, definition.getId());
         VarInts.writeUnsignedInt(buffer, definition.getFormat().ordinal());
         switch (definition.getFormat()) {
            case BYTE:
               buffer.writeByte((Byte)value);
               break;
            case SHORT:
               buffer.writeShortLE((Short)value);
               break;
            case INT:
               VarInts.writeInt(buffer, (Integer)value);
               break;
            case FLOAT:
               buffer.writeFloatLE((Float)value);
               break;
            case STRING:
               this.writeString(buffer, (String)value);
               break;
            case NBT:
               this.writeTag(buffer, value);
               break;
            case VECTOR3I:
               this.writeVector3i(buffer, (Vector3i)value);
               break;
            case LONG:
               VarInts.writeLong(buffer, (Long)value);
               break;
            case VECTOR3F:
               this.writeVector3f(buffer, (Vector3f)value);
               break;
            default:
               throw new UnsupportedOperationException("Unknown entity data type " + definition.getFormat());
         }
      }
   }

   @Override
   public StructureSettings readStructureSettings(ByteBuf buffer) {
      String paletteName = this.readString(buffer);
      boolean ignoringEntities = buffer.readBoolean();
      boolean ignoringBlocks = buffer.readBoolean();
      Vector3i size = this.readBlockPosition(buffer);
      Vector3i offset = this.readBlockPosition(buffer);
      long lastEditedByEntityId = VarInts.readLong(buffer);
      StructureRotation rotation = StructureRotation.from(buffer.readByte());
      StructureMirror mirror = StructureMirror.from(buffer.readByte());
      float integrityValue = buffer.readFloatLE();
      int integritySeed = buffer.readIntLE();
      return new StructureSettings(
         paletteName,
         ignoringEntities,
         ignoringBlocks,
         true,
         size,
         offset,
         lastEditedByEntityId,
         rotation,
         mirror,
         StructureAnimationMode.NONE,
         0.0F,
         integrityValue,
         integritySeed,
         Vector3f.ZERO
      );
   }

   @Override
   public void writeStructureSettings(ByteBuf buffer, StructureSettings settings) {
      this.writeString(buffer, settings.getPaletteName());
      buffer.writeBoolean(settings.isIgnoringEntities());
      buffer.writeBoolean(settings.isIgnoringBlocks());
      this.writeBlockPosition(buffer, settings.getSize());
      this.writeBlockPosition(buffer, settings.getOffset());
      VarInts.writeLong(buffer, settings.getLastEditedByEntityId());
      buffer.writeByte(settings.getRotation().ordinal());
      buffer.writeByte(settings.getMirror().ordinal());
      buffer.writeFloatLE(settings.getIntegrityValue());
      buffer.writeIntLE(settings.getIntegritySeed());
   }
}
