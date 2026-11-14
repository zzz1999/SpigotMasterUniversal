package org.cloudburstmc.netty.channel.raknet;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ServerChannel;
import io.netty.channel.socket.DatagramChannel;
import io.netty.util.concurrent.PromiseCombiner;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.cloudburstmc.netty.channel.proxy.ProxyChannel;
import org.cloudburstmc.netty.channel.raknet.config.DefaultRakServerConfig;
import org.cloudburstmc.netty.channel.raknet.config.RakServerChannelConfig;
import org.cloudburstmc.netty.handler.codec.raknet.common.UnconnectedPongEncoder;
import org.cloudburstmc.netty.handler.codec.raknet.server.RakServerOfflineHandler;
import org.cloudburstmc.netty.handler.codec.raknet.server.RakServerRateLimiter;
import org.cloudburstmc.netty.handler.codec.raknet.server.RakServerRouteHandler;
import org.cloudburstmc.netty.handler.codec.raknet.server.RakServerTailHandler;

public class RakServerChannel extends ProxyChannel<DatagramChannel> implements ServerChannel {
   private final RakServerChannelConfig config;
   private final Map<SocketAddress, RakChildChannel> childChannelMap = new ConcurrentHashMap<>();

   public RakServerChannel(DatagramChannel channel) {
      super(channel);
      this.config = new DefaultRakServerConfig(this);
      this.pipeline().addLast("rak-unconnected-pong-encoder", UnconnectedPongEncoder.INSTANCE);
      this.pipeline().addLast("rak-server-rate-limiter", new RakServerRateLimiter(this));
      this.pipeline().addLast("rak-offline-handler", new RakServerOfflineHandler(this));
      this.pipeline().addLast("rak-server-route-handler", new RakServerRouteHandler(this));
      this.pipeline().addLast("rak-server-tail-handler", RakServerTailHandler.INSTANCE);
   }

   public RakChildChannel createChildChannel(InetSocketAddress address, long clientGuid, int protocolVersion, int mtu) {
      if (this.childChannelMap.containsKey(address)) {
         return null;
      }

      RakChildChannel channel = new RakChildChannel(address, this, clientGuid, protocolVersion, mtu);
      channel.closeFuture().addListener((ChannelFutureListener)this::onChildClosed);
      this.pipeline().fireChannelRead(channel).fireChannelReadComplete();
      this.childChannelMap.put(address, channel);
      return channel;
   }

   public RakChildChannel getChildChannel(SocketAddress address) {
      return this.childChannelMap.get(address);
   }

   private void onChildClosed(ChannelFuture channelFuture) {
      RakChildChannel channel = (RakChildChannel)channelFuture.channel();
      channel.rakPipeline().fireChannelInactive();
      channel.rakPipeline().fireChannelUnregistered();
      this.childChannelMap.remove(channel.remoteAddress());
   }

   @Override
   public void onCloseTriggered(ChannelPromise promise) {
      PromiseCombiner combiner = new PromiseCombiner(this.eventLoop());
      this.childChannelMap.values().forEach(channel -> combiner.add(channel.close()));
      ChannelPromise combinedPromise = this.newPromise();
      combinedPromise.addListener(future -> super.onCloseTriggered(promise));
      combiner.finish(combinedPromise);
   }

   public boolean tryBlockAddress(InetAddress address, long time, TimeUnit unit) {
      RakServerRateLimiter rateLimiter = this.pipeline().get(RakServerRateLimiter.class);
      return rateLimiter != null ? rateLimiter.blockAddress(address, time, unit) : false;
   }

   public RakServerChannelConfig config() {
      return this.config;
   }
}
