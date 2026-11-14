package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class ContainerClosePacket implements BedrockPacket {
   private byte id;
   private boolean serverInitiated;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CONTAINER_CLOSE;
   }

   public byte getId() {
      return this.id;
   }

   public boolean isServerInitiated() {
      return this.serverInitiated;
   }

   public void setId(byte id) {
      this.id = id;
   }

   public void setServerInitiated(boolean serverInitiated) {
      this.serverInitiated = serverInitiated;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ContainerClosePacket)) {
         return false;
      } else {
         ContainerClosePacket other = (ContainerClosePacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            return this.id != other.id ? false : this.serverInitiated == other.serverInitiated;
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof ContainerClosePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.id;
      return result * 59 + (this.serverInitiated ? 79 : 97);
   }

   @Override
   public String toString() {
      return "ContainerClosePacket(id=" + this.id + ", serverInitiated=" + this.serverInitiated + ")";
   }
}
