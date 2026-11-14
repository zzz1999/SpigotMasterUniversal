package com.nukkitx.protocol.bedrock.data.entity;

import com.nukkitx.nbt.NbtUtils;
import com.nukkitx.protocol.common.util.Preconditions;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class EntityDataMap implements Map<EntityDataType<?>, Object> {
   private final Map<EntityDataType<?>, Object> map = new LinkedHashMap<>();

   public @NonNull EnumSet<EntityFlag> getOrCreateFlags() {
      EnumSet<EntityFlag> flags = this.get(EntityDataTypes.FLAGS);
      if (flags == null) {
         flags = this.get(EntityDataTypes.FLAGS_2);
         if (flags == null) {
            flags = EnumSet.noneOf(EntityFlag.class);
         }

         this.putFlags(flags);
      }

      return flags;
   }

   public EnumSet<EntityFlag> getFlags() {
      return this.get(EntityDataTypes.FLAGS);
   }

   public EntityFlag setFlag(EntityFlag flag, boolean value) {
      Objects.requireNonNull(flag, "flag");
      EnumSet<EntityFlag> flags = this.getOrCreateFlags();
      if (value) {
         flags.add(flag);
      } else {
         flags.remove(flag);
      }

      return flag;
   }

   public EnumSet<EntityFlag> putFlags(EnumSet<EntityFlag> flags) {
      Objects.requireNonNull(flags, "flags");
      this.map.put(EntityDataTypes.FLAGS, flags);
      this.map.put(EntityDataTypes.FLAGS_2, flags);
      return flags;
   }

   public <T> T get(EntityDataType<T> type) {
      return (T)this.map.get(type);
   }

   private <T> @NonNull T getOrDefault(EntityDataType<T> type, T defaultValue) {
      Objects.requireNonNull(type, "type");
      Object object = this.map.getOrDefault(type, defaultValue);

      try {
         return (T)object;
      } catch (ClassCastException e) {
         return defaultValue;
      }
   }

   public <T> void putType(EntityDataType<T> type, T value) {
      this.put(type, value);
   }

   @Override
   public int size() {
      return this.map.size();
   }

   @Override
   public boolean isEmpty() {
      return this.map.isEmpty();
   }

   @Override
   public boolean containsKey(Object key) {
      return this.map.containsKey(key);
   }

   @Override
   public boolean containsValue(Object value) {
      return this.map.containsValue(value);
   }

   @Override
   public Object get(Object key) {
      return this.map.get(key);
   }

   public Object put(EntityDataType<?> key, Object value) {
      Preconditions.checkNotNull(key, "type");
      Preconditions.checkNotNull(value, "value was null for %s", key);
      Preconditions.checkArgument(key.isInstance(value), "value with type %s is not an instance of %s", value.getClass(), key);
      return key != EntityDataTypes.FLAGS && key != EntityDataTypes.FLAGS_2 ? this.map.put(key, value) : this.putFlags((EnumSet<EntityFlag>)value);
   }

   @Override
   public Object remove(Object key) {
      return this.map.remove(key);
   }

   @Override
   public void putAll(@NonNull Map<? extends EntityDataType<?>, ?> map) {
      Preconditions.checkNotNull(map, "map");
      this.map.putAll((Map<? extends EntityDataType<?>, ? extends Object>)map);
   }

   @Override
   public void clear() {
      this.map.clear();
   }

   @Override
   public @NonNull Set<EntityDataType<?>> keySet() {
      return this.map.keySet();
   }

   @Override
   public @NonNull Collection<Object> values() {
      return this.map.values();
   }

   @Override
   public @NonNull Set<Entry<EntityDataType<?>, Object>> entrySet() {
      return this.map.entrySet();
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         EntityDataMap that = (EntityDataMap)o;
         return this.map.equals(that.map);
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return this.map.hashCode();
   }

   @Override
   public String toString() {
      Iterator<Entry<EntityDataType<?>, Object>> i = this.map.entrySet().iterator();
      if (!i.hasNext()) {
         return "{}";
      }

      StringBuilder sb = new StringBuilder();
      sb.append('{');

      while (i.hasNext()) {
         Entry<EntityDataType<?>, Object> e = i.next();
         EntityDataType<?> key = e.getKey();
         if (key != EntityDataTypes.FLAGS_2) {
            String stringVal = NbtUtils.toString(e.getValue());
            sb.append(key.toString()).append('=').append(stringVal);
            if (!i.hasNext()) {
               return sb.append('}').toString();
            }

            sb.append(',').append(' ');
         }
      }

      return sb.toString();
   }
}
