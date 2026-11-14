package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.SubChunkData;
import com.nukkitx.protocol.common.PacketSignal;
import io.netty.util.AbstractReferenceCounted;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.math.vector.Vector3i;

public class SubChunkPacket extends AbstractReferenceCounted implements BedrockPacket {
   private int dimension;
   private boolean cacheEnabled;
   private Vector3i centerPosition;
   private List<SubChunkData> subChunks = new ObjectArrayList<>();

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SUB_CHUNK;
   }

   public SubChunkPacket touch(Object o) {
      this.subChunks.forEach(AbstractReferenceCounted::touch);
      return this;
   }

   @Override
   protected void deallocate() {
      this.subChunks.forEach(AbstractReferenceCounted::release);
   }

   public int getDimension() {
      return this.dimension;
   }

   public boolean isCacheEnabled() {
      return this.cacheEnabled;
   }

   public Vector3i getCenterPosition() {
      return this.centerPosition;
   }

   public List<SubChunkData> getSubChunks() {
      return this.subChunks;
   }

   public void setDimension(int dimension) {
      this.dimension = dimension;
   }

   public void setCacheEnabled(boolean cacheEnabled) {
      this.cacheEnabled = cacheEnabled;
   }

   public void setCenterPosition(Vector3i centerPosition) {
      this.centerPosition = centerPosition;
   }

   public void setSubChunks(List<SubChunkData> subChunks) {
      this.subChunks = subChunks;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SubChunkPacket)) {
         return false;
      } else {
         SubChunkPacket other = (SubChunkPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.dimension != other.dimension) {
            return false;
         } else if (this.cacheEnabled != other.cacheEnabled) {
            return false;
         } else {
            Object this$centerPosition = this.centerPosition;
            Object other$centerPosition = other.centerPosition;
            if (this$centerPosition == null ? other$centerPosition == null : this$centerPosition.equals(other$centerPosition)) {
               Object this$subChunks = this.subChunks;
               Object other$subChunks = other.subChunks;
               return this$subChunks == null ? other$subChunks == null : this$subChunks.equals(other$subChunks);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof SubChunkPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.dimension;
      result = result * 59 + (this.cacheEnabled ? 79 : 97);
      Object $centerPosition = this.centerPosition;
      result = result * 59 + ($centerPosition == null ? 43 : $centerPosition.hashCode());
      Object $subChunks = this.subChunks;
      return result * 59 + ($subChunks == null ? 43 : $subChunks.hashCode());
   }

   @Override
   public String toString() {
      return "SubChunkPacket(dimension="
         + this.dimension
         + ", cacheEnabled="
         + this.cacheEnabled
         + ", centerPosition="
         + this.centerPosition
         + ", subChunks="
         + this.subChunks
         + ")";
   }
}
