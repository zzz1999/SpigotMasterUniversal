package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.definitions.BlockDefinition;
import com.nukkitx.protocol.common.PacketSignal;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import org.cloudburstmc.math.vector.Vector3i;

public class UpdateBlockPacket implements BedrockPacket {
   public static final Set<UpdateBlockPacket.Flag> FLAG_ALL = Collections.unmodifiableSet(
      EnumSet.of(UpdateBlockPacket.Flag.NEIGHBORS, UpdateBlockPacket.Flag.NETWORK)
   );
   public static final Set<UpdateBlockPacket.Flag> FLAG_ALL_PRIORITY = Collections.unmodifiableSet(
      EnumSet.of(UpdateBlockPacket.Flag.NEIGHBORS, UpdateBlockPacket.Flag.NETWORK, UpdateBlockPacket.Flag.PRIORITY)
   );
   final Set<UpdateBlockPacket.Flag> flags = EnumSet.noneOf(UpdateBlockPacket.Flag.class);
   Vector3i blockPosition;
   BlockDefinition definition;
   int dataLayer;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.UPDATE_BLOCK;
   }

   public Set<UpdateBlockPacket.Flag> getFlags() {
      return this.flags;
   }

   public Vector3i getBlockPosition() {
      return this.blockPosition;
   }

   public BlockDefinition getDefinition() {
      return this.definition;
   }

   public int getDataLayer() {
      return this.dataLayer;
   }

   public void setBlockPosition(Vector3i blockPosition) {
      this.blockPosition = blockPosition;
   }

   public void setDefinition(BlockDefinition definition) {
      this.definition = definition;
   }

   public void setDataLayer(int dataLayer) {
      this.dataLayer = dataLayer;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UpdateBlockPacket)) {
         return false;
      }

      UpdateBlockPacket other = (UpdateBlockPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.dataLayer != other.dataLayer) {
         return false;
      }

      Object this$flags = this.flags;
      Object other$flags = other.flags;
      if (this$flags == null ? other$flags == null : this$flags.equals(other$flags)) {
         Object this$blockPosition = this.blockPosition;
         Object other$blockPosition = other.blockPosition;
         if (this$blockPosition == null ? other$blockPosition == null : this$blockPosition.equals(other$blockPosition)) {
            Object this$definition = this.definition;
            Object other$definition = other.definition;
            return this$definition == null ? other$definition == null : this$definition.equals(other$definition);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof UpdateBlockPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.dataLayer;
      Object $flags = this.flags;
      result = result * 59 + ($flags == null ? 43 : $flags.hashCode());
      Object $blockPosition = this.blockPosition;
      result = result * 59 + ($blockPosition == null ? 43 : $blockPosition.hashCode());
      Object $definition = this.definition;
      return result * 59 + ($definition == null ? 43 : $definition.hashCode());
   }

   @Override
   public String toString() {
      return "UpdateBlockPacket(flags="
         + this.flags
         + ", blockPosition="
         + this.blockPosition
         + ", definition="
         + this.definition
         + ", dataLayer="
         + this.dataLayer
         + ")";
   }

   public enum Flag {
      NEIGHBORS,
      NETWORK,
      NO_GRAPHIC,
      UNUSED,
      PRIORITY;
   }
}
