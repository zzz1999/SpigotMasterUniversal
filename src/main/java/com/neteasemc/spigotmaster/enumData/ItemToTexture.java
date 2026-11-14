package com.neteasemc.spigotmaster.enumData;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.Material;

public class ItemToTexture {
   public static final Map<Material, String> ItemTypeToTexture = new HashMap<Material, String>() {
      {
         this.put(Material.BOW, "bow_standby");
         this.put(Material.POTION, "potion_bottle_drinkable");
         this.put(Material.BOOK, "book_normal");
         this.put(Material.BOOKSHELF, "bookshelf");
         this.put(Material.BRICK, "brick");
         this.put(Material.CARROT, "carrots_stage_3");
         this.put(Material.COAL_ORE, "coal_ore");
         this.put(Material.COAL_BLOCK, "coal_block");
         this.put(Material.CLAY, "clay");
         this.put(Material.COBBLESTONE, "cobblestone");
         this.put(Material.DEAD_BUSH, "deadbush");
         this.put(Material.DIAMOND_BLOCK, "diamond_block");
         this.put(Material.DIAMOND_ORE, "diamond_ore");
         this.put(Material.DIRT, "dirt");
         this.put(Material.EMERALD_BLOCK, "emerald_block");
         this.put(Material.EMERALD_ORE, "emerald_ore");
         this.put(resolveMaterial("END_BRICKS", "END_STONE_BRICKS"), "end_bricks");
         this.put(Material.END_ROD, "end_rod");
         this.put(resolveMaterial("ENDER_STONE", "END_STONE"), "end_stone");
         this.put(Material.GLOWSTONE, "glowstone");
         this.put(Material.GOLD_BLOCK, "gold_block");
         this.put(Material.GOLD_ORE, "gold_ore");
         this.put(Material.LAPIS_BLOCK, "lapis_block");
         this.put(Material.LAPIS_ORE, "lapis_ore");
         this.put(Material.GRAVEL, "gravel");
         this.put(Material.LADDER, "ladder");
         this.put(Material.NETHERRACK, "netherrack");
         this.put(Material.REDSTONE_BLOCK, "redstone_block");
         this.put(Material.REDSTONE_ORE, "redstone_ore");
         this.put(Material.SNOW, "snow");
         this.put(Material.SLIME_BLOCK, "slime");
         this.put(Material.SPONGE, "sponge");
         this.put(Material.SOUL_SAND, "soul_sand");
         this.put(Material.SANDSTONE, "sandstone_normal");
         this.put(Material.STONE, "stone");
         this.put(resolveMaterial("RAILS", "RAIL"), "rail_normal");
      }
   };

   private static Material resolveMaterial(String legacyName, String modernName) {
      Material material = Material.getMaterial(legacyName);
      return material != null ? material : Material.getMaterial(modernName);
   }
}
