package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class CameraPacket implements BedrockPacket {
   private long cameraUniqueEntityId;
   private long playerUniqueEntityId;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CAMERA;
   }

   public CameraPacket clone() {
      try {
         return (CameraPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getCameraUniqueEntityId() {
      return this.cameraUniqueEntityId;
   }

   public long getPlayerUniqueEntityId() {
      return this.playerUniqueEntityId;
   }

   public void setCameraUniqueEntityId(final long cameraUniqueEntityId) {
      this.cameraUniqueEntityId = cameraUniqueEntityId;
   }

   public void setPlayerUniqueEntityId(final long playerUniqueEntityId) {
      this.playerUniqueEntityId = playerUniqueEntityId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CameraPacket)) {
         return false;
      } else {
         CameraPacket other = (CameraPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            return this.cameraUniqueEntityId != other.cameraUniqueEntityId ? false : this.playerUniqueEntityId == other.playerUniqueEntityId;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CameraPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $cameraUniqueEntityId = this.cameraUniqueEntityId;
      result = result * 59 + (int)($cameraUniqueEntityId >>> 32 ^ $cameraUniqueEntityId);
      long $playerUniqueEntityId = this.playerUniqueEntityId;
      return result * 59 + (int)($playerUniqueEntityId >>> 32 ^ $playerUniqueEntityId);
   }

   @Override
   public String toString() {
      return "CameraPacket(cameraUniqueEntityId=" + this.cameraUniqueEntityId + ", playerUniqueEntityId=" + this.playerUniqueEntityId + ")";
   }
}
