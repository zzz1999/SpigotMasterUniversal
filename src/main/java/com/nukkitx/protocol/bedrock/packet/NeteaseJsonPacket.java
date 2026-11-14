package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class NeteaseJsonPacket implements BedrockPacket {
   private String jsonString;

   public NeteaseJsonPacket() {
   }

   public NeteaseJsonPacket(String jsoString) {
      this.jsonString = jsoString;
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.NETEASE_JSON;
   }

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   public String getJsonString() {
      return this.jsonString;
   }

   public void setJsonString(String jsonString) {
      this.jsonString = jsonString;
   }

   @Override
   public String toString() {
      return "NeteaseJsonPacket(jsonString=" + this.getJsonString() + ")";
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NeteaseJsonPacket)) {
         return false;
      }

      NeteaseJsonPacket other = (NeteaseJsonPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$jsonString = this.jsonString;
      Object other$jsonString = other.jsonString;
      return this$jsonString == null ? other$jsonString == null : this$jsonString.equals(other$jsonString);
   }

   protected boolean canEqual(Object other) {
      return other instanceof NeteaseJsonPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $jsonString = this.jsonString;
      return result * 59 + ($jsonString == null ? 43 : $jsonString.hashCode());
   }
}
