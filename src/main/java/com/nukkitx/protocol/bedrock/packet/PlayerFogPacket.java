package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class PlayerFogPacket implements BedrockPacket {
   private final List<String> fogStack = new ObjectArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAYER_FOG;
   }

   public List<String> getFogStack() {
      return this.fogStack;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlayerFogPacket)) {
         return false;
      }

      PlayerFogPacket other = (PlayerFogPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$fogStack = this.fogStack;
      Object other$fogStack = other.fogStack;
      return this$fogStack == null ? other$fogStack == null : this$fogStack.equals(other$fogStack);
   }

   protected boolean canEqual(Object other) {
      return other instanceof PlayerFogPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $fogStack = this.fogStack;
      return result * 59 + ($fogStack == null ? 43 : $fogStack.hashCode());
   }

   @Override
   public String toString() {
      return "PlayerFogPacket(fogStack=" + this.fogStack + ")";
   }
}
