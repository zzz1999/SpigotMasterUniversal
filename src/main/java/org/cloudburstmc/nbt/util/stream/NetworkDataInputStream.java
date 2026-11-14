package org.cloudburstmc.nbt.util.stream;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.cloudburstmc.nbt.util.VarInts;

public class NetworkDataInputStream extends LittleEndianDataInputStream {
   public NetworkDataInputStream(InputStream stream) {
      this(stream, 0L);
   }

   public NetworkDataInputStream(InputStream stream, long maxReadSize) {
      super(new DataInputStream(stream), maxReadSize);
   }

   public NetworkDataInputStream(DataInputStream stream) {
      this(stream, 0L);
   }

   public NetworkDataInputStream(DataInputStream stream, long maxReadSize) {
      super(stream, maxReadSize);
   }

   @Override
   public int readInt() throws IOException {
      this.tryRead(4);
      return VarInts.readInt(this.delegate());
   }

   @Override
   public long readLong() throws IOException {
      this.tryRead(8);
      return VarInts.readLong(this.delegate());
   }

   @Override
   public @NonNull String readUTF() throws IOException {
      int length = VarInts.readUnsignedInt(this.delegate());
      this.tryRead(length + 4);
      byte[] bytes = new byte[length];
      this.readFully(bytes);
      return new String(bytes, StandardCharsets.UTF_8);
   }
}
