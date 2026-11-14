package com.neteasemc.spigotmaster.eventListener;

import com.neteasemc.spigotmaster.EnginePyRpcHandler;
import com.neteasemc.spigotmaster.PyRpcHandler;
import com.neteasemc.spigotmaster.SpigotMaster;
import com.neteasemc.spigotmaster.enumData.SpigotMasterEvent;
import com.neteasemc.spigotmaster.playerInfo.PlayerInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.entity.Player;

public class ClientEventListener {
   private SpigotMaster plugin;
   public static String ENGINE_NAME_SPACE = "Minecraft";
   public static String ENGINE_SYSTEM_NAME = "Engine";
   public static String CHAT_EXTENSION_NAME = "chatExtension";
   public static String SHOP_MOD_NAME = "neteaseShop";
   public static String SHOP_SERVER_SYS = "neteaseShopDev";
   public static String SHOP_CLIENT_SYS = "neteaseShopBeh";

   public ClientEventListener(final SpigotMaster plugin) {
      this.plugin = plugin;
      plugin.getPyRpcListener().listenForClientEngineCall("ClientLoadAddonsFinishedFromGac", new EnginePyRpcHandler() {
         @Override
         public void onEvent(Player player, List<Object> data) {
            plugin.getClientEventListener().onClientLoadAddonFinish(player);
            plugin.getPyRpcListener().fireSpigotMasterEvent(SpigotMasterEvent.CLIENT_LOAD_ADDON_FINISH, player, null);
         }
      });
   }

   public boolean onClientLoadAddonFinish(Player player) {
      try {
         this.sendRoomChatEvent(player);
      } catch (Exception e) {
         this.plugin.getLogger().warning("spigotMaster run client load addon failed:" + e);
      }

      return true;
   }

   public void sendRoomChatEvent(Player player) {
      PlayerInfo playerInfo = this.plugin.getGeyserMsgListener().getPlayerInfo(player);
      if (playerInfo == null) {
         this.plugin.getLogger().info("player info is null,from chat");
      } else {
         Map<String, Object> selfData = new HashMap<>();
         List<String> allUids = this.plugin.getGeyserMsgListener().getAllPlayerUidStrs();
         selfData.put("uids", allUids);
         this.plugin.notifyToClient(player, ENGINE_NAME_SPACE, CHAT_EXTENSION_NAME, "RoomPlayerList", selfData);
         long uid = playerInfo.getProxyUid();
         Map<String, Object> otherData = new HashMap<>();
         List<String> otherUids = Arrays.asList(Long.toString(uid));
         otherData.put("uids", otherUids);
         this.plugin.broadcastToAllClient(player, ENGINE_NAME_SPACE, CHAT_EXTENSION_NAME, "PlayerAddRoom", otherData);
      }
   }

   public boolean openShopPlugin(final boolean useCustomShop) {
      this.plugin
         .listenForEvent(
            SHOP_MOD_NAME,
            SHOP_CLIENT_SYS,
            "clientEnterEvent",
            new PyRpcHandler() {
               @Override
               public void onEvent(Player player, Map<String, Object> data) {
                  PlayerInfo playerInfo = ClientEventListener.this.plugin.getGeyserMsgListener().getPlayerInfo(player);
                  if (playerInfo == null) {
                     ClientEventListener.this.plugin.getLogger().info("player info is null,from shop");
                  } else {
                     Map<String, Object> resData = new HashMap<>();
                     resData.put("gameId", playerInfo.getGameId());
                     resData.put("isTestServer", playerInfo.isTestServer());
                     resData.put("useCustomShop", useCustomShop);
                     resData.put("cacheTime", 1);
                     resData.put("uid", playerInfo.getProxyUid());
                     resData.put("platformUid", "");
                     ClientEventListener.this.plugin
                        .notifyToClient(player, ClientEventListener.SHOP_MOD_NAME, ClientEventListener.SHOP_SERVER_SYS, "serverReadyEvent", resData);
                  }
               }
            }
         );
      this.plugin.listenForEvent(SHOP_MOD_NAME, SHOP_CLIENT_SYS, "clientForceShipEvent", new PyRpcHandler() {
         @Override
         public void onEvent(Player player, Map<String, Object> data) {
            ClientEventListener.this.plugin.getPyRpcListener().fireSpigotMasterEvent(SpigotMasterEvent.PLAYER_URGE_SHIP, player, null);
         }
      });
      this.plugin.getPyRpcListener().listenForClientEngineCall("UrgeShipEvent", new EnginePyRpcHandler() {
         @Override
         public void onEvent(Player player, List<Object> data) {
            ClientEventListener.this.plugin.getPyRpcListener().fireSpigotMasterEvent(SpigotMasterEvent.PLAYER_URGE_SHIP, player, null);
         }
      });
      this.plugin.getPyRpcListener().listenForClientEngineCall("StoreBuySuccServerEvent", new EnginePyRpcHandler() {
         @Override
         public void onEvent(Player player, List<Object> data) {
            ClientEventListener.this.plugin.getPyRpcListener().fireSpigotMasterEvent(SpigotMasterEvent.PLAYER_BUY_ITEM_SUCCESS, player, null);
         }
      });
      this.plugin.listenForEvent(SHOP_MOD_NAME, SHOP_CLIENT_SYS, "clientBuyItemPaySuccessEvent", new PyRpcHandler() {
         @Override
         public void onEvent(Player player, Map<String, Object> data) {
            ClientEventListener.this.plugin.getPyRpcListener().fireSpigotMasterEvent(SpigotMasterEvent.PLAYER_BUY_ITEM_SUCCESS, player, null);
         }
      });
      return true;
   }
}
