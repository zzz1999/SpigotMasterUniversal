package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.entity.EntityLinkData;
import com.nukkitx.protocol.common.PacketSignal;

public class SetEntityLinkPacket implements BedrockPacket {
   private EntityLinkData entityLink;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.SET_ENTITY_LINK;
   }

   public EntityLinkData getEntityLink() {
      return this.entityLink;
   }

   public void setEntityLink(EntityLinkData entityLink) {
      this.entityLink = entityLink;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SetEntityLinkPacket)) {
         return false;
      }

      SetEntityLinkPacket other = (SetEntityLinkPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$entityLink = this.entityLink;
      Object other$entityLink = other.entityLink;
      return this$entityLink == null ? other$entityLink == null : this$entityLink.equals(other$entityLink);
   }

   protected boolean canEqual(Object other) {
      return other instanceof SetEntityLinkPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $entityLink = this.entityLink;
      return result * 59 + ($entityLink == null ? 43 : $entityLink.hashCode());
   }

   @Override
   public String toString() {
      return "SetEntityLinkPacket(entityLink=" + this.entityLink + ")";
   }
}
