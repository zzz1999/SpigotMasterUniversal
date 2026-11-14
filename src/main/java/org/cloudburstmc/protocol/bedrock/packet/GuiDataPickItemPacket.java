package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class GuiDataPickItemPacket implements BedrockPacket {
   private String description;
   private String itemEffects;
   private int hotbarSlot;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.GUI_DATA_PICK_ITEM;
   }

   public GuiDataPickItemPacket clone() {
      try {
         return (GuiDataPickItemPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getDescription() {
      return this.description;
   }

   public String getItemEffects() {
      return this.itemEffects;
   }

   public int getHotbarSlot() {
      return this.hotbarSlot;
   }

   public void setDescription(final String description) {
      this.description = description;
   }

   public void setItemEffects(final String itemEffects) {
      this.itemEffects = itemEffects;
   }

   public void setHotbarSlot(final int hotbarSlot) {
      this.hotbarSlot = hotbarSlot;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof GuiDataPickItemPacket)) {
         return false;
      } else {
         GuiDataPickItemPacket other = (GuiDataPickItemPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.hotbarSlot != other.hotbarSlot) {
            return false;
         } else {
            Object this$description = this.description;
            Object other$description = other.description;
            if (this$description == null ? other$description == null : this$description.equals(other$description)) {
               Object this$itemEffects = this.itemEffects;
               Object other$itemEffects = other.itemEffects;
               return this$itemEffects == null ? other$itemEffects == null : this$itemEffects.equals(other$itemEffects);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof GuiDataPickItemPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.hotbarSlot;
      Object $description = this.description;
      result = result * 59 + ($description == null ? 43 : $description.hashCode());
      Object $itemEffects = this.itemEffects;
      return result * 59 + ($itemEffects == null ? 43 : $itemEffects.hashCode());
   }

   @Override
   public String toString() {
      return "GuiDataPickItemPacket(description=" + this.description + ", itemEffects=" + this.itemEffects + ", hotbarSlot=" + this.hotbarSlot + ")";
   }
}
