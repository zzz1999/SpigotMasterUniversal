package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.EduSharedUriResource;
import org.cloudburstmc.protocol.common.PacketSignal;

public class EduUriResourcePacket implements BedrockPacket {
   private EduSharedUriResource eduSharedUriResource;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.EDU_URI_RESOURCE;
   }

   public EduUriResourcePacket clone() {
      try {
         return (EduUriResourcePacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public EduSharedUriResource getEduSharedUriResource() {
      return this.eduSharedUriResource;
   }

   public void setEduSharedUriResource(final EduSharedUriResource eduSharedUriResource) {
      this.eduSharedUriResource = eduSharedUriResource;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EduUriResourcePacket)) {
         return false;
      }

      EduUriResourcePacket other = (EduUriResourcePacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$eduSharedUriResource = this.eduSharedUriResource;
      Object other$eduSharedUriResource = other.eduSharedUriResource;
      return this$eduSharedUriResource == null ? other$eduSharedUriResource == null : this$eduSharedUriResource.equals(other$eduSharedUriResource);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EduUriResourcePacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $eduSharedUriResource = this.eduSharedUriResource;
      return result * 59 + ($eduSharedUriResource == null ? 43 : $eduSharedUriResource.hashCode());
   }

   @Override
   public String toString() {
      return "EduUriResourcePacket(eduSharedUriResource=" + this.eduSharedUriResource + ")";
   }
}
