package org.cloudburstmc.netty.channel.raknet.packet;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.internal.ObjectPool;
import java.util.ArrayList;
import java.util.List;

public class RakDatagramPacket extends AbstractReferenceCounted {
   private static final ObjectPool<RakDatagramPacket> RECYCLER = ObjectPool.newPool(RakDatagramPacket::new);
   private final ObjectPool.Handle<RakDatagramPacket> handle;
   private final List<EncapsulatedPacket> packets = new ArrayList<>();
   private byte flags = -124;
   private long sendTime;
   private long nextSend;
   private int sequenceIndex = -1;

   public static RakDatagramPacket newInstance() {
      return RECYCLER.get();
   }

   private RakDatagramPacket(ObjectPool.Handle<RakDatagramPacket> handle) {
      this.handle = handle;
   }

   public RakDatagramPacket retain() {
      super.retain();
      return this;
   }

   public RakDatagramPacket retain(int increment) {
      super.retain(increment);
      return this;
   }

   public RakDatagramPacket touch(Object hint) {
      for (EncapsulatedPacket packet : this.packets) {
         packet.touch(hint);
      }

      return this;
   }

   public boolean tryAddPacket(EncapsulatedPacket packet, int mtu) {
      if (this.getSize() + packet.getSize() > mtu - 4) {
         return false;
      }

      this.packets.add(packet);
      if (packet.isSplit()) {
         this.flags = (byte)(this.flags | 8);
      }

      return true;
   }

   @Override
   public boolean release() {
      return super.release();
   }

   @Override
   protected void deallocate() {
      for (EncapsulatedPacket packet : this.packets) {
         packet.release();
      }

      this.packets.clear();
      this.flags = -124;
      this.sendTime = 0L;
      this.nextSend = 0L;
      this.sequenceIndex = -1;
      this.setRefCnt(1);
      this.handle.recycle(this);
   }

   public int getSize() {
      int size = 4;

      for (EncapsulatedPacket packet : this.packets) {
         size += packet.getSize();
      }

      return size;
   }

   public List<EncapsulatedPacket> getPackets() {
      return this.packets;
   }

   public byte getFlags() {
      return this.flags;
   }

   public void setFlags(byte flags) {
      this.flags = flags;
   }

   public long getSendTime() {
      return this.sendTime;
   }

   public void setSendTime(long sendTime) {
      this.sendTime = sendTime;
   }

   public long getNextSend() {
      return this.nextSend;
   }

   public void setNextSend(long nextSend) {
      this.nextSend = nextSend;
   }

   public int getSequenceIndex() {
      return this.sequenceIndex;
   }

   public void setSequenceIndex(int sequenceIndex) {
      this.sequenceIndex = sequenceIndex;
   }

   @Override
   public String toString() {
      return "RakDatagramPacket{handle="
         + this.handle
         + ", packets="
         + this.packets
         + ", flags="
         + this.flags
         + ", sendTime="
         + this.sendTime
         + ", nextSend="
         + this.nextSend
         + ", sequenceIndex="
         + this.sequenceIndex
         + '}';
   }
}
