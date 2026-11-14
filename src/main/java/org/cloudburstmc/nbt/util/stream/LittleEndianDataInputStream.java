package org.cloudburstmc.nbt.util.stream;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.checkerframework.checker.nullness.qual.NonNull;

public class LittleEndianDataInputStream extends LimitedDataInput {
   public LittleEndianDataInputStream(InputStream stream) {
      this(stream, 0L);
   }

   public LittleEndianDataInputStream(InputStream stream, long maxReadSize) {
      super(new DataInputStream(stream), maxReadSize);
   }

   public LittleEndianDataInputStream(DataInputStream stream) {
      this(stream, 0L);
   }

   public LittleEndianDataInputStream(DataInputStream stream, long maxReadSize) {
      super(stream, maxReadSize);
   }

   @Override
   public short readShort() throws IOException {
      this.tryRead(2);
      return Short.reverseBytes(this.delegate().readShort());
   }

   @Override
   public int readUnsignedShort() throws IOException {
      this.tryRead(2);
      return Short.toUnsignedInt(Short.reverseBytes(this.delegate().readShort()));
   }

   @Override
   public char readChar() throws IOException {
      this.tryRead(2);
      return Character.reverseBytes(this.delegate().readChar());
   }

   @Override
   public int readInt() throws IOException {
      this.tryRead(4);
      return Integer.reverseBytes(this.delegate().readInt());
   }

   @Override
   public long readLong() throws IOException {
      this.tryRead(8);
      return Long.reverseBytes(this.delegate().readLong());
   }

   @Override
   public float readFloat() throws IOException {
      this.tryRead(4);
      return Float.intBitsToFloat(Integer.reverseBytes(this.delegate().readInt()));
   }

   @Override
   public double readDouble() throws IOException {
      this.tryRead(8);
      return Double.longBitsToDouble(Long.reverseBytes(this.delegate().readLong()));
   }

   @Override
   public @NonNull String readUTF() throws IOException {
      int size = this.readUnsignedShort();
      this.tryRead(size + 4);
      byte[] bytes = new byte[size];
      this.readFully(bytes);
      return new String(bytes, StandardCharsets.UTF_8);
   }
}
