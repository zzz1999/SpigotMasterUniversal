package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.protocol.common.PacketSignal;

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

   public SyncEntityPropertyPacket clone() {
      try {
         return (SyncEntityPropertyPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public NbtMap getData() {
      return this.data;
   }

   public void setData(final NbtMap data) {
      this.data = data;
   }

   @Override
   public String toString() {
      return "SyncEntityPropertyPacket(data=" + this.getData() + ")";
   }

   @Override
   public boolean equals(final Object o) {
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

   protected boolean canEqual(final Object other) {
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
