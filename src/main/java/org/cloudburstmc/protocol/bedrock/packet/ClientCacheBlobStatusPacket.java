package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongList;
import org.cloudburstmc.protocol.common.PacketSignal;

public class ClientCacheBlobStatusPacket implements BedrockPacket {
   private final LongList acks = new LongArrayList();
   private final LongList naks = new LongArrayList();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CLIENT_CACHE_BLOB_STATUS;
   }

   public ClientCacheBlobStatusPacket clone() {
      try {
         return (ClientCacheBlobStatusPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public LongList getAcks() {
      return this.acks;
   }

   public LongList getNaks() {
      return this.naks;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ClientCacheBlobStatusPacket)) {
         return false;
      } else {
         ClientCacheBlobStatusPacket other = (ClientCacheBlobStatusPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$acks = this.acks;
            Object other$acks = other.acks;
            if (this$acks == null ? other$acks == null : this$acks.equals(other$acks)) {
               Object this$naks = this.naks;
               Object other$naks = other.naks;
               return this$naks == null ? other$naks == null : this$naks.equals(other$naks);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ClientCacheBlobStatusPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $acks = this.acks;
      result = result * 59 + ($acks == null ? 43 : $acks.hashCode());
      Object $naks = this.naks;
      return result * 59 + ($naks == null ? 43 : $naks.hashCode());
   }

   @Override
   public String toString() {
      return "ClientCacheBlobStatusPacket(acks=" + this.acks + ", naks=" + this.naks + ")";
   }
}
