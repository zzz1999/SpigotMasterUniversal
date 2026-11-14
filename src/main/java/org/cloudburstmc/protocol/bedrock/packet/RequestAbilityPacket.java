package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.Ability;
import org.cloudburstmc.protocol.common.PacketSignal;

public class RequestAbilityPacket implements BedrockPacket {
   private Ability ability;
   private Ability.Type type;
   private boolean boolValue;
   private float floatValue;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.REQUEST_ABILITY;
   }

   public RequestAbilityPacket clone() {
      try {
         return (RequestAbilityPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public Ability getAbility() {
      return this.ability;
   }

   public Ability.Type getType() {
      return this.type;
   }

   public boolean isBoolValue() {
      return this.boolValue;
   }

   public float getFloatValue() {
      return this.floatValue;
   }

   public void setAbility(final Ability ability) {
      this.ability = ability;
   }

   public void setType(final Ability.Type type) {
      this.type = type;
   }

   public void setBoolValue(final boolean boolValue) {
      this.boolValue = boolValue;
   }

   public void setFloatValue(final float floatValue) {
      this.floatValue = floatValue;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof RequestAbilityPacket)) {
         return false;
      } else {
         RequestAbilityPacket other = (RequestAbilityPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.boolValue != other.boolValue) {
            return false;
         } else if (Float.compare(this.floatValue, other.floatValue) != 0) {
            return false;
         } else {
            Object this$ability = this.ability;
            Object other$ability = other.ability;
            if (this$ability == null ? other$ability == null : this$ability.equals(other$ability)) {
               Object this$type = this.type;
               Object other$type = other.type;
               return this$type == null ? other$type == null : this$type.equals(other$type);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RequestAbilityPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.boolValue ? 79 : 97);
      result = result * 59 + Float.floatToIntBits(this.floatValue);
      Object $ability = this.ability;
      result = result * 59 + ($ability == null ? 43 : $ability.hashCode());
      Object $type = this.type;
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "RequestAbilityPacket(ability=" + this.ability + ", type=" + this.type + ", boolValue=" + this.boolValue + ", floatValue=" + this.floatValue + ")";
   }
}
