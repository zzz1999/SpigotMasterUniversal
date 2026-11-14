package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.event.EventData;
import org.cloudburstmc.protocol.common.PacketSignal;

public class EventPacket implements BedrockPacket {
   private long uniqueEntityId;
   private boolean usePlayerId;
   private EventData eventData;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.EVENT;
   }

   public EventPacket clone() {
      try {
         return (EventPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public boolean isUsePlayerId() {
      return this.usePlayerId;
   }

   public EventData getEventData() {
      return this.eventData;
   }

   public void setUniqueEntityId(final long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   public void setUsePlayerId(final boolean usePlayerId) {
      this.usePlayerId = usePlayerId;
   }

   public void setEventData(final EventData eventData) {
      this.eventData = eventData;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EventPacket)) {
         return false;
      }

      EventPacket other = (EventPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.uniqueEntityId != other.uniqueEntityId) {
         return false;
      }

      if (this.usePlayerId != other.usePlayerId) {
         return false;
      }

      Object this$eventData = this.eventData;
      Object other$eventData = other.eventData;
      return this$eventData == null ? other$eventData == null : this$eventData.equals(other$eventData);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EventPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueEntityId = this.uniqueEntityId;
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      result = result * 59 + (this.usePlayerId ? 79 : 97);
      Object $eventData = this.eventData;
      return result * 59 + ($eventData == null ? 43 : $eventData.hashCode());
   }

   @Override
   public String toString() {
      return "EventPacket(uniqueEntityId=" + this.uniqueEntityId + ", usePlayerId=" + this.usePlayerId + ", eventData=" + this.eventData + ")";
   }

   public enum Event {
      ACHIEVEMENT_AWARDED,
      ENTITY_INTERACT,
      PORTAL_BUILT,
      PORTAL_USED,
      MOB_KILLED,
      CAULDRON_USED,
      PLAYER_DEATH,
      BOSS_KILLED,
      @Deprecated
      AGENT_COMMAND,
      AGENT_CREATED,
      PATTERN_REMOVED,
      SLASH_COMMAND_EXECUTED,
      FISH_BUCKETED,
      MOB_BORN,
      PET_DIED,
      CAULDRON_BLOCK_USED,
      COMPOSTER_BLOCK_USED,
      BELL_BLOCK_USED;
   }
}
