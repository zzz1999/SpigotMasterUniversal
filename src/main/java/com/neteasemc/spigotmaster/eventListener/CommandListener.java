package com.neteasemc.spigotmaster.eventListener;

import com.neteasemc.spigotmaster.commandExecutor.CommandCompareItem;
import com.neteasemc.spigotmaster.commandExecutor.CommandPrintItem;
import com.neteasemc.spigotmaster.commandExecutor.CommandTestSendBedrockpacket;
import com.neteasemc.spigotmaster.commandExecutor.CommandTestSetGravity;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandListener {
   private JavaPlugin plugin;

   public CommandListener(JavaPlugin plugin, boolean isDebug) {
      this.plugin = plugin;
      if (isDebug) {
         this.forceRegistCommand();
      }
   }

   public void forceRegistCommand() {
      this.plugin.getCommand("printItem").setExecutor(new CommandPrintItem());
      this.plugin.getCommand("compareItem").setExecutor(new CommandCompareItem());
      this.plugin.getCommand("testSendPacket").setExecutor(new CommandTestSendBedrockpacket());
      this.plugin.getCommand("testSetGravity").setExecutor(new CommandTestSetGravity());
   }
}
