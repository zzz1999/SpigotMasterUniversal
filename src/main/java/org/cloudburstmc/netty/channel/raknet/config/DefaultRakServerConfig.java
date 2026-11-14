package org.cloudburstmc.netty.channel.raknet.config;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import org.cloudburstmc.netty.channel.raknet.RakConstants;
import org.cloudburstmc.netty.channel.raknet.RakServerChannel;

public class DefaultRakServerConfig extends DefaultChannelConfig implements RakServerChannelConfig {
   private volatile int maxChannels;
   private volatile long guid = ThreadLocalRandom.current().nextLong();
   private volatile int[] supportedProtocols;
   private volatile int maxConnections;
   private volatile ByteBuf unconnectedMagic = Unpooled.wrappedBuffer(RakConstants.DEFAULT_UNCONNECTED_MAGIC);
   private volatile ByteBuf advertisement;
   private volatile boolean handlePing;
   private volatile int maxMtu = 1400;
   private volatile int minMtu = 576;
   private volatile int packetLimit = 120;
   private volatile int globalPacketLimit = 100000;
   private volatile int unconnectedPacketLimit = 10;

   public DefaultRakServerConfig(RakServerChannel channel) {
      super(channel);
   }

   @Override
   public Map<ChannelOption<?>, Object> getOptions() {
      return this.getOptions(
         super.getOptions(),
         RakChannelOption.RAK_GUID,
         RakChannelOption.RAK_MAX_CHANNELS,
         RakChannelOption.RAK_MAX_CONNECTIONS,
         RakChannelOption.RAK_SUPPORTED_PROTOCOLS,
         RakChannelOption.RAK_UNCONNECTED_MAGIC,
         RakChannelOption.RAK_ADVERTISEMENT
      );
   }

   @Override
   public <T> T getOption(ChannelOption<T> option) {
      if (option == RakChannelOption.RAK_MAX_MTU) {
         return (T)Integer.valueOf(this.getMaxMtu());
      } else if (option == RakChannelOption.RAK_MIN_MTU) {
         return (T)Integer.valueOf(this.getMinMtu());
      } else if (option == RakChannelOption.RAK_GUID) {
         return (T)Long.valueOf(this.getGuid());
      } else if (option == RakChannelOption.RAK_MAX_CHANNELS) {
         return (T)Integer.valueOf(this.getMaxChannels());
      } else if (option == RakChannelOption.RAK_MAX_CONNECTIONS) {
         return (T)Integer.valueOf(this.getMaxConnections());
      } else if (option == RakChannelOption.RAK_SUPPORTED_PROTOCOLS) {
         return (T)this.getSupportedProtocols();
      } else if (option == RakChannelOption.RAK_UNCONNECTED_MAGIC) {
         return (T)this.getUnconnectedMagic();
      } else if (option == RakChannelOption.RAK_ADVERTISEMENT) {
         return (T)this.getAdvertisement();
      } else if (option == RakChannelOption.RAK_HANDLE_PING) {
         return (T)Boolean.valueOf(this.getHandlePing());
      } else if (option == RakChannelOption.RAK_PACKET_LIMIT) {
         return (T)Integer.valueOf(this.getPacketLimit());
      } else if (option == RakChannelOption.RAK_GLOBAL_PACKET_LIMIT) {
         return (T)Integer.valueOf(this.getGlobalPacketLimit());
      } else {
         return (T)(option == RakChannelOption.RAK_OFFLINE_PACKET_LIMIT ? this.getUnconnectedPacketLimit() : this.channel.parent().config().getOption(option));
      }
   }

