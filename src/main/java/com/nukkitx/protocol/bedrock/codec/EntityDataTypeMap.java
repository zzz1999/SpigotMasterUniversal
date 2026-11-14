package com.nukkitx.protocol.bedrock.codec;

import com.nukkitx.protocol.bedrock.data.entity.EntityDataFormat;
import com.nukkitx.protocol.bedrock.data.entity.EntityDataType;
import com.nukkitx.protocol.bedrock.transformer.EntityDataTransformer;
import com.nukkitx.protocol.common.util.Preconditions;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.function.Consumer;

public class EntityDataTypeMap {
   private static final EntityDataFormat[] FORMATS = EntityDataFormat.values();
   private final EntityDataTypeMap.Definition<?>[][][] idDefinitions;
   private final Map<EntityDataType<?>, EntityDataTypeMap.Definition<?>> typeDefinitionMap;

   public EntityDataTypeMap.Definition<?>[] fromId(int id, EntityDataFormat format) {
      if (id >= 0 && id < this.idDefinitions.length && format != null) {
         EntityDataTypeMap.Definition<?>[][] definitions = this.idDefinitions[id];
         int formatId = format.ordinal();
         if (definitions != null && formatId < definitions.length) {
            return definitions[formatId];
         }
      }

      return null;
   }

   public <T> EntityDataTypeMap.Definition<T> fromType(EntityDataType<T> type) {
      return (EntityDataTypeMap.Definition<T>)this.typeDefinitionMap.get(type);
   }

   public EntityDataTypeMap.Builder toBuilder() {
      EntityDataTypeMap.Builder builder = new EntityDataTypeMap.Builder(copy(this.idDefinitions));
      this.typeDefinitionMap.forEach((type, def) -> builder.typeDefinitionMap.put((EntityDataType<?>)type, def.copy()));
      return builder;
   }

   public static EntityDataTypeMap.Builder builder() {
      return new EntityDataTypeMap.Builder(new EntityDataTypeMap.Definition[64][][]);
   }

   public String prettyPrint() {
      TreeMap<Integer, EntityDataType<?>> map = new TreeMap<>();
      this.typeDefinitionMap.forEach((type, def) -> map.put(def.id, (EntityDataType<?>)type));
      StringJoiner joiner = new StringJoiner("\n");

      for (Entry<Integer, EntityDataType<?>> entry : map.entrySet()) {
         joiner.add(entry.getKey() + " => " + entry.getValue());
      }

      return joiner.toString();
   }

   private static int powerOfTwoCeiling(int value) {
      value = --value | value >> 1;
      value |= value >> 2;
      value |= value >> 4;
      value |= value >> 8;
      value |= value >> 16;
      return value + 1;
   }

   private static EntityDataTypeMap.Definition<?>[][][] copy(EntityDataTypeMap.Definition<?>[][][] array) {
      EntityDataTypeMap.Definition<?>[][][] copy = new EntityDataTypeMap.Definition[lastNonNullIndex(array) + 1][][];

      for (int i = 0; i < copy.length; i++) {
         if (array[i] != null) {
            copy[i] = new EntityDataTypeMap.Definition[FORMATS.length][];

            for (int i2 = 0; i2 < copy[i].length && i2 < array[i].length; i2++) {
               if (array[i][i2] != null) {
                  int length = array[i][i2].length;
                  copy[i][i2] = new EntityDataTypeMap.Definition[length];

                  for (int index = 0; index < copy[i][i2].length; index++) {
                     copy[i][i2][index] = array[i][i2][index].copy();
                  }
               }
            }
         }
      }

      return copy;
   }

   private static <T> int lastNonNullIndex(T[] array) {
      int index = array.length - 1;

      while (array[index] == null && index > 0) {
         index--;
      }

      return index;
   }

   private EntityDataTypeMap(EntityDataTypeMap.Definition<?>[][][] idDefinitions, Map<EntityDataType<?>, EntityDataTypeMap.Definition<?>> typeDefinitionMap) {
      this.idDefinitions = idDefinitions;
      this.typeDefinitionMap = typeDefinitionMap;
   }

   public static class Builder {
      private EntityDataTypeMap.Definition<?>[][][] types;
      private final Map<EntityDataType<?>, EntityDataTypeMap.Definition<?>> typeDefinitionMap = new IdentityHashMap<>();

      private void ensureIndex(int index) {
         this.ensureCapacity(index + 1);
      }

      private void ensureCapacity(int size) {
         if (size > this.types.length) {
            int newSize = EntityDataTypeMap.powerOfTwoCeiling(size + 1);
            EntityDataTypeMap.Definition<?>[][][] newTypes = new EntityDataTypeMap.Definition[newSize][][];
            System.arraycopy(this.types, 0, newTypes, 0, this.types.length);
            this.types = newTypes;
         }
      }

      public <T> EntityDataTypeMap.Builder replace(EntityDataType<T> type, int index, EntityDataFormat format) {
         return this.replace(type, index, format, EntityDataTransformer.identity());
      }

      public <T> EntityDataTypeMap.Builder replace(EntityDataType<T> type, int index, EntityDataFormat format, EntityDataTransformer<?, T> transformer) {
         Preconditions.checkArgument(index < this.types.length, "Index is out of bounds");
         Preconditions.checkArgument(this.types[index] != null, "No data types to replace at %s", index);
         this.iterateIndex(index, definition -> this.typeDefinitionMap.remove(definition.type));
         this.types[index] = null;
         return this.insert(type, index, format, transformer);
      }

