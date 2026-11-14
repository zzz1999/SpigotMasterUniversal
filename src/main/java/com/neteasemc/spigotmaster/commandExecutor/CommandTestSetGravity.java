package com.neteasemc.spigotmaster.commandExecutor;

import com.neteasemc.spigotmaster.SpigotMaster;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class CommandTestSetGravity implements CommandExecutor {
   int taskId = -1;

   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (sender instanceof Player && args.length > 0) {
         Float gravity = Float.parseFloat(args[0]);
         SpigotMaster spigotMaster = (SpigotMaster)Bukkit.getPluginManager().getPlugin("SpigotMaster");
         Player player = (Player)sender;
         Location loc = player.getLocation();
         double radius = 10.0;

         for (Entity entity : loc.getWorld().getNearbyEntities(loc, radius, radius, radius)) {
            if (entity instanceof LivingEntity && entity != player) {
               System.out.println("=== set entity gravity:" + entity.getEntityId() + " type:" + entity.getType().getName() + " " + gravity);
               spigotMaster.setEntityGravity(entity.getEntityId(), gravity);
            }
         }
      }

      return true;
   }
}
