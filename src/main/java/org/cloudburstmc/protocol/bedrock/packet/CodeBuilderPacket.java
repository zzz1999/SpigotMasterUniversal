package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class CodeBuilderPacket implements BedrockPacket {
   private String url;
   private boolean opening;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CODE_BUILDER;
   }

   public CodeBuilderPacket clone() {
      try {
         return (CodeBuilderPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getUrl() {
      return this.url;
   }

   public boolean isOpening() {
      return this.opening;
   }

   public void setUrl(final String url) {
      this.url = url;
   }

   public void setOpening(final boolean opening) {
      this.opening = opening;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CodeBuilderPacket)) {
         return false;
      }

      CodeBuilderPacket other = (CodeBuilderPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.opening != other.opening) {
         return false;
      }

      Object this$url = this.url;
      Object other$url = other.url;
      return this$url == null ? other$url == null : this$url.equals(other$url);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CodeBuilderPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.opening ? 79 : 97);
      Object $url = this.url;
      return result * 59 + ($url == null ? 43 : $url.hashCode());
   }

   @Override
   public String toString() {
      return "CodeBuilderPacket(url=" + this.url + ", opening=" + this.opening + ")";
   }
}
