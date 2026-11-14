package org.cloudburstmc.protocol.bedrock.codec.v291.serializer;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ToIntFunction;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.data.command.CommandData;
import org.cloudburstmc.protocol.bedrock.data.command.CommandEnumConstraint;
import org.cloudburstmc.protocol.bedrock.data.command.CommandEnumData;
import org.cloudburstmc.protocol.bedrock.data.command.CommandOverloadData;
import org.cloudburstmc.protocol.bedrock.data.command.CommandParam;
import org.cloudburstmc.protocol.bedrock.data.command.CommandParamData;
import org.cloudburstmc.protocol.bedrock.data.command.CommandParamOption;
import org.cloudburstmc.protocol.bedrock.data.command.CommandPermission;
import org.cloudburstmc.protocol.bedrock.packet.AvailableCommandsPacket;
import org.cloudburstmc.protocol.common.util.Preconditions;
import org.cloudburstmc.protocol.common.util.SequencedHashSet;
import org.cloudburstmc.protocol.common.util.TypeMap;
import org.cloudburstmc.protocol.common.util.VarInts;

public class AvailableCommandsSerializer_v291 implements BedrockPacketSerializer<AvailableCommandsPacket> {
   protected static final InternalLogger log = InternalLoggerFactory.getInstance(AvailableCommandsSerializer_v291.class);
   protected static final CommandPermission[] PERMISSIONS = CommandPermission.values();
   protected static final int ARG_FLAG_VALID = 1048576;
   protected static final int ARG_FLAG_ENUM = 2097152;
   protected static final int ARG_FLAG_POSTFIX = 16777216;
   protected static final int ARG_FLAG_SOFT_ENUM = 67108864;
   protected static final ToIntFunction<ByteBuf> READ_BYTE = ByteBuf::readUnsignedByte;
   protected static final ToIntFunction<ByteBuf> READ_SHORT = ByteBuf::readUnsignedShortLE;
   protected static final ToIntFunction<ByteBuf> READ_INT = ByteBuf::readIntLE;
   protected static final ObjIntConsumer<ByteBuf> WRITE_BYTE = ByteBuf::writeByte;
   protected static final ObjIntConsumer<ByteBuf> WRITE_SHORT = ByteBuf::writeShortLE;
   protected static final ObjIntConsumer<ByteBuf> WRITE_INT = ByteBuf::writeIntLE;
   protected static final CommandData.Flag[] FLAGS = CommandData.Flag.values();
   protected static final CommandParamOption[] OPTIONS = CommandParamOption.values();
   protected final TypeMap<CommandParam> paramTypeMap;

   public void serialize(ByteBuf buffer, BedrockCodecHelper helper, AvailableCommandsPacket packet) {
      SequencedHashSet<String> enumValues = new SequencedHashSet<>();
      SequencedHashSet<String> postFixes = new SequencedHashSet<>();
      SequencedHashSet<CommandEnumData> enums = new SequencedHashSet<>();
      SequencedHashSet<CommandEnumData> softEnums = new SequencedHashSet<>();

      for (CommandData data : packet.getCommands()) {
         if (data.getAliases() != null) {
            enumValues.addAll(data.getAliases().getValues().keySet());
            enums.add(data.getAliases());
         }

         for (CommandOverloadData overload : data.getOverloads()) {
            for (CommandParamData parameter : overload.getOverloads()) {
               CommandEnumData commandEnumData = parameter.getEnumData();
               if (commandEnumData != null) {
                  if (commandEnumData.isSoft()) {
                     softEnums.add(commandEnumData);
                  } else {
                     enumValues.addAll(commandEnumData.getValues().keySet());
                     enums.add(commandEnumData);
                  }
               }

               String postfix = parameter.getPostfix();
               if (postfix != null) {
                  postFixes.add(postfix);
               }
            }
         }
      }

      helper.writeArray(buffer, enumValues, helper::writeString);
      helper.writeArray(buffer, postFixes, helper::writeString);
      this.writeEnums(buffer, helper, enumValues, enums);
      helper.writeArray(buffer, packet.getCommands(), (buf, command) -> this.writeCommand(buffer, helper, command, enums, softEnums, postFixes));
      helper.writeArray(buffer, softEnums, helper::writeCommandEnum);
   }

