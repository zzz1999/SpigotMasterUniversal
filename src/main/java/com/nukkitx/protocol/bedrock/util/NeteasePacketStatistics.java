package com.nukkitx.protocol.bedrock.util;

import java.util.HashMap;
import java.util.Map;

public class NeteasePacketStatistics {
   private Map<String, NeteasePacketStatistics.StatisticsNode> packetStatistics = new HashMap<>();
   private Map<Long, Map<String, NeteasePacketStatistics.StatisticsNode>> userPacketStatistics = new HashMap<>();

   public void addSendStatistics(String packetName, int packetSize, long userId) {
      NeteasePacketStatistics.StatisticsNode staticNode = this.packetStatistics.computeIfAbsent(packetName, k -> new NeteasePacketStatistics.StatisticsNode());
      staticNode.setNum(staticNode.getNum() + 1L);
      staticNode.setSize(staticNode.getSize() + packetSize);
      Map<String, NeteasePacketStatistics.StatisticsNode> userPacketStatic = this.userPacketStatistics.computeIfAbsent(userId, k -> new HashMap<>());
      NeteasePacketStatistics.StatisticsNode userStaticNode = userPacketStatic.computeIfAbsent(packetName, k -> new NeteasePacketStatistics.StatisticsNode());
      userStaticNode.setNum(userStaticNode.getNum() + 1L);
      userStaticNode.setSize(userStaticNode.getSize() + packetSize);
   }

   private class StatisticsNode {
      private long num = 0L;
      private long size = 0L;

      public StatisticsNode() {
      }

      public long getNum() {
         return this.num;
      }

      public long getSize() {
         return this.size;
      }

      public void setNum(long num) {
         this.num = num;
      }

      public void setSize(long size) {
         this.size = size;
      }

      @Override
      public boolean equals(Object o) {
         if (o == this) {
            return true;
         } else if (!(o instanceof NeteasePacketStatistics.StatisticsNode)) {
            return false;
         } else {
            NeteasePacketStatistics.StatisticsNode other = (NeteasePacketStatistics.StatisticsNode)o;
            if (!other.canEqual(this)) {
               return false;
            } else {
               return this.getNum() != other.getNum() ? false : this.getSize() == other.getSize();
            }
         }
      }

      protected boolean canEqual(Object other) {
         return other instanceof NeteasePacketStatistics.StatisticsNode;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         long $num = this.getNum();
         result = result * 59 + (int)($num >>> 32 ^ $num);
         long $size = this.getSize();
         return result * 59 + (int)($size >>> 32 ^ $size);
      }

      @Override
      public String toString() {
         return "NeteasePacketStatistics.StatisticsNode(num=" + this.getNum() + ", size=" + this.getSize() + ")";
      }
   }
}
