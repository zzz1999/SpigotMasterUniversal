package org.cloudburstmc.protocol.bedrock.data;

import io.netty.buffer.ByteBuf;
import io.netty.util.AbstractReferenceCounted;
import org.cloudburstmc.math.vector.Vector3i;

public class SubChunkData extends AbstractReferenceCounted {
   private Vector3i position;
   private ByteBuf data;
   private SubChunkRequestResult result;
   private HeightMapDataType heightMapType;
   private ByteBuf heightMapData;
   private HeightMapDataType renderHeightMapType;
   private ByteBuf renderHeightMapData;
   private boolean cacheEnabled;
   private long blobId;

   public SubChunkData touch(Object o) {
      if (this.data != null) {
         this.data.touch(o);
      }

      if (this.heightMapData != null) {
         this.heightMapData.touch(o);
      }

      return this;
   }

   @Override
   protected void deallocate() {
      if (this.data != null) {
         this.data.release();
      }

      if (this.heightMapData != null) {
         this.heightMapData.release();
      }
   }

   public Vector3i getPosition() {
      return this.position;
   }

   public ByteBuf getData() {
      return this.data;
   }

   public SubChunkRequestResult getResult() {
      return this.result;
   }

   public HeightMapDataType getHeightMapType() {
      return this.heightMapType;
   }

   public ByteBuf getHeightMapData() {
      return this.heightMapData;
   }

   public HeightMapDataType getRenderHeightMapType() {
      return this.renderHeightMapType;
   }

   public ByteBuf getRenderHeightMapData() {
      return this.renderHeightMapData;
   }

   public boolean isCacheEnabled() {
      return this.cacheEnabled;
   }

   public long getBlobId() {
      return this.blobId;
   }

   public void setPosition(final Vector3i position) {
      this.position = position;
   }

   public void setData(final ByteBuf data) {
      this.data = data;
   }

   public void setResult(final SubChunkRequestResult result) {
      this.result = result;
   }

   public void setHeightMapType(final HeightMapDataType heightMapType) {
      this.heightMapType = heightMapType;
   }

   public void setHeightMapData(final ByteBuf heightMapData) {
      this.heightMapData = heightMapData;
   }

   public void setRenderHeightMapType(final HeightMapDataType renderHeightMapType) {
      this.renderHeightMapType = renderHeightMapType;
   }

   public void setRenderHeightMapData(final ByteBuf renderHeightMapData) {
      this.renderHeightMapData = renderHeightMapData;
   }

   public void setCacheEnabled(final boolean cacheEnabled) {
      this.cacheEnabled = cacheEnabled;
   }

   public void setBlobId(final long blobId) {
      this.blobId = blobId;
   }

   @Override
   public String toString() {
      return "SubChunkData(position="
         + this.getPosition()
         + ", data="
         + this.getData()
         + ", result="
         + this.getResult()
         + ", heightMapType="
         + this.getHeightMapType()
         + ", heightMapData="
         + this.getHeightMapData()
         + ", renderHeightMapType="
         + this.getRenderHeightMapType()
         + ", renderHeightMapData="
         + this.getRenderHeightMapData()
         + ", cacheEnabled="
         + this.isCacheEnabled()
         + ", blobId="
         + this.getBlobId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubChunkData)) {
         return false;
      }

      SubChunkData other = (SubChunkData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isCacheEnabled() != other.isCacheEnabled()) {
         return false;
      }

      if (this.getBlobId() != other.getBlobId()) {
         return false;
      }

      Object this$position = this.getPosition();
      Object other$position = other.getPosition();
      if (this$position == null ? other$position == null : this$position.equals(other$position)) {
         Object this$data = this.getData();
         Object other$data = other.getData();
         if (this$data == null ? other$data == null : this$data.equals(other$data)) {
            Object this$result = this.getResult();
            Object other$result = other.getResult();
            if (this$result == null ? other$result == null : this$result.equals(other$result)) {
               Object this$heightMapType = this.getHeightMapType();
               Object other$heightMapType = other.getHeightMapType();
               if (this$heightMapType == null ? other$heightMapType == null : this$heightMapType.equals(other$heightMapType)) {
                  Object this$heightMapData = this.getHeightMapData();
                  Object other$heightMapData = other.getHeightMapData();
                  if (this$heightMapData == null ? other$heightMapData == null : this$heightMapData.equals(other$heightMapData)) {
                     Object this$renderHeightMapType = this.getRenderHeightMapType();
                     Object other$renderHeightMapType = other.getRenderHeightMapType();
                     if (this$renderHeightMapType == null ? other$renderHeightMapType == null : this$renderHeightMapType.equals(other$renderHeightMapType)) {
                        Object this$renderHeightMapData = this.getRenderHeightMapData();
                        Object other$renderHeightMapData = other.getRenderHeightMapData();
                        return this$renderHeightMapData == null
                           ? other$renderHeightMapData == null
                           : this$renderHeightMapData.equals(other$renderHeightMapData);
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubChunkData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isCacheEnabled() ? 79 : 97);
      long $blobId = this.getBlobId();
      result = result * 59 + (int)($blobId >>> 32 ^ $blobId);
      Object $position = this.getPosition();
      result = result * 59 + ($position == null ? 43 : $position.hashCode());
      Object $data = this.getData();
      result = result * 59 + ($data == null ? 43 : $data.hashCode());
      Object $result = this.getResult();
      result = result * 59 + ($result == null ? 43 : $result.hashCode());
      Object $heightMapType = this.getHeightMapType();
      result = result * 59 + ($heightMapType == null ? 43 : $heightMapType.hashCode());
      Object $heightMapData = this.getHeightMapData();
      result = result * 59 + ($heightMapData == null ? 43 : $heightMapData.hashCode());
      Object $renderHeightMapType = this.getRenderHeightMapType();
      result = result * 59 + ($renderHeightMapType == null ? 43 : $renderHeightMapType.hashCode());
      Object $renderHeightMapData = this.getRenderHeightMapData();
      return result * 59 + ($renderHeightMapData == null ? 43 : $renderHeightMapData.hashCode());
   }
}
