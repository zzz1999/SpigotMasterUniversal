package org.cloudburstmc.netty.channel.raknet;

import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.DatagramChannel;
import org.cloudburstmc.netty.channel.proxy.ProxyChannel;
import org.cloudburstmc.netty.channel.raknet.config.DefaultRakClientConfig;
import org.cloudburstmc.netty.channel.raknet.config.RakChannelConfig;
import org.cloudburstmc.netty.handler.codec.raknet.client.RakClientProxyRouteHandler;
import org.cloudburstmc.netty.handler.codec.raknet.client.RakClientRouteHandler;
import org.cloudburstmc.netty.handler.codec.raknet.common.UnconnectedPingEncoder;
import org.cloudburstmc.netty.handler.codec.raknet.common.UnconnectedPongDecoder;

public class RakClientChannel extends ProxyChannel<DatagramChannel> implements RakChannel {
   private static final ChannelMetadata metadata = new ChannelMetadata(true);
   private final RakChannelConfig config = new DefaultRakClientConfig(this);
   private final ChannelPromise connectPromise;

   public RakClientChannel(DatagramChannel channel) {
      super(channel);
      this.pipeline().addLast("rak-client-route-handler", new RakClientRouteHandler(this));
      this.rakPipeline().addFirst("rak-client-proxy-route-handler", new RakClientProxyRouteHandler(this));
      this.rakPipeline().addBefore("rak-proxy-inbound-router", "rak-unconnected-ping-encoder", new UnconnectedPingEncoder(this));
      this.rakPipeline().addAfter("rak-unconnected-ping-encoder", "rak-unconnected-pong-deencoder", new UnconnectedPongDecoder(this));
      this.connectPromise = this.newPromise();
      this.connectPromise.addListener(future -> {
         if (future.isSuccess()) {
            this.onConnectionEstablished();
         } else {
            this.close();
         }
      });
   }

   private void onConnectionEstablished() {
      this.pipeline().fireChannelActive();
   }

   @Override
   public RakChannelConfig config() {
      return this.config;
   }

   public ChannelPromise getConnectPromise() {
      return this.connectPromise;
   }

   @Override
   public boolean isActive() {
      return super.isActive() && this.connectPromise.isSuccess();
   }

   @Override
   public ChannelPipeline rakPipeline() {
      return this.parent().pipeline();
   }

   @Override
   public ChannelMetadata metadata() {
      return metadata;
   }
}
