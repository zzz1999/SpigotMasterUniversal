package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.math.vector.Vector3f;

public class UpdateClientInputLocksPacket implements BedrockPacket {
   private int lockComponentData;
   private Vector3f serverPosition;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.UPDATE_CLIENT_INPUT_LOCKS;
   }

   public int getLockComponentData() {
      return this.lockComponentData;
   }

   public Vector3f getServerPosition() {
      return this.serverPosition;
   }

   public void setLockComponentData(int lockComponentData) {
      this.lockComponentData = lockComponentData;
   }

   public void setServerPosition(Vector3f serverPosition) {
      this.serverPosition = serverPosition;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UpdateClientInputLocksPacket)) {
         return false;
      }

      UpdateClientInputLocksPacket other = (UpdateClientInputLocksPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.lockComponentData != other.lockComponentData) {
         return false;
      }

      Object this$serverPosition = this.serverPosition;
      Object other$serverPosition = other.serverPosition;
      return this$serverPosition == null ? other$serverPosition == null : this$serverPosition.equals(other$serverPosition);
   }

   protected boolean canEqual(Object other) {
      return other instanceof UpdateClientInputLocksPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.lockComponentData;
      Object $serverPosition = this.serverPosition;
      return result * 59 + ($serverPosition == null ? 43 : $serverPosition.hashCode());
   }

   @Override
   public String toString() {
      return "UpdateClientInputLocksPacket(lockComponentData=" + this.lockComponentData + ", serverPosition=" + this.serverPosition + ")";
   }
}
