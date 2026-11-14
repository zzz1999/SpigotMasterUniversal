package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.BookEditPacket;
import org.cloudburstmc.protocol.common.util.Int2ObjectBiMap;
import org.cloudburstmc.protocol.common.util.TextConverter;

public class BookEditSerializer_v291 implements BedrockPacketSerializer<BookEditPacket> {
   public static final BookEditSerializer_v291 INSTANCE = new BookEditSerializer_v291();
   private static final Int2ObjectBiMap<BookEditPacket.Action> types = new Int2ObjectBiMap<>();

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, BookEditPacket packet) {
      buffer.writeByte(packet.getAction().ordinal());
      buffer.writeByte(packet.getInventorySlot());
      TextConverter converter = helper.getTextConverter();
      switch (packet.getAction()) {
         case REPLACE_PAGE:
         case ADD_PAGE:
            buffer.writeByte(packet.getPageNumber());
            helper.writeString(buffer, converter.serialize(packet.getText(CharSequence.class)));
            helper.writeString(buffer, packet.getPhotoName());
            break;
         case DELETE_PAGE:
            buffer.writeByte(packet.getPageNumber());
            break;
         case SWAP_PAGES:
            buffer.writeByte(packet.getPageNumber());
            buffer.writeByte(packet.getSecondaryPageNumber());
            break;
         case SIGN_BOOK:
            helper.writeString(buffer, converter.serialize(packet.getTitle(CharSequence.class)));
            helper.writeString(buffer, converter.serialize(packet.getAuthor(CharSequence.class)));
            helper.writeString(buffer, packet.getXuid());
      }
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, BookEditPacket packet) {
      packet.setAction(types.get(buffer.readUnsignedByte()));
      packet.setInventorySlot(buffer.readUnsignedByte());
      TextConverter converter = helper.getTextConverter();
      switch (packet.getAction()) {
         case REPLACE_PAGE:
         case ADD_PAGE:
            packet.setPageNumber(buffer.readUnsignedByte());
            packet.setText(converter.deserialize(helper.readString(buffer)));
            packet.setPhotoName(helper.readString(buffer));
            break;
         case DELETE_PAGE:
            packet.setPageNumber(buffer.readUnsignedByte());
            break;
         case SWAP_PAGES:
            packet.setPageNumber(buffer.readUnsignedByte());
            packet.setSecondaryPageNumber(buffer.readUnsignedByte());
            break;
         case SIGN_BOOK:
            packet.setTitle(converter.deserialize(helper.readString(buffer)));
            packet.setAuthor(converter.deserialize(helper.readString(buffer)));
            packet.setXuid(helper.readString(buffer));
      }
   }

   protected BookEditSerializer_v291() {
   }

   static {
      types.put(0, BookEditPacket.Action.REPLACE_PAGE);
      types.put(1, BookEditPacket.Action.ADD_PAGE);
      types.put(2, BookEditPacket.Action.DELETE_PAGE);
      types.put(3, BookEditPacket.Action.SWAP_PAGES);
      types.put(4, BookEditPacket.Action.SIGN_BOOK);
   }
}
