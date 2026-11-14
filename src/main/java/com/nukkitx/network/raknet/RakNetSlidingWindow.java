package com.nukkitx.network.raknet;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class RakNetSlidingWindow {
   private static final InternalLogger log = InternalLoggerFactory.getInstance(RakNetSession.class);
   private final int mtu;
   private final int adjustedMtu;
   private double cwnd;
   private double ssThresh;
   private double estimatedRTT = -1.0;
   private double lastRTT = -1.0;
   private double deviationRTT = -1.0;
   private long oldestUnsentAck;
   private long nextCongestionControlBlock;
   private boolean backoffThisBlock;
   private boolean isContinuousSend;
   private int expectedNextSequenceNumber;
   private int nextSequenceNumber;

   public RakNetSlidingWindow(int mtu, int adjustedMtu) {
      this.mtu = mtu;
      this.cwnd = mtu;
      this.adjustedMtu = adjustedMtu;
   }

   public int getRetransmissionBandwidth(int unAckedBytes, boolean isContinuousSend) {
      return unAckedBytes;
   }

   public int getTransmissionBandwidth(int unAckedBytes, boolean isContinuousSend) {
      this.isContinuousSend = isContinuousSend;
      return unAckedBytes <= this.cwnd ? (int)(this.cwnd - unAckedBytes) : 0;
   }

   public int onPacketReceived(long curTime, int sequenceNumber) {
      if (this.oldestUnsentAck == 0L) {
         this.oldestUnsentAck = curTime;
      }

      int skippedMessageCount = 0;
      if (sequenceNumber == this.expectedNextSequenceNumber) {
         this.expectedNextSequenceNumber = sequenceNumber + 1 & 16777215;
      } else if (sequenceNumber > this.expectedNextSequenceNumber || this.expectedNextSequenceNumber - sequenceNumber > 8388607) {
         skippedMessageCount = sequenceNumber - this.expectedNextSequenceNumber & 16777215;
         if (skippedMessageCount > 1000) {
            if (skippedMessageCount > 50000) {
               log.info("too many stale data:" + skippedMessageCount);
               return -1;
            }

            skippedMessageCount = 1000;
         }

         this.expectedNextSequenceNumber = sequenceNumber + 1 & 16777215;
      }

      return skippedMessageCount;
   }

   public void onResend(long nextActionTime) {
      if (this.isContinuousSend && !this.backoffThisBlock && this.cwnd > this.adjustedMtu * 2) {
         this.ssThresh = this.cwnd / 2.0;
         if (this.ssThresh < this.adjustedMtu) {
            this.ssThresh = this.adjustedMtu;
         }

         this.cwnd = this.adjustedMtu;
         this.nextCongestionControlBlock = this.nextSequenceNumber;
         this.backoffThisBlock = true;
      }
   }

   public void onNak() {
      if (this.isContinuousSend && !this.backoffThisBlock) {
         this.ssThresh = this.cwnd / 2.0;
         this.nextCongestionControlBlock = this.nextSequenceNumber;
         this.backoffThisBlock = true;
      }
   }

   public synchronized int getAndIncrementNextSequenceNumber() {
      int r = this.nextSequenceNumber;
      this.nextSequenceNumber = this.nextSequenceNumber + 1 & 16777215;
      return r;
   }

   public void onAck(long rtt, long sequenceIndex, boolean isContinuousSend) {
      this.lastRTT = rtt;
      if (this.estimatedRTT == -1.0) {
         this.estimatedRTT = rtt;
         this.deviationRTT = rtt;
      } else {
         double d = 0.05;
         double difference = rtt - this.estimatedRTT;
         this.estimatedRTT += d * difference;
         this.deviationRTT = this.deviationRTT + d * (Math.abs(difference) - this.deviationRTT);
      }

      this.isContinuousSend = isContinuousSend;
      if (isContinuousSend) {
         boolean isNewCongestionControlPeriod = sequenceIndex > this.nextCongestionControlBlock || this.nextCongestionControlBlock - sequenceIndex > 8388607L;
         if (isNewCongestionControlPeriod) {
            this.backoffThisBlock = false;
            this.nextCongestionControlBlock = this.nextSequenceNumber;
         }

         if (this.isInSlowStart()) {
            this.cwnd = this.cwnd + this.mtu;
            if (this.cwnd > this.ssThresh && this.ssThresh != 0.0) {
               this.cwnd = this.ssThresh + this.mtu * this.mtu / this.cwnd;
            }
         } else {
            this.cwnd = this.cwnd + this.mtu * this.mtu / this.cwnd;
         }

         this.cwnd = this.cwnd > 2.147483647E9 ? 2.147483647E9 : this.cwnd;
      }
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

   public double getCwnd() {
      return this.cwnd;
   }
}
