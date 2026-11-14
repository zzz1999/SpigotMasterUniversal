package org.cloudburstmc.netty.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import java.util.Objects;
import org.cloudburstmc.netty.channel.raknet.packet.EncapsulatedPacket;

public class SplitPacketHelper extends AbstractReferenceCounted {
   private final EncapsulatedPacket[] packets;
   private final long created = System.currentTimeMillis();

   public SplitPacketHelper(long expectedLength) {
      if (expectedLength < 2L) {
         throw new IllegalArgumentException("expectedLength must be greater than 1");
      }

      this.packets = new EncapsulatedPacket[(int)expectedLength];
   }

   public EncapsulatedPacket add(EncapsulatedPacket packet, ByteBufAllocator alloc) {
      Objects.requireNonNull(packet, "packet cannot be null");
      if (!packet.isSplit()) {
         throw new IllegalArgumentException("Packet is not split");
      }

      if (this.refCnt() <= 0) {
         throw new IllegalReferenceCountException(this.refCnt());
      }

      if (packet.getPartIndex() >= 0 && packet.getPartIndex() < this.packets.length) {
         int partIndex = packet.getPartIndex();
         if (this.packets[partIndex] != null) {
            return null;
         }

         this.packets[partIndex] = packet.retain();
         int sz = 0;

         for (EncapsulatedPacket netPacket : this.packets) {
            if (netPacket == null) {
               return null;
            }

            sz += netPacket.getBuffer().readableBytes();
         }

         ByteBuf reassembled = alloc.ioBuffer(sz);

         for (EncapsulatedPacket netPacket : this.packets) {
            ByteBuf buf = netPacket.getBuffer();
            reassembled.writeBytes(buf, buf.readerIndex(), buf.readableBytes());
         }

         return packet.fromSplit(reassembled);
      } else {
         throw new IllegalArgumentException(
            String.format("Split packet part index out of range. Got %s, expected 0-%s", packet.getPartIndex(), this.packets.length - 1)
         );
      }
   }

   public boolean expired() {
      if (this.refCnt() <= 0) {
         throw new IllegalReferenceCountException(this.refCnt());
      } else {
         return System.currentTimeMillis() - this.created >= 30000L;
      }
   }

   @Override
   protected void deallocate() {
      for (EncapsulatedPacket packet : this.packets) {
         ReferenceCountUtil.release(packet);
      }
   }

   @Override
   public ReferenceCounted touch(Object hint) {
      throw new UnsupportedOperationException();
   }
}
