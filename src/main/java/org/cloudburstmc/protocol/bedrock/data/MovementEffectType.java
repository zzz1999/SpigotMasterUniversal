package org.cloudburstmc.protocol.bedrock.data;

public enum MovementEffectType {
   INVALID(-1),
   GLIDE_BOOST(0),
   DOLPHIN_BOOST(1);

   private final int id;
   private static final MovementEffectType[] VALUES = values();

   public static MovementEffectType byId(int id) {
      for (MovementEffectType type : VALUES) {
         if (type.getId() == id) {
            return type;
         }
      }

      return null;
   }

   public int getId() {
      return this.id;
   }

   MovementEffectType(final int id) {
      this.id = id;
   }
}
