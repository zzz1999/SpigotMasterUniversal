package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.camera.CameraPreset;
import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

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

   public List<CameraPreset> getPresets() {
      return this.presets;
   }

   @Override
   public boolean equals(Object o) {
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

   protected boolean canEqual(Object other) {
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
