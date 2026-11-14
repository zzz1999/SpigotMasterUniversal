package org.cloudburstmc.netty.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.DefaultChannelPipeline;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Queue;

public class RakUtils {
   private static final Constructor<DefaultChannelPipeline> DEFAULT_CHANNEL_PIPELINE_CONSTRUCTOR;
   private static final int AF_INET6 = 23;

   public static DefaultChannelPipeline newChannelPipeline(Channel channel) {
      try {
         return DEFAULT_CHANNEL_PIPELINE_CONSTRUCTOR.newInstance(channel);
      } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
         throw new IllegalStateException("Unable to instantiate DefaultChannelPipeline", e);
      }
   }

   public static InetSocketAddress readAddress(ByteBuf buffer) {
      short type = buffer.readByte();

      InetAddress address;
      int port;
      try {
         if (type == 4) {
            byte[] addressBytes = new byte[4];
            buffer.readBytes(addressBytes);
            flip(addressBytes);
            address = Inet4Address.getByAddress(addressBytes);
            port = buffer.readUnsignedShort();
         } else {
            if (type != 6) {
               throw new UnsupportedOperationException("Unknown Internet Protocol version.");
            }

            buffer.readShortLE();
            port = buffer.readUnsignedShort();
            buffer.readInt();
            byte[] addressBytes = new byte[16];
            buffer.readBytes(addressBytes);
            int scopeId = buffer.readInt();
            address = Inet6Address.getByAddress(null, addressBytes, scopeId);
         }
      } catch (UnknownHostException e) {
         throw new IllegalArgumentException(e);
      }

      return new InetSocketAddress(address, port);
   }

   public static void writeAddress(ByteBuf buffer, InetSocketAddress address) {
      byte[] addressBytes = address.getAddress().getAddress();
      if (address.getAddress() instanceof Inet4Address) {
         buffer.writeByte(4);
         flip(addressBytes);
         buffer.writeBytes(addressBytes);
         buffer.writeShort(address.getPort());
      } else {
         if (!(address.getAddress() instanceof Inet6Address)) {
            throw new UnsupportedOperationException("Unknown InetAddress instance");
         }

         buffer.writeByte(6);
         buffer.writeShortLE(23);
         buffer.writeShort(address.getPort());
         buffer.writeInt(0);
         buffer.writeBytes(addressBytes);
         buffer.writeInt(((Inet6Address)address.getAddress()).getScopeId());
      }
   }

   private static void flip(byte[] bytes) {
      for (int i = 0; i < bytes.length; i++) {
         bytes[i] = (byte)(~bytes[i] & 0xFF);
      }
   }

   public static int writeAckEntries(ByteBuf buffer, Queue<IntRange> ackQueue, int mtu) {
      int startIndex = buffer.writerIndex();
      buffer.writeZero(2);
      mtu -= 2;
      int count = 0;

      IntRange ackRange;
      while ((ackRange = ackQueue.peek()) != null) {
         boolean singleton = ackRange.start == ackRange.end;
         int size = singleton ? 4 : 7;
         if (mtu < size) {
            break;
         }

         count++;
         mtu -= size;
         buffer.writeBoolean(singleton);
         buffer.writeMediumLE(ackRange.start);
         if (!singleton) {
            buffer.writeMediumLE(ackRange.end);
         }

         ackQueue.remove();
      }

      int finalIndex = buffer.writerIndex();
      buffer.writerIndex(startIndex);
      buffer.writeShort(count);
      buffer.writerIndex(finalIndex);
      return count;
   }

   public static int clamp(int value, int low, int high) {
      return value < low ? low : (value > high ? high : value);
   }

   public static int powerOfTwoCeiling(int value) {
      value = --value | value >> 1;
      value |= value >> 2;
      value |= value >> 4;
      value |= value >> 8;
      value |= value >> 16;
      return value + 1;
   }

   static {
      try {
         Constructor<DefaultChannelPipeline> constructor = DefaultChannelPipeline.class.getDeclaredConstructor(Channel.class);
         constructor.setAccessible(true);
         DEFAULT_CHANNEL_PIPELINE_CONSTRUCTOR = constructor;
      } catch (NoSuchMethodException e) {
         throw new AssertionError("Unable to find DefaultChannelPipeline(Channel) constructor", e);
      }
   }
}
