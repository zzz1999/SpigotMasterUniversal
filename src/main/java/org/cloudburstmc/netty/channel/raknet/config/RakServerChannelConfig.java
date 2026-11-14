package org.cloudburstmc.netty.channel.raknet.config;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelConfig;

public interface RakServerChannelConfig extends ChannelConfig {
   int getMaxChannels();

   RakServerChannelConfig setMaxChannels(int var1);

   long getGuid();

   RakServerChannelConfig setGuid(long var1);

   int[] getSupportedProtocols();

   RakServerChannelConfig setSupportedProtocols(int[] var1);

   int getMaxConnections();

   RakServerChannelConfig setMaxConnections(int var1);

   ByteBuf getUnconnectedMagic();

   RakServerChannelConfig setUnconnectedMagic(ByteBuf var1);

   ByteBuf getAdvertisement();

   RakServerChannelConfig setAdvertisement(ByteBuf var1);

   boolean getHandlePing();

   RakServerChannelConfig setHandlePing(boolean var1);

   int getMaxMtu();

   RakServerChannelConfig setMaxMtu(int var1);

   int getMinMtu();

   RakServerChannelConfig setMinMtu(int var1);

   int getPacketLimit();

   void setPacketLimit(int var1);

   int getGlobalPacketLimit();

   void setGlobalPacketLimit(int var1);

   int getUnconnectedPacketLimit();

   void setUnconnectedPacketLimit(int var1);
}
