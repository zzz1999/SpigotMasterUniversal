package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.UUID;
import org.cloudburstmc.protocol.bedrock.data.inventory.CraftingType;
import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;
import org.cloudburstmc.protocol.common.PacketSignal;

@Deprecated
public class CraftingEventPacket implements BedrockPacket {
   private final List<ItemData> inputs = new ObjectArrayList<>();
   private final List<ItemData> outputs = new ObjectArrayList<>();
   private byte containerId;
   private CraftingType type;
   private UUID uuid;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CRAFTING_EVENT;
   }

   public CraftingEventPacket clone() {
      try {
         return (CraftingEventPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<ItemData> getInputs() {
      return this.inputs;
   }

   public List<ItemData> getOutputs() {
      return this.outputs;
   }

   public byte getContainerId() {
      return this.containerId;
   }

   public CraftingType getType() {
      return this.type;
   }

   public UUID getUuid() {
      return this.uuid;
   }

   public void setContainerId(final byte containerId) {
      this.containerId = containerId;
   }

   public void setType(final CraftingType type) {
      this.type = type;
   }

   public void setUuid(final UUID uuid) {
      this.uuid = uuid;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CraftingEventPacket)) {
         return false;
      }

      CraftingEventPacket other = (CraftingEventPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.containerId != other.containerId) {
         return false;
      }

      Object this$inputs = this.inputs;
      Object other$inputs = other.inputs;
      if (this$inputs == null ? other$inputs == null : this$inputs.equals(other$inputs)) {
         Object this$outputs = this.outputs;
         Object other$outputs = other.outputs;
         if (this$outputs == null ? other$outputs == null : this$outputs.equals(other$outputs)) {
            Object this$type = this.type;
            Object other$type = other.type;
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$uuid = this.uuid;
               Object other$uuid = other.uuid;
               return this$uuid == null ? other$uuid == null : this$uuid.equals(other$uuid);
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
      return other instanceof CraftingEventPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.containerId;
      Object $inputs = this.inputs;
      result = result * 59 + ($inputs == null ? 43 : $inputs.hashCode());
      Object $outputs = this.outputs;
      result = result * 59 + ($outputs == null ? 43 : $outputs.hashCode());
      Object $type = this.type;
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $uuid = this.uuid;
      return result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
   }

   @Override
   public String toString() {
      return "CraftingEventPacket(inputs="
         + this.inputs
         + ", outputs="
         + this.outputs
         + ", containerId="
         + this.containerId
         + ", type="
         + this.type
         + ", uuid="
         + this.uuid
         + ")";
   }
}
