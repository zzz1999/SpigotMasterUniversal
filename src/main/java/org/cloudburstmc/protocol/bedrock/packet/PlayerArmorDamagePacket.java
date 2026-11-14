package org.cloudburstmc.protocol.bedrock.packet;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import org.cloudburstmc.protocol.bedrock.data.PlayerArmorDamageFlag;
import org.cloudburstmc.protocol.common.PacketSignal;

public class PlayerArmorDamagePacket implements BedrockPacket {
   private final Set<PlayerArmorDamageFlag> flags = EnumSet.noneOf(PlayerArmorDamageFlag.class);
   private final int[] damage = new int[5];

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAYER_ARMOR_DAMAGE;
   }

   public PlayerArmorDamagePacket clone() {
      try {
         return (PlayerArmorDamagePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public Set<PlayerArmorDamageFlag> getFlags() {
      return this.flags;
   }

   public int[] getDamage() {
      return this.damage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlayerArmorDamagePacket)) {
         return false;
      }

      PlayerArmorDamagePacket other = (PlayerArmorDamagePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$flags = this.flags;
      Object other$flags = other.flags;
      return (this$flags == null ? other$flags == null : this$flags.equals(other$flags)) ? Arrays.equals(this.damage, other.damage) : false;
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlayerArmorDamagePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $flags = this.flags;
      result = result * 59 + ($flags == null ? 43 : $flags.hashCode());
      return result * 59 + Arrays.hashCode(this.damage);
   }

   @Override
   public String toString() {
      return "PlayerArmorDamagePacket(flags=" + this.flags + ", damage=" + Arrays.toString(this.damage) + ")";
   }
}
