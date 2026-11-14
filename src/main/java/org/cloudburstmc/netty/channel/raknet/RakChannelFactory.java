package org.cloudburstmc.netty.channel.raknet;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFactory;
import io.netty.channel.socket.DatagramChannel;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.function.Consumer;

public class RakChannelFactory<T extends Channel> implements ChannelFactory<T> {
   private final Constructor<? extends T> constructor;
   private final Constructor<? extends DatagramChannel> datagramConstructor;
   private final Consumer<DatagramChannel> parentConsumer;

   private RakChannelFactory(Class<? extends T> clazz, Class<? extends DatagramChannel> datagramClass, Consumer<DatagramChannel> parentConsumer) {
      Objects.requireNonNull(clazz, "clazz");
      Objects.requireNonNull(datagramClass, "datagramClass");

      try {
         this.constructor = clazz.getConstructor(DatagramChannel.class);
      } catch (NoSuchMethodException e) {
         throw new IllegalArgumentException("Proxy class " + StringUtil.simpleClassName(clazz) + " does not have a public non-arg constructor", e);
      }

      try {
         this.datagramConstructor = datagramClass.getConstructor();
      } catch (NoSuchMethodException e) {
         throw new IllegalArgumentException("Class " + StringUtil.simpleClassName(clazz) + " does not have a public non-arg constructor", e);
      }

      this.parentConsumer = parentConsumer;
   }

   public static RakChannelFactory<RakServerChannel> server(Class<? extends DatagramChannel> clazz) {
      return new RakChannelFactory<>(RakServerChannel.class, clazz, null);
   }

   public static RakChannelFactory<RakServerChannel> server(Class<? extends DatagramChannel> clazz, Consumer<DatagramChannel> parentConsumer) {
      return new RakChannelFactory<>(RakServerChannel.class, clazz, parentConsumer);
   }

   public static RakChannelFactory<RakClientChannel> client(Class<? extends DatagramChannel> clazz) {
      return new RakChannelFactory<>(RakClientChannel.class, clazz, null);
   }

   public static RakChannelFactory<RakClientChannel> client(Class<? extends DatagramChannel> clazz, Consumer<DatagramChannel> parentConsumer) {
      return new RakChannelFactory<>(RakClientChannel.class, clazz, parentConsumer);
   }

   @Override
   public T newChannel() {
      try {
         DatagramChannel channel = this.datagramConstructor.newInstance();
         if (this.parentConsumer != null) {
            this.parentConsumer.accept(channel);
         }

         return (T)this.constructor.newInstance(channel);
      } catch (Throwable t) {
         throw new ChannelException("Unable to create Channel from class " + this.constructor.getDeclaringClass(), t);
      }
   }

   @Override
   public String toString() {
      return StringUtil.simpleClassName(RakChannelFactory.class)
         + '('
         + StringUtil.simpleClassName(this.constructor.getDeclaringClass())
         + ".class, "
         + StringUtil.simpleClassName(this.datagramConstructor.getDeclaringClass())
         + ".class)";
   }
}
