package com.nukkitx.protocol.bedrock.codec.v291.serializer;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.bedrock.codec.BedrockPacketSerializer;
import com.nukkitx.protocol.bedrock.packet.PurchaseReceiptPacket;
import io.netty.buffer.ByteBuf;

public class PurchaseReceiptSerializer_v291 implements BedrockPacketSerializer<PurchaseReceiptPacket> {
   public static final PurchaseReceiptSerializer_v291 INSTANCE = new PurchaseReceiptSerializer_v291();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, PurchaseReceiptPacket packet) {
      helper.writeArray(buffer, packet.getReceipts(), helper::writeString);
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, PurchaseReceiptPacket packet) {
      helper.readArray(buffer, packet.getReceipts(), helper::readString);
   }

   protected PurchaseReceiptSerializer_v291() {
   }
}
