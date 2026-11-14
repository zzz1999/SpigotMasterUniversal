package com.neteasemc.spigotmaster.versionWrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.inventory.ItemStack;

public interface VersionWrapper {
   String customEntityPrefix = "__netease_entity_identifier,";

   String getCustomItemIdentifier(ItemStack var1);

   ItemStack setCustomItemIdentifier(ItemStack var1, String var2);

   String getCustomEntityIdentifier(Entity var1);

   Entity setCustomEntityIdentifier(Entity var1, String var2);

   void setEntitySize(Entity var1, float var2, float var3);

   ItemStack setItemLayer(ItemStack var1, int var2, String var3);

   String getItemLayer(ItemStack var1, int var2);

   ItemStack removeItemLayer(ItemStack var1, int var2);

   ItemStack removeGameProfileTag(ItemStack var1);

   void addEntity(Player var1, Entity var2, SpawnReason var3);

   void addEntity(World var1, Entity var2, SpawnReason var3);

   default String customEntityIdentifierWithPrefix(String customIdentifier) {
      return "__netease_entity_identifier," + customIdentifier;
   }

   default String customEntityIdentifierWithoutPrefix(String customIdentifier) {
      return customIdentifier.startsWith("__netease_entity_identifier,")
         ? customIdentifier.substring("__netease_entity_identifier,".length())
         : customIdentifier;
   }

   default String layerToTag(int layer) {
      switch (layer) {
         case -2:
            return "bottom_layer_2";
         case -1:
            return "bottom_layer_1";
         case 1:
            return "top_layer_1";
         case 2:
            return "top_layer_2";
         case 3:
            return "top_layer_3";
         default:
            return null;
      }
   }
}
