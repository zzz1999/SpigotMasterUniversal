package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.UUID;

public class EmoteListPacket implements BedrockPacket {
   private long runtimeEntityId;
   private final List<UUID> pieceIds = new ObjectArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.EMOTE_LIST;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public List<UUID> getPieceIds() {
      return this.pieceIds;
   }

   public void setRuntimeEntityId(long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EmoteListPacket)) {
         return false;
      }

      EmoteListPacket other = (EmoteListPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      Object this$pieceIds = this.pieceIds;
      Object other$pieceIds = other.pieceIds;
      return this$pieceIds == null ? other$pieceIds == null : this$pieceIds.equals(other$pieceIds);
   }

   protected boolean canEqual(Object other) {
      return other instanceof EmoteListPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      Object $pieceIds = this.pieceIds;
      return result * 59 + ($pieceIds == null ? 43 : $pieceIds.hashCode());
   }

   @Override
   public String toString() {
      return "EmoteListPacket(runtimeEntityId=" + this.runtimeEntityId + ", pieceIds=" + this.pieceIds + ")";
   }
}
