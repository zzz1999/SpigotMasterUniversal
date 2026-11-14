package com.neteasemc.spigotmaster.commandExecutor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPrintItem implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (sender instanceof Player) {
         Player player = (Player)sender;
         int inventoryId = Integer.valueOf(args[0]);
         System.out.println("==================================================");
         System.out.println("print item:" + inventoryId + " item:" + player.getInventory().getItem(inventoryId));
         System.out.println("item dura" + player.getInventory().getItem(inventoryId).getDurability());
         System.out.println("item type" + player.getInventory().getItem(inventoryId).getType());
         System.out.println("item meta" + player.getInventory().getItem(inventoryId).getItemMeta());
         System.out.println("item data" + player.getInventory().getItem(inventoryId).getData());
         System.out.println("item" + player.getInventory().getItem(inventoryId));
         System.out.println("==================================================");
      }

      return true;
   }
}
