package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.GraphicsMode;
import org.cloudburstmc.protocol.common.PacketSignal;

public class UpdateClientOptionsPacket implements BedrockPacket {
   private GraphicsMode graphicsMode;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.UPDATE_CLIENT_OPTIONS;
   }

   @Override
   public BedrockPacket clone() {
      try {
         return (UpdateClientOptionsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public GraphicsMode getGraphicsMode() {
      return this.graphicsMode;
   }

   public void setGraphicsMode(final GraphicsMode graphicsMode) {
      this.graphicsMode = graphicsMode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UpdateClientOptionsPacket)) {
         return false;
      }

      UpdateClientOptionsPacket other = (UpdateClientOptionsPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$graphicsMode = this.graphicsMode;
      Object other$graphicsMode = other.graphicsMode;
      return this$graphicsMode == null ? other$graphicsMode == null : this$graphicsMode.equals(other$graphicsMode);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UpdateClientOptionsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $graphicsMode = this.graphicsMode;
      return result * 59 + ($graphicsMode == null ? 43 : $graphicsMode.hashCode());
   }

   @Override
   public String toString() {
      return "UpdateClientOptionsPacket(graphicsMode=" + this.graphicsMode + ")";
   }
}
