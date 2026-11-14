package com.neteasemc.spigotmaster.playerInfo;

import java.util.UUID;

public class PlayerInfo {
   private String gameId = "";
   private String gameKey = "";
   private String gasServerUrl = "";
   private String webServerUrl = "";
   private int reviewStage = 0;
   private long proxyUid = 0L;
   private boolean isTestServer = false;
   private UUID uuid;

   public String getGameId() {
      return this.gameId;
   }

   public String getGameKey() {
      return this.gameKey;
   }

   public String getGasServerUrl() {
      return this.gasServerUrl;
   }

   public String getWebServerUrl() {
      return this.webServerUrl;
   }

   public int getReviewStage() {
      return this.reviewStage;
   }

   public long getProxyUid() {
      return this.proxyUid;
   }

   public boolean isTestServer() {
      return this.isTestServer;
   }

   public UUID getUuid() {
      return this.uuid;
   }

   public void setGameId(String gameId) {
      this.gameId = gameId;
   }

   public void setGameKey(String gameKey) {
      this.gameKey = gameKey;
   }

   public void setGasServerUrl(String gasServerUrl) {
      this.gasServerUrl = gasServerUrl;
   }

   public void setWebServerUrl(String webServerUrl) {
      this.webServerUrl = webServerUrl;
   }

   public void setReviewStage(int reviewStage) {
      this.reviewStage = reviewStage;
   }

   public void setProxyUid(long proxyUid) {
      this.proxyUid = proxyUid;
   }

   public void setTestServer(boolean isTestServer) {
      this.isTestServer = isTestServer;
   }

   public void setUuid(UUID uuid) {
      this.uuid = uuid;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlayerInfo)) {
         return false;
      }

      PlayerInfo other = (PlayerInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.reviewStage != other.reviewStage) {
         return false;
      }

      if (this.proxyUid != other.proxyUid) {
         return false;
      }

      if (this.isTestServer != other.isTestServer) {
         return false;
      }

      Object this$gameId = this.gameId;
      Object other$gameId = other.gameId;
      if (this$gameId == null ? other$gameId == null : this$gameId.equals(other$gameId)) {
         Object this$gameKey = this.gameKey;
         Object other$gameKey = other.gameKey;
         if (this$gameKey == null ? other$gameKey == null : this$gameKey.equals(other$gameKey)) {
            Object this$gasServerUrl = this.gasServerUrl;
            Object other$gasServerUrl = other.gasServerUrl;
            if (this$gasServerUrl == null ? other$gasServerUrl == null : this$gasServerUrl.equals(other$gasServerUrl)) {
               Object this$webServerUrl = this.webServerUrl;
               Object other$webServerUrl = other.webServerUrl;
               if (this$webServerUrl == null ? other$webServerUrl == null : this$webServerUrl.equals(other$webServerUrl)) {
                  Object this$uuid = this.uuid;
                  Object other$uuid = other.uuid;
                  return this$uuid == null ? other$uuid == null : this$uuid.equals(other$uuid);
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
      return other instanceof PlayerInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.reviewStage;
      long $proxyUid = this.proxyUid;
      result = result * 59 + (int)($proxyUid >>> 32 ^ $proxyUid);
      result = result * 59 + (this.isTestServer ? 79 : 97);
      Object $gameId = this.gameId;
      result = result * 59 + ($gameId == null ? 43 : $gameId.hashCode());
      Object $gameKey = this.gameKey;
      result = result * 59 + ($gameKey == null ? 43 : $gameKey.hashCode());
      Object $gasServerUrl = this.gasServerUrl;
      result = result * 59 + ($gasServerUrl == null ? 43 : $gasServerUrl.hashCode());
      Object $webServerUrl = this.webServerUrl;
      result = result * 59 + ($webServerUrl == null ? 43 : $webServerUrl.hashCode());
      Object $uuid = this.uuid;
      return result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
   }

   @Override
   public String toString() {
      return "PlayerInfo(gameId="
         + this.getGameId()
         + ", gameKey="
         + this.getGameKey()
         + ", gasServerUrl="
         + this.getGasServerUrl()
         + ", webServerUrl="
         + this.getWebServerUrl()
         + ", reviewStage="
         + this.getReviewStage()
         + ", proxyUid="
         + this.getProxyUid()
         + ", isTestServer="
         + this.isTestServer()
         + ", uuid="
         + this.getUuid()
         + ")";
   }
}
