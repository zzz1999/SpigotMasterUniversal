package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.bedrock.data.ClientboundDebugRendererType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ClientboundDebugRendererPacket implements BedrockPacket {
   private ClientboundDebugRendererType debugMarkerType;
   private String markerText;
   private Vector3f markerPosition;
   private float markerColorRed;
   private float markerColorGreen;
   private float markerColorBlue;
   private float markerColorAlpha;
   private long markerDuration;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CLIENTBOUND_DEBUG_RENDERER;
   }

   public ClientboundDebugRendererPacket clone() {
      try {
         return (ClientboundDebugRendererPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public ClientboundDebugRendererType getDebugMarkerType() {
      return this.debugMarkerType;
   }

   public String getMarkerText() {
      return this.markerText;
   }

   public Vector3f getMarkerPosition() {
      return this.markerPosition;
   }

   public float getMarkerColorRed() {
      return this.markerColorRed;
   }

   public float getMarkerColorGreen() {
      return this.markerColorGreen;
   }

   public float getMarkerColorBlue() {
      return this.markerColorBlue;
   }

   public float getMarkerColorAlpha() {
      return this.markerColorAlpha;
   }

   public long getMarkerDuration() {
      return this.markerDuration;
   }

   public void setDebugMarkerType(final ClientboundDebugRendererType debugMarkerType) {
      this.debugMarkerType = debugMarkerType;
   }

   public void setMarkerText(final String markerText) {
      this.markerText = markerText;
   }

   public void setMarkerPosition(final Vector3f markerPosition) {
      this.markerPosition = markerPosition;
   }

   public void setMarkerColorRed(final float markerColorRed) {
      this.markerColorRed = markerColorRed;
   }

   public void setMarkerColorGreen(final float markerColorGreen) {
      this.markerColorGreen = markerColorGreen;
   }

   public void setMarkerColorBlue(final float markerColorBlue) {
      this.markerColorBlue = markerColorBlue;
   }

   public void setMarkerColorAlpha(final float markerColorAlpha) {
      this.markerColorAlpha = markerColorAlpha;
   }

   public void setMarkerDuration(final long markerDuration) {
      this.markerDuration = markerDuration;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ClientboundDebugRendererPacket)) {
         return false;
      }

      ClientboundDebugRendererPacket other = (ClientboundDebugRendererPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (Float.compare(this.markerColorRed, other.markerColorRed) != 0) {
         return false;
      }

      if (Float.compare(this.markerColorGreen, other.markerColorGreen) != 0) {
         return false;
      }

      if (Float.compare(this.markerColorBlue, other.markerColorBlue) != 0) {
         return false;
      }

      if (Float.compare(this.markerColorAlpha, other.markerColorAlpha) != 0) {
         return false;
      }

      if (this.markerDuration != other.markerDuration) {
         return false;
      }

      Object this$debugMarkerType = this.debugMarkerType;
      Object other$debugMarkerType = other.debugMarkerType;
      if (this$debugMarkerType == null ? other$debugMarkerType == null : this$debugMarkerType.equals(other$debugMarkerType)) {
         Object this$markerText = this.markerText;
         Object other$markerText = other.markerText;
         if (this$markerText == null ? other$markerText == null : this$markerText.equals(other$markerText)) {
            Object this$markerPosition = this.markerPosition;
            Object other$markerPosition = other.markerPosition;
            return this$markerPosition == null ? other$markerPosition == null : this$markerPosition.equals(other$markerPosition);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ClientboundDebugRendererPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.markerColorRed);
      result = result * 59 + Float.floatToIntBits(this.markerColorGreen);
      result = result * 59 + Float.floatToIntBits(this.markerColorBlue);
      result = result * 59 + Float.floatToIntBits(this.markerColorAlpha);
      long $markerDuration = this.markerDuration;
      result = result * 59 + (int)($markerDuration >>> 32 ^ $markerDuration);
      Object $debugMarkerType = this.debugMarkerType;
      result = result * 59 + ($debugMarkerType == null ? 43 : $debugMarkerType.hashCode());
      Object $markerText = this.markerText;
      result = result * 59 + ($markerText == null ? 43 : $markerText.hashCode());
      Object $markerPosition = this.markerPosition;
      return result * 59 + ($markerPosition == null ? 43 : $markerPosition.hashCode());
   }

   @Override
   public String toString() {
      return "ClientboundDebugRendererPacket(debugMarkerType="
         + this.debugMarkerType
         + ", markerText="
         + this.markerText
         + ", markerPosition="
         + this.markerPosition
         + ", markerColorRed="
         + this.markerColorRed
         + ", markerColorGreen="
         + this.markerColorGreen
         + ", markerColorBlue="
         + this.markerColorBlue
         + ", markerColorAlpha="
         + this.markerColorAlpha
         + ", markerDuration="
         + this.markerDuration
         + ")";
   }
}
