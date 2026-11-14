package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.auth.AuthPayload;
import org.cloudburstmc.protocol.common.PacketSignal;

public class SubClientLoginPacket implements BedrockPacket {
   private AuthPayload authPayload;
   private String clientJwt;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SUB_CLIENT_LOGIN;
   }

   public SubClientLoginPacket clone() {
      try {
         return (SubClientLoginPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public AuthPayload getAuthPayload() {
      return this.authPayload;
   }

   public String getClientJwt() {
      return this.clientJwt;
   }

   public void setAuthPayload(final AuthPayload authPayload) {
      this.authPayload = authPayload;
   }

   public void setClientJwt(final String clientJwt) {
      this.clientJwt = clientJwt;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SubClientLoginPacket)) {
         return false;
      } else {
         SubClientLoginPacket other = (SubClientLoginPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$authPayload = this.authPayload;
            Object other$authPayload = other.authPayload;
            if (this$authPayload == null ? other$authPayload == null : this$authPayload.equals(other$authPayload)) {
               Object this$clientJwt = this.clientJwt;
               Object other$clientJwt = other.clientJwt;
               return this$clientJwt == null ? other$clientJwt == null : this$clientJwt.equals(other$clientJwt);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubClientLoginPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $authPayload = this.authPayload;
      result = result * 59 + ($authPayload == null ? 43 : $authPayload.hashCode());
      Object $clientJwt = this.clientJwt;
      return result * 59 + ($clientJwt == null ? 43 : $clientJwt.hashCode());
   }

   @Override
   public String toString() {
      return "SubClientLoginPacket(authPayload=" + this.authPayload + ", clientJwt=" + this.clientJwt + ")";
   }
}
