package org.cloudburstmc.nbt;

import java.io.Closeable;
import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import org.cloudburstmc.nbt.util.stream.LimitedDataInput;

public class NBTInputStream implements Closeable {
   private final DataInput input;
   private final boolean internKeys;
   private final boolean internValues;
   private boolean closed = false;

   public NBTInputStream(DataInput input, boolean internKeys, boolean internValues) {
      this(input, internKeys, internValues, 0L);
   }

   public NBTInputStream(DataInput input, boolean internKeys, boolean internValues, long maxReadSize) {
      Objects.requireNonNull(input, "input");
      if (input instanceof LimitedDataInput) {
         this.input = input;
      } else {
         this.input = new LimitedDataInput(input, maxReadSize);
      }

      this.internKeys = internKeys;
      this.internValues = internValues;
   }

   public NBTInputStream(DataInput input) {
      this(input, false, false);
   }

   public NBTInputStream(DataInput input, long maxReadSize) {
      this(input, false, false, maxReadSize);
   }

   public Object readTag() throws IOException {
      return this.readTag(16);
   }

   public Object readTag(int maxDepth) throws IOException {
      if (this.closed) {
         throw new IllegalStateException("Trying to read from a closed reader!");
      }

      int typeId = this.input.readUnsignedByte();
      NbtType<?> type = NbtType.byId(typeId);
      this.input.readUTF();
      return this.deserialize(type, maxDepth);
   }

   public <T> T readValue(NbtType<T> type) throws IOException {
      return this.readValue(type, 16);
   }

   public <T> T readValue(NbtType<T> type, int maxDepth) throws IOException {
      if (this.closed) {
         throw new IllegalStateException("Trying to read from a closed reader!");
      } else {
         return (T)this.deserialize(type, maxDepth);
      }
   }

   private Object deserialize(NbtType<?> type, int maxDepth) throws IOException {
      if (maxDepth < 0) {
         throw new IllegalArgumentException("NBT compound is too deeply nested");
      }

      switch (type.getEnum()) {
         case END:
            return null;
         case BYTE:
            return this.input.readByte();
         case SHORT:
            return this.input.readShort();
         case INT:
            if (this.internValues) {
               return IntegerInternPool.intern(this.input.readInt());
            }

            return this.input.readInt();
         case LONG:
            return this.input.readLong();
         case FLOAT:
            if (this.internValues) {
               return FloatInternPool.intern(this.input.readFloat());
            }

            return this.input.readFloat();
         case DOUBLE:
            return this.input.readDouble();
         case BYTE_ARRAY: {
            int arraySize = this.input.readInt();
            byte[] bytes = new byte[arraySize];
            this.input.readFully(bytes);
            return bytes;
         }
         case STRING:
            if (this.internValues) {
               return this.input.readUTF().intern();
            }

            return this.input.readUTF();
         case COMPOUND:
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();

            NbtType<?> nbtType;
            while ((nbtType = NbtType.byId(this.input.readUnsignedByte())) != NbtType.END) {
               String name;
               if (this.internKeys) {
                  name = this.input.readUTF().intern();
               } else {
                  name = this.input.readUTF();
               }

               map.put(name, this.deserialize(nbtType, maxDepth - 1));
            }

            return new NbtMap(map);
         case LIST:
            int typeId = this.input.readUnsignedByte();
            NbtType<?> listType = NbtType.byId(typeId);
            List<? super Object> list = new ArrayList<>();
            int listLength = this.input.readInt();

            for (int i = 0; i < listLength; i++) {
               list.add(this.deserialize(listType, maxDepth - 1));
            }

            return new NbtList<>((NbtType)listType, list);
         case INT_ARRAY: {
            int arraySize = this.input.readInt();
            int[] ints = new int[arraySize];

            for (int i = 0; i < arraySize; i++) {
               ints[i] = this.input.readInt();
            }

            return ints;
         }
         case LONG_ARRAY: {
            int arraySize = this.input.readInt();
            long[] longs = new long[arraySize];

            for (int i = 0; i < arraySize; i++) {
               longs[i] = this.input.readLong();
            }

            return longs;
         }
         default:
            throw new IllegalArgumentException("Unknown type " + type);
      }
   }

   @Override
   public void close() throws IOException {
      if (!this.closed) {
         this.closed = true;
         if (this.input instanceof Closeable) {
            ((Closeable)this.input).close();
         }
      }
   }
}
