package com.neteasemc.spigotmaster.ViaVersionInject;

public class Injector {
   public Injector() {
      try {
         this._initInject();
      } catch (NoSuchFieldException | IllegalAccessException e) {
         e.printStackTrace();
      }
   }

   public void _initInject() throws NoSuchFieldException, IllegalAccessException {
   }
}
