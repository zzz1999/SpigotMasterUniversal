package org.cloudburstmc.protocol.bedrock.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.ReferenceCounted;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.common.PacketSignal;

public final class UnknownPacket implements BedrockPacket, BedrockPacketSerializer<UnknownPacket>, ReferenceCounted {
   private int packetId;
   private ByteBuf payload;

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, UnknownPacket packet) {
      buffer.writeBytes(packet.payload, packet.payload.readerIndex(), packet.payload.readableBytes());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, UnknownPacket packet) {
      packet.payload = buffer.readRetainedSlice(buffer.readableBytes());
   }

   @Override
   public String toString() {
      return "UNKNOWN - " + this.getPacketId() + " - Hex: " + (this.payload != null && this.payload.refCnt() != 0 ? ByteBufUtil.hexDump(this.payload) : "null");
   }

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return PacketSignal.UNHANDLED;
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.UNKNOWN;
   }

   @Override
   public int refCnt() {
      return this.payload == null ? 0 : this.payload.refCnt();
   }

   public UnknownPacket retain() {
      if (this.payload != null) {
         this.payload.retain();
      }

      return this;
   }

   public UnknownPacket retain(int increment) {
      if (this.payload != null) {
         this.payload.retain(increment);
      }

      return this;
   }

   public UnknownPacket touch() {
      if (this.payload != null) {
         this.payload.touch();
      }

      return this;
   }

   public UnknownPacket touch(Object hint) {
      if (this.payload != null) {
         this.payload.touch(hint);
      }

      return this;
   }

   @Override
   public boolean release() {
      return this.payload == null || this.payload.release();
   }

   @Override
   public boolean release(int decrement) {
      return this.payload == null || this.payload.release(decrement);
   }

   public UnknownPacket clone() {
      throw new UnsupportedOperationException("Can not clone reference counted packet");
   }

   public int getPacketId() {
      return this.packetId;
   }

   public ByteBuf getPayload() {
      return this.payload;
   }

   public void setPacketId(final int packetId) {
      this.packetId = packetId;
   }

   public void setPayload(final ByteBuf payload) {
      this.payload = payload;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UnknownPacket)) {
         return false;
      }

      UnknownPacket other = (UnknownPacket)o;
      if (this.packetId != other.packetId) {
         return false;
      }

      Object this$payload = this.payload;
      Object other$payload = other.payload;
      return this$payload == null ? other$payload == null : this$payload.equals(other$payload);
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.packetId;
      Object $payload = this.payload;
      return result * 59 + ($payload == null ? 43 : $payload.hashCode());
   }
}
