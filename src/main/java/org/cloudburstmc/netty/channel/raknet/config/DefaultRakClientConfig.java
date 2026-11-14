package org.cloudburstmc.netty.channel.raknet.config;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import java.util.Map;
import org.cloudburstmc.netty.channel.raknet.RakConstants;

public class DefaultRakClientConfig extends DefaultRakSessionConfig {
   private volatile ByteBuf unconnectedMagic = Unpooled.wrappedBuffer(RakConstants.DEFAULT_UNCONNECTED_MAGIC);
   private volatile long connectTimeout = 10000L;
   private volatile long sessionTimeout = 10000L;
   private volatile long serverGuid;

   public DefaultRakClientConfig(Channel channel) {
      super(channel);
   }

   @Override
   public Map<ChannelOption<?>, Object> getOptions() {
      return this.getOptions(super.getOptions(), RakChannelOption.RAK_UNCONNECTED_MAGIC);
   }

   @Override
   public <T> T getOption(ChannelOption<T> option) {
      if (option == RakChannelOption.RAK_UNCONNECTED_MAGIC) {
         return (T)this.getUnconnectedMagic();
      } else if (option == RakChannelOption.RAK_CONNECT_TIMEOUT) {
         return (T)Long.valueOf(this.getConnectTimeout());
      } else if (option == RakChannelOption.RAK_REMOTE_GUID) {
         return (T)Long.valueOf(this.getServerGuid());
      } else {
         return (T)(option == RakChannelOption.RAK_SESSION_TIMEOUT ? this.getSessionTimeout() : super.getOption(option));
      }
   }

   @Override
   public <T> boolean setOption(ChannelOption<T> option, T value) {
      this.validate(option, value);
      if (option == RakChannelOption.RAK_UNCONNECTED_MAGIC) {
         this.setUnconnectedMagic((ByteBuf)value);
         return true;
      } else if (option == RakChannelOption.RAK_CONNECT_TIMEOUT) {
         this.setConnectTimeout((Long)value);
         return true;
      } else if (option == RakChannelOption.RAK_REMOTE_GUID) {
         this.setServerGuid((Long)value);
         return true;
      } else if (option == RakChannelOption.RAK_SESSION_TIMEOUT) {
         this.setSessionTimeout((Long)value);
         return true;
      } else {
         return super.setOption(option, value);
      }
   }

   public ByteBuf getUnconnectedMagic() {
      return this.unconnectedMagic.slice();
   }

   public RakServerChannelConfig setUnconnectedMagic(ByteBuf unconnectedMagic) {
      if (unconnectedMagic.readableBytes() < 16) {
         throw new IllegalArgumentException("Unconnect magic must at least be 16 bytes");
      }

      this.unconnectedMagic = unconnectedMagic.copy().asReadOnly();
      return null;
   }

   public long getConnectTimeout() {
      return this.connectTimeout;
   }

   public DefaultRakClientConfig setConnectTimeout(long connectTimeout) {
      this.connectTimeout = connectTimeout;
      return this;
   }

   public long getServerGuid() {
      return this.serverGuid;
   }

   public DefaultRakClientConfig setServerGuid(long serverGuid) {
      this.serverGuid = serverGuid;
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
}
