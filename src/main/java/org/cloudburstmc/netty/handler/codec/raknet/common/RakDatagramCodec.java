package org.cloudburstmc.netty.handler.codec.raknet.common;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import java.util.List;
import org.cloudburstmc.netty.channel.raknet.packet.EncapsulatedPacket;
import org.cloudburstmc.netty.channel.raknet.packet.RakDatagramPacket;

public class RakDatagramCodec extends MessageToMessageCodec<ByteBuf, RakDatagramPacket> {
   public static final String NAME = "rak-datagram-codec";

   protected void encode(ChannelHandlerContext ctx, RakDatagramPacket packet, List<Object> out) throws Exception {
      ByteBuf header = ctx.alloc().ioBuffer(4);
      header.writeByte(packet.getFlags());
      header.writeMediumLE(packet.getSequenceIndex());
      CompositeByteBuf buf = ctx.alloc().compositeBuffer(packet.getPackets().size() * 2 + 1);
      buf.addComponent(true, header);

      for (EncapsulatedPacket encapsulated : packet.getPackets()) {
         encapsulated.encode(buf);
      }

      out.add(buf);
   }

   protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> list) throws Exception {
      byte potentialFlags = buffer.getByte(buffer.readerIndex());
      if ((potentialFlags & -128) == 0) {
         list.add(buffer.retain());
      } else if ((potentialFlags & 64) == 0 && (potentialFlags & 32) == 0) {
         RakDatagramPacket packet = RakDatagramPacket.newInstance();

         try {
            packet.setFlags(buffer.readByte());
            packet.setSequenceIndex(buffer.readUnsignedMediumLE());

            while (buffer.isReadable()) {
               EncapsulatedPacket encapsulated = EncapsulatedPacket.newInstance();

               try {
                  encapsulated.decode(buffer);
                  packet.getPackets().add(encapsulated.retain());
               } finally {
                  encapsulated.release();
               }
            }

            list.add(packet.retain());
         } finally {
            packet.release();
         }
      } else {
         list.add(buffer.retain());
      }
   }
}
