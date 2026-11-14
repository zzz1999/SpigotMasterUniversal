package com.neteasemc.spigotmaster.commandExecutor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCompareItem implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (sender instanceof Player) {
         Player player = (Player)sender;
         int inventoryId = Integer.valueOf(args[0]);
         int inventoryId1 = Integer.valueOf(args[1]);
         System.out.println("==================================================");
         System.out.println("item equal:" + player.getInventory().getItem(inventoryId).equals(player.getInventory().getItem(inventoryId1)));
         System.out.println("item sim:" + player.getInventory().getItem(inventoryId1).isSimilar(player.getInventory().getItem(inventoryId1)));
         System.out.println("item0:" + player.getInventory().getItem(inventoryId).toString());
         System.out.println("item1:" + player.getInventory().getItem(inventoryId1).toString());
         System.out.println("==================================================");
      }

      return true;
   }
}
