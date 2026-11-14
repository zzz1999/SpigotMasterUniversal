package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.inventory.InventoryLayout;
import org.cloudburstmc.protocol.bedrock.data.inventory.InventoryTabLeft;
import org.cloudburstmc.protocol.bedrock.data.inventory.InventoryTabRight;
import org.cloudburstmc.protocol.common.PacketSignal;

public class SetPlayerInventoryOptionsPacket implements BedrockPacket {
   private InventoryTabLeft leftTab;
   private InventoryTabRight rightTab;
   private boolean filtering;
   private InventoryLayout layout;
   private InventoryLayout craftingLayout;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_PLAYER_INVENTORY_OPTIONS;
   }

   public SetPlayerInventoryOptionsPacket clone() {
      try {
         return (SetPlayerInventoryOptionsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public InventoryTabLeft getLeftTab() {
      return this.leftTab;
   }

   public InventoryTabRight getRightTab() {
      return this.rightTab;
   }

   public boolean isFiltering() {
      return this.filtering;
   }

   public InventoryLayout getLayout() {
      return this.layout;
   }

   public InventoryLayout getCraftingLayout() {
      return this.craftingLayout;
   }

   public void setLeftTab(final InventoryTabLeft leftTab) {
      this.leftTab = leftTab;
   }

   public void setRightTab(final InventoryTabRight rightTab) {
      this.rightTab = rightTab;
   }

   public void setFiltering(final boolean filtering) {
      this.filtering = filtering;
   }

   public void setLayout(final InventoryLayout layout) {
      this.layout = layout;
   }

   public void setCraftingLayout(final InventoryLayout craftingLayout) {
      this.craftingLayout = craftingLayout;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetPlayerInventoryOptionsPacket)) {
         return false;
      }

      SetPlayerInventoryOptionsPacket other = (SetPlayerInventoryOptionsPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.filtering != other.filtering) {
         return false;
      }

      Object this$leftTab = this.leftTab;
      Object other$leftTab = other.leftTab;
      if (this$leftTab == null ? other$leftTab == null : this$leftTab.equals(other$leftTab)) {
         Object this$rightTab = this.rightTab;
         Object other$rightTab = other.rightTab;
         if (this$rightTab == null ? other$rightTab == null : this$rightTab.equals(other$rightTab)) {
            Object this$layout = this.layout;
            Object other$layout = other.layout;
            if (this$layout == null ? other$layout == null : this$layout.equals(other$layout)) {
               Object this$craftingLayout = this.craftingLayout;
               Object other$craftingLayout = other.craftingLayout;
               return this$craftingLayout == null ? other$craftingLayout == null : this$craftingLayout.equals(other$craftingLayout);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SetPlayerInventoryOptionsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.filtering ? 79 : 97);
      Object $leftTab = this.leftTab;
      result = result * 59 + ($leftTab == null ? 43 : $leftTab.hashCode());
      Object $rightTab = this.rightTab;
      result = result * 59 + ($rightTab == null ? 43 : $rightTab.hashCode());
      Object $layout = this.layout;
      result = result * 59 + ($layout == null ? 43 : $layout.hashCode());
      Object $craftingLayout = this.craftingLayout;
      return result * 59 + ($craftingLayout == null ? 43 : $craftingLayout.hashCode());
   }

   @Override
   public String toString() {
      return "SetPlayerInventoryOptionsPacket(leftTab="
         + this.leftTab
         + ", rightTab="
         + this.rightTab
         + ", filtering="
         + this.filtering
         + ", layout="
         + this.layout
         + ", craftingLayout="
         + this.craftingLayout
         + ")";
   }
}
