package com.nukkitx.protocol.bedrock.packet;

import com.nukkitx.protocol.common.PacketSignal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ConfirmSkinPacket implements BedrockPacket {
   private List<ConfirmSkinPacket.SkinEntry> entries = new ArrayList<>();

   @Override
   public PacketSignal handle(BedrockPacketHandler handler) {
      return handler.handle(this);
   }

   public void addEntry(ConfirmSkinPacket.SkinEntry skinEntry) {
      this.entries.add(skinEntry);
   }

   @Override
   public BedrockPacketType getPacketType() {
      return BedrockPacketType.CONFIRM_SKIN_PACKET;
   }

   public List<ConfirmSkinPacket.SkinEntry> getEntries() {
      return this.entries;
   }

   public void setEntries(List<ConfirmSkinPacket.SkinEntry> entries) {
      this.entries = entries;
   }

   @Override
   public String toString() {
      return "ConfirmSkinPacket(entries=" + this.getEntries() + ")";
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ConfirmSkinPacket)) {
         return false;
      }

      ConfirmSkinPacket other = (ConfirmSkinPacket)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$entries = this.entries;
      Object other$entries = other.entries;
      return this$entries == null ? other$entries == null : this$entries.equals(other$entries);
   }

   protected boolean canEqual(Object other) {
      return other instanceof ConfirmSkinPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $entries = this.entries;
      return result * 59 + ($entries == null ? 43 : $entries.hashCode());
   }

   public static class SkinEntry {
      private boolean valid;
      private UUID uuid;
      private byte[] skinBytes;
      private String uidStr;
      private String geoStr;

      @Override
      public String toString() {
         return "ConfirmSkinPacket.SkinEntry(valid="
            + this.isValid()
            + ", uuid="
            + this.getUuid()
            + ", skinBytes="
            + Arrays.toString(this.getSkinBytes())
            + ", uidStr="
            + this.getUidStr()
            + ", geoStr="
            + this.getGeoStr()
            + ")";
      }

      public boolean isValid() {
         return this.valid;
      }

      public UUID getUuid() {
         return this.uuid;
      }

      public byte[] getSkinBytes() {
         return this.skinBytes;
      }

      public String getUidStr() {
         return this.uidStr;
      }

      public String getGeoStr() {
         return this.geoStr;
      }

      public void setValid(boolean valid) {
         this.valid = valid;
      }

      public void setUuid(UUID uuid) {
         this.uuid = uuid;
      }

      public void setSkinBytes(byte[] skinBytes) {
         this.skinBytes = skinBytes;
      }

      public void setUidStr(String uidStr) {
         this.uidStr = uidStr;
      }

      public void setGeoStr(String geoStr) {
         this.geoStr = geoStr;
      }

      @Override
      public boolean equals(Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof ConfirmSkinPacket.SkinEntry)) {
            return false;
         }

         ConfirmSkinPacket.SkinEntry other = (ConfirmSkinPacket.SkinEntry)o;
         if (!other.canEqual(this)) {
            return false;
         }

         if (this.isValid() != other.isValid()) {
            return false;
         }

         Object this$uuid = this.getUuid();
         Object other$uuid = other.getUuid();
         if (this$uuid == null ? other$uuid == null : this$uuid.equals(other$uuid)) {
            if (!Arrays.equals(this.getSkinBytes(), other.getSkinBytes())) {
               return false;
            } else {
               Object this$uidStr = this.getUidStr();
               Object other$uidStr = other.getUidStr();
               if (this$uidStr == null ? other$uidStr == null : this$uidStr.equals(other$uidStr)) {
                  Object this$geoStr = this.getGeoStr();
                  Object other$geoStr = other.getGeoStr();
                  return this$geoStr == null ? other$geoStr == null : this$geoStr.equals(other$geoStr);
               } else {
                  return false;
               }
            }
         } else {
            return false;
         }
      }

      protected boolean canEqual(Object other) {
         return other instanceof ConfirmSkinPacket.SkinEntry;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         result = result * 59 + (this.isValid() ? 79 : 97);
         Object $uuid = this.getUuid();
         result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
         result = result * 59 + Arrays.hashCode(this.getSkinBytes());
         Object $uidStr = this.getUidStr();
         result = result * 59 + ($uidStr == null ? 43 : $uidStr.hashCode());
         Object $geoStr = this.getGeoStr();
         return result * 59 + ($geoStr == null ? 43 : $geoStr.hashCode());
      }
   }
}
