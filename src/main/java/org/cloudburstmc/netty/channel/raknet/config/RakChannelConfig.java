package org.cloudburstmc.netty.channel.raknet.config;

import io.netty.channel.ChannelConfig;

public interface RakChannelConfig extends ChannelConfig {
   long getGuid();

   RakChannelConfig setGuid(long var1);

   int getMtu();

   RakChannelConfig setMtu(int var1);

   int getProtocolVersion();

   RakChannelConfig setProtocolVersion(int var1);

   int getOrderingChannels();

   RakChannelConfig setOrderingChannels(int var1);

   RakMetrics getMetrics();

   RakChannelConfig setMetrics(RakMetrics var1);

   long getSessionTimeout();

   RakChannelConfig setSessionTimeout(long var1);

   boolean isAutoFlush();

   void setAutoFlush(boolean var1);

   int getFlushInterval();

   void setFlushInterval(int var1);
}
