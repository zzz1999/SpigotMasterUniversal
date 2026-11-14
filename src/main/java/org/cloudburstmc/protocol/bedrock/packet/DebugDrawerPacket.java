package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.debugshape.DebugShape;
import org.cloudburstmc.protocol.common.PacketSignal;

public class DebugDrawerPacket implements BedrockPacket {
   private final List<DebugShape> shapes = new ObjectArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.DEBUG_DRAWER;
   }

   @Override
   public BedrockPacket clone() {
      try {
         return (DebugDrawerPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new RuntimeException(e);
      }
   }

   public List<DebugShape> getShapes() {
      return this.shapes;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DebugDrawerPacket)) {
         return false;
      }

      DebugDrawerPacket other = (DebugDrawerPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$shapes = this.shapes;
      Object other$shapes = other.shapes;
      return this$shapes == null ? other$shapes == null : this$shapes.equals(other$shapes);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DebugDrawerPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $shapes = this.shapes;
      return result * 59 + ($shapes == null ? 43 : $shapes.hashCode());
   }

   @Override
   public String toString() {
      return "DebugDrawerPacket(shapes=" + this.shapes + ")";
   }
}
