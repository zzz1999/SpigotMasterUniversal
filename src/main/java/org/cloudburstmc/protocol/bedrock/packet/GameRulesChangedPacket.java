package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.GameRuleData;
import org.cloudburstmc.protocol.common.PacketSignal;

public class GameRulesChangedPacket implements BedrockPacket {
   private final List<GameRuleData<?>> gameRules = new ObjectArrayList<>();

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.GAME_RULES_CHANGED;
   }

   public GameRulesChangedPacket clone() {
      try {
         return (GameRulesChangedPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<GameRuleData<?>> getGameRules() {
      return this.gameRules;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof GameRulesChangedPacket)) {
         return false;
      }

      GameRulesChangedPacket other = (GameRulesChangedPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$gameRules = this.gameRules;
      Object other$gameRules = other.gameRules;
      return this$gameRules == null ? other$gameRules == null : this$gameRules.equals(other$gameRules);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof GameRulesChangedPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $gameRules = this.gameRules;
      return result * 59 + ($gameRules == null ? 43 : $gameRules.hashCode());
   }

   @Override
   public String toString() {
      return "GameRulesChangedPacket(gameRules=" + this.gameRules + ")";
   }
}
