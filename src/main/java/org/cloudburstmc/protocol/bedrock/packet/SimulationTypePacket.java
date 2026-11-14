package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.SimulationType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class SimulationTypePacket implements BedrockPacket {
   private SimulationType type;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SIMULATION_TYPE;
   }

   public SimulationTypePacket clone() {
      try {
         return (SimulationTypePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public SimulationType getType() {
      return this.type;
   }

   public void setType(final SimulationType type) {
      this.type = type;
   }

   @Override
   public String toString() {
      return "SimulationTypePacket(type=" + this.getType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SimulationTypePacket)) {
         return false;
      }

      SimulationTypePacket other = (SimulationTypePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.type;
      Object other$type = other.type;
      return this$type == null ? other$type == null : this$type.equals(other$type);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SimulationTypePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.type;
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }
}
