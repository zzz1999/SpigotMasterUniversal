package com.nukkitx.protocol.bedrock.codec.v503.serializer;

import com.nukkitx.protocol.bedrock.codec.v475.serializer.StartGameSerializer_v475;
import io.netty.buffer.ByteBuf;

public class StartGameSerializer_v503 extends StartGameSerializer_v475 {
   @Override
   protected long readSeed(ByteBuf buf) {
      return buf.readLongLE();
   }

   @Override
   protected void writeSeed(ByteBuf buf, long seed) {
      buf.writeLongLE(seed);
   }
}
