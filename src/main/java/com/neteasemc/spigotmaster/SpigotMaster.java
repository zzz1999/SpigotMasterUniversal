package com.neteasemc.spigotmaster;

import com.neteasemc.protocol.custom.packet.geyserTransferPacket.GeyserTransferPacket;
import com.neteasemc.protocol.custom.packet.neteaseJsonPacket.NeteaseJsonPacket;
import com.neteasemc.protocol.custom.packet.setEntityDataPacket.SetEntityDataPacket;
import com.neteasemc.spigotmaster.enumData.ItemToTexture;
import com.neteasemc.spigotmaster.enumData.SpigotMasterEvent;
import com.neteasemc.spigotmaster.eventListener.ClientEventListener;
import com.neteasemc.spigotmaster.eventListener.CommandListener;
import com.neteasemc.spigotmaster.eventListener.EventListener;
import com.neteasemc.spigotmaster.util.WebUtil;
import com.neteasemc.spigotmaster.versionWrapper.VersionMatcher;
import com.neteasemc.spigotmaster.versionWrapper.VersionWrapper;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.JSONValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.EntityUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Colorable;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;
import org.geysermc.cumulus.form.Form;
import org.geysermc.cumulus.form.util.FormBuilder;
import org.msgpack.core.annotations.Nullable;

public class SpigotMaster extends JavaPlugin {
   private final String MESSAGE_NAME = "floodgate:netease";
   private PyRpcMessageListener pyRpcListener;
   private GeyserMessageListener geyserMsgListener;
   private EventListener eventListener;
   private ClientEventListener clientEventListener;
   private VersionWrapper versionWrapper;
   private String serverVersion;
   private CommandListener cmdListener;

