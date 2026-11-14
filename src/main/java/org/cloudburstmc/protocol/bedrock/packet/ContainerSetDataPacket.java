package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class ContainerSetDataPacket implements BedrockPacket {
   public static final int FURNACE_TICK_COUNT = 0;
   public static final int FURNACE_LIT_TIME = 1;
   public static final int FURNACE_LIT_DURATION = 2;
   public static final int FURNACE_STORED_XP = 3;
   public static final int FURNACE_FUEL_AUX = 4;
   public static final int BREWING_STAND_BREW_TIME = 0;
   public static final int BREWING_STAND_FUEL_AMOUNT = 1;
   public static final int BREWING_STAND_FUEL_TOTAL = 2;
   private byte windowId;
   private int property;
   private int value;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CONTAINER_SET_DATA;
   }

   public ContainerSetDataPacket clone() {
      try {
         return (ContainerSetDataPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public byte getWindowId() {
      return this.windowId;
   }

   public int getProperty() {
      return this.property;
   }

   public int getValue() {
      return this.value;
   }

   public void setWindowId(final byte windowId) {
      this.windowId = windowId;
   }

   public void setProperty(final int property) {
      this.property = property;
   }

   public void setValue(final int value) {
      this.value = value;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ContainerSetDataPacket)) {
         return false;
      } else {
         ContainerSetDataPacket other = (ContainerSetDataPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.windowId != other.windowId) {
            return false;
         } else {
            return this.property != other.property ? false : this.value == other.value;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContainerSetDataPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.windowId;
      result = result * 59 + this.property;
      return result * 59 + this.value;
   }

   @Override
   public String toString() {
      return "ContainerSetDataPacket(windowId=" + this.windowId + ", property=" + this.property + ", value=" + this.value + ")";
   }
}
