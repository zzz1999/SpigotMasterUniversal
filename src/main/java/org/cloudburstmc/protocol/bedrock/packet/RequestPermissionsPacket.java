package org.cloudburstmc.protocol.bedrock.packet;

import org.cloudburstmc.protocol.bedrock.data.PlayerPermission;
import org.cloudburstmc.protocol.common.PacketSignal;

public class RequestPermissionsPacket implements BedrockPacket {
   private long uniqueEntityId;
   private PlayerPermission permissions;
   private int customPermissions;

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.REQUEST_PERMISSIONS;
   }

   public RequestPermissionsPacket clone() {
      try {
         return (RequestPermissionsPacket)super.clone();
      } catch (CloneNotSupportedException e) {
         throw new AssertionError(e);
      }
   }

   public long getUniqueEntityId() {
      return this.uniqueEntityId;
   }

   public PlayerPermission getPermissions() {
      return this.permissions;
   }

   public int getCustomPermissions() {
      return this.customPermissions;
   }

   public void setUniqueEntityId(final long uniqueEntityId) {
      this.uniqueEntityId = uniqueEntityId;
   }

   public void setPermissions(final PlayerPermission permissions) {
      this.permissions = permissions;
   }

   public void setCustomPermissions(final int customPermissions) {
      this.customPermissions = customPermissions;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RequestPermissionsPacket)) {
         return false;
      }

      RequestPermissionsPacket other = (RequestPermissionsPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.uniqueEntityId != other.uniqueEntityId) {
         return false;
      }

      if (this.customPermissions != other.customPermissions) {
         return false;
      }

      Object this$permissions = this.permissions;
      Object other$permissions = other.permissions;
      return this$permissions == null ? other$permissions == null : this$permissions.equals(other$permissions);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RequestPermissionsPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $uniqueEntityId = this.uniqueEntityId;
      result = result * 59 + (int)($uniqueEntityId >>> 32 ^ $uniqueEntityId);
      result = result * 59 + this.customPermissions;
      Object $permissions = this.permissions;
      return result * 59 + ($permissions == null ? 43 : $permissions.hashCode());
   }

   @Override
   public String toString() {
      return "RequestPermissionsPacket(uniqueEntityId="
         + this.uniqueEntityId
         + ", permissions="
         + this.permissions
         + ", customPermissions="
         + this.customPermissions
         + ")";
   }
}
