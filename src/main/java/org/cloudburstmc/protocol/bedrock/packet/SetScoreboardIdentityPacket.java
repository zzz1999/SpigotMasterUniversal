package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.UUID;
import org.cloudburstmc.protocol.common.PacketSignal;

public class SetScoreboardIdentityPacket implements BedrockPacket {
   private final List<SetScoreboardIdentityPacket.Entry> entries = new ObjectArrayList<>();
   private SetScoreboardIdentityPacket.Action action;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_SCOREBOARD_IDENTITY;
   }

   public SetScoreboardIdentityPacket clone() {
      try {
         return (SetScoreboardIdentityPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<SetScoreboardIdentityPacket.Entry> getEntries() {
      return this.entries;
   }

   public SetScoreboardIdentityPacket.Action getAction() {
      return this.action;
   }

   public void setAction(final SetScoreboardIdentityPacket.Action action) {
      this.action = action;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SetScoreboardIdentityPacket)) {
         return false;
      } else {
         SetScoreboardIdentityPacket other = (SetScoreboardIdentityPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$entries = this.entries;
            Object other$entries = other.entries;
            if (this$entries == null ? other$entries == null : this$entries.equals(other$entries)) {
               Object this$action = this.action;
               Object other$action = other.action;
               return this$action == null ? other$action == null : this$action.equals(other$action);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SetScoreboardIdentityPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $entries = this.entries;
      result = result * 59 + ($entries == null ? 43 : $entries.hashCode());
      Object $action = this.action;
      return result * 59 + ($action == null ? 43 : $action.hashCode());
   }

   @Override
   public String toString() {
      return "SetScoreboardIdentityPacket(entries=" + this.entries + ", action=" + this.action + ")";
   }

   public enum Action {
      ADD,
      REMOVE;
   }

   public static final class Entry {
      private final long scoreboardId;
      private final UUID uuid;

      public Entry(final long scoreboardId, final UUID uuid) {
         this.scoreboardId = scoreboardId;
         this.uuid = uuid;
      }

      public long getScoreboardId() {
         return this.scoreboardId;
      }

      public UUID getUuid() {
         return this.uuid;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof SetScoreboardIdentityPacket.Entry)) {
            return false;
         }

         SetScoreboardIdentityPacket.Entry other = (SetScoreboardIdentityPacket.Entry)o;
         if (this.getScoreboardId() != other.getScoreboardId()) {
            return false;
         }

         Object this$uuid = this.getUuid();
         Object other$uuid = other.getUuid();
         return this$uuid == null ? other$uuid == null : this$uuid.equals(other$uuid);
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         long $scoreboardId = this.getScoreboardId();
         result = result * 59 + (int)($scoreboardId >>> 32 ^ $scoreboardId);
         Object $uuid = this.getUuid();
         return result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
      }

      @Override
      public String toString() {
         return "SetScoreboardIdentityPacket.Entry(scoreboardId=" + this.getScoreboardId() + ", uuid=" + this.getUuid() + ")";
      }
   }
}
