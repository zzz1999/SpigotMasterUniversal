package org.cloudburstmc.protocol.bedrock.packet;

import java.util.Map;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.bedrock.data.GraphicsOverrideParameterType;
import org.cloudburstmc.protocol.common.PacketSignal;

public class GraphicsParameterOverridePacket implements BedrockPacket {
   private String biomeIdentifier;
   private GraphicsOverrideParameterType parameterType;
   private Map<Float, Vector3f> values;
   private boolean reset;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.GRAPHICS_PARAMETER_OVERRIDE_PACKET;
   }

   public GraphicsParameterOverridePacket clone() {
      try {
         return (GraphicsParameterOverridePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public String getBiomeIdentifier() {
      return this.biomeIdentifier;
   }

   public GraphicsOverrideParameterType getParameterType() {
      return this.parameterType;
   }

   public Map<Float, Vector3f> getValues() {
      return this.values;
   }

   public boolean isReset() {
      return this.reset;
   }

   public void setBiomeIdentifier(final String biomeIdentifier) {
      this.biomeIdentifier = biomeIdentifier;
   }

   public void setParameterType(final GraphicsOverrideParameterType parameterType) {
      this.parameterType = parameterType;
   }

   public void setValues(final Map<Float, Vector3f> values) {
      this.values = values;
   }

   public void setReset(final boolean reset) {
      this.reset = reset;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof GraphicsParameterOverridePacket)) {
         return false;
      }

      GraphicsParameterOverridePacket other = (GraphicsParameterOverridePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.reset != other.reset) {
         return false;
      }

      Object this$biomeIdentifier = this.biomeIdentifier;
      Object other$biomeIdentifier = other.biomeIdentifier;
      if (this$biomeIdentifier == null ? other$biomeIdentifier == null : this$biomeIdentifier.equals(other$biomeIdentifier)) {
         Object this$parameterType = this.parameterType;
         Object other$parameterType = other.parameterType;
         if (this$parameterType == null ? other$parameterType == null : this$parameterType.equals(other$parameterType)) {
            Object this$values = this.values;
            Object other$values = other.values;
            return this$values == null ? other$values == null : this$values.equals(other$values);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof GraphicsParameterOverridePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.reset ? 79 : 97);
      Object $biomeIdentifier = this.biomeIdentifier;
      result = result * 59 + ($biomeIdentifier == null ? 43 : $biomeIdentifier.hashCode());
      Object $parameterType = this.parameterType;
      result = result * 59 + ($parameterType == null ? 43 : $parameterType.hashCode());
      Object $values = this.values;
      return result * 59 + ($values == null ? 43 : $values.hashCode());
   }

   @Override
   public String toString() {
      return "GraphicsParameterOverridePacket(biomeIdentifier="
         + this.biomeIdentifier
         + ", parameterType="
         + this.parameterType
         + ", values="
         + this.values
         + ", reset="
         + this.reset
         + ")";
   }
}
