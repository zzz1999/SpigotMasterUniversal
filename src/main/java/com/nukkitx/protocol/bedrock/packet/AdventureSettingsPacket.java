package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.AdventureSetting;
import com.nukkitx.protocol.bedrock.data.PlayerPermission;
import com.nukkitx.protocol.bedrock.data.command.CommandPermission;
import com.nukkitx.protocol.common.PacketSignal;
import java.util.EnumSet;
import java.util.Set;

@Deprecated
public class AdventureSettingsPacket implements BedrockPacket {
   private final Set<AdventureSetting> settings = EnumSet.noneOf(AdventureSetting.class);
   private CommandPermission commandPermission = CommandPermission.ANY;
   private PlayerPermission playerPermission = PlayerPermission.VISITOR;
   private long uniqueEntityId;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ADVENTURE_SETTINGS;
   }

   public Set<AdventureSetting> getSettings() {
      return this.settings;
   }

   public CommandPermission getCommandPermission() {
      return this.commandPermission;
   }

   public PlayerPermission getPlayerPermission() {
      return this.playerPermission;
   }

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public void setCommandPermission(CommandPermission commandPermission) {
      this.commandPermission = commandPermission;
   }

   public void setPlayerPermission(PlayerPermission playerPermission) {
      this.playerPermission = playerPermission;
   }

   public void setUniqueEntityId(long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AdventureSettingsPacket)) {
         return false;
      }

      AdventureSettingsPacket other = (AdventureSettingsPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.uniqueEntityId != other.uniqueEntityId) {
         return false;
      }

      Object this$settings = this.settings;
      Object other$settings = other.settings;
      if (this$settings == null ? other$settings == null : this$settings.equals(other$settings)) {
         Object this$commandPermission = this.commandPermission;
         Object other$commandPermission = other.commandPermission;
         if (this$commandPermission == null ? other$commandPermission == null : this$commandPermission.equals(other$commandPermission)) {
            Object this$playerPermission = this.playerPermission;
            Object other$playerPermission = other.playerPermission;
            return this$playerPermission == null ? other$playerPermission == null : this$playerPermission.equals(other$playerPermission);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof AdventureSettingsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueEntityId = this.uniqueEntityId;
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      Object $settings = this.settings;
      result = result * 59 + ($settings == null ? 43 : $settings.hashCode());
      Object $commandPermission = this.commandPermission;
      result = result * 59 + ($commandPermission == null ? 43 : $commandPermission.hashCode());
      Object $playerPermission = this.playerPermission;
      return result * 59 + ($playerPermission == null ? 43 : $playerPermission.hashCode());
   }

   @Override
   public String toString() {
      return "AdventureSettingsPacket(settings="
         + this.settings
         + ", commandPermission="
         + this.commandPermission
         + ", playerPermission="
         + this.playerPermission
         + ", uniqueEntityId="
         + this.uniqueEntityId
         + ")";
   }
}
