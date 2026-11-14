package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class TickingAreasLoadStatusPacket implements BedrockPacket {
   boolean waitingForPreload;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.TICKING_AREAS_LOAD_STATUS;
   }

   public TickingAreasLoadStatusPacket clone() {
      try {
         return (TickingAreasLoadStatusPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public boolean isWaitingForPreload() {
      return this.waitingForPreload;
   }

   public void setWaitingForPreload(final boolean waitingForPreload) {
      this.waitingForPreload = waitingForPreload;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TickingAreasLoadStatusPacket)) {
         return false;
      }

      TickingAreasLoadStatusPacket other = (TickingAreasLoadStatusPacket)o;
      return !other.canEqual(this) ? false : this.waitingForPreload == other.waitingForPreload;
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TickingAreasLoadStatusPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + (this.waitingForPreload ? 79 : 97);
   }

   @Override
   public String toString() {
      return "TickingAreasLoadStatusPacket(waitingForPreload=" + this.waitingForPreload + ")";
   }
}
