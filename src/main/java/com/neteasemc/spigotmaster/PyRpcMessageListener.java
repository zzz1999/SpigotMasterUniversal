package com.neteasemc.spigotmaster;

import com.neteasemc.spigotmaster.enumData.SpigotMasterEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;

public class PyRpcMessageListener implements PluginMessageListener {
   private Map<String, List<PyRpcHandler>> handlers = new HashMap<>();
   private Map<String, List<PyRpcHandler>> spigotMasterEventHandlers = new HashMap<>();
   private Map<String, List<EnginePyRpcHandler>> engineCallbackHandlers = new HashMap<>();

   public void listenForSpigotMasterEvent(SpigotMasterEvent event, PyRpcHandler handler) {
      List<PyRpcHandler> pyRpcHandlers = this.spigotMasterEventHandlers.computeIfAbsent(event.getEventName(), k -> new ArrayList<>());
      pyRpcHandlers.add(handler);
   }

   public void fireSpigotMasterEvent(SpigotMasterEvent event, Player player, @Nullable Map<String, Object> data) {
      List<PyRpcHandler> handlers = this.spigotMasterEventHandlers.get(event.getEventName());
      if (handlers != null) {
         for (PyRpcHandler handler : handlers) {
            try {
               handler.onEvent(player, data);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }
   }

   public void listenForClientEngineCall(String method, EnginePyRpcHandler handler) {
      List<EnginePyRpcHandler> pyRpcHandlers = this.engineCallbackHandlers.computeIfAbsent(method, k -> new ArrayList<>());
      pyRpcHandlers.add(handler);
   }

   public void listenForEvent(String namespace, String system, String event, PyRpcHandler handler) {
      String key = String.format("%s,%s,%s", namespace, system, event);
      List<PyRpcHandler> pyRpcHandlers = this.handlers.computeIfAbsent(key, k -> new ArrayList<>());
      pyRpcHandlers.add(handler);
   }

   public void onPluginMessageReceived(String s, Player player, byte[] bytes) {
      MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(bytes);

      try {
         Object o = PyRpcPacker.unpackObject(unpacker);
         String method;
         List<Object> args;
         if (o instanceof List) {
            List<Object> list = (List<Object>)o;
            method = (String)list.get(0);
            args = (List<Object>)list.get(1);
         } else {
            List<Object> list = (List<Object>)((Map)o).get("value");
            method = (String)list.get(0);
            args = (List<Object>)((Map)list.get(1)).get("value");
         }

         if (method.equals("ModEventC2S")) {
            String namespace = (String)args.get(0);
            String system = (String)args.get(1);
            String event = (String)args.get(2);
            String key = String.format("%s,%s,%s", namespace, system, event);
            List<PyRpcHandler> handlers = this.handlers.get(key);
            if (handlers != null) {
               Map<String, Object> data = (Map<String, Object>)args.get(3);

               for (PyRpcHandler handler : handlers) {
                  try {
                     handler.onEvent(player, data);
                  } catch (Exception e) {
                     e.printStackTrace();
                  }
               }
            }
         } else {
            List<EnginePyRpcHandler> handlers = this.engineCallbackHandlers.get(method);
            if (handlers != null) {
               for (EnginePyRpcHandler handler : handlers) {
                  try {
                     handler.onEvent(player, args);
                  } catch (Exception e) {
                     e.printStackTrace();
                  }
               }
            }
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
