package org.cloudburstmc.nbt;

import java.util.HashMap;
import java.util.Map;

public final class NbtType<T> {
   public static final NbtType<Void> END = new NbtType<>(Void.class, NbtType.Enum.END);
   public static final NbtType<Byte> BYTE = new NbtType<>(Byte.class, NbtType.Enum.BYTE);
   public static final NbtType<Short> SHORT = new NbtType<>(Short.class, NbtType.Enum.SHORT);
   public static final NbtType<Integer> INT = new NbtType<>(Integer.class, NbtType.Enum.INT);
   public static final NbtType<Long> LONG = new NbtType<>(Long.class, NbtType.Enum.LONG);
   public static final NbtType<Float> FLOAT = new NbtType<>(Float.class, NbtType.Enum.FLOAT);
   public static final NbtType<Double> DOUBLE = new NbtType<>(Double.class, NbtType.Enum.DOUBLE);
   public static final NbtType<byte[]> BYTE_ARRAY = new NbtType<>(byte[].class, NbtType.Enum.BYTE_ARRAY);
   public static final NbtType<String> STRING = new NbtType<>(String.class, NbtType.Enum.STRING);
   public static final NbtType<NbtList> LIST = new NbtType<>(NbtList.class, NbtType.Enum.LIST);
   public static final NbtType<NbtMap> COMPOUND = new NbtType<>(NbtMap.class, NbtType.Enum.COMPOUND);
   public static final NbtType<int[]> INT_ARRAY = new NbtType<>(int[].class, NbtType.Enum.INT_ARRAY);
   public static final NbtType<long[]> LONG_ARRAY = new NbtType<>(long[].class, NbtType.Enum.LONG_ARRAY);
   private static final NbtType<?>[] BY_ID = new NbtType[]{
      END, BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, BYTE_ARRAY, STRING, LIST, COMPOUND, INT_ARRAY, LONG_ARRAY
   };
   private static final Map<Class<?>, NbtType<?>> BY_CLASS = new HashMap<>();
   private final Class<T> tagClass;
   private final NbtType.Enum enumeration;

   private NbtType(Class<T> tagClass, NbtType.Enum enumeration) {
      this.tagClass = tagClass;
      this.enumeration = enumeration;
   }

   public static NbtType<?> byId(int id) {
      if (id >= 0 && id < BY_ID.length) {
         return BY_ID[id];
      } else {
         throw new IndexOutOfBoundsException("Tag type id must be greater than 0 and less than " + (BY_ID.length - 1));
      }
   }

   public static <T> NbtType<T> byClass(Class<T> tagClass) {
      NbtType<T> type = (NbtType<T>)BY_CLASS.get(tagClass);
      if (type == null) {
         throw new IllegalArgumentException("Tag of class " + tagClass + " does not exist");
      } else {
         return type;
      }
   }

   public Class<T> getTagClass() {
      return this.tagClass;
   }

   public int getId() {
      return this.enumeration.ordinal();
   }

   public String getTypeName() {
      return this.enumeration.getName();
   }

   public NbtType.Enum getEnum() {
      return this.enumeration;
   }

   static {
      for (NbtType<?> type : BY_ID) {
         BY_CLASS.put(type.getTagClass(), type);
      }
   }

   public enum Enum {
      END,
      BYTE,
      SHORT,
      INT,
      LONG,
      FLOAT,
      DOUBLE,
      BYTE_ARRAY,
      STRING,
      LIST,
      COMPOUND,
      INT_ARRAY,
      LONG_ARRAY;

      private final String name = "TAG_" + this.name();

      public String getName() {
         return this.name;
      }
   }
}
