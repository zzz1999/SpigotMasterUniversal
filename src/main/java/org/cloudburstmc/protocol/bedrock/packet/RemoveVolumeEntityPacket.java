package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class RemoveVolumeEntityPacket implements BedrockPacket {
   private int id;
   private int dimension;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.REMOVE_VOLUME_ENTITY;
   }

   public RemoveVolumeEntityPacket clone() {
      try {
         return (RemoveVolumeEntityPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getId() {
      return this.id;
   }

   public int getDimension() {
      return this.dimension;
   }

   public void setId(final int id) {
      this.id = id;
   }

   public void setDimension(final int dimension) {
      this.dimension = dimension;
   }

   @Override
   public String toString() {
      return "RemoveVolumeEntityPacket(id=" + this.getId() + ", dimension=" + this.getDimension() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof RemoveVolumeEntityPacket)) {
         return false;
      } else {
         RemoveVolumeEntityPacket other = (RemoveVolumeEntityPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            return this.id != other.id ? false : this.dimension == other.dimension;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RemoveVolumeEntityPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.id;
      return result * 59 + this.dimension;
   }
}
