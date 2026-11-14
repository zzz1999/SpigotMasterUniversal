package com.neteasemc.spigotmaster;

import com.neteasemc.protocol.custom.GeyserBasePacket;
import com.neteasemc.protocol.custom.GeyserBasePacketHandler;
import com.neteasemc.protocol.custom.packet.formPacket.FormPacket;
import com.neteasemc.protocol.custom.packet.playerInfoPacket.PlayerInfoPacket;
import com.neteasemc.protocol.custom.packet.skinConfirmPacket.SkinConfirmPacket;
import com.neteasemc.protocol.custom.packet.spigotInfoPacket.SpigotInfoPacket;
import com.neteasemc.spigotmaster.util.WebUtil;
import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.JSONValue;
import com.nukkitx.protocol.common.PacketSignal;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.EntityUtils;
import org.bukkit.entity.Player;

public class GeyserPacketHandler implements GeyserBasePacketHandler {
   private GeyserMessageListener listener;
   private PyRpcMessageListener pyRpcListener;

   public GeyserPacketHandler(GeyserMessageListener listener, PyRpcMessageListener pyRpcListener) {
      this.listener = listener;
      this.pyRpcListener = pyRpcListener;
   }

   boolean defaultHandler(GeyserBasePacket packet) {
      this.listener.getPlugin().getLogger().warning("default Handled packet: " + packet.getClass().getSimpleName());
      return false;
   }

   @Override
   public PacketSignal handle(PlayerInfoPacket packet, Player player) {
      this.listener.setPlayerInfo(packet, player);
      return PacketSignal.HANDLED;
   }

   @Override
   public PacketSignal handle(final SkinConfirmPacket packet, final Player player) {
      if (packet.isOther()) {
         this.listener.checkSkin(packet, player);
         return PacketSignal.HANDLED;
      }

      try {
         this.listener.removeConfirmSkinData(player);
         String skinMd5 = WebUtil.toMd5WithPreZero(packet.getSkinData());
         String uid = packet.getNeteaseUid();
         String geoMd5 = WebUtil.toMd5WithPreZero(packet.getGeoStr());
         List<String> skinMd5s = new ArrayList<>();
         List<String> uids = new ArrayList<>();
         List<String> geoMd5s = new ArrayList<>();
         skinMd5s.add(skinMd5);
         uids.add(uid);
         geoMd5s.add(geoMd5);
         FutureCallback<HttpResponse> skinCallback = new FutureCallback<HttpResponse>() {
            @Override
            public void cancelled() {
               GeyserPacketHandler.this.listener.getPlugin().getLogger().info("skin valid http post cancel");
            }

            public void completed(HttpResponse response) {
               if (response.getStatusLine().getStatusCode() != 200) {
                  GeyserPacketHandler.this.listener
                     .getPlugin()
                     .getLogger()
                     .info("skin valid http post response fail" + response.getStatusLine().getStatusCode());
               } else {
                  try {
                     String responseStr = EntityUtils.toString(response.getEntity());
                     JSONObject object = (JSONObject)JSONValue.parse(responseStr);
                     int resCode = (Integer)object.get("code");
                     if (resCode != 0) {
                        return;
                     }

                     JSONArray entities = (JSONArray)object.get("entities");
                     if (entities != null && !entities.isEmpty()) {
                        Boolean res = (Boolean)entities.get(0);
                        if (!res) {
                           return;
                        }

                        GeyserPacketHandler.this.listener.addConfirmSkinData(packet, player);
                     }
                  } catch (Exception e) {
                     GeyserPacketHandler.this.listener.getPlugin().getLogger().warning("skin valid http post response body parse failed" + e);
                     e.printStackTrace();
                  }
               }
            }

            @Override
            public void failed(Exception arg0) {
               GeyserPacketHandler.this.listener.getPlugin().getLogger().warning("skin valid http post failed:" + arg0);
            }
         };
         String validUrl = this.listener.getPlayerInfo(player).getWebServerUrl() + WebUtil.SKIN_VALID_URL;
         WebUtil.postSkinValidForm(validUrl, skinMd5s, uids, geoMd5s, skinCallback);
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      }

      return PacketSignal.HANDLED;
   }

   @Override
   public PacketSignal handle(SpigotInfoPacket packet, Player player) {
      String spigotVersion = this.listener.getPlugin().getServer().getVersion();
      SpigotInfoPacket response = new SpigotInfoPacket();
      response.setSpigotVersion(spigotVersion);
      this.listener.sendToClient(player, response);
      return PacketSignal.HANDLED;
   }

   @Override
   public PacketSignal handle(FormPacket packet, Player player) {
      return this.listener.getFormHandler().handleFormResponse(packet, player) ? PacketSignal.HANDLED : PacketSignal.UNHANDLED;
   }

   public GeyserMessageListener getListener() {
      return this.listener;
   }

   public PyRpcMessageListener getPyRpcListener() {
      return this.pyRpcListener;
   }
}
