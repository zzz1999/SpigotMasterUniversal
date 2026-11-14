package com.neteasemc.spigotmaster.commandExecutor;

import com.neteasemc.spigotmaster.SpigotMaster;
import com.nukkitx.network.VarInts;
import com.nukkitx.protocol.bedrock.codec.v594.Bedrock_v594;
import com.nukkitx.protocol.bedrock.packet.SetTimePacket;
import com.nukkitx.protocol.bedrock.packet.TextPacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class CommandTestSendBedrockpacket implements CommandExecutor {
   int taskId = -1;

   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (sender instanceof Player && args.length > 0) {
         if (args[0].equals("start")) {
            final SpigotMaster spigotMaster = (SpigotMaster)Bukkit.getPluginManager().getPlugin("SpigotMaster");
            TextPacket textPacket = new TextPacket();
            textPacket.setMessage("时间要开始加速了！！！！");
            textPacket.setNeedsTranslation(false);
            textPacket.setType(TextPacket.Type.CHAT);
            textPacket.setXuid("");
            textPacket.setSourceName("!!!!");
            textPacket.setPlatformChatId("");
            textPacket.setParameters(new ArrayList<>());
            int textPacketId = Bedrock_v594.CODEC.getPacketDefinition(textPacket.getClass()).getId();
            ByteBuf txtByteBuf = ByteBufAllocator.DEFAULT.heapBuffer(2024);
            Bedrock_v594.CODEC.tryEncode(Bedrock_v594.CODEC.createHelper(), txtByteBuf, textPacket, null);
            VarInts.writeUnsignedInt(txtByteBuf, 0);
            int txtDataLen = txtByteBuf.readableBytes();
            byte[] txtData = new byte[txtDataLen];
            txtByteBuf.readBytes(txtData, 0, txtDataLen);
            txtByteBuf.release();
            spigotMaster.sendBedrockPacket(textPacketId, txtData);
            final BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            this.taskId = scheduler.scheduleSyncRepeatingTask(spigotMaster, new Runnable() {
               @Override
               public void run() {
                  final SetTimePacket timePacket = new SetTimePacket();
                  timePacket.setTime(1000);
                  final int setTimePacketId = Bedrock_v594.CODEC.getPacketDefinition(timePacket.getClass()).getId();
                  ByteBuf setTimeByteBuf = ByteBufAllocator.DEFAULT.heapBuffer(2024);
                  Bedrock_v594.CODEC.tryEncode(Bedrock_v594.CODEC.createHelper(), setTimeByteBuf, timePacket, null);
                  int setTimeDataLen = setTimeByteBuf.readableBytes();
                  byte[] setTimeData = new byte[setTimeDataLen];
                  setTimeByteBuf.readBytes(setTimeData, 0, setTimeDataLen);
                  setTimeByteBuf.release();
                  spigotMaster.sendBedrockPacket(setTimePacketId, setTimeData);
                  scheduler.scheduleSyncDelayedTask(spigotMaster, new Runnable() {
                     @Override
                     public void run() {
                        ByteBuf setTimeByteBuf = ByteBufAllocator.DEFAULT.heapBuffer(2024);
                        timePacket.setTime(13000);
                        setTimeByteBuf = ByteBufAllocator.DEFAULT.heapBuffer(2024);
                        Bedrock_v594.CODEC.tryEncode(Bedrock_v594.CODEC.createHelper(), setTimeByteBuf, timePacket, null);
                        int setTimeDataLen = setTimeByteBuf.readableBytes();
                        byte[] setTimeData = new byte[setTimeDataLen];
                        setTimeByteBuf.readBytes(setTimeData, 0, setTimeDataLen);
                        setTimeByteBuf.release();
                        spigotMaster.sendBedrockPacket(setTimePacketId, setTimeData);
                     }
                  }, 10L);
                  scheduler.scheduleSyncDelayedTask(spigotMaster, new Runnable() {
                     @Override
                     public void run() {
                        ByteBuf setTimeByteBuf = ByteBufAllocator.DEFAULT.heapBuffer(2024);
                        timePacket.setTime(20000);
                        setTimeByteBuf = ByteBufAllocator.DEFAULT.heapBuffer(2024);
                        Bedrock_v594.CODEC.tryEncode(Bedrock_v594.CODEC.createHelper(), setTimeByteBuf, timePacket, null);
                        int setTimeDataLen = setTimeByteBuf.readableBytes();
                        byte[] setTimeData = new byte[setTimeDataLen];
                        setTimeByteBuf.readBytes(setTimeData, 0, setTimeDataLen);
                        setTimeByteBuf.release();
                        spigotMaster.sendBedrockPacket(setTimePacketId, setTimeData);
                     }
                  }, 25L);
               }
            }, 0L, 50L);
         } else {
            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            scheduler.cancelTask(this.taskId);
         }
      }

      return true;
   }
}
