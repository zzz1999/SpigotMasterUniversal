package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.common.PacketSignal;

public class PlayerUpdateEntityOverridesPacket implements BedrockPacket {
   private long entityUniqueId;
   private int propertyIndex;
   private PlayerUpdateEntityOverridesPacket.UpdateType updateType;
   private int intValue;
   private float floatValue;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAYER_UPDATE_ENTITY_OVERRIDES;
   }

   @Override
   public BedrockPacket clone() {
      try {
         return (PlayerUpdateEntityOverridesPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getEntityUniqueId() {
      return this.entityUniqueId;
   }

   public int getPropertyIndex() {
      return this.propertyIndex;
   }

   public PlayerUpdateEntityOverridesPacket.UpdateType getUpdateType() {
      return this.updateType;
   }

   public int getIntValue() {
      return this.intValue;
   }

   public float getFloatValue() {
      return this.floatValue;
   }

   public void setEntityUniqueId(final long entityUniqueId) {
      this.entityUniqueId = entityUniqueId;
   }

   public void setPropertyIndex(final int propertyIndex) {
      this.propertyIndex = propertyIndex;
   }

   public void setUpdateType(final PlayerUpdateEntityOverridesPacket.UpdateType updateType) {
      this.updateType = updateType;
   }

   public void setIntValue(final int intValue) {
      this.intValue = intValue;
   }

   public void setFloatValue(final float floatValue) {
      this.floatValue = floatValue;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlayerUpdateEntityOverridesPacket)) {
         return false;
      }

      PlayerUpdateEntityOverridesPacket other = (PlayerUpdateEntityOverridesPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.entityUniqueId != other.entityUniqueId) {
         return false;
      }

      if (this.propertyIndex != other.propertyIndex) {
         return false;
      }

      if (this.intValue != other.intValue) {
         return false;
      }

      if (Float.compare(this.floatValue, other.floatValue) != 0) {
         return false;
      }

      Object this$updateType = this.updateType;
      Object other$updateType = other.updateType;
      return this$updateType == null ? other$updateType == null : this$updateType.equals(other$updateType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlayerUpdateEntityOverridesPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $entityUniqueId = this.entityUniqueId;
      result = result * 59 + (int)($entityUniqueId >>> 32 ^ $entityUniqueId);
      result = result * 59 + this.propertyIndex;
      result = result * 59 + this.intValue;
      result = result * 59 + Float.floatToIntBits(this.floatValue);
      Object $updateType = this.updateType;
      return result * 59 + ($updateType == null ? 43 : $updateType.hashCode());
   }

   @Override
   public String toString() {
      return "PlayerUpdateEntityOverridesPacket(entityUniqueId="
         + this.entityUniqueId
         + ", propertyIndex="
         + this.propertyIndex
         + ", updateType="
         + this.updateType
         + ", intValue="
         + this.intValue
         + ", floatValue="
         + this.floatValue
         + ")";
   }

   public enum UpdateType {
      CLEAR_OVERRIDES,
      REMOVE_OVERRIDE,
      SET_INT_OVERRIDE,
      SET_FLOAT_OVERRIDE;
   }
}
