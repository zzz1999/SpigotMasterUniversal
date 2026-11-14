package com.neteasemc.spigotmaster.skinData;

public class SkinData {
   private String uidStr = "";
   private String geoStr = "";
   private String userName = "";
   private String skinData = "";
   private int skinWidth;
   private int skinHeight;
   private String capeIdStr = "";
   private String capeData = "";
   private int capeWidth;
   private int capeHeight;
   private String playFabIdStr = "";
   private boolean isOther = false;
   private String xuid = "";
   private String skinResourcePatch = "";
   private String fulllSkinId = "";

   public String getUidStr() {
      return this.uidStr;
   }

   public String getGeoStr() {
      return this.geoStr;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getSkinData() {
      return this.skinData;
   }

   public int getSkinWidth() {
      return this.skinWidth;
   }

   public int getSkinHeight() {
      return this.skinHeight;
   }

   public String getCapeIdStr() {
      return this.capeIdStr;
   }

   public String getCapeData() {
      return this.capeData;
   }

   public int getCapeWidth() {
      return this.capeWidth;
   }

   public int getCapeHeight() {
      return this.capeHeight;
   }

   public String getPlayFabIdStr() {
      return this.playFabIdStr;
   }

   public boolean isOther() {
      return this.isOther;
   }

   public String getXuid() {
      return this.xuid;
   }

   public String getSkinResourcePatch() {
      return this.skinResourcePatch;
   }

   public String getFulllSkinId() {
      return this.fulllSkinId;
   }

   public void setUidStr(String uidStr) {
      this.uidStr = uidStr;
   }

   public void setGeoStr(String geoStr) {
      this.geoStr = geoStr;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public void setSkinData(String skinData) {
      this.skinData = skinData;
   }

   public void setSkinWidth(int skinWidth) {
      this.skinWidth = skinWidth;
   }

   public void setSkinHeight(int skinHeight) {
      this.skinHeight = skinHeight;
   }

   public void setCapeIdStr(String capeIdStr) {
      this.capeIdStr = capeIdStr;
   }

   public void setCapeData(String capeData) {
      this.capeData = capeData;
   }

   public void setCapeWidth(int capeWidth) {
      this.capeWidth = capeWidth;
   }

   public void setCapeHeight(int capeHeight) {
      this.capeHeight = capeHeight;
   }

   public void setPlayFabIdStr(String playFabIdStr) {
      this.playFabIdStr = playFabIdStr;
   }

   public void setOther(boolean isOther) {
      this.isOther = isOther;
   }

   public void setXuid(String xuid) {
      this.xuid = xuid;
   }

   public void setSkinResourcePatch(String skinResourcePatch) {
      this.skinResourcePatch = skinResourcePatch;
   }

   public void setFulllSkinId(String fulllSkinId) {
      this.fulllSkinId = fulllSkinId;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SkinData)) {
         return false;
      }

      SkinData other = (SkinData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.skinWidth != other.skinWidth) {
         return false;
      }

      if (this.skinHeight != other.skinHeight) {
         return false;
      }

      if (this.capeWidth != other.capeWidth) {
         return false;
      }

      if (this.capeHeight != other.capeHeight) {
         return false;
      }

      if (this.isOther != other.isOther) {
         return false;
      }

      Object this$uidStr = this.uidStr;
      Object other$uidStr = other.uidStr;
      if (this$uidStr == null ? other$uidStr == null : this$uidStr.equals(other$uidStr)) {
         Object this$geoStr = this.geoStr;
         Object other$geoStr = other.geoStr;
         if (this$geoStr == null ? other$geoStr == null : this$geoStr.equals(other$geoStr)) {
            Object this$userName = this.userName;
            Object other$userName = other.userName;
            if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
               Object this$skinData = this.skinData;
               Object other$skinData = other.skinData;
               if (this$skinData == null ? other$skinData == null : this$skinData.equals(other$skinData)) {
                  Object this$capeIdStr = this.capeIdStr;
                  Object other$capeIdStr = other.capeIdStr;
                  if (this$capeIdStr == null ? other$capeIdStr == null : this$capeIdStr.equals(other$capeIdStr)) {
                     Object this$capeData = this.capeData;
                     Object other$capeData = other.capeData;
                     if (this$capeData == null ? other$capeData == null : this$capeData.equals(other$capeData)) {
                        Object this$playFabIdStr = this.playFabIdStr;
                        Object other$playFabIdStr = other.playFabIdStr;
                        if (this$playFabIdStr == null ? other$playFabIdStr == null : this$playFabIdStr.equals(other$playFabIdStr)) {
                           Object this$xuid = this.xuid;
                           Object other$xuid = other.xuid;
                           if (this$xuid == null ? other$xuid == null : this$xuid.equals(other$xuid)) {
                              Object this$skinResourcePatch = this.skinResourcePatch;
                              Object other$skinResourcePatch = other.skinResourcePatch;
                              if (this$skinResourcePatch == null ? other$skinResourcePatch == null : this$skinResourcePatch.equals(other$skinResourcePatch)) {
                                 Object this$fulllSkinId = this.fulllSkinId;
                                 Object other$fulllSkinId = other.fulllSkinId;
                                 return this$fulllSkinId == null ? other$fulllSkinId == null : this$fulllSkinId.equals(other$fulllSkinId);
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof SkinData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.skinWidth;
      result = result * 59 + this.skinHeight;
      result = result * 59 + this.capeWidth;
      result = result * 59 + this.capeHeight;
      result = result * 59 + (this.isOther ? 79 : 97);
      Object $uidStr = this.uidStr;
      result = result * 59 + ($uidStr == null ? 43 : $uidStr.hashCode());
      Object $geoStr = this.geoStr;
      result = result * 59 + ($geoStr == null ? 43 : $geoStr.hashCode());
      Object $userName = this.userName;
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $skinData = this.skinData;
      result = result * 59 + ($skinData == null ? 43 : $skinData.hashCode());
      Object $capeIdStr = this.capeIdStr;
      result = result * 59 + ($capeIdStr == null ? 43 : $capeIdStr.hashCode());
      Object $capeData = this.capeData;
      result = result * 59 + ($capeData == null ? 43 : $capeData.hashCode());
      Object $playFabIdStr = this.playFabIdStr;
      result = result * 59 + ($playFabIdStr == null ? 43 : $playFabIdStr.hashCode());
      Object $xuid = this.xuid;
      result = result * 59 + ($xuid == null ? 43 : $xuid.hashCode());
      Object $skinResourcePatch = this.skinResourcePatch;
      result = result * 59 + ($skinResourcePatch == null ? 43 : $skinResourcePatch.hashCode());
      Object $fulllSkinId = this.fulllSkinId;
      return result * 59 + ($fulllSkinId == null ? 43 : $fulllSkinId.hashCode());
   }

   @Override
   public String toString() {
      return "SkinData(uidStr="
         + this.getUidStr()
         + ", geoStr="
         + this.getGeoStr()
         + ", userName="
         + this.getUserName()
         + ", skinData="
         + this.getSkinData()
         + ", skinWidth="
         + this.getSkinWidth()
         + ", skinHeight="
         + this.getSkinHeight()
         + ", capeIdStr="
         + this.getCapeIdStr()
         + ", capeData="
         + this.getCapeData()
         + ", capeWidth="
         + this.getCapeWidth()
         + ", capeHeight="
         + this.getCapeHeight()
         + ", playFabIdStr="
         + this.getPlayFabIdStr()
         + ", isOther="
         + this.isOther()
         + ", xuid="
         + this.getXuid()
         + ", skinResourcePatch="
         + this.getSkinResourcePatch()
         + ", fulllSkinId="
         + this.getFulllSkinId()
         + ")";
   }
}
