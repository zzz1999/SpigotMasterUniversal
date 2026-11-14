package com.nukkitx.protocol.bedrock.data.command;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class CommandData {
   private final String name;
   private final String description;
   private final Set<CommandData.Flag> flags;
   private final CommandPermission permission;
   private final CommandEnumData aliases;
   private final List<ChainedSubCommandData> subcommands;
   private final CommandOverloadData[] overloads;

   @Override
   public String toString() {
      StringBuilder overloads = new StringBuilder("[\r\n");

      for (CommandOverloadData overload : this.overloads) {
         overloads.append("    [\r\n");
         overloads.append("       chaining=").append(overload.isChaining()).append("\r\n");

         for (CommandParamData parameter : overload.getOverloads()) {
            overloads.append("       ").append(parameter).append("\r\n");
         }

         overloads.append("    ]\r\n");
      }

      overloads.append("]\r\n");
      StringBuilder builder = new StringBuilder("CommandData(\r\n");

      for (Object object : Arrays.asList(
         "name=" + this.name,
         "description=" + this.description,
         "flags=" + Arrays.toString(this.flags.toArray()),
         "permission=" + this.permission,
         "aliases=" + this.aliases,
         "subcommands=" + Arrays.toString(this.subcommands.toArray()),
         "overloads=" + overloads
      )) {
         builder.append("    ").append(Objects.toString(object).replaceAll("\r\n", "\r\n    ")).append("\r\n");
      }

      return builder.append(")").toString();
   }

   public CommandData(
      String name,
      String description,
      Set<CommandData.Flag> flags,
      CommandPermission permission,
      CommandEnumData aliases,
      List<ChainedSubCommandData> subcommands,
      CommandOverloadData[] overloads
   ) {
      this.name = name;
      this.description = description;
      this.flags = flags;
      this.permission = permission;
      this.aliases = aliases;
      this.subcommands = subcommands;
      this.overloads = overloads;
   }

   public String getName() {
      return this.name;
   }

   public String getDescription() {
      return this.description;
   }

   public Set<CommandData.Flag> getFlags() {
      return this.flags;
   }

   public CommandPermission getPermission() {
      return this.permission;
   }

   public CommandEnumData getAliases() {
      return this.aliases;
   }

   public List<ChainedSubCommandData> getSubcommands() {
      return this.subcommands;
   }

   public CommandOverloadData[] getOverloads() {
      return this.overloads;
   }

   @Override
   public boolean equals(Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CommandData)) {
         return false;
      }

      CommandData other = (CommandData)o;
      Object this$name = this.getName();
      Object other$name = other.getName();
      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
         Object this$description = this.getDescription();
         Object other$description = other.getDescription();
         if (this$description == null ? other$description == null : this$description.equals(other$description)) {
            Object this$flags = this.getFlags();
            Object other$flags = other.getFlags();
            if (this$flags == null ? other$flags == null : this$flags.equals(other$flags)) {
               Object this$permission = this.getPermission();
               Object other$permission = other.getPermission();
               if (this$permission == null ? other$permission == null : this$permission.equals(other$permission)) {
                  Object this$aliases = this.getAliases();
                  Object other$aliases = other.getAliases();
                  if (this$aliases == null ? other$aliases == null : this$aliases.equals(other$aliases)) {
                     Object this$subcommands = this.getSubcommands();
                     Object other$subcommands = other.getSubcommands();
                     return (this$subcommands == null ? other$subcommands == null : this$subcommands.equals(other$subcommands))
                        ? Arrays.deepEquals(this.getOverloads(), other.getOverloads())
                        : false;
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
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
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $description = this.getDescription();
      result = result * 59 + ($description == null ? 43 : $description.hashCode());
      Object $flags = this.getFlags();
      result = result * 59 + ($flags == null ? 43 : $flags.hashCode());
      Object $permission = this.getPermission();
      result = result * 59 + ($permission == null ? 43 : $permission.hashCode());
      Object $aliases = this.getAliases();
      result = result * 59 + ($aliases == null ? 43 : $aliases.hashCode());
      Object $subcommands = this.getSubcommands();
      result = result * 59 + ($subcommands == null ? 43 : $subcommands.hashCode());
      return result * 59 + Arrays.deepHashCode(this.getOverloads());
   }

   public enum Flag {
      TEST_USAGE,
      HIDDEN_FROM_COMMAND_BLOCK,
      HIDDEN_FROM_PLAYER,
      HIDDEN_FROM_AUTOMATION,
      LOCAL_SYNC,
      EXECUTE_DISALLOWED,
      MESSAGE_TYPE,
      NOT_CHEAT,
      ASYNC;
   }
}
