package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ChangeDimensionPacket implements BedrockPacket {
   private int dimension;
   private Vector3f position;
   private boolean respawn;
   private Integer loadingScreenId;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CHANGE_DIMENSION;
   }

   public ChangeDimensionPacket clone() {
      try {
         return (ChangeDimensionPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getDimension() {
      return this.dimension;
   }

   public Vector3f getPosition() {
      return this.position;
   }

   public boolean isRespawn() {
      return this.respawn;
   }

   public Integer getLoadingScreenId() {
      return this.loadingScreenId;
   }

   public void setDimension(final int dimension) {
      this.dimension = dimension;
   }

   public void setPosition(final Vector3f position) {
      this.position = position;
   }

   public void setRespawn(final boolean respawn) {
      this.respawn = respawn;
   }

   public void setLoadingScreenId(final Integer loadingScreenId) {
      this.loadingScreenId = loadingScreenId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ChangeDimensionPacket)) {
         return false;
      } else {
         ChangeDimensionPacket other = (ChangeDimensionPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.dimension != other.dimension) {
            return false;
         } else if (this.respawn != other.respawn) {
            return false;
         } else {
            Object this$loadingScreenId = this.loadingScreenId;
            Object other$loadingScreenId = other.loadingScreenId;
            if (this$loadingScreenId == null ? other$loadingScreenId == null : this$loadingScreenId.equals(other$loadingScreenId)) {
               Object this$position = this.position;
               Object other$position = other.position;
               return this$position == null ? other$position == null : this$position.equals(other$position);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ChangeDimensionPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.dimension;
      result = result * 59 + (this.respawn ? 79 : 97);
      Object $loadingScreenId = this.loadingScreenId;
      result = result * 59 + ($loadingScreenId == null ? 43 : $loadingScreenId.hashCode());
      Object $position = this.position;
      return result * 59 + ($position == null ? 43 : $position.hashCode());
   }

   @Override
   public String toString() {
      return "ChangeDimensionPacket(dimension="
         + this.dimension
         + ", position="
         + this.position
         + ", respawn="
         + this.respawn
         + ", loadingScreenId="
         + this.loadingScreenId
         + ")";
   }
}
