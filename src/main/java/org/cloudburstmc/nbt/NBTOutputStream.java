package org.cloudburstmc.nbt;

import java.io.Closeable;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;
import java.util.Map.Entry;

public class NBTOutputStream implements Closeable {
   private final DataOutput output;
   private boolean closed = false;

   public NBTOutputStream(DataOutput output) {
      this.output = Objects.requireNonNull(output, "output");
   }

   public void writeTag(Object tag) throws IOException {
      this.writeTag(tag, 16);
   }

   public void writeTag(Object tag, int maxDepth) throws IOException {
      Objects.requireNonNull(tag, "tag");
      if (this.closed) {
         throw new IllegalStateException("closed");
      }

      NbtType<?> type = NbtType.byClass(tag.getClass());
      this.output.writeByte(type.getId());
      this.output.writeUTF("");
      this.serialize(tag, type, maxDepth);
   }

   public void writeValue(Object tag) throws IOException {
      this.writeValue(tag, 16);
   }

   public void writeValue(Object tag, int maxDepth) throws IOException {
      Objects.requireNonNull(tag, "tag");
      if (this.closed) {
         throw new IllegalStateException("closed");
      }

      NbtType<?> type = NbtType.byClass(tag.getClass());
      this.serialize(tag, type, maxDepth);
   }

   private void serialize(Object tag, NbtType<?> type, int maxDepth) throws IOException {
      if (maxDepth < 0) {
         throw new IllegalArgumentException("Reached depth limit");
      }

      switch (type.getEnum()) {
         case END:
         default:
            break;
         case BYTE:
            Byte byteVal = (Byte)tag;
            this.output.writeByte(byteVal);
            break;
         case SHORT:
            Short shortVal = (Short)tag;
            this.output.writeShort(shortVal);
            break;
         case INT:
            Integer intVal = (Integer)tag;
            this.output.writeInt(intVal);
            break;
         case LONG:
            Long longVal = (Long)tag;
            this.output.writeLong(longVal);
            break;
         case FLOAT:
            Float floatVal = (Float)tag;
            this.output.writeFloat(floatVal);
            break;
         case DOUBLE:
            Double doubleVal = (Double)tag;
            this.output.writeDouble(doubleVal);
            break;
         case BYTE_ARRAY:
            byte[] byteArray = (byte[])tag;
            this.output.writeInt(byteArray.length);
            this.output.write(byteArray);
            break;
         case STRING:
            String string = (String)tag;
            this.output.writeUTF(string);
            break;
         case LIST:
            NbtList<?> list = (NbtList<?>)tag;
            NbtType<?> listType = list.getType();
            this.output.writeByte(listType.getId());
            this.output.writeInt(list.size());

            for (Object entry : list) {
               this.serialize(entry, listType, maxDepth - 1);
            }
            break;
         case COMPOUND:
            NbtMap map = (NbtMap)tag;

            for (Entry<String, Object> entry : map.entrySet()) {
               NbtType<?> entryType = NbtType.byClass(entry.getValue().getClass());
               this.output.writeByte(entryType.getId());
               this.output.writeUTF(entry.getKey());
               this.serialize(entry.getValue(), entryType, maxDepth - 1);
            }

            this.output.writeByte(0);
            break;
         case INT_ARRAY:
            int[] intArray = (int[])tag;
            this.output.writeInt(intArray.length);

            for (int val : intArray) {
               this.output.writeInt(val);
            }
            break;
         case LONG_ARRAY:
            long[] longArray = (long[])tag;
            this.output.writeInt(longArray.length);

            for (long val : longArray) {
               this.output.writeLong(val);
            }
      }
   }

   @Override
   public void close() throws IOException {
      if (!this.closed) {
         this.closed = true;
         if (this.output instanceof Closeable) {
            ((Closeable)this.output).close();
         }
      }
   }
}
