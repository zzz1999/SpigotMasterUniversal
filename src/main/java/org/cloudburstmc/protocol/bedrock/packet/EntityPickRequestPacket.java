package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class EntityPickRequestPacket implements BedrockPacket {
   private long runtimeEntityId;
   private int hotbarSlot;
   private boolean withData;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.ENTITY_PICK_REQUEST;
   }

   public EntityPickRequestPacket clone() {
      try {
         return (EntityPickRequestPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public int getHotbarSlot() {
      return this.hotbarSlot;
   }

   public boolean isWithData() {
      return this.withData;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setHotbarSlot(final int hotbarSlot) {
      this.hotbarSlot = hotbarSlot;
   }

   public void setWithData(final boolean withData) {
      this.withData = withData;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof EntityPickRequestPacket)) {
         return false;
      } else {
         EntityPickRequestPacket other = (EntityPickRequestPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.runtimeEntityId != other.runtimeEntityId) {
            return false;
         } else {
            return this.hotbarSlot != other.hotbarSlot ? false : this.withData == other.withData;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EntityPickRequestPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      result = result * 59 + this.hotbarSlot;
      return result * 59 + (this.withData ? 79 : 97);
   }

   @Override
   public String toString() {
      return "EntityPickRequestPacket(runtimeEntityId=" + this.runtimeEntityId + ", hotbarSlot=" + this.hotbarSlot + ", withData=" + this.withData + ")";
   }
}