      public <T> EntityDataTypeMap.Builder insert(EntityDataType<T> type, int index, EntityDataFormat format) {
         return this.insert(type, index, format, EntityDataTransformer.identity());
      }

      public <T> EntityDataTypeMap.Builder insert(EntityDataType<T> type, int index, EntityDataFormat format, EntityDataTransformer<?, T> transformer) {
         Preconditions.checkNotNull(type, "type");
         Preconditions.checkNotNull(transformer, "transformer");
         Preconditions.checkNotNull(format, "format");
         Preconditions.checkArgument(index >= 0, "index cannot be negative");
         Preconditions.checkArgument(!this.typeDefinitionMap.containsKey(type), "type already defined");
         this.ensureIndex(index + 1);
         if (this.types[index] == null) {
            this.types[index] = new EntityDataTypeMap.Definition[EntityDataTypeMap.FORMATS.length][];
         }

         EntityDataTypeMap.Definition<?>[][] formats = this.types[index];
         int formatId = format.ordinal();
         EntityDataTypeMap.Definition<?>[] definitions = formats[formatId];
         if (definitions == null) {
            definitions = formats[formatId] = new EntityDataTypeMap.Definition[1];
         } else {
            definitions = formats[formatId] = Arrays.copyOf(definitions, definitions.length + 1);
         }

         EntityDataTypeMap.Definition<?> definition = definitions[definitions.length - 1] = new EntityDataTypeMap.Definition(index, type, transformer, format);
         this.typeDefinitionMap.put(type, definition);
         return this;
      }

      public EntityDataTypeMap.Builder shift(int startIndex, int delta) {
         return this.shift(startIndex, delta, this.types.length - startIndex);
      }

      public EntityDataTypeMap.Builder shift(int startIndex, int delta, int length) {
         Preconditions.checkArgument(startIndex < this.types.length, "Start index is out of bounds (%s >= %s)", startIndex, this.types.length);
         int endIndex = startIndex + length;
         Preconditions.checkArgument(endIndex <= this.types.length, "Length exceeds array bounds");
         this.ensureCapacity(this.types.length + delta);
         System.arraycopy(this.types, startIndex, this.types, startIndex + delta, length);

         for (int i = 0; i < delta; i++) {
            this.types[startIndex + i] = null;
         }

         for (int i = 0; i < length; i++) {
            int index = startIndex + delta + i;
            EntityDataTypeMap.Definition<?>[][] formats = this.types[index];
            if (formats != null) {
               this.iterateIndex(index, definition -> {
                  definition.id = index;
                  EntityDataTypeMap.Definition<?> def = this.typeDefinitionMap.get(definition.type);
                  if (def != null) {
                     def.id = index;
                  }
               });
            }
         }

         return this;
      }

      public EntityDataTypeMap.Builder remove(int index) {
         Preconditions.checkElementIndex(index, this.types.length);
         Preconditions.checkArgument(this.types[index] != null, "Cannot remove null value");
         this.iterateIndex(index, definition -> this.typeDefinitionMap.remove(definition.type));
         this.types[index] = null;
         return this;
      }

      public <T> EntityDataTypeMap.Builder update(EntityDataType<T> type, EntityDataTransformer<?, T> transformer) {
         Preconditions.checkNotNull(type, "type");
         Preconditions.checkNotNull(transformer, "transformer");
         EntityDataTypeMap.Definition<T> definition = (EntityDataTypeMap.Definition<T>)this.typeDefinitionMap.get(type);
         Preconditions.checkArgument(definition != null, "type not defined");
         definition.transformer = transformer;
         this.iterateIndex(definition.getId(), def -> {
            if (def.getFormat() == definition.getFormat()) {
               ((EntityDataTypeMap.Definition<T>)def).transformer = transformer;
            }
         });
         return this;
      }

      private void iterateIndex(int index, Consumer<EntityDataTypeMap.Definition<?>> consumer) {
         EntityDataTypeMap.Definition<?>[][] formats = this.types[index];
         if (formats != null) {
            for (EntityDataTypeMap.Definition<?>[] format : formats) {
               if (format != null) {
                  for (EntityDataTypeMap.Definition<?> definition : format) {
                     if (definition != null) {
                        consumer.accept(definition);
                     }
                  }
               }
            }
         }
      }

      public EntityDataTypeMap build() {
         return new EntityDataTypeMap(EntityDataTypeMap.copy(this.types), this.typeDefinitionMap);
      }

      private Builder(EntityDataTypeMap.Definition<?>[][][] types) {
         this.types = types;
      }
   }

   public static class Definition<T> {
      int id;
      final EntityDataType<T> type;
      EntityDataTransformer<?, T> transformer;
      final EntityDataFormat format;

      private EntityDataTypeMap.Definition<T> copy() {
         return new EntityDataTypeMap.Definition<>(this.id, this.type, this.transformer, this.format);
      }

      public int getId() {
         return this.id;
      }

      public EntityDataType<T> getType() {
         return this.type;
      }

      public EntityDataTransformer<?, T> getTransformer() {
         return this.transformer;
      }

      public EntityDataFormat getFormat() {
         return this.format;
      }

      @Override
      public String toString() {
         return "EntityDataTypeMap.Definition(id="
            + this.getId()
            + ", type="
            + this.getType()
            + ", transformer="
            + this.getTransformer()
            + ", format="
            + this.getFormat()
            + ")";
      }

      private Definition(int id, EntityDataType<T> type, EntityDataTransformer<?, T> transformer, EntityDataFormat format) {
         this.id = id;
         this.type = type;
         this.transformer = transformer;
         this.format = format;
      }
   }
}
