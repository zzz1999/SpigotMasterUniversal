package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.AbilityLayer;
import com.nukkitx.protocol.bedrock.data.PlayerAbilityHolder;
import com.nukkitx.protocol.bedrock.data.PlayerPermission;
import com.nukkitx.protocol.bedrock.data.command.CommandPermission;
import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class UpdateAbilitiesPacket implements BedrockPacket, PlayerAbilityHolder {
   private long uniqueEntityId;
   private PlayerPermission playerPermission;
   private CommandPermission commandPermission;
   private List<AbilityLayer> abilityLayers = new ObjectArrayList<>();

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.UPDATE_ABILITIES;
   }

   @Override
   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   @Override
   public PlayerPermission getPlayerPermission() {
      return this.playerPermission;
   }

   @Override
   public CommandPermission getCommandPermission() {
      return this.commandPermission;
   }

   @Override
   public List<AbilityLayer> getAbilityLayers() {
      return this.abilityLayers;
   }

   @Override
   public void setUniqueEntityId(long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   @Override
   public void setPlayerPermission(PlayerPermission playerPermission) {
      this.playerPermission = playerPermission;
   }

   @Override
   public void setCommandPermission(CommandPermission commandPermission) {
      this.commandPermission = commandPermission;
   }

   @Override
   public void setAbilityLayers(List<AbilityLayer> abilityLayers) {
      this.abilityLayers = abilityLayers;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UpdateAbilitiesPacket)) {
         return false;
      }

      UpdateAbilitiesPacket other = (UpdateAbilitiesPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.uniqueEntityId != other.uniqueEntityId) {
         return false;
      }

      Object this$playerPermission = this.playerPermission;
      Object other$playerPermission = other.playerPermission;
      if (this$playerPermission == null ? other$playerPermission == null : this$playerPermission.equals(other$playerPermission)) {
         Object this$commandPermission = this.commandPermission;
         Object other$commandPermission = other.commandPermission;
         if (this$commandPermission == null ? other$commandPermission == null : this$commandPermission.equals(other$commandPermission)) {
            Object this$abilityLayers = this.abilityLayers;
            Object other$abilityLayers = other.abilityLayers;
            return this$abilityLayers == null ? other$abilityLayers == null : this$abilityLayers.equals(other$abilityLayers);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof UpdateAbilitiesPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueEntityId = this.uniqueEntityId;
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      Object $playerPermission = this.playerPermission;
      result = result * 59 + ($playerPermission == null ? 43 : $playerPermission.hashCode());
      Object $commandPermission = this.commandPermission;
      result = result * 59 + ($commandPermission == null ? 43 : $commandPermission.hashCode());
      Object $abilityLayers = this.abilityLayers;
      return result * 59 + ($abilityLayers == null ? 43 : $abilityLayers.hashCode());
   }

   @Override
   public String toString() {
      return "UpdateAbilitiesPacket(uniqueEntityId="
         + this.uniqueEntityId
         + ", playerPermission="
         + this.playerPermission
         + ", commandPermission="
         + this.commandPermission
         + ", abilityLayers="
         + this.abilityLayers
         + ")";
   }
}
