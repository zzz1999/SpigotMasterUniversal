package org.cloudburstmc.protocol.bedrock.packet;

import io.netty.buffer.ByteBuf;
import io.netty.util.AbstractReferenceCounted;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongList;
import org.cloudburstmc.protocol.common.PacketSignal;

public class LevelChunkPacket extends AbstractReferenceCounted implements BedrockPacket {
   private int chunkX;
   private int chunkZ;
   private int subChunksLength;
   private boolean cachingEnabled;
   private boolean requestSubChunks;
   private int subChunkLimit;
   private final LongList blobIds = new LongArrayList();
   private ByteBuf data;
   private int dimension;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.LEVEL_CHUNK;
   }

   public LevelChunkPacket touch(Object hint) {
      this.data.touch(hint);
      return this;
   }

   @Override
   protected void deallocate() {
      this.data.release();
   }

   public LevelChunkPacket clone() {
      throw new UnsupportedOperationException("Can not clone reference counted packet");
   }

   public int getChunkX() {
      return this.chunkX;
   }

   public int getChunkZ() {
      return this.chunkZ;
   }

   public int getSubChunksLength() {
      return this.subChunksLength;
   }

   public boolean isCachingEnabled() {
      return this.cachingEnabled;
   }

   public boolean isRequestSubChunks() {
      return this.requestSubChunks;
   }

   public int getSubChunkLimit() {
      return this.subChunkLimit;
   }

   public LongList getBlobIds() {
      return this.blobIds;
   }

   public ByteBuf getData() {
      return this.data;
   }

   public int getDimension() {
      return this.dimension;
   }

   public void setChunkX(final int chunkX) {
      this.chunkX = chunkX;
   }

   public void setChunkZ(final int chunkZ) {
      this.chunkZ = chunkZ;
   }

   public void setSubChunksLength(final int subChunksLength) {
      this.subChunksLength = subChunksLength;
   }

   public void setCachingEnabled(final boolean cachingEnabled) {
      this.cachingEnabled = cachingEnabled;
   }

   public void setRequestSubChunks(final boolean requestSubChunks) {
      this.requestSubChunks = requestSubChunks;
   }

   public void setSubChunkLimit(final int subChunkLimit) {
      this.subChunkLimit = subChunkLimit;
   }

   public void setData(final ByteBuf data) {
      this.data = data;
   }

   public void setDimension(final int dimension) {
      this.dimension = dimension;
   }

   @Override
   public String toString() {
      return "LevelChunkPacket(chunkX="
         + this.chunkX
         + ", chunkZ="
         + this.chunkZ
         + ", subChunksLength="
         + this.subChunksLength
         + ", cachingEnabled="
         + this.cachingEnabled
         + ", requestSubChunks="
         + this.requestSubChunks
         + ", subChunkLimit="
         + this.subChunkLimit
         + ", blobIds="
         + this.blobIds
         + ", dimension="
         + this.dimension
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof LevelChunkPacket)) {
         return false;
      } else {
         LevelChunkPacket other = (LevelChunkPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.chunkX != other.chunkX) {
            return false;
         } else if (this.chunkZ != other.chunkZ) {
            return false;
         } else if (this.subChunksLength != other.subChunksLength) {
            return false;
         } else if (this.cachingEnabled != other.cachingEnabled) {
            return false;
         } else if (this.requestSubChunks != other.requestSubChunks) {
            return false;
         } else if (this.subChunkLimit != other.subChunkLimit) {
            return false;
         } else if (this.dimension != other.dimension) {
            return false;
         } else {
            Object this$blobIds = this.blobIds;
            Object other$blobIds = other.blobIds;
            if (this$blobIds == null ? other$blobIds == null : this$blobIds.equals(other$blobIds)) {
               Object this$data = this.data;
               Object other$data = other.data;
               return this$data == null ? other$data == null : this$data.equals(other$data);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof LevelChunkPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.chunkX;
      result = result * 59 + this.chunkZ;
      result = result * 59 + this.subChunksLength;
      result = result * 59 + (this.cachingEnabled ? 79 : 97);
      result = result * 59 + (this.requestSubChunks ? 79 : 97);
      result = result * 59 + this.subChunkLimit;
      result = result * 59 + this.dimension;
      Object $blobIds = this.blobIds;
      result = result * 59 + ($blobIds == null ? 43 : $blobIds.hashCode());
      Object $data = this.data;
      return result * 59 + ($data == null ? 43 : $data.hashCode());
   }
}
