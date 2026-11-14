package com.neteasemc.spigotmaster;

import java.util.Map;
import org.bukkit.entity.Player;

public interface PyRpcHandler {
   void onEvent(Player var1, Map<String, Object> var2);
}
