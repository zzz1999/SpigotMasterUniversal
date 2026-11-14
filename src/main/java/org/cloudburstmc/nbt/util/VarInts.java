package org.cloudburstmc.nbt.util;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class VarInts {
   private VarInts() {
   }

   public static void writeInt(DataOutput buffer, int value) throws IOException {
      encode(buffer, (value << 1 ^ value >> 31) & 4294967295L);
   }

   public static int readInt(DataInput buffer) throws IOException {
      int n = (int)decode(buffer, 32);
      return n >>> 1 ^ -(n & 1);
   }

   public static void writeUnsignedInt(DataOutput buffer, long value) throws IOException {
      encode(buffer, value & 4294967295L);
   }

   public static int readUnsignedInt(DataInput buffer) throws IOException {
      return (int)decode(buffer, 32);
   }

   public static void writeLong(DataOutput buffer, long value) throws IOException {
      encode(buffer, value << 1 ^ value >> 63);
   }

   public static long readLong(DataInput buffer) throws IOException {
      long n = decode(buffer, 64);
      return n >>> 1 ^ -(n & 1L);
   }

   public static void writeUnsignedLong(DataOutput buffer, long value) throws IOException {
      encode(buffer, value);
   }

   public static long readUnsignedLong(DataInput buffer) throws IOException {
      return decode(buffer, 64);
   }

   private static void encode(DataOutput out, long value) throws IOException {
      if ((value & -128L) == 0L) {
         out.writeByte((byte)value);
      } else if ((value & -16384L) == 0L) {
         byte[] bytes = new byte[]{(byte)(value & 127L | 128L), (byte)(value >>> 7)};
         out.write(bytes);
      } else {
         encodeFull(out, value);
      }
   }

   private static void encodeFull(DataOutput out, long value) throws IOException {
      byte[] bytes;
      if ((value & -2097152L) == 0L) {
         bytes = new byte[]{(byte)(value & 127L | 128L), (byte)(value >>> 7 & 127L | 128L), (byte)(value >>> 14)};
      } else if ((value & -268435456L) == 0L) {
         bytes = new byte[]{(byte)(value & 127L | 128L), (byte)(value >>> 7 & 127L | 128L), (byte)(value >>> 14 & 127L | 128L), (byte)(value >>> 21)};
      } else if ((value & -34359738368L) == 0L) {
         bytes = new byte[]{
            (byte)(value & 127L | 128L),
            (byte)(value >>> 7 & 127L | 128L),
            (byte)(value >>> 14 & 127L | 128L),
            (byte)(value >>> 21 & 127L | 128L),
            (byte)(value >>> 28)
         };
      } else if ((value & -4398046511104L) == 0L) {
         bytes = new byte[]{
            (byte)(value & 127L | 128L),
            (byte)(value >>> 7 & 127L | 128L),
            (byte)(value >>> 14 & 127L | 128L),
            (byte)(value >>> 21 & 127L | 128L),
            (byte)(value >>> 28 & 127L | 128L),
            (byte)(value >>> 35)
         };
      } else if ((value & -562949953421312L) == 0L) {
         bytes = new byte[]{
            (byte)(value & 127L | 128L),
            (byte)(value >>> 7 & 127L | 128L),
            (byte)(value >>> 14 & 127L | 128L),
            (byte)(value >>> 21 & 127L | 128L),
            (byte)(value >>> 28 & 127L | 128L),
            (byte)(value >>> 35 & 127L | 128L),
            (byte)(value >>> 42)
         };
      } else if ((value & -72057594037927936L) == 0L) {
         bytes = new byte[]{
            (byte)(value & 127L | 128L),
            (byte)(value >>> 7 & 127L | 128L),
            (byte)(value >>> 14 & 127L | 128L),
            (byte)(value >>> 21 & 127L | 128L),
            (byte)(value >>> 28 & 127L | 128L),
            (byte)(value >>> 35 & 127L | 128L),
            (byte)(value >>> 42 & 127L | 128L),
            (byte)(value >>> 49)
         };
      } else if ((value & Long.MIN_VALUE) == 0L) {
         bytes = new byte[]{
            (byte)(value & 127L | 128L),
            (byte)(value >>> 7 & 127L | 128L),
            (byte)(value >>> 14 & 127L | 128L),
            (byte)(value >>> 21 & 127L | 128L),
            (byte)(value >>> 28 & 127L | 128L),
            (byte)(value >>> 35 & 127L | 128L),
            (byte)(value >>> 42 & 127L | 128L),
            (byte)(value >>> 49 & 127L | 128L),
            (byte)(value >>> 56)
         };
      } else {
         bytes = new byte[]{
            (byte)(value & 127L | 128L),
            (byte)(value >>> 7 & 127L | 128L),
            (byte)(value >>> 14 & 127L | 128L),
            (byte)(value >>> 21 & 127L | 128L),
            (byte)(value >>> 28 & 127L | 128L),
            (byte)(value >>> 35 & 127L | 128L),
            (byte)(value >>> 42 & 127L | 128L),
            (byte)(value >>> 49 & 127L | 128L),
            (byte)(value >>> 56 & 127L | 128L),
            (byte)(value >>> 63)
         };
      }

      out.write(bytes);
   }

   private static long decode(DataInput buffer, int maxBits) throws IOException {
      long result = 0L;

      for (int shift = 0; shift < maxBits; shift += 7) {
         byte b = buffer.readByte();
         result |= (b & 127L) << shift;
         if ((b & 128) == 0) {
            return result;
         }
      }

      throw new ArithmeticException("VarInt was too large");
   }
}
