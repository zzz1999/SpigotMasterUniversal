package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.ScoreInfo;
import org.cloudburstmc.protocol.common.PacketSignal;

public class SetScorePacket implements BedrockPacket {
   private SetScorePacket.Action action;
   private List<ScoreInfo> infos = new ObjectArrayList<>();

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_SCORE;
   }

   public SetScorePacket clone() {
      try {
         return (SetScorePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public SetScorePacket.Action getAction() {
      return this.action;
   }

   public List<ScoreInfo> getInfos() {
      return this.infos;
   }

   public void setAction(final SetScorePacket.Action action) {
      this.action = action;
   }

   public void setInfos(final List<ScoreInfo> infos) {
      this.infos = infos;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SetScorePacket)) {
         return false;
      } else {
         SetScorePacket other = (SetScorePacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$action = this.action;
            Object other$action = other.action;
            if (this$action == null ? other$action == null : this$action.equals(other$action)) {
               Object this$infos = this.infos;
               Object other$infos = other.infos;
               return this$infos == null ? other$infos == null : this$infos.equals(other$infos);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SetScorePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $action = this.action;
      result = result * 59 + ($action == null ? 43 : $action.hashCode());
      Object $infos = this.infos;
      return result * 59 + ($infos == null ? 43 : $infos.hashCode());
   }

   @Override
   public String toString() {
      return "SetScorePacket(action=" + this.action + ", infos=" + this.infos + ")";
   }

   public enum Action {
      SET,
      REMOVE;
   }
}
