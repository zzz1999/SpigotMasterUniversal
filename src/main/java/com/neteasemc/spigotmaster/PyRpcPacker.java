package com.neteasemc.spigotmaster;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;
import org.msgpack.core.MessageFormat;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.MessageUnpacker;

public class PyRpcPacker {
   private static final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);

   private static void packObject(MessagePacker var0, Object var1) throws IOException {
      if (var1 == null) {
         var0.packNil();
      } else if (var1 instanceof String) {
         packString(var0, (String)var1);
      } else if (var1 instanceof Long) {
         var0.packLong((Long)var1);
      } else if (var1 instanceof Integer) {
         var0.packInt((Integer)var1);
      } else if (var1 instanceof Map) {
         packMap(var0, (Map<String, Object>)var1);
      } else if (var1 instanceof List) {
         packList(var0, (List<Object>)var1);
      } else if (var1 instanceof Float) {
         var0.packDouble(((Float)var1).floatValue());
      } else if (var1 instanceof Double) {
         var0.packDouble((Double)var1);
      } else if (var1 instanceof Boolean) {
         var0.packBoolean((Boolean)var1);
      } else {
         if (!(var1 instanceof BigInteger)) {
            throw new IOException("can not pack type " + var1.getClass().getName());
         }

         var0.packBigInteger((BigInteger)var1);
      }
   }

   private static void packString(MessagePacker var0, String var1) throws IOException {
      byte[] var2 = var1.getBytes(StandardCharsets.UTF_8);
      var0.packBinaryHeader(var2.length);
      var0.writePayload(var2);
   }

   private static void packList(MessagePacker var0, List<Object> var1) throws IOException {
      var0.packArrayHeader(var1.size());

      for (Object var3 : var1) {
         packObject(var0, var3);
      }
   }

   private static void packMap(MessagePacker var0, Map<String, Object> var1) throws IOException {
      var0.packMapHeader(var1.size());

      for (Entry var3 : var1.entrySet()) {
         packString(var0, (String)var3.getKey());
         packObject(var0, var3.getValue());
      }
   }

   public static byte[] pack(String var0, String var1, String var2, Map<String, Object> var3) throws IOException {
      ByteArrayOutputStream var4 = new ByteArrayOutputStream();
      GZIPOutputStream var5 = new GZIPOutputStream(var4);

      try {
         MessagePacker var6 = MessagePack.newDefaultPacker(var5);

         try {
            var6.packArrayHeader(3);
            var6.packString("ModEventS2C");
            var6.packArrayHeader(4);
            var6.packString(var0);
            var6.packString(var1);
            var6.packString(var2);
            packMap(var6, var3);
            var6.packNil();
         } catch (Throwable var11) {
            if (var6 != null) {
               try {
                  var6.close();
               } catch (Throwable var10) {
                  var11.addSuppressed(var10);
               }
            }

            throw var11;
         }

         if (var6 != null) {
            var6.close();
         }
      } catch (Throwable var12) {
         try {
            var5.close();
         } catch (Throwable var9) {
            var12.addSuppressed(var9);
         }

         throw var12;
      }

      var5.close();
      return var4.toByteArray();
   }

   public static Object unpackObject(MessageUnpacker var0) throws IOException {
      MessageFormat var1 = var0.getNextFormat();
      switch (var1.getValueType()) {
         case NIL:
            var0.unpackNil();
            return null;
         case BOOLEAN:
            return var0.unpackBoolean();
         case INTEGER:
            switch (var1) {
               case UINT64:
                  BigInteger var8 = var0.unpackBigInteger();
                  if (var8.compareTo(MAX_LONG) <= 0) {
                     return var8.longValue();
                  }

                  return var8;
               case INT64:
                  return var0.unpackLong();
               case UINT32:
                  long var9 = var0.unpackLong();
                  if (var9 <= 2147483647L) {
                     return (int)var9;
                  }

                  return var9;
               default:
                  return var0.unpackInt();
            }
         case FLOAT:
            return var0.unpackDouble();
         case STRING:
            return new String(var0.readPayload(var0.unpackRawStringHeader()), StandardCharsets.UTF_8);
         case BINARY:
            return new String(var0.readPayload(var0.unpackBinaryHeader()), StandardCharsets.UTF_8);
         case ARRAY:
            int var2 = var0.unpackArrayHeader();
            ArrayList var3 = new ArrayList(var2);

            for (int var10 = 0; var10 < var2; var10++) {
               var3.add(unpackObject(var0));
            }

            return var3;
         case MAP:
            int var4 = var0.unpackMapHeader();
            HashMap var5 = new HashMap(var4);

            for (int var6 = 0; var6 < var4; var6++) {
               String var7 = (String)unpackObject(var0);
               var5.put(var7, unpackObject(var0));
            }

            return var5;
         default:
            throw new IOException("can not unpack type " + var1.getValueType().name());
      }
   }
}
