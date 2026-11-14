package org.cloudburstmc.protocol.bedrock.data;

import java.util.EnumSet;
import java.util.Set;

public class AbilityLayer {
   private AbilityLayer.Type layerType;
   private final Set<Ability> abilitiesSet = EnumSet.noneOf(Ability.class);
   private final Set<Ability> abilityValues = EnumSet.noneOf(Ability.class);
   private float flySpeed;
   private float walkSpeed;
   private float verticalFlySpeed;

   public AbilityLayer.Type getLayerType() {
      return this.layerType;
   }

   public Set<Ability> getAbilitiesSet() {
      return this.abilitiesSet;
   }

   public Set<Ability> getAbilityValues() {
      return this.abilityValues;
   }

   public float getFlySpeed() {
      return this.flySpeed;
   }

   public float getWalkSpeed() {
      return this.walkSpeed;
   }

   public float getVerticalFlySpeed() {
      return this.verticalFlySpeed;
   }

   public void setLayerType(final AbilityLayer.Type layerType) {
      this.layerType = layerType;
   }

   public void setFlySpeed(final float flySpeed) {
      this.flySpeed = flySpeed;
   }

   public void setWalkSpeed(final float walkSpeed) {
      this.walkSpeed = walkSpeed;
   }

   public void setVerticalFlySpeed(final float verticalFlySpeed) {
      this.verticalFlySpeed = verticalFlySpeed;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AbilityLayer)) {
         return false;
      }

      AbilityLayer other = (AbilityLayer)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (Float.compare(this.getFlySpeed(), other.getFlySpeed()) != 0) {
         return false;
      }

      if (Float.compare(this.getWalkSpeed(), other.getWalkSpeed()) != 0) {
         return false;
      }

      if (Float.compare(this.getVerticalFlySpeed(), other.getVerticalFlySpeed()) != 0) {
         return false;
      }

      Object this$layerType = this.getLayerType();
      Object other$layerType = other.getLayerType();
      if (this$layerType == null ? other$layerType == null : this$layerType.equals(other$layerType)) {
         Object this$abilitiesSet = this.getAbilitiesSet();
         Object other$abilitiesSet = other.getAbilitiesSet();
         if (this$abilitiesSet == null ? other$abilitiesSet == null : this$abilitiesSet.equals(other$abilitiesSet)) {
            Object this$abilityValues = this.getAbilityValues();
            Object other$abilityValues = other.getAbilityValues();
            return this$abilityValues == null ? other$abilityValues == null : this$abilityValues.equals(other$abilityValues);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AbilityLayer;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + Float.floatToIntBits(this.getFlySpeed());
      result = result * 59 + Float.floatToIntBits(this.getWalkSpeed());
      result = result * 59 + Float.floatToIntBits(this.getVerticalFlySpeed());
      Object $layerType = this.getLayerType();
      result = result * 59 + ($layerType == null ? 43 : $layerType.hashCode());
      Object $abilitiesSet = this.getAbilitiesSet();
      result = result * 59 + ($abilitiesSet == null ? 43 : $abilitiesSet.hashCode());
      Object $abilityValues = this.getAbilityValues();
      return result * 59 + ($abilityValues == null ? 43 : $abilityValues.hashCode());
   }

   @Override
   public String toString() {
      return "AbilityLayer(layerType="
         + this.getLayerType()
         + ", abilitiesSet="
         + this.getAbilitiesSet()
         + ", abilityValues="
         + this.getAbilityValues()
         + ", flySpeed="
         + this.getFlySpeed()
         + ", walkSpeed="
         + this.getWalkSpeed()
         + ", verticalFlySpeed="
         + this.getVerticalFlySpeed()
         + ")";
   }

   public enum Type {
      CACHE,
      BASE,
      SPECTATOR,
      COMMANDS,
      EDITOR,
      LOADING_SCREEN;
   }
}
