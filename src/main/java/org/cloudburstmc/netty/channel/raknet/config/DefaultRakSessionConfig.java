package org.cloudburstmc.netty.channel.raknet.config;

import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import java.util.Map;

public class DefaultRakSessionConfig extends DefaultChannelConfig implements RakChannelConfig {
   private volatile long guid;
   private volatile int mtu = 1400;
   private volatile int protocolVersion;
   private volatile int orderingChannels = 16;
   private volatile RakMetrics metrics;
   private volatile long sessionTimeout = 10000L;
   private volatile boolean autoFlush = true;
   private volatile int flushInterval = 10;

   public DefaultRakSessionConfig(Channel channel) {
      super(channel);
   }

   @Override
   public Map<ChannelOption<?>, Object> getOptions() {
      return this.getOptions(
         super.getOptions(), RakChannelOption.RAK_GUID, RakChannelOption.RAK_MAX_CHANNELS, RakChannelOption.RAK_MTU, RakChannelOption.RAK_PROTOCOL_VERSION
      );
   }

   @Override
   public <T> T getOption(ChannelOption<T> option) {
      if (option == RakChannelOption.RAK_GUID) {
         return (T)Long.valueOf(this.getGuid());
      } else if (option == RakChannelOption.RAK_MTU) {
         return (T)Integer.valueOf(this.getMtu());
      } else if (option == RakChannelOption.RAK_PROTOCOL_VERSION) {
         return (T)Integer.valueOf(this.getProtocolVersion());
      } else if (option == RakChannelOption.RAK_ORDERING_CHANNELS) {
         return (T)Integer.valueOf(this.getOrderingChannels());
      } else if (option == RakChannelOption.RAK_METRICS) {
         return (T)this.getMetrics();
      } else if (option == RakChannelOption.RAK_SESSION_TIMEOUT) {
         return (T)Long.valueOf(this.getSessionTimeout());
      } else if (option == RakChannelOption.RAK_AUTO_FLUSH) {
         return (T)Boolean.valueOf(this.isAutoFlush());
      } else {
         return (T)(option == RakChannelOption.RAK_FLUSH_INTERVAL ? this.getFlushInterval() : this.channel.parent().config().getOption(option));
      }
   }

   @Override
   public <T> boolean setOption(ChannelOption<T> option, T value) {
      this.validate(option, value);
      if (option == RakChannelOption.RAK_GUID) {
         this.setGuid((Long)value);
      } else if (option == RakChannelOption.RAK_MTU) {
         this.setMtu((Integer)value);
      } else if (option == RakChannelOption.RAK_PROTOCOL_VERSION) {
         this.setProtocolVersion((Integer)value);
      } else if (option == RakChannelOption.RAK_ORDERING_CHANNELS) {
         this.setOrderingChannels((Integer)value);
      } else if (option == RakChannelOption.RAK_METRICS) {
         this.setMetrics((RakMetrics)value);
      } else {
         if (option == RakChannelOption.RAK_SESSION_TIMEOUT) {
            this.setSessionTimeout((Long)value);
            return true;
         }

         if (option == RakChannelOption.RAK_AUTO_FLUSH) {
            this.setAutoFlush((Boolean)value);
         } else {
            if (option != RakChannelOption.RAK_FLUSH_INTERVAL) {
               return this.channel.parent().config().setOption(option, value);
            }

            this.setFlushInterval((Integer)value);
         }
      }

      return true;
   }

   @Override
   public long getGuid() {
      return this.guid;
   }

   @Override
   public RakChannelConfig setGuid(long guid) {
      this.guid = guid;
      return this;
   }

   @Override
   public int getMtu() {
      return this.mtu;
   }

   @Override
   public RakChannelConfig setMtu(int mtu) {
      this.mtu = mtu;
      return this;
   }

   @Override
   public int getProtocolVersion() {
      return this.protocolVersion;
   }

   @Override
   public RakChannelConfig setProtocolVersion(int protocolVersion) {
      this.protocolVersion = protocolVersion;
      return this;
   }

   @Override
   public int getOrderingChannels() {
      return this.orderingChannels;
   }

   @Override
   public RakChannelConfig setOrderingChannels(int orderingChannels) {
      this.orderingChannels = orderingChannels;
      return this;
   }

   @Override
   public RakMetrics getMetrics() {
      return this.metrics;
   }

   @Override
   public RakChannelConfig setMetrics(RakMetrics metrics) {
      this.metrics = metrics;
      return this;
   }

   @Override
   public RakChannelConfig setSessionTimeout(long timeout) {
      this.sessionTimeout = timeout;
      return this;
   }

   @Override
   public long getSessionTimeout() {
      return this.sessionTimeout;
   }

   @Override
   public boolean isAutoFlush() {
      return this.autoFlush;
   }

   @Override
   public void setAutoFlush(boolean autoFlush) {
      this.autoFlush = autoFlush;
   }

   @Override
   public int getFlushInterval() {
      return this.flushInterval;
   }

   @Override
   public void setFlushInterval(int flushInterval) {
      this.flushInterval = flushInterval;
   }
}
