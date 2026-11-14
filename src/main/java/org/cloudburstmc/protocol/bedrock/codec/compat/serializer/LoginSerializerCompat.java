package org.cloudburstmc.protocol.bedrock.codec.compat.serializer;

import io.netty.buffer.ByteBuf;
import io.netty.util.AsciiString;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.data.auth.CertificateChainPayload;
import org.cloudburstmc.protocol.bedrock.packet.LoginPacket;
import org.cloudburstmc.protocol.common.util.Preconditions;
import org.cloudburstmc.protocol.common.util.VarInts;
import org.jose4j.json.internal.json_simple.JSONArray;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.jose4j.json.internal.json_simple.JSONValue;

public class LoginSerializerCompat implements BedrockPacketSerializer<LoginPacket> {
   public static final LoginSerializerCompat INSTANCE = new LoginSerializerCompat();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, LoginPacket packet) {
      throw new UnsupportedOperationException();
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, LoginPacket packet) {
      packet.setProtocolVersion(buffer.readInt());
      ByteBuf jwt = buffer.readSlice(VarInts.readUnsignedInt(buffer));
      Object json = JSONValue.parse(this.readString(jwt).toString());
      Preconditions.checkArgument(json instanceof JSONObject && ((JSONObject)json).containsKey("chain"), "Invalid login chain");
      Object chain = ((JSONObject)json).get("chain");
      Preconditions.checkArgument(chain instanceof JSONArray, "Expected JSON array for login chain");
      List<String> chainList = new ObjectArrayList<>(3);

      for (Object node : (JSONArray)chain) {
         Preconditions.checkArgument(node instanceof String, "Expected String in login chain");
         chainList.add((String)node);
      }

      packet.setAuthPayload(new CertificateChainPayload(chainList));
      String value = (String)jwt.readCharSequence(jwt.readIntLE(), StandardCharsets.UTF_8);
      packet.setClientJwt(value);
   }

   protected AsciiString readString(ByteBuf buffer) {
      return (AsciiString)buffer.readCharSequence(buffer.readIntLE(), StandardCharsets.US_ASCII);
   }

   private LoginSerializerCompat() {
   }
}
