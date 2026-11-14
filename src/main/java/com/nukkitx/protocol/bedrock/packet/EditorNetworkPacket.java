package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class EditorNetworkPacket implements BedrockPacket {
   private Object payload;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.EDITOR_NETWORK;
   }

   public Object getPayload() {
      return this.payload;
   }

   public void setPayload(Object payload) {
      this.payload = payload;
   }

   @Override
   public boolean equals(Object o) {
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

      Object this$payload = this.payload;
      Object other$payload = other.payload;
      return this$payload == null ? other$payload == null : this$payload.equals(other$payload);
   }

   protected boolean canEqual(Object other) {
      return other instanceof EditorNetworkPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $payload = this.payload;
      return result * 59 + ($payload == null ? 43 : $payload.hashCode());
   }

   @Override
   public String toString() {
      return "EditorNetworkPacket(payload=" + this.payload + ")";
   }
}
