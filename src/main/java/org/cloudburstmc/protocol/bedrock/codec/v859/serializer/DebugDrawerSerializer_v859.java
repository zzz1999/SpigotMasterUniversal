package org.cloudburstmc.protocol.bedrock.codec.v859.serializer;

import io.netty.buffer.ByteBuf;
import java.awt.Color;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.v818.serializer.DebugDrawerSerializer_v818;
import org.cloudburstmc.protocol.bedrock.data.debugshape.DebugArrow;
import org.cloudburstmc.protocol.bedrock.data.debugshape.DebugBox;
import org.cloudburstmc.protocol.bedrock.data.debugshape.DebugCircle;
import org.cloudburstmc.protocol.bedrock.data.debugshape.DebugLine;
import org.cloudburstmc.protocol.bedrock.data.debugshape.DebugShape;
import org.cloudburstmc.protocol.bedrock.data.debugshape.DebugSphere;
import org.cloudburstmc.protocol.bedrock.data.debugshape.DebugText;
import org.cloudburstmc.protocol.common.util.VarInts;

public class DebugDrawerSerializer_v859 extends DebugDrawerSerializer_v818 {
   public static final DebugDrawerSerializer_v859 INSTANCE = new DebugDrawerSerializer_v859();

   protected int toPayloadType(DebugShape.Type type) {
      if (type == null) {
         return 0;
      }

      switch (type) {
         case ARROW:
            return 1;
         case TEXT:
            return 2;
         case BOX:
            return 3;
         case LINE:
            return 4;
         case SPHERE:
         case CIRCLE:
            return 5;
         default:
            throw new IllegalStateException("Unknown debug shape type");
      }
   }

   @Override
   protected void writeShape(ByteBuf buffer, BedrockCodecHelper helper, DebugShape shape) {
      VarInts.writeUnsignedLong(buffer, shape.getId());
      this.writeCommonShapeData(buffer, helper, shape);
      VarInts.writeInt(buffer, shape.getDimension());
      VarInts.writeUnsignedInt(buffer, this.toPayloadType(shape.getType()));
      switch (shape.getType()) {
         case ARROW:
            DebugArrow arrow = (DebugArrow)shape;
            helper.writeOptionalNull(buffer, arrow.getArrowEndPosition(), WRITE_VECTOR3F);
            helper.writeOptionalNull(buffer, arrow.getArrowHeadLength(), ByteBuf::writeFloatLE);
            helper.writeOptionalNull(buffer, arrow.getArrowHeadRadius(), ByteBuf::writeFloatLE);
            helper.writeOptionalNull(buffer, arrow.getArrowHeadSegments(), ByteBuf::writeByte);
            break;
         case TEXT:
            DebugText text = (DebugText)shape;
            helper.writeString(buffer, text.getText());
            break;
         case BOX:
            DebugBox box = (DebugBox)shape;
            helper.writeVector3f(buffer, box.getBoxBounds());
            break;
         case LINE:
            DebugLine line = (DebugLine)shape;
            helper.writeVector3f(buffer, line.getLineEndPosition());
            break;
         case SPHERE:
            DebugSphere sphere = (DebugSphere)shape;
            buffer.writeByte(sphere.getSegments());
            break;
         case CIRCLE:
            DebugCircle circle = (DebugCircle)shape;
            buffer.writeByte(circle.getSegments());
      }
   }

   @Override
   protected DebugShape readShape(ByteBuf buffer, BedrockCodecHelper helper) {
      long id = VarInts.readUnsignedLong(buffer);
      DebugShape.Type type = helper.readOptional(buffer, null, (buf, aHelper) -> SHAPE_TYPES[buf.readUnsignedByte()]);
      Vector3f position = helper.readOptional(buffer, null, READ_VECTOR3F);
      Float scale = helper.readOptional(buffer, null, ByteBuf::readFloatLE);
      Vector3f rotation = helper.readOptional(buffer, null, READ_VECTOR3F);
      Float totalTimeLeft = helper.readOptional(buffer, null, ByteBuf::readFloatLE);
      Color color = helper.readOptional(buffer, null, READ_COLOR);
      int dimension = VarInts.readInt(buffer);
      int payloadType = VarInts.readUnsignedInt(buffer);
      if (type == null) {
         return new DebugShape(id, dimension);
      }

      switch (type) {
         case ARROW:
            Vector3f arrowEndPosition = helper.readOptional(buffer, null, READ_VECTOR3F);
            Float arrowHeadLength = helper.readOptional(buffer, null, ByteBuf::readFloatLE);
            Float arrowHeadRadius = helper.readOptional(buffer, null, ByteBuf::readFloatLE);
            Integer arrowHeadSegments = helper.readOptional(buffer, null, buf -> Integer.valueOf(buf.readUnsignedByte()));
            return new DebugArrow(
               id, dimension, position, scale, rotation, totalTimeLeft, color, arrowEndPosition, arrowHeadLength, arrowHeadRadius, arrowHeadSegments
            );
         case TEXT:
            String text = helper.readString(buffer);
            return new DebugText(id, dimension, position, scale, rotation, totalTimeLeft, color, text);
         case BOX:
            Vector3f boxBounds = helper.readVector3f(buffer);
            return new DebugBox(id, dimension, position, scale, rotation, totalTimeLeft, color, boxBounds);
         case LINE:
            Vector3f lineEndPosition = helper.readVector3f(buffer);
            return new DebugLine(id, dimension, position, scale, rotation, totalTimeLeft, color, lineEndPosition);
         case SPHERE:
            Integer sphereSegments = Integer.valueOf(buffer.readUnsignedByte());
            return new DebugSphere(id, dimension, position, scale, rotation, totalTimeLeft, color, sphereSegments);
         case CIRCLE:
            Integer circleSegments = Integer.valueOf(buffer.readUnsignedByte());
            return new DebugCircle(id, dimension, position, scale, rotation, totalTimeLeft, color, circleSegments);
         default:
            throw new IllegalStateException("Unknown debug shape type");
      }
   }
}