   public void onEnable() {
      this.getLogger().info("com.neteasemc.spigotmaster.SpigotMaster onEnable");
      String var1 = this.getServer().getVersion();
      Pattern var2 = Pattern.compile("MC: (\\d+\\.\\d+(?:\\.\\d+)?)");
      Matcher var3 = var2.matcher(var1);
      if (var3.find() && var3.groupCount() >= 1) {
         this.serverVersion = var3.group(1);
      }

      this.versionWrapper = new VersionMatcher().match();
      this.pyRpcListener = new PyRpcMessageListener();
      this.getServer().getMessenger().registerIncomingPluginChannel(this, "floodgate:netease", this.pyRpcListener);
      this.getServer().getMessenger().registerOutgoingPluginChannel(this, "floodgate:netease");
      this.geyserMsgListener = new GeyserMessageListener(this, this.pyRpcListener);
      WebUtil.setPlugin(this);
      WebUtil.startHttpClient();
      this.clientEventListener = new ClientEventListener(this);
      this.eventListener = new EventListener(this);
      this.getServer().getPluginManager().registerEvents(this.eventListener, this);
      this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
         @Override
         public void run() {
            WebUtil.reportFriendOnline();
         }
      }, 0L, 6000L);
      InputStream var4 = this.getResource("plugin.yml");
      YamlConfiguration var5 = YamlConfiguration.loadConfiguration(new InputStreamReader(var4));
      boolean var6 = var5.getBoolean("is-debug", false);
      this.cmdListener = new CommandListener(this, var6);
   }

   public void onDisable() {
      WebUtil.stopHttpClient();
      this.getLogger().info("com.neteasemc.spigotmaster.SpigotMaster onDisable");
   }

   public void openCommand() {
      this.cmdListener.forceRegistCommand();
   }

   public Material getCustomItemMaterial(String var1) {
      this.getLogger().warning("该接口已经废弃");
      return null;
   }

   public String getCustomItemIdentifier(ItemStack var1) {
      return this.versionWrapper.getCustomItemIdentifier(var1);
   }

   public ItemStack setCustomItemIdentifier(ItemStack var1, String var2) {
      return this.versionWrapper.setCustomItemIdentifier(var1, var2);
   }

   public ItemStack setItemLayer(ItemStack var1, int var2, String var3) {
      return this.versionWrapper.setItemLayer(var1, var2, var3);
   }

   public String getItemLayer(ItemStack var1, int var2) {
      return this.versionWrapper.getItemLayer(var1, var2);
   }

   public ItemStack removeItemLayer(ItemStack var1, int var2) {
      return this.versionWrapper.removeItemLayer(var1, var2);
   }

   public void listenForSpigotMasterEvent(SpigotMasterEvent var1, PyRpcHandler var2) {
      this.pyRpcListener.listenForSpigotMasterEvent(var1, var2);
   }

   public void listenForEvent(String var1, String var2, String var3, PyRpcHandler var4) {
      this.pyRpcListener.listenForEvent(var1, var2, var3, var4);
   }

   public void notifyToClient(Player var1, String var2, String var3, String var4, Map<String, Object> var5) {
      try {
         var1.sendPluginMessage(this, "floodgate:netease", PyRpcPacker.pack(var2, var3, var4, var5));
      } catch (IOException var7) {
         var7.printStackTrace();
      }
   }

   public void notifyToMultiClients(List<Player> var1, String var2, String var3, String var4, Map<String, Object> var5) {
      try {
         byte[] var6 = PyRpcPacker.pack(var2, var3, var4, var5);

         for (Player var8 : var1) {
            var8.sendPluginMessage(this, "floodgate:netease", var6);
         }
      } catch (IOException var10) {
         var10.printStackTrace();
      }
   }

   public void notifyToClientsNearby(@Nullable Player var1, Location var2, double var3, String var5, String var6, String var7, Map<String, Object> var8) {
      try {
         byte[] var9 = PyRpcPacker.pack(var5, var6, var7, var8);

         for (Player var11 : var2.getWorld().getPlayers()) {
            if (var1 != var11) {
               Location var12 = var11.getLocation();
               double var13 = var2.getX() - var12.getX();
               double var15 = var2.getY() - var12.getY();
               double var17 = var2.getZ() - var12.getZ();
               if (var13 * var13 + var15 * var15 + var17 * var17 < var3 * var3) {
                  var11.sendPluginMessage(this, "floodgate:netease", var9);
               }
            }
         }
      } catch (IOException var20) {
         var20.printStackTrace();
      }
   }

   public void broadcastToAllClient(@Nullable Player var1, World var2, String var3, String var4, String var5, Map<String, Object> var6) {
      try {
         byte[] var7 = PyRpcPacker.pack(var3, var4, var5, var6);

         for (Player var9 : var2.getPlayers()) {
            if (var1 != var9) {
               var9.sendPluginMessage(this, "floodgate:netease", var7);
            }
         }
      } catch (IOException var11) {
         var11.printStackTrace();
      }
   }

   public void broadcastToAllClient(@Nullable Player var1, String var2, String var3, String var4, Map<String, Object> var5) {
      try {
         byte[] var6 = PyRpcPacker.pack(var2, var3, var4, var5);

         for (Player var8 : this.getServer().getOnlinePlayers()) {
            if (var1 != var8) {
               var8.sendPluginMessage(this, "floodgate:netease", var6);
            }
         }
      } catch (IOException var10) {
         var10.printStackTrace();
      }
   }

   public void enableCustomShopEntry(boolean var1) {
      this.clientEventListener.openShopPlugin(var1);
   }

   public void openShop(Player var1) {
      this.notifyToClient(var1, ClientEventListener.SHOP_MOD_NAME, ClientEventListener.SHOP_SERVER_SYS, "OpenShopEvent", new HashMap<>());
   }

   public void closeShop(Player var1) {
      this.notifyToClient(var1, ClientEventListener.SHOP_MOD_NAME, ClientEventListener.SHOP_SERVER_SYS, "CloseShopEvent", new HashMap<>());
   }

   public void showHintOne(Player var1, @Nullable String var2) {
      HashMap var3 = new HashMap();
      ArrayList var4 = new ArrayList();
      var4.add(var2);
      var3.put("hint", var4);
      var2 = var2 == null ? "" : var2;
      this.notifyToClient(var1, ClientEventListener.SHOP_MOD_NAME, ClientEventListener.SHOP_SERVER_SYS, "ShowHintEvent", var3);
   }

   public void showHintTwo(Player var1, String var2, @Nullable String var3) {
      var3 = var3 == null ? "" : var3;
      HashMap var4 = new HashMap();
      ArrayList var5 = new ArrayList();
      var5.add(var2);
      var5.add(var3);
      var4.put("hint", var5);
      this.notifyToClient(var1, ClientEventListener.SHOP_MOD_NAME, ClientEventListener.SHOP_SERVER_SYS, "ShowHintEvent", var4);
   }

   public void getPlayerOrderList(final Player var1, final FutureCallback<Map<String, Object>> var2) {
      FutureCallback var3 = new FutureCallback<HttpResponse>() {
         public void completed(HttpResponse var1x) {
            if (var1x.getStatusLine().getStatusCode() != 200) {
               var2.failed(new Exception("请求玩家订单失败，错误码:" + var1x.getStatusLine().getStatusCode()));
            } else {
               try {
                  String var2x = EntityUtils.toString(var1x.getEntity());
                  JSONObject var3 = (JSONObject)JSONValue.parse(var2x);
                  int var4 = (Integer)var3.get("code");
                  if (var4 != 0) {
                     var2.failed(new Exception("请求玩家订单失败，错误码:" + var4));
                     return;
                  }

                  Map var5 = new HashMap<>();
                  var5.put("player", var1);
                  var5.put("json_result", var3);
                  var2.completed(var5);
               } catch (Exception var6) {
                  var2.failed(new Exception("请求玩家订单失败,json数据解析失败"));
                  var6.printStackTrace();
               }
            }
         }

         @Override
         public void failed(Exception var1x) {
            var2.failed(var1x);
         }

         @Override
         public void cancelled() {
            var2.cancelled();
         }
      };
      WebUtil.postGetItemOrders(var1, var3);
   }

   public void finPlayerOrder(final Player var1, List<String> var2, final FutureCallback<Map<String, Object>> var3) {
      FutureCallback var4 = new FutureCallback<HttpResponse>() {
         public void completed(HttpResponse var1x) {
            if (var1x.getStatusLine().getStatusCode() != 200) {
               var3.failed(new Exception("通知网易服务器修改订单失败，错误码:" + var1x.getStatusLine().getStatusCode()));
            } else {
               try {
                  String var2 = EntityUtils.toString(var1x.getEntity());
                  JSONObject var3x = (JSONObject)JSONValue.parse(var2);
                  int var4 = (Integer)var3x.get("code");
                  if (var4 != 0) {
                     var3.failed(new Exception("通知网易服务器修改订单失败，错误码:" + var4));
                     return;
                  }

                  Map var5 = new HashMap<>();
                  var5.put("player", var1);
                  var5.put("json_result", var3x);
                  var3.completed(var5);
               } catch (Exception var6) {
                  var3.failed(new Exception("通知网易服务器修改订单失败,json数据解析失败"));
                  var6.printStackTrace();
               }
            }
         }

         @Override
         public void failed(Exception var1x) {
            var3.failed(var1x);
         }

         @Override
         public void cancelled() {
            var3.cancelled();
         }
      };
      WebUtil.postFinPlayerOrder(var1, var2, var4);
   }

   public void enableClientChatExtension(Player var1) {
      HashMap var2 = new HashMap();
      var2.put("open", true);
      this.notifyToClient(var1, ClientEventListener.ENGINE_NAME_SPACE, ClientEventListener.CHAT_EXTENSION_NAME, "ChatExtensionOpenStateChangedEvent", var2);
   }

   public void disableClientChatExtension(Player var1) {
      HashMap var2 = new HashMap();
      var2.put("open", false);
      this.notifyToClient(var1, ClientEventListener.ENGINE_NAME_SPACE, ClientEventListener.CHAT_EXTENSION_NAME, "ChatExtensionOpenStateChangedEvent", var2);
   }

   public String getCustomEntityIdentifier(Entity var1) {
      return this.versionWrapper.getCustomEntityIdentifier(var1);
   }

   public Entity spawnEntity(Player var1, Location var2, EntityType var3, String var4) {
      Class var5 = var3.getEntityClass();
      SpigotMaster var6 = this;
      return var1.getWorld().spawn(var2, var5, var2x -> var6.setCustomEntityIdentifier(var2x, var4));
   }

   public void spawnEntity(Player var1, Entity var2, String var3) {
      SpigotMaster var4 = this;
      var4.setCustomEntityIdentifier(var2, var3);
      this.versionWrapper.addEntity(var1, var2, SpawnReason.CUSTOM);
   }

   public Entity spawnEntity(World var1, Location var2, EntityType var3, String var4) {
      Class var5 = var3.getEntityClass();
      SpigotMaster var6 = this;
      return var1.spawn(var2, var5, var2x -> var6.setCustomEntityIdentifier(var2x, var4));
   }

   public void spawnEntity(World var1, Entity var2, String var3) {
      SpigotMaster var4 = this;
      var4.setCustomEntityIdentifier(var2, var3);
      this.versionWrapper.addEntity(var1, var2, SpawnReason.CUSTOM);
   }

   public Entity setCustomEntityIdentifier(Entity var1, String var2) {
      return this.versionWrapper.setCustomEntityIdentifier(var1, var2);
   }

   public boolean sendForm(Player var1, Form var2) {
      return this.geyserMsgListener.getFormHandler().sendForm(var1, var2);
   }

   public boolean sendForm(Player var1, FormBuilder<?, ?, ?> var2) {
      return this.geyserMsgListener.getFormHandler().sendForm(var1, var2.build());
   }

   public void setEntitySize(Entity var1, float var2, float var3) {
      this.versionWrapper.setEntitySize(var1, var2, var3);
      SetEntityDataPacket var4 = new SetEntityDataPacket(var1.getEntityId(), var2, var3);
      this.geyserMsgListener.broadcastToAllClient(var4, null);
   }

   public void setMythicMobIdentifier(Entity var1, String var2) {
      var2 = var2.replaceFirst(String.valueOf(var2.charAt(0)), String.valueOf(Character.toLowerCase(var2.charAt(0))));
      var2 = "mythicmob:" + var2;
      this.versionWrapper.setCustomEntityIdentifier(var1, var2);
   }

   public void setEntityScale(Entity var1, float var2) {
      SetEntityDataPacket var3 = new SetEntityDataPacket(var1.getEntityId(), var2);
      this.geyserMsgListener.broadcastToAllClient(var3, null);
   }

   public void sendBedrockPacket(int var1, byte[] var2) {
      GeyserTransferPacket var3 = new GeyserTransferPacket(var1, var2);
      this.geyserMsgListener.broadcastToAllClient(var3, null);
   }

   public void sendBedrockPacketToPlayer(int var1, byte[] var2, Player var3) {
      GeyserTransferPacket var4 = new GeyserTransferPacket(var1, var2);
      this.geyserMsgListener.sendToClient(var3, var4);
   }

   public void setEntityGravity(int var1, float var2) {
      JSONObject var3 = new JSONObject();
      var3.put("eventName", "SET_ENTITY_GRAVITY");
      var3.put("entityId", var1);
      var3.put("gravity", var2);
      String var4 = var3.toJSONString();
      NeteaseJsonPacket var5 = new NeteaseJsonPacket(var4);
      this.geyserMsgListener.broadcastToAllClient(var5, null);
   }

   public String getItemIconPath(ItemStack var1) {
      Material var2 = var1.getType();
      String var3 = var2.name().toLowerCase();
      String var4 = "textures/";
      if (var2.isBlock()) {
         var4 = var4 + "blocks/";
         MaterialData var5 = var1.getData();
         if (var5 instanceof Colorable) {
            Colorable var6 = (Colorable)var5;
            String var7 = var6.getColor().name().toLowerCase();
            if ("WOOL".equals(var2.name())) {
               var4 = var4 + var3 + "_colored_" + var7;
            } else {
               var4 = var4 + var3 + "_" + var7;
            }
         } else {
            String var8 = ItemToTexture.ItemTypeToTexture.getOrDefault(var2, var3 + "_side");
            var4 = var4 + var8;
         }
      } else {
         String var11 = ItemToTexture.ItemTypeToTexture.getOrDefault(var2, var3);
         var4 = var4 + "items/" + var11;
      }

      return var4 + ".png";
   }

   public PyRpcMessageListener getPyRpcListener() {
      return this.pyRpcListener;
   }

   public GeyserMessageListener getGeyserMsgListener() {
      return this.geyserMsgListener;
   }

   public EventListener getEventListener() {
      return this.eventListener;
   }

   public ClientEventListener getClientEventListener() {
      return this.clientEventListener;
   }

   public VersionWrapper getVersionWrapper() {
      return this.versionWrapper;
   }

   public String getServerVersion() {
      return this.serverVersion;
   }

   public CommandListener getCmdListener() {
      return this.cmdListener;
   }
}
