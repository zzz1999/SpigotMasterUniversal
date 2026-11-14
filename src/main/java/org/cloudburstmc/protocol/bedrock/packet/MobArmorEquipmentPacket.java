package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;
import org.cloudburstmc.protocol.common.PacketSignal;

public class MobArmorEquipmentPacket implements BedrockPacket {
   private long runtimeEntityId;
   private ItemData helmet;
   private ItemData chestplate;
   private ItemData leggings;
   private ItemData boots;
   private ItemData body;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.MOB_ARMOR_EQUIPMENT;
   }

   public MobArmorEquipmentPacket clone() {
      try {
         return (MobArmorEquipmentPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public ItemData getHelmet() {
      return this.helmet;
   }

   public ItemData getChestplate() {
      return this.chestplate;
   }

   public ItemData getLeggings() {
      return this.leggings;
   }

   public ItemData getBoots() {
      return this.boots;
   }

   public ItemData getBody() {
      return this.body;
   }

   public void setRuntimeEntityId(final long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setHelmet(final ItemData helmet) {
      this.helmet = helmet;
   }

   public void setChestplate(final ItemData chestplate) {
      this.chestplate = chestplate;
   }

   public void setLeggings(final ItemData leggings) {
      this.leggings = leggings;
   }

   public void setBoots(final ItemData boots) {
      this.boots = boots;
   }

   public void setBody(final ItemData body) {
      this.body = body;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MobArmorEquipmentPacket)) {
         return false;
      }

      MobArmorEquipmentPacket other = (MobArmorEquipmentPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      Object this$helmet = this.helmet;
      Object other$helmet = other.helmet;
      if (this$helmet == null ? other$helmet == null : this$helmet.equals(other$helmet)) {
         Object this$chestplate = this.chestplate;
         Object other$chestplate = other.chestplate;
         if (this$chestplate == null ? other$chestplate == null : this$chestplate.equals(other$chestplate)) {
            Object this$leggings = this.leggings;
            Object other$leggings = other.leggings;
            if (this$leggings == null ? other$leggings == null : this$leggings.equals(other$leggings)) {
               Object this$boots = this.boots;
               Object other$boots = other.boots;
               if (this$boots == null ? other$boots == null : this$boots.equals(other$boots)) {
                  Object this$body = this.body;
                  Object other$body = other.body;
                  return this$body == null ? other$body == null : this$body.equals(other$body);
               } else {
                  return false;
               }
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
      return other instanceof MobArmorEquipmentPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      Object $helmet = this.helmet;
      result = result * 59 + ($helmet == null ? 43 : $helmet.hashCode());
      Object $chestplate = this.chestplate;
      result = result * 59 + ($chestplate == null ? 43 : $chestplate.hashCode());
      Object $leggings = this.leggings;
      result = result * 59 + ($leggings == null ? 43 : $leggings.hashCode());
      Object $boots = this.boots;
      result = result * 59 + ($boots == null ? 43 : $boots.hashCode());
      Object $body = this.body;
      return result * 59 + ($body == null ? 43 : $body.hashCode());
   }

   @Override
   public String toString() {
      return "MobArmorEquipmentPacket(runtimeEntityId="
         + this.runtimeEntityId
         + ", helmet="
         + this.helmet
         + ", chestplate="
         + this.chestplate
         + ", leggings="
         + this.leggings
         + ", boots="
         + this.boots
         + ", body="
         + this.body
         + ")";
   }
}
