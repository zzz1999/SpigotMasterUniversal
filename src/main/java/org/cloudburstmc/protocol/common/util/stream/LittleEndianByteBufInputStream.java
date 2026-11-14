package org.cloudburstmc.protocol.common.util.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.cloudburstmc.protocol.common.util.Preconditions;

public class LittleEndianByteBufInputStream extends ByteBufInputStream {
   private final ByteBuf buffer;

   public LittleEndianByteBufInputStream(ByteBuf buffer) {
      super(buffer);
      this.buffer = buffer;
   }

   @Override
   public char readChar() throws IOException {
      return Character.reverseBytes(this.buffer.readChar());
   }

   @Override
   public double readDouble() throws IOException {
      return this.buffer.readDoubleLE();
   }

   @Override
   public float readFloat() throws IOException {
      return this.buffer.readFloatLE();
   }

   @Override
   public short readShort() throws IOException {
      return this.buffer.readShortLE();
   }

   @Override
   public int readUnsignedShort() throws IOException {
      return this.buffer.readUnsignedShortLE();
   }

   @Override
   public long readLong() throws IOException {
      return this.buffer.readLongLE();
   }

   @Override
   public int readInt() throws IOException {
      return this.buffer.readIntLE();
   }

   @Override
   public String readUTF() throws IOException {
      int length = this.readUnsignedShort();
      return (String)this.buffer.readCharSequence(length, StandardCharsets.UTF_8);
   }

   public String readUTFMaxLen(int maxLength) throws IOException {
      int length = this.readUnsignedShort();
      Preconditions.checkArgument(maxLength <= 0 || length <= maxLength, "Tried to read %s bytes but maximum is %s", length, maxLength);
      return (String)this.buffer.readCharSequence(length, StandardCharsets.UTF_8);
   }
}
