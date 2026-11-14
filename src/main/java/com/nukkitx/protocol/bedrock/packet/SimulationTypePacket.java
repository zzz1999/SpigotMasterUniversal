package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.SimulationType;
import com.nukkitx.protocol.common.PacketSignal;

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

   public SimulationType getType() {
      return this.type;
   }

   public void setType(SimulationType type) {
      this.type = type;
   }

   @Override
   public String toString() {
      return "SimulationTypePacket(type=" + this.getType() + ")";
   }

   @Override
   public boolean equals(Object o) {
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

   protected boolean canEqual(Object other) {
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
