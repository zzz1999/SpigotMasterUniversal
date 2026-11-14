package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.data.inventory.CreativeItemData;
import org.cloudburstmc.protocol.bedrock.data.inventory.CreativeItemGroup;
import org.cloudburstmc.protocol.common.PacketSignal;

public class CreativeContentPacket implements BedrockPacket {
   private final List<CreativeItemGroup> groups = new ObjectArrayList<>();
   private final List<CreativeItemData> contents = new ObjectArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CREATIVE_CONTENT;
   }

   public CreativeContentPacket clone() {
      try {
         return (CreativeContentPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public List<CreativeItemGroup> getGroups() {
      return this.groups;
   }

   public List<CreativeItemData> getContents() {
      return this.contents;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CreativeContentPacket)) {
         return false;
      } else {
         CreativeContentPacket other = (CreativeContentPacket)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$groups = this.groups;
            Object other$groups = other.groups;
            if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
               Object this$contents = this.contents;
               Object other$contents = other.contents;
               return this$contents == null ? other$contents == null : this$contents.equals(other$contents);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CreativeContentPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $groups = this.groups;
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $contents = this.contents;
      return result * 59 + ($contents == null ? 43 : $contents.hashCode());
   }

   @Override
   public String toString() {
      return "CreativeContentPacket(groups=" + this.groups + ", contents=" + this.contents + ")";
   }
}
