package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class ServerboundDiagnosticsPacket implements BedrockPacket {
   private float avgFps;
   private float avgServerSimTickTimeMS;
   private float avgClientSimTickTimeMS;
   private float avgBeginFrameTimeMS;
   private float avgInputTimeMS;
   private float avgRenderTimeMS;
   private float avgEndFrameTimeMS;
   private float avgRemainderTimePercent;
   private float avgUnaccountedTimePercent;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SERVERBOUND_DIAGNOSTICS;
   }

   public ServerboundDiagnosticsPacket clone() {
      try {
         return (ServerboundDiagnosticsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public float getAvgFps() {
      return this.avgFps;
   }

   public float getAvgServerSimTickTimeMS() {
      return this.avgServerSimTickTimeMS;
   }

   public float getAvgClientSimTickTimeMS() {
      return this.avgClientSimTickTimeMS;
   }

   public float getAvgBeginFrameTimeMS() {
      return this.avgBeginFrameTimeMS;
   }

   public float getAvgInputTimeMS() {
      return this.avgInputTimeMS;
   }

   public float getAvgRenderTimeMS() {
      return this.avgRenderTimeMS;
   }

   public float getAvgEndFrameTimeMS() {
      return this.avgEndFrameTimeMS;
   }

   public float getAvgRemainderTimePercent() {
      return this.avgRemainderTimePercent;
   }

   public float getAvgUnaccountedTimePercent() {
      return this.avgUnaccountedTimePercent;
   }

   public void setAvgFps(final float avgFps) {
      this.avgFps = avgFps;
   }

   public void setAvgServerSimTickTimeMS(final float avgServerSimTickTimeMS) {
      this.avgServerSimTickTimeMS = avgServerSimTickTimeMS;
   }

   public void setAvgClientSimTickTimeMS(final float avgClientSimTickTimeMS) {
      this.avgClientSimTickTimeMS = avgClientSimTickTimeMS;
   }

   public void setAvgBeginFrameTimeMS(final float avgBeginFrameTimeMS) {
      this.avgBeginFrameTimeMS = avgBeginFrameTimeMS;
   }

   public void setAvgInputTimeMS(final float avgInputTimeMS) {
      this.avgInputTimeMS = avgInputTimeMS;
   }

   public void setAvgRenderTimeMS(final float avgRenderTimeMS) {
      this.avgRenderTimeMS = avgRenderTimeMS;
   }

   public void setAvgEndFrameTimeMS(final float avgEndFrameTimeMS) {
      this.avgEndFrameTimeMS = avgEndFrameTimeMS;
   }

   public void setAvgRemainderTimePercent(final float avgRemainderTimePercent) {
      this.avgRemainderTimePercent = avgRemainderTimePercent;
   }

   public void setAvgUnaccountedTimePercent(final float avgUnaccountedTimePercent) {
      this.avgUnaccountedTimePercent = avgUnaccountedTimePercent;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ServerboundDiagnosticsPacket)) {
         return false;
      } else {
         ServerboundDiagnosticsPacket other = (ServerboundDiagnosticsPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (Float.compare(this.avgFps, other.avgFps) != 0) {
            return false;
         } else if (Float.compare(this.avgServerSimTickTimeMS, other.avgServerSimTickTimeMS) != 0) {
            return false;
         } else if (Float.compare(this.avgClientSimTickTimeMS, other.avgClientSimTickTimeMS) != 0) {
            return false;
         } else if (Float.compare(this.avgBeginFrameTimeMS, other.avgBeginFrameTimeMS) != 0) {
            return false;
         } else if (Float.compare(this.avgInputTimeMS, other.avgInputTimeMS) != 0) {
            return false;
         } else if (Float.compare(this.avgRenderTimeMS, other.avgRenderTimeMS) != 0) {
            return false;
         } else if (Float.compare(this.avgEndFrameTimeMS, other.avgEndFrameTimeMS) != 0) {
            return false;
         } else {
            return Float.compare(this.avgRemainderTimePercent, other.avgRemainderTimePercent) != 0
               ? false
               : Float.compare(this.avgUnaccountedTimePercent, other.avgUnaccountedTimePercent) == 0;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ServerboundDiagnosticsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.avgFps);
      result = result * 59 + Float.floatToIntBits(this.avgServerSimTickTimeMS);
      result = result * 59 + Float.floatToIntBits(this.avgClientSimTickTimeMS);
      result = result * 59 + Float.floatToIntBits(this.avgBeginFrameTimeMS);
      result = result * 59 + Float.floatToIntBits(this.avgInputTimeMS);
      result = result * 59 + Float.floatToIntBits(this.avgRenderTimeMS);
      result = result * 59 + Float.floatToIntBits(this.avgEndFrameTimeMS);
      result = result * 59 + Float.floatToIntBits(this.avgRemainderTimePercent);
      return result * 59 + Float.floatToIntBits(this.avgUnaccountedTimePercent);
   }

   @Override
   public String toString() {
      return "ServerboundDiagnosticsPacket(avgFps="
         + this.avgFps
         + ", avgServerSimTickTimeMS="
         + this.avgServerSimTickTimeMS
         + ", avgClientSimTickTimeMS="
         + this.avgClientSimTickTimeMS
         + ", avgBeginFrameTimeMS="
         + this.avgBeginFrameTimeMS
         + ", avgInputTimeMS="
         + this.avgInputTimeMS
         + ", avgRenderTimeMS="
         + this.avgRenderTimeMS
         + ", avgEndFrameTimeMS="
         + this.avgEndFrameTimeMS
         + ", avgRemainderTimePercent="
         + this.avgRemainderTimePercent
         + ", avgUnaccountedTimePercent="
         + this.avgUnaccountedTimePercent
         + ")";
   }
}
