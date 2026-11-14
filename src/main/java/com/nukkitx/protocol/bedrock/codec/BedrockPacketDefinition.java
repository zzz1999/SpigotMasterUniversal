package com.nukkitx.protocol.bedrock.codec;

import com.nukkitx.protocol.bedrock.data.PacketRecipient;
import com.nukkitx.protocol.bedrock.packet.BedrockPacket;
import java.util.function.Supplier;

public final class BedrockPacketDefinition<T extends BedrockPacket> {
   private final int id;
   private final Supplier<T> factory;
   private final BedrockPacketSerializer<T> serializer;
   private final PacketRecipient recipient;

   public BedrockPacketDefinition(int id, Supplier<T> factory, BedrockPacketSerializer<T> serializer, PacketRecipient recipient) {
      this.id = id;
      this.factory = factory;
      this.serializer = serializer;
      this.recipient = recipient;
   }

   public int getId() {
      return this.id;
   }

   public Supplier<T> getFactory() {
      return this.factory;
   }

   public BedrockPacketSerializer<T> getSerializer() {
      return this.serializer;
   }

   public PacketRecipient getRecipient() {
      return this.recipient;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BedrockPacketDefinition)) {
         return false;
      }

      BedrockPacketDefinition<?> other = (BedrockPacketDefinition<?>)o;
      if (this.getId() != other.getId()) {
         return false;
      }

      Object this$factory = this.getFactory();
      Object other$factory = other.getFactory();
      if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
         Object this$serializer = this.getSerializer();
         Object other$serializer = other.getSerializer();
         if (this$serializer == null ? other$serializer == null : this$serializer.equals(other$serializer)) {
            Object this$recipient = this.getRecipient();
            Object other$recipient = other.getRecipient();
            return this$recipient == null ? other$recipient == null : this$recipient.equals(other$recipient);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getId();
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $serializer = this.getSerializer();
      result = result * 59 + ($serializer == null ? 43 : $serializer.hashCode());
      Object $recipient = this.getRecipient();
      return result * 59 + ($recipient == null ? 43 : $recipient.hashCode());
   }

   @Override
   public String toString() {
      return "BedrockPacketDefinition(id="
         + this.getId()
         + ", factory="
         + this.getFactory()
         + ", serializer="
         + this.getSerializer()
         + ", recipient="
         + this.getRecipient()
         + ")";
   }
}
