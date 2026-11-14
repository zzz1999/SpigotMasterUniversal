package org.cloudburstmc.netty.channel.raknet;

import org.cloudburstmc.netty.channel.raknet.packet.RakDatagramPacket;

public class RakSlidingWindow {
   private final int mtu;
   private double cwnd;
   private double ssThresh;
   private double estimatedRTT = -1.0;
   private double lastRTT = -1.0;
   private double deviationRTT = -1.0;
   private long oldestUnsentAck;
   private long nextCongestionControlBlock;
   private boolean backoffThisBlock;
   private int unackedBytes;

   public RakSlidingWindow(int mtu) {
      this.mtu = mtu;
      this.cwnd = mtu;
   }

   public int getRetransmissionBandwidth() {
      return this.unackedBytes;
   }

   public int getTransmissionBandwidth() {
      return this.unackedBytes <= this.cwnd ? (int)(this.cwnd - this.unackedBytes) : 0;
   }

   public void onPacketReceived(long curTime) {
      if (this.oldestUnsentAck == 0L) {
         this.oldestUnsentAck = curTime;
      }
   }

   public void onResend(long curSequenceIndex) {
      if (!this.backoffThisBlock && this.cwnd > this.mtu * 2.0) {
         this.ssThresh = this.cwnd * 0.5;
         if (this.ssThresh < this.mtu) {
            this.ssThresh = this.mtu;
         }

         this.cwnd = this.mtu;
         this.nextCongestionControlBlock = curSequenceIndex;
         this.backoffThisBlock = true;
      }
   }

   public void onNak() {
      if (!this.backoffThisBlock) {
         this.ssThresh = this.cwnd * 0.75;
      }
   }

   public void onAck(long curTime, RakDatagramPacket datagram, long curSequenceIndex) {
      long rtt = curTime - datagram.getSendTime();
      this.lastRTT = rtt;
      this.unackedBytes = this.unackedBytes - datagram.getSize();
      if (this.estimatedRTT == -1.0) {
         this.estimatedRTT = rtt;
         this.deviationRTT = rtt;
      } else {
         double d = 0.05;
         double difference = rtt - this.estimatedRTT;
         this.estimatedRTT += d * difference;
         this.deviationRTT = this.deviationRTT + d * (Math.abs(difference) - this.deviationRTT);
      }

      boolean isNewCongestionControlPeriod = datagram.getSequenceIndex() > this.nextCongestionControlBlock;
      if (isNewCongestionControlPeriod) {
         this.backoffThisBlock = false;
         this.nextCongestionControlBlock = curSequenceIndex;
      }

      if (this.isInSlowStart()) {
         this.cwnd = this.cwnd + this.mtu;
         if (this.cwnd > this.ssThresh && this.ssThresh != 0.0) {
            this.cwnd = this.ssThresh + this.mtu * this.mtu / this.cwnd;
         }
      } else if (isNewCongestionControlPeriod) {
         this.cwnd = this.cwnd + this.mtu * this.mtu / this.cwnd;
      }
   }

   public void onReliableSend(RakDatagramPacket datagram) {
      this.unackedBytes = this.unackedBytes + datagram.getSize();
   }

   public boolean isInSlowStart() {
      return this.cwnd <= this.ssThresh || this.ssThresh == 0.0;
   }

   public void onSendAck() {
      this.oldestUnsentAck = 0L;
   }

   public long getRtoForRetransmission() {
      if (this.estimatedRTT == -1.0) {
         return 2000L;
      }

      long threshold = (long)(2.0 * this.estimatedRTT + 4.0 * this.deviationRTT + 30.0);
      return threshold > 2000L ? 2000L : threshold;
   }

   public double getRTT() {
      return this.estimatedRTT;
   }

   public boolean shouldSendAcks(long curTime) {
      long rto = this.getSenderRtoForAck();
      return rto == -1L || curTime >= this.oldestUnsentAck + 10L;
   }

   public long getSenderRtoForAck() {
      return this.lastRTT == -1.0 ? -1L : (long)(this.lastRTT + 10.0);
   }

   public int getUnackedBytes() {
      return this.unackedBytes;
   }
}
