package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;

public class PositionTrackingDBClientRequestPacket implements BedrockPacket {
   private PositionTrackingDBClientRequestPacket.Action action;
   private int trackingId;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.POSITION_TRACKING_DB_CLIENT_REQUEST;
   }

   public PositionTrackingDBClientRequestPacket.Action getAction() {
      return this.action;
   }

   public int getTrackingId() {
      return this.trackingId;
   }

   public void setAction(PositionTrackingDBClientRequestPacket.Action action) {
      this.action = action;
   }

   public void setTrackingId(int trackingId) {
      this.trackingId = trackingId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PositionTrackingDBClientRequestPacket)) {
         return false;
      }

      PositionTrackingDBClientRequestPacket other = (PositionTrackingDBClientRequestPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.trackingId != other.trackingId) {
         return false;
      }

      Object this$action = this.action;
      Object other$action = other.action;
      return this$action == null ? other$action == null : this$action.equals(other$action);
   }

   protected boolean canEqual(Object other) {
      return other instanceof PositionTrackingDBClientRequestPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.trackingId;
      Object $action = this.action;
      return result * 59 + ($action == null ? 43 : $action.hashCode());
   }

   @Override
   public String toString() {
      return "PositionTrackingDBClientRequestPacket(action=" + this.action + ", trackingId=" + this.trackingId + ")";
   }

   public enum Action {
      QUERY;
   }
}
