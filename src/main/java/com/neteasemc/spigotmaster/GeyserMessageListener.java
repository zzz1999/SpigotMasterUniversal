package com.neteasemc.spigotmaster;

import com.neteasemc.protocol.custom.GeyserBaseCode;
import com.neteasemc.protocol.custom.GeyserBasePacket;
import com.neteasemc.protocol.custom.packet.customItemPacket.CustomItemPacket;
import com.neteasemc.protocol.custom.packet.customItemPacket.CustomItemPacketSerializer;
import com.neteasemc.protocol.custom.packet.formPacket.FormPacket;
import com.neteasemc.protocol.custom.packet.formPacket.FormPacketSerializer;
import com.neteasemc.protocol.custom.packet.geyserTransferPacket.GeyserTransferPacket;
import com.neteasemc.protocol.custom.packet.geyserTransferPacket.GeyserTransferPacketSerializer;
import com.neteasemc.protocol.custom.packet.neteaseJsonPacket.NeteaseJsonPacket;
import com.neteasemc.protocol.custom.packet.neteaseJsonPacket.NeteaseJsonPacketSerializer;
import com.neteasemc.protocol.custom.packet.playerInfoPacket.PlayerInfoPacket;
import com.neteasemc.protocol.custom.packet.playerInfoPacket.PlayerInfoPacketSerializer;
import com.neteasemc.protocol.custom.packet.setEntityDataPacket.SetEntityDataPacket;
import com.neteasemc.protocol.custom.packet.setEntityDataPacket.SetEntityDataPacketSerializer;
import com.neteasemc.protocol.custom.packet.skinConfirmPacket.SkinConfirmPacket;
import com.neteasemc.protocol.custom.packet.skinConfirmPacket.SkinConfirmPacketSerializer;
import com.neteasemc.protocol.custom.packet.spigotInfoPacket.SpigotInfoPacket;
import com.neteasemc.protocol.custom.packet.spigotInfoPacket.SpigotInfoPacketSerializer;
import com.neteasemc.spigotmaster.playerInfo.PlayerInfo;
import com.neteasemc.spigotmaster.skinData.SkinData;
import com.nukkitx.network.VarInts;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.DataFormatException;
import javax.annotation.Nullable;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class GeyserMessageListener implements PluginMessageListener {
   private GeyserBaseCode baseCode;
   private GeyserPacketHandler packetHandler;
   private FormHandler formHandler;
   private JavaPlugin plugin;
   private final String GEYSER_MSG_NAME = "geyser:msg";
   private Map<UUID, SkinData> uuidToSkinData = new ConcurrentHashMap<>();
   private Map<UUID, PlayerInfo> playerInfos = new ConcurrentHashMap<>();

   public List<Long> getAllPlayerUids() {
      List<Long> res = new ArrayList<>();

      for (PlayerInfo info : this.playerInfos.values()) {
         res.add(info.getProxyUid());
      }

      return res;
   }

   public List<String> getAllPlayerUidStrs() {
      List<String> res = new ArrayList<>();

      for (PlayerInfo info : this.playerInfos.values()) {
         long tmp = info.getProxyUid();
         res.add(Long.toString(tmp));
      }

      return res;
   }

   public PlayerInfo getPlayerInfo(Player player) {
      return this.playerInfos.getOrDefault(player.getUniqueId(), null);
   }

   public void setPlayerInfo(PlayerInfoPacket packet, Player player) {
      UUID uuid = player.getUniqueId();
      PlayerInfo info = new PlayerInfo();
      info.setGameId(packet.getGameId());
      info.setGameKey(packet.getGameKey());
      info.setGasServerUrl(packet.getGasServerUrl());
      info.setWebServerUrl(packet.getWebServerUrl());
      info.setReviewStage(packet.getReviewStage());
      info.setProxyUid(packet.getProxyUid());
      info.setUuid(packet.getUuid());
      if (packet.getReviewStage() != 2) {
         info.setTestServer(true);
      }

      this.playerInfos.put(uuid, info);
   }

   public void removePlayerInfo(Player player) {
      UUID javaUuid = player.getUniqueId();
      this.playerInfos.remove(javaUuid);
   }

   public void removeConfirmSkinData(Player player) {
      UUID javaUuid = player.getUniqueId();
      this.uuidToSkinData.remove(javaUuid);
   }

   public void addConfirmSkinData(SkinConfirmPacket packet, Player player) {
      SkinData skinData = new SkinData();
      skinData.setUidStr(packet.getUidStr());
      skinData.setUserName(packet.getUserName());
      skinData.setGeoStr(packet.getGeoStr());
      skinData.setSkinData(packet.getSkinData());
      skinData.setSkinWidth(packet.getSkinWidth());
      skinData.setSkinHeight(packet.getSkinHeight());
      skinData.setCapeIdStr(packet.getCapeIdStr());
      skinData.setCapeData(packet.getCapeData());
      skinData.setCapeWidth(packet.getCapeWidth());
      skinData.setCapeHeight(packet.getCapeHeight());
      skinData.setPlayFabIdStr(packet.getPlayFabIdStr());
      skinData.setFulllSkinId(packet.getFulllSkinId());
      skinData.setSkinResourcePatch(packet.getSkinResourcePatch());
      UUID javaUuid = player.getUniqueId();
      this.uuidToSkinData.put(javaUuid, skinData);
      packet.setJavaUuid(javaUuid);
      this.sendToClient(player, packet);
      packet.setUuid(javaUuid);
      this.broadcastToAllClient(packet, player);
   }

   public void checkSkin(SkinConfirmPacket packet, Player player) {
      UUID uuid = packet.getUuid();
      if (this.uuidToSkinData.containsKey(uuid)) {
         SkinData skinData = this.uuidToSkinData.get(uuid);
         packet.setUidStr(skinData.getUidStr());
         packet.setUserName(skinData.getUserName());
         packet.setGeoStr(skinData.getGeoStr());
         packet.setSkinData(skinData.getSkinData());
         packet.setSkinWidth(skinData.getSkinWidth());
         packet.setSkinHeight(skinData.getSkinHeight());
         packet.setCapeIdStr(skinData.getCapeIdStr());
         packet.setCapeData(skinData.getCapeData());
         packet.setCapeWidth(skinData.getCapeWidth());
         packet.setCapeHeight(skinData.getCapeHeight());
         packet.setPlayFabIdStr(skinData.getPlayFabIdStr());
         packet.setFulllSkinId(skinData.getFulllSkinId());
         packet.setSkinResourcePatch(skinData.getSkinResourcePatch());
         packet.setUuid(uuid);
         this.sendToClient(player, packet);
      }
   }

   public GeyserMessageListener(JavaPlugin plugin, PyRpcMessageListener pyRpcListener) {
      this.plugin = plugin;
      this.plugin.getLogger().info("init packet coder");
      this.baseCode = GeyserBaseCode.builder()
         .registerPacket(SkinConfirmPacket.class, SkinConfirmPacketSerializer.INSTANCE, 1)
         .registerPacket(CustomItemPacket.class, CustomItemPacketSerializer.INSTANCE, 2)
         .registerPacket(PlayerInfoPacket.class, PlayerInfoPacketSerializer.INSTANCE, 3)
         .registerPacket(SpigotInfoPacket.class, SpigotInfoPacketSerializer.INSTANCE, 4)
         .registerPacket(FormPacket.class, FormPacketSerializer.INSTANCE, 5)
         .registerPacket(SetEntityDataPacket.class, SetEntityDataPacketSerializer.INSTANCE, 6)
         .registerPacket(NeteaseJsonPacket.class, NeteaseJsonPacketSerializer.INSTANCE, 7)
         .registerPacket(GeyserTransferPacket.class, GeyserTransferPacketSerializer.INSTANCE, 8)
         .build();
      this.packetHandler = new GeyserPacketHandler(this, pyRpcListener);
      this.formHandler = new FormHandler(this);
      this.plugin.getServer().getMessenger().registerIncomingPluginChannel(this.plugin, "geyser:msg", this);
      this.plugin.getServer().getMessenger().registerOutgoingPluginChannel(this.plugin, "geyser:msg");
   }

   public void sendToClient(Player player, GeyserBasePacket packet) {
      ByteBuf buffer = ByteBufAllocator.DEFAULT.heapBuffer();

      try {
         this.baseCode.tryEncode(buffer, packet);
         byte[] payload = new byte[buffer.readableBytes()];
         buffer.readBytes(payload);
         this._sendToClient(player, payload);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         buffer.release();
      }
   }

   public void broadcastToAllClient(GeyserBasePacket packet, @Nullable Player except) {
      ByteBuf buffer = ByteBufAllocator.DEFAULT.heapBuffer();

      try {
         this.baseCode.tryEncode(buffer, packet);
         byte[] payload = new byte[buffer.readableBytes()];
         buffer.readBytes(payload);

         for (Player player : this.plugin.getServer().getOnlinePlayers()) {
            if (except != player) {
               this._sendToClient(player, payload);
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         buffer.release();
      }
   }

   public void onPluginMessageReceived(String s, Player player, byte[] bytes) {
      ByteBuf buffer = Unpooled.wrappedBuffer(bytes);

      try {
         if (!buffer.isReadable()) {
            throw new DataFormatException("packet is null");
         }

         int header = VarInts.readUnsignedInt(buffer);
         int packetId = header & 1023;
         GeyserBasePacket packet = this.baseCode.tryDecode(buffer, packetId);
         packet.handle(this.packetHandler, player);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         buffer.release();
      }
   }

   private void _sendToClient(Player player, byte[] payload) {
      player.sendPluginMessage(this.plugin, "geyser:msg", payload);
   }

   public FormHandler getFormHandler() {
      return this.formHandler;
   }

   public JavaPlugin getPlugin() {
      return this.plugin;
   }

   public Map<UUID, SkinData> getUuidToSkinData() {
      return this.uuidToSkinData;
   }

   public Map<UUID, PlayerInfo> getPlayerInfos() {
      return this.playerInfos;
   }
}
