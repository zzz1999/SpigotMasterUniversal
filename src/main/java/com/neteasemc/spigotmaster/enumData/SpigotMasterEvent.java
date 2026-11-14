package com.neteasemc.spigotmaster.enumData;

public enum SpigotMasterEvent {
   PLAYER_URGE_SHIP("player_urge_ship"),
   PLAYER_BUY_ITEM_SUCCESS("player_buy_item_success"),
   CLIENT_LOAD_ADDON_FINISH("client_load_addon_finish");

   private final String eventName;

   public String getEventName() {
      return this.eventName;
   }

   SpigotMasterEvent(String eventName) {
      this.eventName = eventName;
   }
}
