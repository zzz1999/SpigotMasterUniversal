package org.cloudburstmc.protocol.bedrock.codec.v776.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.data.camera.AimAssistAction;
import org.cloudburstmc.protocol.bedrock.packet.CameraAimAssistInstructionPacket;

public class CameraAimAssistInstructionSerializer_v776 implements BedrockPacketSerializer<CameraAimAssistInstructionPacket> {
   public static final CameraAimAssistInstructionSerializer_v776 INSTANCE = new CameraAimAssistInstructionSerializer_v776();
   protected static final AimAssistAction[] ACTIONS = AimAssistAction.values();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, CameraAimAssistInstructionPacket packet) {
      helper.writeString(buffer, packet.getPresetId());
      buffer.writeByte(packet.getAction().ordinal());
      buffer.writeBoolean(packet.isAllowAimAssist());
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, CameraAimAssistInstructionPacket packet) {
      packet.setPresetId(helper.readString(buffer));
      packet.setAction(ACTIONS[buffer.readUnsignedByte()]);
      packet.setAllowAimAssist(buffer.readBoolean());
   }

   protected CameraAimAssistInstructionSerializer_v776() {
   }
}
