package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.bedrock.data.skin.SerializedSkin;
import com.nukkitx.protocol.common.PacketSignal;
import java.util.UUID;

public class PlayerSkinPacket implements BedrockPacket {
   private UUID uuid;
   private SerializedSkin skin;
   private String newSkinName;
   private String oldSkinName;
   private boolean trustedSkin;

   @Override
   public final PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.PLAYER_SKIN;
   }

   public UUID getUuid() {
      return this.uuid;
   }

   public SerializedSkin getSkin() {
      return this.skin;
   }

   public String getNewSkinName() {
      return this.newSkinName;
   }

   public String getOldSkinName() {
      return this.oldSkinName;
   }

   public boolean isTrustedSkin() {
      return this.trustedSkin;
   }

   public void setUuid(UUID uuid) {
      this.uuid = uuid;
   }

   public void setSkin(SerializedSkin skin) {
      this.skin = skin;
   }

   public void setNewSkinName(String newSkinName) {
      this.newSkinName = newSkinName;
   }

   public void setOldSkinName(String oldSkinName) {
      this.oldSkinName = oldSkinName;
   }

   public void setTrustedSkin(boolean trustedSkin) {
      this.trustedSkin = trustedSkin;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlayerSkinPacket)) {
         return false;
      }

      PlayerSkinPacket other = (PlayerSkinPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.trustedSkin != other.trustedSkin) {
         return false;
      }

      Object this$uuid = this.uuid;
      Object other$uuid = other.uuid;
      if (this$uuid == null ? other$uuid == null : this$uuid.equals(other$uuid)) {
         Object this$skin = this.skin;
         Object other$skin = other.skin;
         if (this$skin == null ? other$skin == null : this$skin.equals(other$skin)) {
            Object this$newSkinName = this.newSkinName;
            Object other$newSkinName = other.newSkinName;
            if (this$newSkinName == null ? other$newSkinName == null : this$newSkinName.equals(other$newSkinName)) {
               Object this$oldSkinName = this.oldSkinName;
               Object other$oldSkinName = other.oldSkinName;
               return this$oldSkinName == null ? other$oldSkinName == null : this$oldSkinName.equals(other$oldSkinName);
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

   protected boolean canEqual(Object other) {
      return other instanceof PlayerSkinPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.trustedSkin ? 79 : 97);
      Object $uuid = this.uuid;
      result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
      Object $skin = this.skin;
      result = result * 59 + ($skin == null ? 43 : $skin.hashCode());
      Object $newSkinName = this.newSkinName;
      result = result * 59 + ($newSkinName == null ? 43 : $newSkinName.hashCode());
      Object $oldSkinName = this.oldSkinName;
      return result * 59 + ($oldSkinName == null ? 43 : $oldSkinName.hashCode());
   }

   @Override
   public String toString() {
      return "PlayerSkinPacket(uuid="
         + this.uuid
         + ", skin="
         + this.skin
         + ", newSkinName="
         + this.newSkinName
         + ", oldSkinName="
         + this.oldSkinName
         + ", trustedSkin="
         + this.trustedSkin
         + ")";
   }
}
