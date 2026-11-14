package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.AttributeData;
import com.nukkitx.protocol.common.PacketSignal;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;

public class UpdateAttributesPacket implements BedrockPacket {
   private long runtimeEntityId;
   private List<AttributeData> attributes = new ObjectArrayList<>();
   private long tick;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.UPDATE_ATTRIBUTES;
   }

   public long getRuntimeEntityId() {
      return this.runtimeEntityId;
   }

   public List<AttributeData> getAttributes() {
      return this.attributes;
   }

   public long getTick() {
      return this.tick;
   }

   public void setRuntimeEntityId(long runtimeEntityId) {
      this.runtimeEntityId = runtimeEntityId;
   }

   public void setAttributes(List<AttributeData> attributes) {
      this.attributes = attributes;
   }

   public void setTick(long tick) {
      this.tick = tick;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UpdateAttributesPacket)) {
         return false;
      }

      UpdateAttributesPacket other = (UpdateAttributesPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.runtimeEntityId != other.runtimeEntityId) {
         return false;
      }

      if (this.tick != other.tick) {
         return false;
      }

      Object this$attributes = this.attributes;
      Object other$attributes = other.attributes;
      return this$attributes == null ? other$attributes == null : this$attributes.equals(other$attributes);
   }

   protected boolean canEqual(Object other) {
      return other instanceof UpdateAttributesPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $runtimeEntityId = this.runtimeEntityId;
      result = result * 59 + (int)($runtimeEntityId >>> 32 ^ $runtimeEntityId);
      long $tick = this.tick;
      result = result * 59 + (int)($tick >>> 32 ^ $tick);
      Object $attributes = this.attributes;
      return result * 59 + ($attributes == null ? 43 : $attributes.hashCode());
   }

   @Override
   public String toString() {
      return "UpdateAttributesPacket(runtimeEntityId=" + this.runtimeEntityId + ", attributes=" + this.attributes + ", tick=" + this.tick + ")";
   }
}
