package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.inventory.FullContainerName;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ContainerRegistryCleanupPacket implements BedrockPacket {
   private final List<FullContainerName> containers = new ObjectArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CONTAINER_REGISTRY_CLEANUP;
   }

   public ContainerRegistryCleanupPacket clone() {
      try {
         return (ContainerRegistryCleanupPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<FullContainerName> getContainers() {
      return this.containers;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContainerRegistryCleanupPacket)) {
         return false;
      }

      ContainerRegistryCleanupPacket other = (ContainerRegistryCleanupPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$containers = this.containers;
      Object other$containers = other.containers;
      return this$containers == null ? other$containers == null : this$containers.equals(other$containers);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContainerRegistryCleanupPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $containers = this.containers;
      return result * 59 + ($containers == null ? 43 : $containers.hashCode());
   }

   @Override
   public String toString() {
      return "ContainerRegistryCleanupPacket(containers=" + this.containers + ")";
   }
}
