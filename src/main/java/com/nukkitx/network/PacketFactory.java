package com.nukkitx.network;

@FunctionalInterface
public interface PacketFactory<T extends NetworkPacket> {
   T newInstance();

   default Class<T> getPacketClass() {
      return (Class<T>)this.newInstance().getClass();
   }
}
