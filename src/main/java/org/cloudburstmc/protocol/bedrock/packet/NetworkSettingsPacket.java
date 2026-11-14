package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.annotation.Incompressible;
import org.cloudburstmc.protocol.bedrock.data.PacketCompressionAlgorithm;
import org.cloudburstmc.protocol.common.PacketSignal;

@Incompressible
public class NetworkSettingsPacket implements BedrockPacket {
   private int compressionThreshold;
   private PacketCompressionAlgorithm compressionAlgorithm;
   private boolean clientThrottleEnabled;
   private int clientThrottleThreshold;
   private float clientThrottleScalar;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.NETWORK_SETTINGS;
   }

   public NetworkSettingsPacket clone() {
      try {
         return (NetworkSettingsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getCompressionThreshold() {
      return this.compressionThreshold;
   }

   public PacketCompressionAlgorithm getCompressionAlgorithm() {
      return this.compressionAlgorithm;
   }

   public boolean isClientThrottleEnabled() {
      return this.clientThrottleEnabled;
   }

   public int getClientThrottleThreshold() {
      return this.clientThrottleThreshold;
   }

   public float getClientThrottleScalar() {
      return this.clientThrottleScalar;
   }

   public void setCompressionThreshold(final int compressionThreshold) {
      this.compressionThreshold = compressionThreshold;
   }

   public void setCompressionAlgorithm(final PacketCompressionAlgorithm compressionAlgorithm) {
      this.compressionAlgorithm = compressionAlgorithm;
   }

   public void setClientThrottleEnabled(final boolean clientThrottleEnabled) {
      this.clientThrottleEnabled = clientThrottleEnabled;
   }

   public void setClientThrottleThreshold(final int clientThrottleThreshold) {
      this.clientThrottleThreshold = clientThrottleThreshold;
   }

   public void setClientThrottleScalar(final float clientThrottleScalar) {
      this.clientThrottleScalar = clientThrottleScalar;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NetworkSettingsPacket)) {
         return false;
      }

      NetworkSettingsPacket other = (NetworkSettingsPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.compressionThreshold != other.compressionThreshold) {
         return false;
      }

      if (this.clientThrottleEnabled != other.clientThrottleEnabled) {
         return false;
      }

      if (this.clientThrottleThreshold != other.clientThrottleThreshold) {
         return false;
      }

      if (Float.compare(this.clientThrottleScalar, other.clientThrottleScalar) != 0) {
         return false;
      }

      Object this$compressionAlgorithm = this.compressionAlgorithm;
      Object other$compressionAlgorithm = other.compressionAlgorithm;
      return this$compressionAlgorithm == null ? other$compressionAlgorithm == null : this$compressionAlgorithm.equals(other$compressionAlgorithm);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NetworkSettingsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.compressionThreshold;
      result = result * 59 + (this.clientThrottleEnabled ? 79 : 97);
      result = result * 59 + this.clientThrottleThreshold;
      result = result * 59 + Float.floatToIntBits(this.clientThrottleScalar);
      Object $compressionAlgorithm = this.compressionAlgorithm;
      return result * 59 + ($compressionAlgorithm == null ? 43 : $compressionAlgorithm.hashCode());
   }

   @Override
   public String toString() {
      return "NetworkSettingsPacket(compressionThreshold="
         + this.compressionThreshold
         + ", compressionAlgorithm="
         + this.compressionAlgorithm
         + ", clientThrottleEnabled="
         + this.clientThrottleEnabled
         + ", clientThrottleThreshold="
         + this.clientThrottleThreshold
         + ", clientThrottleScalar="
         + this.clientThrottleScalar
         + ")";
   }
}
