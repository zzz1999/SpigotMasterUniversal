package com.neteasemc.spigotmaster.eventListener;

import com.neteasemc.spigotmaster.SpigotMaster;
import com.neteasemc.spigotmaster.playerInfo.PlayerInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class EventListener implements Listener {
   private SpigotMaster plugin;

   public EventListener(SpigotMaster plugin) {
      this.plugin = plugin;
   }

   @EventHandler
   public void onPlayerQuit(PlayerQuitEvent event) {
      Player player = event.getPlayer();
      this.playerExitChatRoom(player);
      this.plugin.getGeyserMsgListener().removeConfirmSkinData(player);
      this.plugin.getGeyserMsgListener().removePlayerInfo(player);
   }

   @EventHandler
   public void onChunkLoadEvent(ChunkLoadEvent event) {
      for (Entity entity : event.getChunk().getEntities()) {
         String customIdentifier = this.plugin.getCustomEntityIdentifier(entity);
         if (customIdentifier == null) {
            for (String tag : entity.getScoreboardTags()) {
               if (tag.startsWith("__netease_entity_identifier,")) {
                  this.plugin.setCustomEntityIdentifier(entity, tag.substring("__netease_entity_identifier,".length()));
               }
            }
         }
      }
   }

   public void playerExitChatRoom(Player player) {
      PlayerInfo playerInfo = this.plugin.getGeyserMsgListener().getPlayerInfo(player);
      if (playerInfo == null) {
         this.plugin.getLogger().warning("player info is null,from exit");
      } else {
         long uid = playerInfo.getProxyUid();
         Map<String, Object> otherData = new HashMap<>();
         List<String> otherUids = Arrays.asList(Long.toString(uid));
         otherData.put("uids", otherUids);
         this.plugin.broadcastToAllClient(player, ClientEventListener.ENGINE_NAME_SPACE, ClientEventListener.CHAT_EXTENSION_NAME, "PlayerExitRoom", otherData);
      }
   }

   @EventHandler
   public void onPlayerPickupItem(PlayerPickupItemEvent event) {
      if (this.plugin.getServerVersion().equals("1.12.2")) {
         ItemStack itemStack = event.getItem().getItemStack();
         if (itemStack.getType() == Material.getMaterial("SKULL_ITEM")) {
            SkullMeta skullMeta = (SkullMeta)itemStack.getItemMeta();
            String owner = skullMeta.getOwner();
            if (owner != null && owner.startsWith("geyser_custom_block_")) {
               ItemStack newItemStack = this.plugin.getVersionWrapper().removeGameProfileTag(itemStack);
               event.getItem().setItemStack(newItemStack);
            }
         }
      }
   }

   @EventHandler
   public void onPlayerInteract(PlayerInteractEvent event) {
      if (this.plugin.getServerVersion().equals("1.12.2")) {
         ItemStack item = event.getItem();
         Action action = event.getAction();
         if (item == null) {
            return;
         }

         if (item.getType() == Material.getMaterial("SKULL_ITEM") && action == Action.RIGHT_CLICK_BLOCK) {
            SkullMeta skullMeta = (SkullMeta)item.getItemMeta();
            String owner = skullMeta.getOwner();
            BlockFace face = event.getBlockFace();
            Block clickBlock = event.getClickedBlock();
            Material clickBlockType = clickBlock.getType();
            if (clickBlockType == Material.WATER || clickBlockType == Material.LAVA) {
               return;
            }

            if (face.getModY() > 0 && clickBlockType != Material.getMaterial("SKULL")) {
               return;
            }

            Location loc = new Location(
               event.getPlayer().getWorld(), clickBlock.getX() + face.getModX(), clickBlock.getY() + face.getModY(), clickBlock.getZ() + face.getModZ()
            );
            Block block = loc.getBlock();
            Location belowLoc = new Location(event.getPlayer().getWorld(), loc.getX(), loc.getY() - 1.0, loc.getZ());
            Block belowBlock = belowLoc.getBlock();
            Material belowBlockType = belowBlock.getType();
            if (clickBlockType != Material.getMaterial("SKULL") && belowBlockType != Material.getMaterial("SKULL") && belowBlockType != Material.AIR) {
               return;
            }

            block.setType(Material.getMaterial("SKULL"));
            Skull skull = (Skull)block.getState();
            if (owner != null && !owner.isEmpty()) {
               skull.setSkullType(SkullType.PLAYER);
               skull.setOwningPlayer(Bukkit.getOfflinePlayer(owner));
            } else {
               short data = item.getDurability();
               skull.setRotation(BlockFace.EAST);
               switch (data) {
                  case 0:
                     skull.setSkullType(SkullType.SKELETON);
                     break;
                  case 1:
                     skull.setSkullType(SkullType.WITHER);
                     break;
                  case 2:
                     skull.setSkullType(SkullType.ZOMBIE);
                     break;
                  case 3:
                     skull.setSkullType(SkullType.PLAYER);
                     break;
                  case 4:
                     skull.setSkullType(SkullType.CREEPER);
                     break;
                  case 5:
                     skull.setSkullType(SkullType.DRAGON);
                     break;
                  default:
                     skull.setSkullType(SkullType.SKELETON);
               }
            }

            skull.update();
            if (!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
               this.minusPlayerItemInMainHand(event.getPlayer());
            }
         }
      }
   }

   @EventHandler
   public void onBlockBreak(BlockBreakEvent event) {
      if (this.plugin.getServerVersion().equals("1.12.2")) {
         Player player = event.getPlayer();
         ItemStack mainHandItem = player.getInventory().getItemInMainHand();
         if (mainHandItem != null) {
            Material itemMat = mainHandItem.getType();
            if (itemMat == Material.getMaterial("GOLD_HOE") || itemMat == Material.getMaterial("WOOD_HOE") || itemMat == Material.IRON_HOE || itemMat == Material.DIAMOND_HOE) {
               int dura = mainHandItem.getDurability() + 1;
               if (dura >= itemMat.getMaxDurability()) {
                  player.getInventory().setItemInMainHand(null);
               } else {
                  mainHandItem.setDurability((short)dura);
                  player.updateInventory();
               }
            }
         }
      }
   }

   public void minusPlayerItemInMainHand(Player player) {
      int amount = player.getInventory().getItemInMainHand().getAmount();
      if (amount > 1) {
         ItemStack itemStack = player.getInventory().getItemInMainHand().clone();
         itemStack.setAmount(amount - 1);
         player.getInventory().setItemInMainHand(itemStack);
      } else {
         player.getInventory().setItemInMainHand(null);
      }
   }
}
