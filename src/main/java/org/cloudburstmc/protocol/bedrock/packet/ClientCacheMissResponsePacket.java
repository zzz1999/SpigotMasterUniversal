package org.cloudburstmc.protocol.bedrock.packet;

import io.netty.buffer.ByteBuf;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCounted;
import it.unimi.dsi.fastutil.longs.Long2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ClientCacheMissResponsePacket extends AbstractReferenceCounted implements BedrockPacket {
   private final Long2ObjectMap<ByteBuf> blobs = new Long2ObjectLinkedOpenHashMap<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CLIENT_CACHE_MISS_RESPONSE;
   }

   @Override
   protected void deallocate() {
      this.blobs.values().forEach(ReferenceCounted::release);
   }

   public ClientCacheMissResponsePacket touch(Object hint) {
      this.blobs.values().forEach(byteBuf -> byteBuf.touch(hint));
      return this;
   }

   public ClientCacheMissResponsePacket clone() {
      throw new UnsupportedOperationException("Can not clone reference counted packet");
   }

   public Long2ObjectMap<ByteBuf> getBlobs() {
      return this.blobs;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ClientCacheMissResponsePacket)) {
         return false;
      }

      ClientCacheMissResponsePacket other = (ClientCacheMissResponsePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$blobs = this.blobs;
      Object other$blobs = other.blobs;
      return this$blobs == null ? other$blobs == null : this$blobs.equals(other$blobs);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ClientCacheMissResponsePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $blobs = this.blobs;
      return result * 59 + ($blobs == null ? 43 : $blobs.hashCode());
   }

   @Override
   public String toString() {
      return "ClientCacheMissResponsePacket(blobs=" + this.blobs + ")";
   }
}
