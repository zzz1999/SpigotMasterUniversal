package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.BlockChangeEntry;
import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class UpdateSubChunkBlocksPacket implements BedrockPacket {
   private int chunkX;
   private int chunkY;
   private int chunkZ;
   private final List<BlockChangeEntry> standardBlocks = new ObjectArrayList<>();
   private final List<BlockChangeEntry> extraBlocks = new ObjectArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.UPDATE_SUB_CHUNK_BLOCKS;
   }

   public int getChunkX() {
      return this.chunkX;
   }

   public int getChunkY() {
      return this.chunkY;
   }

   public int getChunkZ() {
      return this.chunkZ;
   }

   public List<BlockChangeEntry> getStandardBlocks() {
      return this.standardBlocks;
   }

   public List<BlockChangeEntry> getExtraBlocks() {
      return this.extraBlocks;
   }

   public void setChunkX(int chunkX) {
      this.chunkX = chunkX;
   }

   public void setChunkY(int chunkY) {
      this.chunkY = chunkY;
   }

   public void setChunkZ(int chunkZ) {
      this.chunkZ = chunkZ;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof UpdateSubChunkBlocksPacket)) {
         return false;
      } else {
         UpdateSubChunkBlocksPacket other = (UpdateSubChunkBlocksPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.chunkX != other.chunkX) {
            return false;
         } else if (this.chunkY != other.chunkY) {
            return false;
         } else if (this.chunkZ != other.chunkZ) {
            return false;
         } else {
            Object this$standardBlocks = this.standardBlocks;
            Object other$standardBlocks = other.standardBlocks;
            if (this$standardBlocks == null ? other$standardBlocks == null : this$standardBlocks.equals(other$standardBlocks)) {
               Object this$extraBlocks = this.extraBlocks;
               Object other$extraBlocks = other.extraBlocks;
               return this$extraBlocks == null ? other$extraBlocks == null : this$extraBlocks.equals(other$extraBlocks);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof UpdateSubChunkBlocksPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.chunkX;
      result = result * 59 + this.chunkY;
      result = result * 59 + this.chunkZ;
      Object $standardBlocks = this.standardBlocks;
      result = result * 59 + ($standardBlocks == null ? 43 : $standardBlocks.hashCode());
      Object $extraBlocks = this.extraBlocks;
      return result * 59 + ($extraBlocks == null ? 43 : $extraBlocks.hashCode());
   }

   @Override
   public String toString() {
      return "UpdateSubChunkBlocksPacket(chunkX="
         + this.chunkX
         + ", chunkY="
         + this.chunkY
         + ", chunkZ="
         + this.chunkZ
         + ", standardBlocks="
         + this.standardBlocks
         + ", extraBlocks="
         + this.extraBlocks
         + ")";
   }
}
