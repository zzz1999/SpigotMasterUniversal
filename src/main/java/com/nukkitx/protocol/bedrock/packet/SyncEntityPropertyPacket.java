package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import org.cloudburstmc.nbt.NbtMap;

public class SyncEntityPropertyPacket implements BedrockPacket {
   private NbtMap data;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SYNC_ENTITY_PROPERTY;
   }

   public NbtMap getData() {
      return this.data;
   }

   public void setData(NbtMap data) {
      this.data = data;
   }

   @Override
   public String toString() {
      return "SyncEntityPropertyPacket(data=" + this.getData() + ")";
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SyncEntityPropertyPacket)) {
         return false;
      }

      SyncEntityPropertyPacket other = (SyncEntityPropertyPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$data = this.data;
      Object other$data = other.data;
      return this$data == null ? other$data == null : this$data.equals(other$data);
   }

   protected boolean canEqual(Object other) {
      return other instanceof SyncEntityPropertyPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $data = this.data;
      return result * 59 + ($data == null ? 43 : $data.hashCode());
   }
}
