package com.neteasemc.spigotmaster.util;

import com.neteasemc.spigotmaster.SpigotMaster;
import com.neteasemc.spigotmaster.playerInfo.PlayerInfo;
import com.nimbusds.jose.shaded.json.JSONObject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WebUtil {
   private static final CloseableHttpAsyncClient httpClient = HttpAsyncClients.createDefault();
   private static SpigotMaster plugin;
   public static String SKIN_VALID_URL = "/pe/web/skin-md5-valid-inner";
   public static String SHIP_ITEM_URL = "/ship-mc-item-order";
   public static String GET_ORDER_ITEM_URL = "/get-mc-item-order-list";
   public static String REPORT_FRIEND_ONLINE_URL = "/game-server-info/collect-play-list";
   public static String GAS_SERVER_BASE_URL = "http://gasproxy.mc.netease.com:60002";
   public static String TEST_GAS_SERVER_BASE_URL = "http://gasproxy.mc.netease.com:60001";

   public static void setPlugin(JavaPlugin javaPlugin) {
      plugin = (SpigotMaster)javaPlugin;
   }

   public static void startHttpClient() {
      plugin.getLogger().info("http client start");
      httpClient.start();
      plugin.getLogger().info("http client start success");
   }

   public static void stopHttpClient() {
      plugin.getLogger().info("http client start closing");

      try {
         httpClient.close();
         plugin.getLogger().info("http client close success");
      } catch (IOException e) {
         plugin.getLogger().warning("http client close error:" + e);
         e.printStackTrace();
      }
   }

   public static void postGetItemOrders(Player player, FutureCallback<HttpResponse> callback) {
      try {
         PlayerInfo playerinfo = plugin.getGeyserMsgListener().getPlayerInfo(player);
         String json = "";
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("gameid", playerinfo.getGameId());
         jsonObject.put("uuid", playerinfo.getUuid().toString());
         json = jsonObject.toString();
         String validUrl = getShipBaseUrl(playerinfo.getGasServerUrl(), playerinfo.isTestServer()) + GET_ORDER_ITEM_URL;
         Map<String, String> headMaps = new HashMap<>();
         String signStr = getServerSign(playerinfo.getGameKey(), "POST", GET_ORDER_ITEM_URL, json);
         headMaps.put("Netease-Server-Sign", signStr);
         StringEntity entity = new StringEntity(json);
         postFormWithExtraHead(validUrl, headMaps, entity, callback);
      } catch (Exception e) {
         plugin.getLogger().warning("http client init get item orders post url error:" + e);
         e.printStackTrace();
      }
   }

   public static void postFinPlayerOrder(Player player, List<String> orderIds, FutureCallback<HttpResponse> callback) {
      try {
         PlayerInfo playerinfo = plugin.getGeyserMsgListener().getPlayerInfo(player);
         String json = "";
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("gameid", playerinfo.getGameId());
         jsonObject.put("uuid", playerinfo.getUuid().toString());
         jsonObject.put("orderid_list", orderIds);
         json = jsonObject.toString();
         String validUrl = getShipBaseUrl(playerinfo.getGasServerUrl(), playerinfo.isTestServer()) + SHIP_ITEM_URL;
         Map<String, String> headMaps = new HashMap<>();
         String signStr = getServerSign(playerinfo.getGameKey(), "POST", SHIP_ITEM_URL, json);
         headMaps.put("Netease-Server-Sign", signStr);
         StringEntity entity = new StringEntity(json);
         postFormWithExtraHead(validUrl, headMaps, entity, callback);
      } catch (Exception e) {
         plugin.getLogger().warning("http client init ship item orders post url error:" + e);
         e.printStackTrace();
      }
   }

   public static void postSkinValidForm(
      String validUrl, List<String> md5List, List<String> uidList, List<String> geoList, FutureCallback<HttpResponse> callback
   ) {
      String json = "";
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("sign", "62bd6025d29b17ff");
      jsonObject.put("md5_list", md5List);
      jsonObject.put("uid_list", uidList);
      jsonObject.put("geo_list", geoList);
      json = jsonObject.toString();

      try {
         StringEntity entity = new StringEntity(json);
         postForm(validUrl, entity, callback);
      } catch (UnsupportedEncodingException e) {
         plugin.getLogger().warning("http client init skin valid post url error:" + e);
         e.printStackTrace();
      }
   }

   public static void postForm(String url, AbstractHttpEntity Entity, FutureCallback<HttpResponse> callback) {
      HttpPost post = new HttpPost(url);
      post.addHeader("Content-Type", "application/json");
      post.addHeader("Accept", "application/json");
      post.setEntity(Entity);
      httpClient.execute(post, callback);
   }

   public static void postFormWithExtraHead(String url, Map<String, String> headMap, AbstractHttpEntity Entity, FutureCallback<HttpResponse> callback) {
      HttpPost post = new HttpPost(url);
      post.addHeader("Content-Type", "application/json");
      post.addHeader("Accept", "application/json");

      for (Entry<String, String> entry : headMap.entrySet()) {
         post.addHeader(entry.getKey(), entry.getValue());
      }

      post.setEntity(Entity);
      httpClient.execute(post, callback);
   }

   public static String getShipBaseUrl(String gasServerUrl, Boolean isTestServer) {
      if (!gasServerUrl.equals("")) {
         return gasServerUrl;
      } else {
         return isTestServer ? TEST_GAS_SERVER_BASE_URL : GAS_SERVER_BASE_URL;
      }
   }

   public static String getServerSign(String signKey, String method, String path, String httpBody) throws Exception {
      String str2sign = method + path + httpBody;
      String signStr = hmacWithJava("HmacSHA256", str2sign, signKey);
      if (signStr.length() < 64) {
         int preLen = 64 - signStr.length();
         String preZero = "0";
         signStr = String.join("", Collections.nCopies(preLen, preZero)) + signStr;
      }

      return signStr;
   }

   public static String hmacWithJava(String algorithm, String data, String key) throws Exception {
      SecretKey skey = new SecretKeySpec(key.getBytes(), algorithm);
      Mac mac = Mac.getInstance(algorithm);
      mac.init(skey);
      mac.update(data.getBytes());
      byte[] res = mac.doFinal();
      return new BigInteger(1, res).toString(16);
   }

   public static String toMd5WithPreZero(String string) throws NoSuchAlgorithmException {
      MessageDigest digest = MessageDigest.getInstance("MD5");
      byte[] tempRes = digest.digest(string.getBytes(StandardCharsets.UTF_8));
      StringBuffer buf = new StringBuffer("");

      for (int i = 0; i < tempRes.length; i++) {
         int cur = tempRes[i];
         if (cur < 0) {
            cur += 256;
         }

         if (cur < 16) {
            buf.append("0");
         }

         buf.append(Integer.toHexString(cur));
      }

      return buf.toString();
   }

   public static void reportFriendOnline() {
      if (Bukkit.getOnlinePlayers().size() > 1) {
         plugin.getLogger().info("send reportFriendOnline");
         ArrayList<String> uids = new ArrayList<>();
         String webServerUrl = null;

         for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerInfo playerinfo = plugin.getGeyserMsgListener().getPlayerInfo(player);
            uids.add(Long.toString(playerinfo.getProxyUid()));
            if (webServerUrl == null) {
               webServerUrl = playerinfo.getWebServerUrl();
            }
         }

         JSONObject jsonObject = new JSONObject();
         jsonObject.put("sign", "62bd6025d29b17ff");
         jsonObject.put("uids", uids);
         jsonObject.put("game_type", "network");
         String json = jsonObject.toString();
         String url = webServerUrl + REPORT_FRIEND_ONLINE_URL;

         try {
            StringEntity entity = new StringEntity(json);
            postForm(url, entity, null);
         } catch (UnsupportedEncodingException e) {
            plugin.getLogger().warning("http report friend online url error:" + e);
            e.printStackTrace();
         }
      }
   }
}
