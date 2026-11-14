package org.cloudburstmc.protocol.common;

import java.net.InetSocketAddress;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface MinecraftSession<T extends MinecraftPacket> {
   boolean isClosed();

   void disconnect();

   InetSocketAddress getAddress();

   default InetSocketAddress getRealAddress() {
      return this.getAddress();
   }

   void sendPacket(@NonNull T packet);

   void sendPacketImmediately(@NonNull T packet);

   long getLatency();
}
