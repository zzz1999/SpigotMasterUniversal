package com.nukkitx.network.raknet;

import com.nukkitx.network.raknet.pipeline.ProxyServerHandler;
import com.nukkitx.network.raknet.pipeline.RakExceptionHandler;
import com.nukkitx.network.raknet.pipeline.RakOutboundHandler;
import com.nukkitx.network.raknet.pipeline.ServerDatagramHandler;
import com.nukkitx.network.raknet.pipeline.ServerMessageHandler;
import com.nukkitx.network.raknet.util.RoundRobinIterator;
import com.nukkitx.network.util.Bootstraps;
import com.nukkitx.network.util.DisconnectReason;
import com.nukkitx.network.util.EventLoops;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import javax.annotation.Nonnegative;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;

@ParametersAreNonnullByDefault
public class RakNetServer extends RakNet {
   private static final InternalLogger log = InternalLoggerFactory.getInstance(RakNetServer.class);
   private final ConcurrentMap<InetAddress, Long> blockAddresses = new ConcurrentHashMap<>();
   final ConcurrentMap<InetSocketAddress, RakNetServerSession> sessionsByAddress = new ConcurrentHashMap<>();
   final ExpiringMap<InetSocketAddress, InetSocketAddress> proxiedAddresses;
   private final InetSocketAddress bindAddress;
   private final int bindThreads;
   private final boolean useProxyProtocol;
   private int maxConnections = 1024;
   private final Set<Channel> channels = new HashSet<>();
   private final Iterator<Channel> channelIterator = new RoundRobinIterator<>(this.channels);
   private final RakNetServer.ServerChannelInitializer initializer = new RakNetServer.ServerChannelInitializer();
   private final ServerMessageHandler messageHandler = new ServerMessageHandler(this);
   private final ProxyServerHandler proxyServerHandler;
   private final ServerDatagramHandler serverDatagramHandler = new ServerDatagramHandler(this);
   private final RakExceptionHandler exceptionHandler = new RakExceptionHandler(this);
   private volatile RakNetServerListener listener = null;

   public RakNetServer(InetSocketAddress bindAddress) {
      this(bindAddress, 1);
   }

   public RakNetServer(InetSocketAddress bindAddress, int bindThreads) {
      this(bindAddress, bindThreads, EventLoops.commonGroup());
   }

   public RakNetServer(InetSocketAddress bindAddress, int bindThreads, EventLoopGroup eventLoopGroup) {
      this(bindAddress, bindThreads, eventLoopGroup, eventLoopGroup, false);
   }

   public RakNetServer(InetSocketAddress bindAddress, int bindThreads, EventLoopGroup eventLoopGroup, EventLoopGroup workerGroup, boolean useProxyProtocol) {
      super(eventLoopGroup, workerGroup);
      this.bindThreads = bindThreads;
      this.bindAddress = bindAddress;
      this.useProxyProtocol = useProxyProtocol;
      this.proxiedAddresses = ExpiringMap.builder().expiration(31L, TimeUnit.MINUTES).expirationPolicy(ExpirationPolicy.ACCESSED).build();
      this.proxyServerHandler = useProxyProtocol ? new ProxyServerHandler(this) : null;
      Consumer<Throwable> loggingThrow = new Consumer<Throwable>() {
         public void accept(Throwable t) {
            RakNetServer.log.error("raknet server caught error:", t);
         }
      };
      this.addExceptionHandler("error_log", loggingThrow);
   }

   @Override
   protected CompletableFuture<Void> bindInternal() {
      int bindThreads = Bootstraps.isReusePortAvailable() ? this.bindThreads : 1;
      ChannelFuture[] channelFutures = new ChannelFuture[bindThreads];

      for (int i = 0; i < bindThreads; i++) {
         channelFutures[i] = this.bootstrap.handler(this.initializer).bind(this.bindAddress);
      }

      return Bootstraps.allOf(channelFutures);
   }

   public void send(InetSocketAddress address, ByteBuf buffer) {
      this.channelIterator.next().writeAndFlush(new DatagramPacket(buffer, address));
   }

   @Override
   public void close(boolean force) {
      super.close(force);

      for (RakNetServerSession session : this.sessionsByAddress.values()) {
         session.disconnect(DisconnectReason.SHUTTING_DOWN);
      }

      for (Channel channel : this.channels) {
         channel.close().syncUninterruptibly();
      }
   }

   @Override
   protected void onTick() {
   }

   public void onOpenConnectionRequest1(ChannelHandlerContext ctx, DatagramPacket packet) {
      if (packet.content().isReadable(16)) {
         ByteBuf buffer = packet.content();
         if (RakNetUtils.verifyUnconnectedMagic(buffer)) {
            int protocolVersion = buffer.readUnsignedByte();
            int mtu = buffer.readableBytes() + 1 + 16 + 1 + (packet.sender().getAddress() instanceof Inet6Address ? 40 : 20) + 8;
            RakNetServerSession session = this.sessionsByAddress.get(packet.sender());
            InetSocketAddress clientAddress;
            InetSocketAddress proxiedAddress;
            if (this.useProxyProtocol && (proxiedAddress = this.proxiedAddresses.get(packet.sender())) != null) {
               clientAddress = proxiedAddress;
            } else {
               clientAddress = packet.sender();
            }

            if (session != null && session.getState() == RakNetState.CONNECTED) {
               this.sendAlreadyConnected(ctx, packet.sender());
            } else if (this.protocolVersion >= 0 && this.protocolVersion != protocolVersion) {
               this.sendIncompatibleProtocolVersion(ctx, packet.sender());
            } else if (this.maxConnections >= 0 && this.maxConnections <= this.getSessionCount()) {
               this.sendNoFreeIncomingConnections(ctx, packet.sender());
            } else if (this.listener != null && !this.listener.onConnectionRequest(packet.sender(), clientAddress)) {
               this.sendConnectionBanned(ctx, packet.sender());
            } else if (session == null) {
               session = new RakNetServerSession(this, packet.sender(), ctx.channel(), this.workerGroup.next(), mtu, protocolVersion);
               if (this.sessionsByAddress.putIfAbsent(packet.sender(), session) == null) {
                  session.setState(RakNetState.INITIALIZING);
                  session.proxiedAddress = this.proxiedAddresses.get(packet.sender());
                  session.sendOpenConnectionReply1();
                  if (this.listener != null) {
                     this.listener.onSessionCreation(session);
                  }
               }
            } else {
               session.sendOpenConnectionReply1();
            }
         }
      }
   }

