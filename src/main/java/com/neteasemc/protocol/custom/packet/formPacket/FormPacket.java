package com.neteasemc.protocol.custom.packet.formPacket;

import com.neteasemc.protocol.custom.GeyserBasePacket;
import com.neteasemc.protocol.custom.GeyserBasePacketHandler;
import com.neteasemc.protocol.custom.GeyserPacketType;
import com.nukkitx.protocol.common.PacketSignal;
import java.util.Arrays;
import org.bukkit.entity.Player;

public class FormPacket extends GeyserBasePacket {
   byte[] formData;

   public FormPacket() {
   }

   public FormPacket(byte[] formData) {
      this.formData = formData;
   }

   @Override
   public GeyserPacketType getPacketType() {
      return GeyserPacketType.FORM;
   }

   @Override
   public PacketSignal handle(GeyserBasePacketHandler handler) {
      return handler.handle(this);
   }

   @Override
   public PacketSignal handle(GeyserBasePacketHandler handler, Player player) {
      return handler.handle(this, player);
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FormPacket)) {
         return false;
      }

      FormPacket other = (FormPacket)o;
      return !other.canEqual(this) ? false : Arrays.equals(this.formData, other.formData);
   }

   @Override
   protected boolean canEqual(Object other) {
      return other instanceof FormPacket;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      return result * 59 + Arrays.hashCode(this.formData);
   }

   @Override
   public String toString() {
      return "FormPacket(formData=" + Arrays.toString(this.getFormData()) + ")";
   }

   public byte[] getFormData() {
      return this.formData;
   }

   public void setFormData(byte[] formData) {
      this.formData = formData;
   }
}