   @Override
   public <T> boolean setOption(ChannelOption<T> option, T value) {
      this.validate(option, value);
      if (option == RakChannelOption.RAK_GUID) {
         this.setGuid((Long)value);
      } else if (option == RakChannelOption.RAK_MAX_CHANNELS) {
         this.setMaxChannels((Integer)value);
      } else if (option == RakChannelOption.RAK_MAX_CONNECTIONS) {
         this.setMaxConnections((Integer)value);
      } else if (option == RakChannelOption.RAK_SUPPORTED_PROTOCOLS) {
         this.setSupportedProtocols((int[])value);
      } else if (option == RakChannelOption.RAK_UNCONNECTED_MAGIC) {
         this.setUnconnectedMagic((ByteBuf)value);
      } else if (option == RakChannelOption.RAK_ADVERTISEMENT) {
         this.setAdvertisement((ByteBuf)value);
      } else if (option == RakChannelOption.RAK_HANDLE_PING) {
         this.setHandlePing((Boolean)value);
      } else if (option == RakChannelOption.RAK_MAX_MTU) {
         this.setMaxMtu((Integer)value);
      } else if (option == RakChannelOption.RAK_MIN_MTU) {
         this.setMinMtu((Integer)value);
      } else if (option == RakChannelOption.RAK_PACKET_LIMIT) {
         this.setPacketLimit((Integer)value);
      } else if (option == RakChannelOption.RAK_OFFLINE_PACKET_LIMIT) {
         this.setUnconnectedPacketLimit((Integer)value);
      } else {
         if (option != RakChannelOption.RAK_GLOBAL_PACKET_LIMIT) {
            return this.channel.parent().config().setOption(option, value);
         }

         this.setGlobalPacketLimit((Integer)value);
      }

      return true;
   }

   @Override
   public int getMaxChannels() {
      return this.maxChannels;
   }

   @Override
   public RakServerChannelConfig setMaxChannels(int maxChannels) {
      if (maxChannels >= 1 && maxChannels <= 256) {
         this.maxChannels = maxChannels;
         return this;
      } else {
         throw new IllegalArgumentException("maxChannels can only be a value between 1 and 256");
      }
   }

   @Override
   public long getGuid() {
      return this.guid;
   }

   @Override
   public RakServerChannelConfig setGuid(long guid) {
      this.guid = guid;
      return this;
   }

   @Override
   public int[] getSupportedProtocols() {
      return this.supportedProtocols;
   }

   @Override
   public RakServerChannelConfig setSupportedProtocols(int[] supportedProtocols) {
      if (supportedProtocols == null) {
         this.supportedProtocols = null;
      } else {
         this.supportedProtocols = Arrays.copyOf(supportedProtocols, supportedProtocols.length);
         Arrays.sort(this.supportedProtocols);
      }

      return this;
   }

   @Override
   public int getMaxConnections() {
      return this.maxConnections;
   }

   @Override
   public RakServerChannelConfig setMaxConnections(int maxConnections) {
      this.maxConnections = maxConnections;
      return this;
   }

   @Override
   public ByteBuf getUnconnectedMagic() {
      return this.unconnectedMagic.slice();
   }

   @Override
   public RakServerChannelConfig setUnconnectedMagic(ByteBuf unconnectedMagic) {
      if (unconnectedMagic.readableBytes() < 16) {
         throw new IllegalArgumentException("Unconnected magic must at least be 16 bytes");
      }

      this.unconnectedMagic = unconnectedMagic.copy().asReadOnly();
      return this;
   }

   @Override
   public ByteBuf getAdvertisement() {
      return this.advertisement;
   }

   @Override
   public RakServerChannelConfig setAdvertisement(ByteBuf advertisement) {
      this.advertisement = advertisement.copy().asReadOnly();
      return this;
   }

   @Override
   public boolean getHandlePing() {
      return this.handlePing;
   }

   @Override
   public RakServerChannelConfig setHandlePing(boolean handlePing) {
      this.handlePing = handlePing;
      return this;
   }

   @Override
   public RakServerChannelConfig setMaxMtu(int maxMtu) {
      this.maxMtu = maxMtu;
      return this;
   }

   @Override
   public int getMaxMtu() {
      return this.maxMtu;
   }

   @Override
   public RakServerChannelConfig setMinMtu(int minMtu) {
      this.minMtu = minMtu;
      return this;
   }

   @Override
   public int getMinMtu() {
      return this.minMtu;
   }

   @Override
   public void setPacketLimit(int limit) {
      this.packetLimit = limit;
   }

   @Override
   public int getPacketLimit() {
      return this.packetLimit;
   }

   @Override
   public int getUnconnectedPacketLimit() {
      return this.unconnectedPacketLimit;
   }

   @Override
   public void setUnconnectedPacketLimit(int unconnectedPacketLimit) {
      this.unconnectedPacketLimit = unconnectedPacketLimit;
   }

   @Override
   public int getGlobalPacketLimit() {
      return this.globalPacketLimit;
   }

   @Override
   public void setGlobalPacketLimit(int globalPacketLimit) {
      this.globalPacketLimit = globalPacketLimit;
   }
}
