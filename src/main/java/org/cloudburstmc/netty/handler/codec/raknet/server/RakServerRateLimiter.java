package org.cloudburstmc.netty.handler.codec.raknet.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.cloudburstmc.netty.channel.raknet.RakServerChannel;

public class RakServerRateLimiter extends SimpleChannelInboundHandler<DatagramPacket> {
   public static final String NAME = "rak-server-rate-limiter";
   private static final InternalLogger log = InternalLoggerFactory.getInstance(RakServerRateLimiter.class);
   private final RakServerChannel channel;
   private final ConcurrentHashMap<InetAddress, AtomicInteger> rateLimitMap = new ConcurrentHashMap<>();
   private final Map<InetAddress, Long> blockedConnections = new ConcurrentHashMap<>();
   private final Collection<InetAddress> exceptions = Collections.synchronizedCollection(new HashSet<>());
   private final AtomicLong globalCounter = new AtomicLong(0L);
   private ScheduledFuture<?> tickFuture;
   private ScheduledFuture<?> blockedTickFuture;

   public RakServerRateLimiter(RakServerChannel channel) {
      this.channel = channel;
   }

   @Override
   public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
      this.tickFuture = ctx.channel().eventLoop().scheduleAtFixedRate(this::onRakTick, 10L, 10L, TimeUnit.MILLISECONDS);
      this.blockedTickFuture = ctx.channel().eventLoop().scheduleAtFixedRate(this::onBlockedTick, 100L, 100L, TimeUnit.MILLISECONDS);
   }

   @Override
   public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
      this.tickFuture.cancel(false);
      this.blockedTickFuture.cancel(true);
      this.rateLimitMap.clear();
   }

   private void onRakTick() {
      this.rateLimitMap.clear();
      this.globalCounter.set(0L);
   }

   private void onBlockedTick() {
      long currTime = System.currentTimeMillis();
      Iterator<Entry<InetAddress, Long>> iterator = this.blockedConnections.entrySet().iterator();

      while (iterator.hasNext()) {
         Entry<InetAddress, Long> entry = iterator.next();
         if (entry.getValue() != 0L && currTime > entry.getValue()) {
            iterator.remove();
            log.info("Unblocked address {}", entry.getKey());
         }
      }
   }

   public boolean blockAddress(InetAddress address, long time, TimeUnit unit) {
      if (this.exceptions.contains(address)) {
         return false;
      }

      long millis = unit.toMillis(time);
      this.blockedConnections.put(address, System.currentTimeMillis() + millis);
      return true;
   }

   public void unblockAddress(InetAddress address) {
      if (this.blockedConnections.remove(address) != null) {
         log.info("Unblocked address {}", address);
      }
   }

   public boolean isAddressBlocked(InetAddress address) {
      return this.blockedConnections.containsKey(address);
   }

   public void addException(InetAddress address) {
      this.exceptions.add(address);
   }

   public void removeException(InetAddress address) {
      this.exceptions.remove(address);
   }

   protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket datagram) throws Exception {
      if (this.globalCounter.incrementAndGet() > this.channel.config().getGlobalPacketLimit()) {
         if (log.isTraceEnabled()) {
            log.trace("[{}] Dropped incoming packet because global packet limit was reached: {}", datagram.sender(), this.globalCounter.get());
         }
      } else {
         InetAddress address = datagram.sender().getAddress();
         if (!this.blockedConnections.containsKey(address)) {
            AtomicInteger counter = this.rateLimitMap.computeIfAbsent(address, a -> new AtomicInteger());
            if (counter.incrementAndGet() > this.channel.config().getPacketLimit() && this.blockAddress(address, 10L, TimeUnit.SECONDS)) {
               log.warn("[{}] Blocked because packet limit was reached");
            } else {
               ctx.fireChannelRead(datagram.retain());
            }
         }
      }
   }
}
