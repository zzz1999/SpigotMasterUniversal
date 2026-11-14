package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class PlayerHotbarPacket implements BedrockPacket {
   private int selectedHotbarSlot;
   private int containerId;
   private boolean selectHotbarSlot;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAYER_HOTBAR;
   }

   public PlayerHotbarPacket clone() {
      try {
         return (PlayerHotbarPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public int getSelectedHotbarSlot() {
      return this.selectedHotbarSlot;
   }

   public int getContainerId() {
      return this.containerId;
   }

   public boolean isSelectHotbarSlot() {
      return this.selectHotbarSlot;
   }

   public void setSelectedHotbarSlot(final int selectedHotbarSlot) {
      this.selectedHotbarSlot = selectedHotbarSlot;
   }

   public void setContainerId(final int containerId) {
      this.containerId = containerId;
   }

   public void setSelectHotbarSlot(final boolean selectHotbarSlot) {
      this.selectHotbarSlot = selectHotbarSlot;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PlayerHotbarPacket)) {
         return false;
      } else {
         PlayerHotbarPacket other = (PlayerHotbarPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.selectedHotbarSlot != other.selectedHotbarSlot) {
            return false;
         } else {
            return this.containerId != other.containerId ? false : this.selectHotbarSlot == other.selectHotbarSlot;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlayerHotbarPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.selectedHotbarSlot;
      result = result * 59 + this.containerId;
      return result * 59 + (this.selectHotbarSlot ? 79 : 97);
   }

   @Override
   public String toString() {
      return "PlayerHotbarPacket(selectedHotbarSlot="
         + this.selectedHotbarSlot
         + ", containerId="
         + this.containerId
         + ", selectHotbarSlot="
         + this.selectHotbarSlot
         + ")";
   }
}
