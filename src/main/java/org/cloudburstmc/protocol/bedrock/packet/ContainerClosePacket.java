package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.inventory.ContainerType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ContainerClosePacket implements BedrockPacket {
   private byte id;
   private boolean serverInitiated;
   private ContainerType type;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CONTAINER_CLOSE;
   }

   public ContainerClosePacket clone() {
      try {
         return (ContainerClosePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public byte getId() {
      return this.id;
   }

   public boolean isServerInitiated() {
      return this.serverInitiated;
   }

   public ContainerType getType() {
      return this.type;
   }

   public void setId(final byte id) {
      this.id = id;
   }

   public void setServerInitiated(final boolean serverInitiated) {
      this.serverInitiated = serverInitiated;
   }

   public void setType(final ContainerType type) {
      this.type = type;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContainerClosePacket)) {
         return false;
      }

      ContainerClosePacket other = (ContainerClosePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.id != other.id) {
         return false;
      }

      if (this.serverInitiated != other.serverInitiated) {
         return false;
      }

      Object this$type = this.type;
      Object other$type = other.type;
      return this$type == null ? other$type == null : this$type.equals(other$type);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContainerClosePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.id;
      result = result * 59 + (this.serverInitiated ? 79 : 97);
      Object $type = this.type;
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "ContainerClosePacket(id=" + this.id + ", serverInitiated=" + this.serverInitiated + ", type=" + this.type + ")";
   }
}
