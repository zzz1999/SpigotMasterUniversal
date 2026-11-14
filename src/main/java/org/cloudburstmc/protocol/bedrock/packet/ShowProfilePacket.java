package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class ShowProfilePacket implements BedrockPacket {
   private String xuid;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SHOW_PROFILE;
   }

   public ShowProfilePacket clone() {
      try {
         return (ShowProfilePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getXuid() {
      return this.xuid;
   }

   public void setXuid(final String xuid) {
      this.xuid = xuid;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ShowProfilePacket)) {
         return false;
      }

      ShowProfilePacket other = (ShowProfilePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$xuid = this.xuid;
      Object other$xuid = other.xuid;
      return this$xuid == null ? other$xuid == null : this$xuid.equals(other$xuid);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ShowProfilePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $xuid = this.xuid;
      return result * 59 + ($xuid == null ? 43 : $xuid.hashCode());
   }

   @Override
   public String toString() {
      return "ShowProfilePacket(xuid=" + this.xuid + ")";
   }
}