   public void block(InetAddress address) {
      Objects.requireNonNull(address, "address");
      this.blockAddresses.put(address, -1L);
   }

   public void block(InetAddress address, long timeout, TimeUnit timeUnit) {
      Objects.requireNonNull(address, "address");
      Objects.requireNonNull(address, "timeUnit");
      this.blockAddresses.put(address, System.currentTimeMillis() + timeUnit.toMillis(timeout));
   }

   public boolean unblock(InetAddress address) {
      Objects.requireNonNull(address, "address");
      return this.blockAddresses.remove(address) != null;
   }

   public boolean isBlocked(InetAddress address) {
      return this.blockAddresses.containsKey(address);
   }

   public void addProxiedAddress(InetSocketAddress address, InetSocketAddress presentAddress) {
      this.proxiedAddresses.put(address, presentAddress);
   }

   public InetSocketAddress getProxiedAddress(InetSocketAddress address) {
      return this.proxiedAddresses.get(address);
   }

   public int getProxiedAddressSize() {
      return this.proxiedAddresses.size();
   }

   public int getSessionCount() {
      return this.sessionsByAddress.size();
   }

   @Nullable
   public RakNetServerSession getSession(InetSocketAddress address) {
      return this.sessionsByAddress.get(address);
   }

   @Nonnegative
   public int getMaxConnections() {
      return this.maxConnections;
   }

   public void setMaxConnections(@Nonnegative int maxConnections) {
      this.maxConnections = maxConnections;
   }

   @Override
   public InetSocketAddress getBindAddress() {
      return this.bindAddress;
   }

   public RakNetServerListener getListener() {
      return this.listener;
   }

   public void setListener(RakNetServerListener listener) {
      this.listener = listener;
   }

   public boolean useProxyProtocol() {
      return this.useProxyProtocol;
   }

   private void sendAlreadyConnected(ChannelHandlerContext ctx, InetSocketAddress recipient) {
      ByteBuf buffer = ctx.alloc().ioBuffer(25, 25);
      buffer.writeByte(18);
      RakNetUtils.writeUnconnectedMagic(buffer);
      buffer.writeLong(this.guid);
      ctx.writeAndFlush(new DatagramPacket(buffer, recipient));
   }

   private void sendConnectionBanned(ChannelHandlerContext ctx, InetSocketAddress recipient) {
      ByteBuf buffer = ctx.alloc().ioBuffer(25, 25);
      buffer.writeByte(23);
      RakNetUtils.writeUnconnectedMagic(buffer);
      buffer.writeLong(this.guid);
      ctx.writeAndFlush(new DatagramPacket(buffer, recipient));
   }

   private void sendIncompatibleProtocolVersion(ChannelHandlerContext ctx, InetSocketAddress recipient) {
      ByteBuf buffer = ctx.alloc().ioBuffer(26, 26);
      buffer.writeByte(25);
      buffer.writeByte(this.protocolVersion);
      RakNetUtils.writeUnconnectedMagic(buffer);
      buffer.writeLong(this.guid);
      ctx.writeAndFlush(new DatagramPacket(buffer, recipient));
   }

   private void sendNoFreeIncomingConnections(ChannelHandlerContext ctx, InetSocketAddress recipient) {
      ByteBuf buffer = ctx.alloc().ioBuffer(25, 25);
      buffer.writeByte(20);
      RakNetUtils.writeUnconnectedMagic(buffer);
      buffer.writeLong(this.guid);
      ctx.writeAndFlush(new DatagramPacket(buffer, recipient));
   }

   @ChannelHandler.Sharable
   private class ServerChannelInitializer extends ChannelInitializer<Channel> {
      private ServerChannelInitializer() {
      }

      @Override
      protected void initChannel(Channel channel) throws Exception {
         ChannelPipeline pipeline = channel.pipeline();
         if (RakNetServer.this.useProxyProtocol()) {
            pipeline.addLast("rak-proxy-server-handler", RakNetServer.this.proxyServerHandler);
         }

         pipeline.addLast("rak-outbound-handler", new RakOutboundHandler(RakNetServer.this));
         pipeline.addLast("rak-server-message-handler", RakNetServer.this.messageHandler);
         pipeline.addLast("rak-server-datagram-handler", RakNetServer.this.serverDatagramHandler);
         pipeline.addLast("rak-exception-handler", RakNetServer.this.exceptionHandler);
         RakNetServer.this.channels.add(channel);
      }
   }
}
