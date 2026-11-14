package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.MultiplayerMode;
import org.cloudburstmc.protocol.common.PacketSignal;

public class MultiplayerSettingsPacket implements BedrockPacket {
   private MultiplayerMode mode;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.MULTIPLAYER_SETTINGS;
   }

   public MultiplayerSettingsPacket clone() {
      try {
         return (MultiplayerSettingsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public MultiplayerMode getMode() {
      return this.mode;
   }

   public void setMode(final MultiplayerMode mode) {
      this.mode = mode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MultiplayerSettingsPacket)) {
         return false;
      }

      MultiplayerSettingsPacket other = (MultiplayerSettingsPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$mode = this.mode;
      Object other$mode = other.mode;
      return this$mode == null ? other$mode == null : this$mode.equals(other$mode);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MultiplayerSettingsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $mode = this.mode;
      return result * 59 + ($mode == null ? 43 : $mode.hashCode());
   }

   @Override
   public String toString() {
      return "MultiplayerSettingsPacket(mode=" + this.mode + ")";
   }
}
