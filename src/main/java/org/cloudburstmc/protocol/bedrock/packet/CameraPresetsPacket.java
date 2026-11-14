package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.camera.CameraPreset;
import org.cloudburstmc.protocol.common.PacketSignal;

public class CameraPresetsPacket implements BedrockPacket {
   private final List<CameraPreset> presets = new ObjectArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CAMERA_PRESETS;
   }

   public CameraPresetsPacket clone() {
      try {
         return (CameraPresetsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<CameraPreset> getPresets() {
      return this.presets;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CameraPresetsPacket)) {
         return false;
      }

      CameraPresetsPacket other = (CameraPresetsPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$presets = this.presets;
      Object other$presets = other.presets;
      return this$presets == null ? other$presets == null : this$presets.equals(other$presets);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CameraPresetsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $presets = this.presets;
      return result * 59 + ($presets == null ? 43 : $presets.hashCode());
   }

   @Override
   public String toString() {
      return "CameraPresetsPacket(presets=" + this.presets + ")";
   }
}
