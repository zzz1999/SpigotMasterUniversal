package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.PacketViolationSeverity;
import com.nukkitx.protocol.bedrock.data.PacketViolationType;
import com.nukkitx.protocol.common.PacketSignal;

public class PacketViolationWarningPacket implements BedrockPacket {
   private PacketViolationType type;
   private PacketViolationSeverity severity;
   private int packetCauseId;
   private String context;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PACKET_VIOLATION_WARNING;
   }

   public PacketViolationType getType() {
      return this.type;
   }

   public PacketViolationSeverity getSeverity() {
      return this.severity;
   }

   public int getPacketCauseId() {
      return this.packetCauseId;
   }

   public String getContext() {
      return this.context;
   }

   public void setType(PacketViolationType type) {
      this.type = type;
   }

   public void setSeverity(PacketViolationSeverity severity) {
      this.severity = severity;
   }

   public void setPacketCauseId(int packetCauseId) {
      this.packetCauseId = packetCauseId;
   }

   public void setContext(String context) {
      this.context = context;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PacketViolationWarningPacket)) {
         return false;
      }

      PacketViolationWarningPacket other = (PacketViolationWarningPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.packetCauseId != other.packetCauseId) {
         return false;
      }

      Object this$type = this.type;
      Object other$type = other.type;
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$severity = this.severity;
         Object other$severity = other.severity;
         if (this$severity == null ? other$severity == null : this$severity.equals(other$severity)) {
            Object this$context = this.context;
            Object other$context = other.context;
            return this$context == null ? other$context == null : this$context.equals(other$context);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof PacketViolationWarningPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.packetCauseId;
      Object $type = this.type;
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $severity = this.severity;
      result = result * 59 + ($severity == null ? 43 : $severity.hashCode());
      Object $context = this.context;
      return result * 59 + ($context == null ? 43 : $context.hashCode());
   }

   @Override
   public String toString() {
      return "PacketViolationWarningPacket(type="
         + this.type
         + ", severity="
         + this.severity
         + ", packetCauseId="
         + this.packetCauseId
         + ", context="
         + this.context
         + ")";
   }
}
