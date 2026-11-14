package org.cloudburstmc.protocol.bedrock.packet;

import java.util.Arrays;
import java.util.UUID;
import org.cloudburstmc.protocol.bedrock.data.ResourcePackType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ResourcePackDataInfoPacket implements BedrockPacket {
   private UUID packId;
   private String packVersion;
   private long maxChunkSize;
   private long chunkCount;
   private long compressedPackSize;
   private byte[] hash;
   private boolean premium;
   private ResourcePackType type;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.RESOURCE_PACK_DATA_INFO;
   }

   public ResourcePackDataInfoPacket clone() {
      try {
         return (ResourcePackDataInfoPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public UUID getPackId() {
      return this.packId;
   }

   public String getPackVersion() {
      return this.packVersion;
   }

   public long getMaxChunkSize() {
      return this.maxChunkSize;
   }

   public long getChunkCount() {
      return this.chunkCount;
   }

   public long getCompressedPackSize() {
      return this.compressedPackSize;
   }

   public byte[] getHash() {
      return this.hash;
   }

   public boolean isPremium() {
      return this.premium;
   }

   public ResourcePackType getType() {
      return this.type;
   }

   public void setPackId(final UUID packId) {
      this.packId = packId;
   }

   public void setPackVersion(final String packVersion) {
      this.packVersion = packVersion;
   }

   public void setMaxChunkSize(final long maxChunkSize) {
      this.maxChunkSize = maxChunkSize;
   }

   public void setChunkCount(final long chunkCount) {
      this.chunkCount = chunkCount;
   }

   public void setCompressedPackSize(final long compressedPackSize) {
      this.compressedPackSize = compressedPackSize;
   }

   public void setHash(final byte[] hash) {
      this.hash = hash;
   }

   public void setPremium(final boolean premium) {
      this.premium = premium;
   }

   public void setType(final ResourcePackType type) {
      this.type = type;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ResourcePackDataInfoPacket)) {
         return false;
      }

      ResourcePackDataInfoPacket other = (ResourcePackDataInfoPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.maxChunkSize != other.maxChunkSize) {
         return false;
      }

      if (this.chunkCount != other.chunkCount) {
         return false;
      }

      if (this.compressedPackSize != other.compressedPackSize) {
         return false;
      }

      if (this.premium != other.premium) {
         return false;
      }

      Object this$packId = this.packId;
      Object other$packId = other.packId;
      if (this$packId == null ? other$packId == null : this$packId.equals(other$packId)) {
         Object this$packVersion = this.packVersion;
         Object other$packVersion = other.packVersion;
         if (this$packVersion == null ? other$packVersion == null : this$packVersion.equals(other$packVersion)) {
            if (!Arrays.equals(this.hash, other.hash)) {
               return false;
            }

            Object this$type = this.type;
            Object other$type = other.type;
            return this$type == null ? other$type == null : this$type.equals(other$type);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ResourcePackDataInfoPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $maxChunkSize = this.maxChunkSize;
      result = result * 59 + (int)($maxChunkSize >>> 32 ^ $maxChunkSize);
      long $chunkCount = this.chunkCount;
      result = result * 59 + (int)($chunkCount >>> 32 ^ $chunkCount);
      long $compressedPackSize = this.compressedPackSize;
      result = result * 59 + (int)($compressedPackSize >>> 32 ^ $compressedPackSize);
      result = result * 59 + (this.premium ? 79 : 97);
      Object $packId = this.packId;
      result = result * 59 + ($packId == null ? 43 : $packId.hashCode());
      Object $packVersion = this.packVersion;
      result = result * 59 + ($packVersion == null ? 43 : $packVersion.hashCode());
      result = result * 59 + Arrays.hashCode(this.hash);
      Object $type = this.type;
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "ResourcePackDataInfoPacket(packId="
         + this.packId
         + ", packVersion="
         + this.packVersion
         + ", maxChunkSize="
         + this.maxChunkSize
         + ", chunkCount="
         + this.chunkCount
         + ", compressedPackSize="
         + this.compressedPackSize
         + ", hash="
         + Arrays.toString(this.hash)
         + ", premium="
         + this.premium
         + ", type="
         + this.type
         + ")";
   }
}
