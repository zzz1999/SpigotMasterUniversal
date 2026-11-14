package org.cloudburstmc.protocol.bedrock.codec.v649.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.v419.serializer.CorrectPlayerMovePredictionSerializer_v419;
import org.cloudburstmc.protocol.bedrock.data.PredictionType;
import org.cloudburstmc.protocol.bedrock.packet.CorrectPlayerMovePredictionPacket;

public class CorrectPlayerMovePredictionSerializer_v649 extends CorrectPlayerMovePredictionSerializer_v419 {
   private static final PredictionType[] PREDICTION_TYPES = PredictionType.values();
   public static final CorrectPlayerMovePredictionSerializer_v649 INSTANCE = new CorrectPlayerMovePredictionSerializer_v649();

   @Override
   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, CorrectPlayerMovePredictionPacket packet) {
      super.serialize(buffer, helper, packet);
      buffer.writeByte(packet.getPredictionType().ordinal());
   }

   @Override
   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, CorrectPlayerMovePredictionPacket packet) {
      super.deserialize(buffer, helper, packet);
      packet.setPredictionType(PREDICTION_TYPES[buffer.readUnsignedByte()]);
   }

   protected CorrectPlayerMovePredictionSerializer_v649() {
   }
}
