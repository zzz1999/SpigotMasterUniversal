package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class ShowCreditsPacket implements BedrockPacket {
   private long runtimeEntityId;
   private ShowCreditsPacket.Status status;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SHOW_CREDITS;
   }

   public ShowCreditsPacket clone() {
      try {
         return (ShowCreditsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public ShowCreditsPacket.Status getStatus() {
      return this.status;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setStatus(final ShowCreditsPacket.Status status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ShowCreditsPacket)) {
         return false;
      }

      ShowCreditsPacket other = (ShowCreditsPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      Object this$status = this.status;
      Object other$status = other.status;
      return this$status == null ? other$status == null : this$status.equals(other$status);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ShowCreditsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      Object $status = this.status;
      return result * 59 + ($status == null ? 43 : $status.hashCode());
   }

   @Override
   public String toString() {
      return "ShowCreditsPacket(runtimeEntityId=" + this.runtimeEntityId + ", status=" + this.status + ")";
   }

   public enum Status {
      START_CREDITS,
      END_CREDITS;
   }
}
