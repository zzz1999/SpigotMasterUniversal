package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ResourcePackClientResponsePacket implements BedrockPacket {
   private final List<String> packIds = new ObjectArrayList<>();
   private ResourcePackClientResponsePacket.Status status;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.RESOURCE_PACK_CLIENT_RESPONSE;
   }

   public ResourcePackClientResponsePacket clone() {
      try {
         return (ResourcePackClientResponsePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<String> getPackIds() {
      return this.packIds;
   }

   public ResourcePackClientResponsePacket.Status getStatus() {
      return this.status;
   }

   public void setStatus(final ResourcePackClientResponsePacket.Status status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ResourcePackClientResponsePacket)) {
         return false;
      } else {
         ResourcePackClientResponsePacket other = (ResourcePackClientResponsePacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$packIds = this.packIds;
            Object other$packIds = other.packIds;
            if (this$packIds == null ? other$packIds == null : this$packIds.equals(other$packIds)) {
               Object this$status = this.status;
               Object other$status = other.status;
               return this$status == null ? other$status == null : this$status.equals(other$status);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ResourcePackClientResponsePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $packIds = this.packIds;
      result = result * 59 + ($packIds == null ? 43 : $packIds.hashCode());
      Object $status = this.status;
      return result * 59 + ($status == null ? 43 : $status.hashCode());
   }

   @Override
   public String toString() {
      return "ResourcePackClientResponsePacket(packIds=" + this.packIds + ", status=" + this.status + ")";
   }

   public enum Status {
      NONE,
      REFUSED,
      SEND_PACKS,
      HAVE_ALL_PACKS,
      COMPLETED;
   }
}
