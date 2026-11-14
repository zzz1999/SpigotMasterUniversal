package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.common.PacketSignal;

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

   public PlayerFogPacket clone() {
      try {
         return (PlayerFogPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<String> getFogStack() {
      return this.fogStack;
   }

   @Override
   public boolean equals(final Object o) {
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

   protected boolean canEqual(final Object other) {
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
