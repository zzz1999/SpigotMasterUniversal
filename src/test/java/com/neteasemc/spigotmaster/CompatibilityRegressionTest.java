package com.neteasemc.spigotmaster;

import com.neteasemc.spigotmaster.enumData.ItemToTexture;
import com.neteasemc.spigotmaster.versionWrapper.VersionWrapper;
import com.neteasemc.spigotmaster.versionWrapper.VersionWrapperUniversal;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeNotNull;

public class CompatibilityRegressionTest {
   @BeforeClass
   public static void installServerForPluginLookup() {
      if (Bukkit.getServer() != null) {
         return;
      }

      final PluginManager pluginManager = (PluginManager)Proxy.newProxyInstance(
         PluginManager.class.getClassLoader(), new Class<?>[] { PluginManager.class },
         (proxy, method, args) -> {
            if ("getPlugin".equals(method.getName())) {
               return null;
            }
            throw new UnsupportedOperationException(method.getName());
         }
      );
      Server server = (Server)Proxy.newProxyInstance(
         Server.class.getClassLoader(), new Class<?>[] { Server.class },
         (proxy, method, args) -> {
            switch (method.getName()) {
               case "getPluginManager":
                  return pluginManager;
               case "getLogger":
                  return Logger.getLogger("SpigotMasterUniversal-compatibility-tests");
               case "getName":
                  return "CompatibilityTestServer";
               case "getVersion":
                  return "CompatibilityTestServer (MC: 1.18.2)";
               case "getBukkitVersion":
                  return "1.18.2-R0.1-SNAPSHOT";
               default:
                  throw new UnsupportedOperationException(method.getName());
            }
         }
      );
      Bukkit.setServer(server);
   }

   @Test
   public void nullAirAndZeroAmountAreEmpty() {
      assertTrue(VersionWrapperUniversal.isItemEmpty(null));
      assertTrue(VersionWrapperUniversal.isItemEmpty(new ItemStack(Material.AIR)));
      assertTrue(VersionWrapperUniversal.isItemEmpty(new ItemStack(Material.STONE, 0)));
   }

   @Test
   public void positiveStoneStackIsNotEmpty() {
      assertFalse(VersionWrapperUniversal.isItemEmpty(new ItemStack(Material.STONE, 1)));
      assertFalse(VersionWrapperUniversal.isItemEmpty(new ItemStack(Material.STONE, 64)));
   }

   @Test
   public void caveAirIsEmptyWhenTheApiContainsIt() {
      assertAirVariant("CAVE_AIR");
   }

   @Test
   public void voidAirIsEmptyWhenTheApiContainsIt() {
      assertAirVariant("VOID_AIR");
   }

   @Test
   public void legacyAirIsEmptyWhenTheApiContainsIt() {
      assertAirVariant("LEGACY_AIR");
   }

   @Test
   public void layerTagsPreserveEverySupportedLayer() {
      VersionWrapper wrapper = new VersionWrapperUniversal();
      assertEquals("bottom_layer_2", wrapper.layerToTag(-2));
      assertEquals("bottom_layer_1", wrapper.layerToTag(-1));
      assertEquals("top_layer_1", wrapper.layerToTag(1));
      assertEquals("top_layer_2", wrapper.layerToTag(2));
      assertEquals("top_layer_3", wrapper.layerToTag(3));
      assertNull(wrapper.layerToTag(Integer.MIN_VALUE));
      assertNull(wrapper.layerToTag(-3));
      assertNull(wrapper.layerToTag(0));
      assertNull(wrapper.layerToTag(4));
      assertNull(wrapper.layerToTag(Integer.MAX_VALUE));
   }

   @Test
   public void textureMappingsUseTheCurrentApiMaterialNames() {
      assertTexture("END_BRICKS", "END_STONE_BRICKS", "end_bricks");
      assertTexture("ENDER_STONE", "END_STONE", "end_stone");
      assertTexture("RAILS", "RAIL", "rail_normal");
      assertFalse(ItemToTexture.ItemTypeToTexture.containsKey(null));
   }

   private static void assertAirVariant(String name) {
      Material material = Material.getMaterial(name);
      assumeNotNull(material);
      assertTrue(VersionWrapperUniversal.isItemEmpty(new ItemStack(material)));
   }

   private static void assertTexture(String legacyName, String modernName, String texture) {
      Material material = Material.getMaterial(legacyName);
      if (material == null) {
         material = Material.getMaterial(modernName);
      }
      assertNotNull(material);
      assertEquals(texture, ItemToTexture.ItemTypeToTexture.get(material));
   }
}
