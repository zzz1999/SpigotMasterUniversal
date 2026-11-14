package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class ServerboundDataStorePacket implements BedrockPacket {
   private String dataStoreName;
   private String property;
   private String path;
   private Object data;
   private int updateCount;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SERVERBOUND_DATA_STORE;
   }

   public ServerboundDataStorePacket clone() {
      try {
         return (ServerboundDataStorePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getDataStoreName() {
      return this.dataStoreName;
   }

   public String getProperty() {
      return this.property;
   }

   public String getPath() {
      return this.path;
   }

   public Object getData() {
      return this.data;
   }

   public int getUpdateCount() {
      return this.updateCount;
   }

   public void setDataStoreName(final String dataStoreName) {
      this.dataStoreName = dataStoreName;
   }

   public void setProperty(final String property) {
      this.property = property;
   }

   public void setPath(final String path) {
      this.path = path;
   }

   public void setData(final Object data) {
      this.data = data;
   }

   public void setUpdateCount(final int updateCount) {
      this.updateCount = updateCount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ServerboundDataStorePacket)) {
         return false;
      }

      ServerboundDataStorePacket other = (ServerboundDataStorePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.updateCount != other.updateCount) {
         return false;
      }

      Object this$dataStoreName = this.dataStoreName;
      Object other$dataStoreName = other.dataStoreName;
      if (this$dataStoreName == null ? other$dataStoreName == null : this$dataStoreName.equals(other$dataStoreName)) {
         Object this$property = this.property;
         Object other$property = other.property;
         if (this$property == null ? other$property == null : this$property.equals(other$property)) {
            Object this$path = this.path;
            Object other$path = other.path;
            if (this$path == null ? other$path == null : this$path.equals(other$path)) {
               Object this$data = this.data;
               Object other$data = other.data;
               return this$data == null ? other$data == null : this$data.equals(other$data);
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
      return other instanceof ServerboundDataStorePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.updateCount;
      Object $dataStoreName = this.dataStoreName;
      result = result * 59 + ($dataStoreName == null ? 43 : $dataStoreName.hashCode());
      Object $property = this.property;
      result = result * 59 + ($property == null ? 43 : $property.hashCode());
      Object $path = this.path;
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $data = this.data;
      return result * 59 + ($data == null ? 43 : $data.hashCode());
   }

   @Override
   public String toString() {
      return "ServerboundDataStorePacket(dataStoreName="
         + this.dataStoreName
         + ", property="
         + this.property
         + ", path="
         + this.path
         + ", data="
         + this.data
         + ", updateCount="
         + this.updateCount
         + ")";
   }
}
