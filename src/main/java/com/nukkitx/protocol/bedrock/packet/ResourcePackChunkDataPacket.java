package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import io.netty.buffer.ByteBuf;
import io.netty.util.AbstractReferenceCounted;
import java.util.UUID;

public class ResourcePackChunkDataPacket extends AbstractReferenceCounted implements BedrockPacket {
   private UUID packId;
   private String packVersion;
   private int chunkIndex;
   private long progress;
   private ByteBuf data;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.RESOURCE_PACK_CHUNK_DATA;
   }

   @Override
   protected void deallocate() {
      this.data.release();
   }

   public ResourcePackChunkDataPacket touch(Object hint) {
      this.data.touch(hint);
      return this;
   }

   public UUID getPackId() {
      return this.packId;
   }

   public String getPackVersion() {
      return this.packVersion;
   }

   public int getChunkIndex() {
      return this.chunkIndex;
   }

   public long getProgress() {
      return this.progress;
   }

   public ByteBuf getData() {
      return this.data;
   }

   public void setPackId(UUID packId) {
      this.packId = packId;
   }

   public void setPackVersion(String packVersion) {
      this.packVersion = packVersion;
   }

   public void setChunkIndex(int chunkIndex) {
      this.chunkIndex = chunkIndex;
   }

   public void setProgress(long progress) {
      this.progress = progress;
   }

   public void setData(ByteBuf data) {
      this.data = data;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ResourcePackChunkDataPacket)) {
         return false;
      }

      ResourcePackChunkDataPacket other = (ResourcePackChunkDataPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.chunkIndex != other.chunkIndex) {
         return false;
      }

      if (this.progress != other.progress) {
         return false;
      }

      Object this$packId = this.packId;
      Object other$packId = other.packId;
      if (this$packId == null ? other$packId == null : this$packId.equals(other$packId)) {
         Object this$packVersion = this.packVersion;
         Object other$packVersion = other.packVersion;
         if (this$packVersion == null ? other$packVersion == null : this$packVersion.equals(other$packVersion)) {
            Object this$data = this.data;
            Object other$data = other.data;
            return this$data == null ? other$data == null : this$data.equals(other$data);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof ResourcePackChunkDataPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.chunkIndex;
      long $progress = this.progress;
      result = result * 59 + (int)($progress >>> 32 ^ $progress);
      Object $packId = this.packId;
      result = result * 59 + ($packId == null ? 43 : $packId.hashCode());
      Object $packVersion = this.packVersion;
      result = result * 59 + ($packVersion == null ? 43 : $packVersion.hashCode());
      Object $data = this.data;
      return result * 59 + ($data == null ? 43 : $data.hashCode());
   }

   @Override
   public String toString() {
      return "ResourcePackChunkDataPacket(packId="
         + this.packId
         + ", packVersion="
         + this.packVersion
         + ", chunkIndex="
         + this.chunkIndex
         + ", progress="
         + this.progress
         + ")";
   }
}
