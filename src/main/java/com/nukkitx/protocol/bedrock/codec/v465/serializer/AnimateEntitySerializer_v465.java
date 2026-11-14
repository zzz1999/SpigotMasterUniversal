package com.nukkitx.protocol.bedrock.codec.v465.serializer;

import com.nukkitx.protocol.bedrock.codec.BedrockCodecHelper;
import com.nukkitx.protocol.bedrock.codec.v419.serializer.AnimateEntitySerializer_v419;
import com.nukkitx.protocol.bedrock.packet.AnimateEntityPacket;
import com.nukkitx.protocol.common.util.VarInts;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.longs.LongList;

public class AnimateEntitySerializer_v465 extends AnimateEntitySerializer_v419 {
   public static final AnimateEntitySerializer_v465 INSTANCE = new AnimateEntitySerializer_v465();

   @Override
   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, AnimateEntityPacket packet) {
      helper.writeString(buffer, packet.getAnimation());
      helper.writeString(buffer, packet.getNextState());
      helper.writeString(buffer, packet.getStopExpression());
      buffer.writeInt(packet.getStopExpressionVersion());
      helper.writeString(buffer, packet.getController());
      buffer.writeFloatLE(packet.getBlendOutTime());
      LongList runtimeIds = packet.getRuntimeEntityIds();
      VarInts.writeUnsignedInt(buffer, runtimeIds.size());

      for (long runtimeId : runtimeIds) {
         VarInts.writeUnsignedLong(buffer, runtimeId);
      }
   }

   @Override
   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, AnimateEntityPacket packet) {
      packet.setAnimation(helper.readString(buffer));
      packet.setNextState(helper.readString(buffer));
      packet.setStopExpression(helper.readString(buffer));
      packet.setStopExpressionVersion(buffer.readInt());
      packet.setController(helper.readString(buffer));
      packet.setBlendOutTime(buffer.readFloatLE());
      LongList runtimeIds = packet.getRuntimeEntityIds();
      int count = VarInts.readUnsignedInt(buffer);

      for (int i = 0; i < count; i++) {
         runtimeIds.add(VarInts.readUnsignedLong(buffer));
      }
   }

   protected AnimateEntitySerializer_v465() {
   }
}
