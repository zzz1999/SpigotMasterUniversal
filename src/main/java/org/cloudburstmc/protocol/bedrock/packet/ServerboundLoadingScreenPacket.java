package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.ServerboundLoadingScreenPacketType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ServerboundLoadingScreenPacket implements BedrockPacket {
   private ServerboundLoadingScreenPacketType type;
   private Integer loadingScreenId;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SERVERBOUND_LOADING_SCREEN;
   }

   public ServerboundLoadingScreenPacket clone() {
      try {
         return (ServerboundLoadingScreenPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public ServerboundLoadingScreenPacketType getType() {
      return this.type;
   }

   public Integer getLoadingScreenId() {
      return this.loadingScreenId;
   }

   public void setType(final ServerboundLoadingScreenPacketType type) {
      this.type = type;
   }

   public void setLoadingScreenId(final Integer loadingScreenId) {
      this.loadingScreenId = loadingScreenId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ServerboundLoadingScreenPacket)) {
         return false;
      } else {
         ServerboundLoadingScreenPacket other = (ServerboundLoadingScreenPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$loadingScreenId = this.loadingScreenId;
            Object other$loadingScreenId = other.loadingScreenId;
            if (this$loadingScreenId == null ? other$loadingScreenId == null : this$loadingScreenId.equals(other$loadingScreenId)) {
               Object this$type = this.type;
               Object other$type = other.type;
               return this$type == null ? other$type == null : this$type.equals(other$type);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ServerboundLoadingScreenPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $loadingScreenId = this.loadingScreenId;
      result = result * 59 + ($loadingScreenId == null ? 43 : $loadingScreenId.hashCode());
      Object $type = this.type;
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "ServerboundLoadingScreenPacket(type=" + this.type + ", loadingScreenId=" + this.loadingScreenId + ")";
   }
}
