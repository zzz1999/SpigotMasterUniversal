package org.cloudburstmc.protocol.bedrock.packet;

import java.util.ArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.inventory.EnchantOptionData;
import org.cloudburstmc.protocol.common.PacketSignal;

public class PlayerEnchantOptionsPacket implements BedrockPacket {
   private final List<EnchantOptionData> options = new ArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAYER_ENCHANT_OPTIONS;
   }

   public PlayerEnchantOptionsPacket clone() {
      try {
         return (PlayerEnchantOptionsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<EnchantOptionData> getOptions() {
      return this.options;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlayerEnchantOptionsPacket)) {
         return false;
      }

      PlayerEnchantOptionsPacket other = (PlayerEnchantOptionsPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$options = this.getOptions();
      Object other$options = other.getOptions();
      return this$options == null ? other$options == null : this$options.equals(other$options);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlayerEnchantOptionsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $options = this.getOptions();
      return result * 59 + ($options == null ? 43 : $options.hashCode());
   }

   @Override
   public String toString() {
      return "PlayerEnchantOptionsPacket(options=" + this.options + ")";
   }
}
