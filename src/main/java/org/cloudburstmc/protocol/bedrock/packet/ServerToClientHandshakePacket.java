package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.annotation.NoEncryption;
import org.cloudburstmc.protocol.common.PacketSignal;

@NoEncryption
public class ServerToClientHandshakePacket implements BedrockPacket {
   private String jwt;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SERVER_TO_CLIENT_HANDSHAKE;
   }

   public ServerToClientHandshakePacket clone() {
      try {
         return (ServerToClientHandshakePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getJwt() {
      return this.jwt;
   }

   public void setJwt(final String jwt) {
      this.jwt = jwt;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ServerToClientHandshakePacket)) {
         return false;
      }

      ServerToClientHandshakePacket other = (ServerToClientHandshakePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$jwt = this.jwt;
      Object other$jwt = other.jwt;
      return this$jwt == null ? other$jwt == null : this$jwt.equals(other$jwt);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ServerToClientHandshakePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $jwt = this.jwt;
      return result * 59 + ($jwt == null ? 43 : $jwt.hashCode());
   }

   @Override
   public String toString() {
      return "ServerToClientHandshakePacket(jwt=" + this.jwt + ")";
   }
}