   public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, AvailableCommandsPacket packet) {
      SequencedHashSet<String> enumValues = new SequencedHashSet<>();
      SequencedHashSet<String> postFixes = new SequencedHashSet<>();
      SequencedHashSet<CommandEnumData> enums = new SequencedHashSet<>();
      SequencedHashSet<CommandEnumData> softEnums = new SequencedHashSet<>();
      Set<Consumer<List<CommandEnumData>>> softEnumParameters = new HashSet<>();
      helper.readArray(buffer, enumValues, helper::readString);
      helper.readArray(buffer, postFixes, helper::readString);
      this.readEnums(buffer, helper, enumValues, enums);
      helper.readArray(buffer, packet.getCommands(), (buf, aHelper) -> this.readCommand(buf, aHelper, enums, postFixes, softEnumParameters));
      helper.readArray(buffer, softEnums, buf -> helper.readCommandEnum(buffer, true));
      softEnumParameters.forEach(consumer -> consumer.accept(softEnums));
   }

   protected void writeEnums(ByteBuf buffer, BedrockCodecHelper helper, List<String> values, List<CommandEnumData> enums) {
      int valuesSize = values.size();
      ObjIntConsumer<ByteBuf> indexWriter;
      if (valuesSize <= 256) {
         indexWriter = WRITE_BYTE;
      } else if (valuesSize <= 65536) {
         indexWriter = WRITE_SHORT;
      } else {
         indexWriter = WRITE_INT;
      }

      helper.writeArray(buffer, enums, (buf, commandEnum) -> {
         helper.writeString(buf, commandEnum.getName());
         VarInts.writeUnsignedInt(buffer, commandEnum.getValues().size());

         for (String value : commandEnum.getValues().keySet()) {
            int index = values.indexOf(value);
            Preconditions.checkArgument(index > -1, "Invalid enum value detected: " + value);
            indexWriter.accept(buf, index);
         }
      });
   }

   protected void readEnums(ByteBuf buffer, BedrockCodecHelper helper, List<String> values, List<CommandEnumData> enums) {
      int valuesSize = values.size();
      ToIntFunction<ByteBuf> indexReader;
      if (valuesSize <= 256) {
         indexReader = READ_BYTE;
      } else if (valuesSize <= 65536) {
         indexReader = READ_SHORT;
      } else {
         indexReader = READ_INT;
      }

      helper.readArray(buffer, enums, buf -> {
         String name = helper.readString(buf);
         int length = VarInts.readUnsignedInt(buffer);
         LinkedHashMap<String, Set<CommandEnumConstraint>> enumValues = new LinkedHashMap<>();

         for (int i = 0; i < length; i++) {
            enumValues.put(values.get(indexReader.applyAsInt(buf)), EnumSet.noneOf(CommandEnumConstraint.class));
         }

         return new CommandEnumData(name, enumValues, false);
      });
   }

   protected void writeCommand(
      ByteBuf buffer, BedrockCodecHelper helper, CommandData commandData, List<CommandEnumData> enums, List<CommandEnumData> softEnums, List<String> postFixes
   ) {
      helper.writeString(buffer, commandData.getName());
      helper.writeString(buffer, commandData.getDescription());
      this.writeFlags(buffer, commandData.getFlags());
      CommandPermission permission = commandData.getPermission() == null ? CommandPermission.ANY : commandData.getPermission();
      buffer.writeByte(permission.ordinal());
      CommandEnumData aliases = commandData.getAliases();
      buffer.writeIntLE(aliases == null ? -1 : enums.indexOf(aliases));
      CommandOverloadData[] overloads = commandData.getOverloads();
      VarInts.writeUnsignedInt(buffer, overloads.length);

      for (CommandOverloadData overload : overloads) {
         VarInts.writeUnsignedInt(buffer, overload.getOverloads().length);

         for (CommandParamData param : overload.getOverloads()) {
            this.writeParameter(buffer, helper, param, enums, softEnums, postFixes);
         }
      }
   }

   protected CommandData readCommand(
      ByteBuf buffer, BedrockCodecHelper helper, List<CommandEnumData> enums, List<String> postfixes, Set<Consumer<List<CommandEnumData>>> softEnumParameters
   ) {
      String name = helper.readString(buffer);
      String description = helper.readString(buffer);
      Set<CommandData.Flag> flags = this.readFlags(buffer);
      CommandPermission permissions = PERMISSIONS[buffer.readUnsignedByte()];
      int aliasIndex = buffer.readIntLE();
      CommandEnumData aliases = aliasIndex == -1 ? null : enums.get(aliasIndex);
      CommandOverloadData[] overloads = new CommandOverloadData[VarInts.readUnsignedInt(buffer)];

      for (int i = 0; i < overloads.length; i++) {
         overloads[i] = new CommandOverloadData(false, new CommandParamData[VarInts.readUnsignedInt(buffer)]);

         for (int i2 = 0; i2 < overloads[i].getOverloads().length; i2++) {
            overloads[i].getOverloads()[i2] = this.readParameter(buffer, helper, enums, postfixes, softEnumParameters);
         }
      }

      return new CommandData(name, description, flags, permissions, aliases, Collections.emptyList(), overloads);
   }

   protected void writeFlags(ByteBuf buffer, Set<CommandData.Flag> flags) {
      int flagBits = 0;

      for (CommandData.Flag flag : flags) {
         flagBits |= 1 << flag.ordinal();
      }

      buffer.writeByte(flagBits);
   }

   protected Set<CommandData.Flag> readFlags(ByteBuf buffer) {
      int flagBits = buffer.readUnsignedByte();
      EnumSet<CommandData.Flag> flags = EnumSet.noneOf(CommandData.Flag.class);

      for (CommandData.Flag flag : CommandData.Flag.values()) {
         if ((flagBits & 1 << flag.ordinal()) != 0) {
            flags.add(flag);
         }

         flagBits |= 1 << flag.ordinal();
      }

      return flags;
   }

   protected void writeParameter(
      ByteBuf buffer, BedrockCodecHelper helper, CommandParamData param, List<CommandEnumData> enums, List<CommandEnumData> softEnums, List<String> postfixes
   ) {
      helper.writeString(buffer, param.getName());
      int symbol;
      if (param.getPostfix() != null) {
         symbol = postfixes.indexOf(param.getPostfix()) | 16777216;
      } else if (param.getEnumData() != null) {
         if (param.getEnumData().isSoft()) {
            symbol = softEnums.indexOf(param.getEnumData()) | 67108864 | 1048576;
         } else {
            symbol = enums.indexOf(param.getEnumData()) | 2097152 | 1048576;
         }
      } else {
         if (param.getType() == null) {
            throw new IllegalStateException("No param type specified: " + param);
         }

         symbol = this.paramTypeMap.getId(param.getType()) | 1048576;
      }

      buffer.writeIntLE(symbol);
      buffer.writeBoolean(param.isOptional());
   }

   protected CommandParamData readParameter(
      ByteBuf buffer, BedrockCodecHelper helper, List<CommandEnumData> enums, List<String> postfixes, Set<Consumer<List<CommandEnumData>>> softEnumParameters
   ) {
      CommandParamData param = new CommandParamData();
      param.setName(helper.readString(buffer));
      int symbol = buffer.readIntLE();
      if ((symbol & 16777216) != 0) {
         param.setPostfix(postfixes.get(symbol & -16777217));
      } else {
         if ((symbol & 1048576) == 0) {
            throw new IllegalStateException("No param type specified: " + param.getName());
         }

         if ((symbol & 67108864) != 0) {
            softEnumParameters.add(softEnums -> param.setEnumData(softEnums.get(symbol & -68157441)));
         } else if ((symbol & 2097152) != 0) {
            param.setEnumData(enums.get(symbol & -3145729));
         } else {
            int parameterTypeId = symbol & -1048577;
            CommandParam type = this.paramTypeMap.getTypeUnsafe(parameterTypeId);
            if (type == null) {
               throw new IllegalStateException("Invalid parameter type: " + parameterTypeId + ", Symbol: " + symbol);
            }

            param.setType(type);
         }
      }

      param.setOptional(buffer.readBoolean());
      return param;
   }

   public AvailableCommandsSerializer_v291(final TypeMap<CommandParam> paramTypeMap) {
      this.paramTypeMap = paramTypeMap;
   }
}
