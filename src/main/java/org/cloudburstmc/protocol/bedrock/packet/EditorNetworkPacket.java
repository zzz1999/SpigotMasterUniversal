package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class EditorNetworkPacket implements BedrockPacket {
   private Object payload;
   private boolean routeToManager;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.EDITOR_NETWORK;
   }

   public EditorNetworkPacket clone() {
      try {
         return (EditorNetworkPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public Object getPayload() {
      return this.payload;
   }

   public boolean isRouteToManager() {
      return this.routeToManager;
   }

   public void setPayload(final Object payload) {
      this.payload = payload;
   }

   public void setRouteToManager(final boolean routeToManager) {
      this.routeToManager = routeToManager;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EditorNetworkPacket)) {
         return false;
      }

      EditorNetworkPacket other = (EditorNetworkPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.routeToManager != other.routeToManager) {
         return false;
      }

      Object this$payload = this.payload;
      Object other$payload = other.payload;
      return this$payload == null ? other$payload == null : this$payload.equals(other$payload);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EditorNetworkPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.routeToManager ? 79 : 97);
      Object $payload = this.payload;
      return result * 59 + ($payload == null ? 43 : $payload.hashCode());
   }

   @Override
   public String toString() {
      return "EditorNetworkPacket(payload=" + this.payload + ", routeToManager=" + this.routeToManager + ")";
   }
}
