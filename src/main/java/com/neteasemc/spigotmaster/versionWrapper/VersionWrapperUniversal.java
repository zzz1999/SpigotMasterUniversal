package com.neteasemc.spigotmaster.versionWrapper;

import com.neteasemc.spigotmaster.SpigotMaster;
import de.tr7zw.nbtapi.NBT;
import de.tr7zw.nbtapi.iface.ReadableNBT;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

public final class VersionWrapperUniversal implements VersionWrapper {
   public static final String NETEASE_IDENTIFIER = "netease_identifier";
   private static final SpigotMaster spigotMaster = (SpigotMaster)Bukkit.getServer().getPluginManager().getPlugin("SpigotMaster");

   @Override
   public String getCustomItemIdentifier(ItemStack itemStack) {
      if (isItemEmpty(itemStack)) {
         return null;
      }

      if (!itemStack.hasItemMeta()) {
         return null;
      }

      ReadableNBT nbt = NBT.readNbt(itemStack);
      return !nbt.hasTag("netease_identifier") ? null : nbt.getString("netease_identifier");
   }

   @Override
   public ItemStack setCustomItemIdentifier(ItemStack itemStack, String customIdentifier) {
      if (isItemEmpty(itemStack)) {
         return null;
      }

      NBT.modify(itemStack, nbt -> {
         nbt.setString("netease_identifier", customIdentifier);
      });
      return itemStack;
   }

   @Override
   public ItemStack setItemLayer(ItemStack itemStack, int layer, String texture) {
      if (isItemEmpty(itemStack)) {
         return null;
      }

      String tag = this.layerToTag(layer);
      if (tag == null) {
         return itemStack;
      }

      NBT.modify(itemStack, nbt -> {
         nbt.setString(tag, texture);
      });
      return itemStack;
   }

   @Override
   public String getItemLayer(ItemStack itemStack, int layer) {
      if (isItemEmpty(itemStack)) {
         return null;
      }

      String tag = this.layerToTag(layer);
      ReadableNBT nbt = NBT.readNbt(itemStack);
      return nbt.hasTag(tag) ? nbt.getString(tag) : null;
   }

   @Override
   public ItemStack removeItemLayer(ItemStack itemStack, int layer) {
      if (isItemEmpty(itemStack)) {
         return null;
      }

      if (!itemStack.hasItemMeta()) {
         return itemStack;
      }

      String tag = this.layerToTag(layer);
      if (tag == null) {
         return itemStack;
      }

      NBT.modify(itemStack, nbt -> {
         nbt.removeKey(tag);
      });
      return itemStack;
   }

   @Override
   public String getCustomEntityIdentifier(Entity entity) {
      return entity == null ? null : (String)NBT.get(entity, nbt -> {
         if (nbt.hasTag("netease_identifier")) {
            String identifierWithPrefix = nbt.getString("netease_identifier");
            return this.customEntityIdentifierWithoutPrefix(identifierWithPrefix);
         } else {
            return null;
         }
      });
   }

   @Override
   public Entity setCustomEntityIdentifier(Entity entity, String customIdentifier) {
      if (entity == null) {
         return null;
      }

      String customIdentifierWithPrefix = this.customEntityIdentifierWithPrefix(customIdentifier);
      NBT.modify(entity, nbt -> {
         nbt.setString("netease_identifier", customIdentifierWithPrefix);
      });
      entity.setMetadata("netease_identifier", new FixedMetadataValue(spigotMaster, customIdentifierWithPrefix));
      return entity;
   }

   @Override
   public void setEntitySize(Entity entity, float height, float width) {
      throw new RuntimeException("Its shouldn't be achieved in this place by netease");
   }

   @Override
   public void addEntity(Player player, Entity entity, SpawnReason spawnReason) {
      throw new RuntimeException("Its shouldn't be achieved in this place by netease");
   }

   @Override
   public void addEntity(World world, Entity entity, SpawnReason spawnReason) {
      throw new RuntimeException("Its shouldn't be achieved in this place by netease");
   }

   @Override
   public ItemStack removeGameProfileTag(ItemStack itemStack) {
      if (isItemEmpty(itemStack)) {
         return null;
      }

      if (!itemStack.hasItemMeta()) {
         return itemStack;
      }

      NBT.modify(itemStack, nbt -> {
         nbt.removeKey("Id");
         nbt.removeKey("Name");
         nbt.removeKey("Properties");
         nbt.removeKey("netease_identifier");
      });
      return itemStack;
   }

   public static boolean isItemEmpty(ItemStack itemStack) {
      if (itemStack == null || itemStack.getAmount() <= 0) {
         return true;
      }

      Material type = itemStack.getType();
      return type == Material.AIR || "CAVE_AIR".equals(type.name()) || "VOID_AIR".equals(type.name()) || "LEGACY_AIR".equals(type.name());
   }
}
