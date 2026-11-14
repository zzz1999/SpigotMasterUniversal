package org.cloudburstmc.netty.channel.raknet;

import io.netty.channel.AbstractChannel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.util.ReferenceCountUtil;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import org.cloudburstmc.netty.channel.raknet.config.DefaultRakSessionConfig;
import org.cloudburstmc.netty.channel.raknet.config.RakChannelConfig;
import org.cloudburstmc.netty.handler.codec.raknet.common.ConnectedPingHandler;
import org.cloudburstmc.netty.handler.codec.raknet.common.ConnectedPongHandler;
import org.cloudburstmc.netty.handler.codec.raknet.common.DisconnectNotificationHandler;
import org.cloudburstmc.netty.handler.codec.raknet.common.RakAcknowledgeHandler;
import org.cloudburstmc.netty.handler.codec.raknet.common.RakDatagramCodec;
import org.cloudburstmc.netty.handler.codec.raknet.common.RakSessionCodec;
import org.cloudburstmc.netty.handler.codec.raknet.common.RakUnhandledMessagesQueue;
import org.cloudburstmc.netty.handler.codec.raknet.server.RakChildDatagramHandler;
import org.cloudburstmc.netty.handler.codec.raknet.server.RakServerOnlineInitialHandler;

public class RakChildChannel extends AbstractChannel implements RakChannel {
   private static final ChannelMetadata metadata = new ChannelMetadata(true);
   private final RakChannelConfig config;
   private final InetSocketAddress remoteAddress;
   private final DefaultChannelPipeline rakPipeline;
   private volatile boolean open = true;
   private volatile boolean active;

   public RakChildChannel(InetSocketAddress remoteAddress, RakServerChannel parent, long guid, int version, int mtu) {
      super(parent);
      this.remoteAddress = remoteAddress;
      this.config = new DefaultRakSessionConfig(this);
      this.config.setGuid(guid);
      this.config.setProtocolVersion(version);
      this.config.setMtu(mtu);
      this.rakPipeline = new RakChannelPipeline(parent, this);
      this.rakPipeline.addLast("rak-child-datagram-handler", new RakChildDatagramHandler(this));
      RakSessionCodec sessionCodec = new RakSessionCodec(this);
      this.rakPipeline.addLast("rak-datagram-codec", new RakDatagramCodec());
      this.rakPipeline.addLast("rak-acknowledge-handler", new RakAcknowledgeHandler(sessionCodec));
      this.rakPipeline.addLast("rak-session-codec", sessionCodec);
      this.rakPipeline.addLast("rak-connected-ping-handler", new ConnectedPingHandler());
      this.rakPipeline.addLast("rak-connected-pong-handler", new ConnectedPongHandler(sessionCodec));
      this.rakPipeline.addLast("rak-disconnect-notification-handler", DisconnectNotificationHandler.INSTANCE);
      this.rakPipeline.addLast("rak-server-online-initial-handler", new RakServerOnlineInitialHandler(this));
      this.rakPipeline.addLast("rak-unhandled-messages-queue", new RakUnhandledMessagesQueue(this));
      this.rakPipeline.fireChannelRegistered();
      this.rakPipeline.fireChannelActive();
   }

   @Override
   public ChannelPipeline rakPipeline() {
      return this.rakPipeline;
   }

   @Override
   public SocketAddress localAddress0() {
      return this.parent().localAddress();
   }

   @Override
   public SocketAddress remoteAddress0() {
      return this.remoteAddress;
   }

   public InetSocketAddress localAddress() {
      return (InetSocketAddress)super.localAddress();
   }

   public InetSocketAddress remoteAddress() {
      return (InetSocketAddress)super.remoteAddress();
   }

   @Override
   public RakChannelConfig config() {
      return this.config;
   }

   @Override
   public ChannelMetadata metadata() {
      return metadata;
   }

   @Override
   protected void doBind(SocketAddress socketAddress) throws Exception {
      throw new UnsupportedOperationException("Can not bind child channel!");
   }

   @Override
   protected void doBeginRead() throws Exception {
   }

   @Override
   protected void doWrite(ChannelOutboundBuffer in) throws Exception {
      if (!this.open) {
         throw new ClosedChannelException();
      }

      if (!this.active) {
         throw new NonWritableChannelException();
      }

      ClosedChannelException exception = null;

      while (true) {
         Object msg = in.current();
         if (msg == null) {
            this.rakPipeline.flush();
            return;
         }

         try {
            if (this.parent().isOpen()) {
               this.rakPipeline.write(ReferenceCountUtil.retain(msg));
               in.remove();
            } else {
               if (exception == null) {
                  exception = new ClosedChannelException();
               }

               in.remove(exception);
            }
         } catch (Throwable cause) {
            in.remove(cause);
         }
      }
   }

   public void setActive(boolean active) {
      this.active = active;
   }

   @Override
   protected void doDisconnect() throws Exception {
      this.close();
   }

   @Override
   protected void doClose() throws Exception {
      this.open = false;
   }

   @Override
   public boolean isActive() {
      return this.isOpen() && this.active;
   }

   @Override
   public boolean isOpen() {
      return this.open;
   }

   @Override
   protected boolean isCompatible(EventLoop eventLoop) {
      return true;
   }

   @Override
   protected AbstractChannel.AbstractUnsafe newUnsafe() {
      return new AbstractChannel.AbstractUnsafe() {
         @Override
         public void connect(SocketAddress socketAddress, SocketAddress socketAddress1, ChannelPromise channelPromise) {
            throw new UnsupportedOperationException("Can not connect child channel!");
         }
      };
   }
}
