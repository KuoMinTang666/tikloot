package net.kuomintang666.Tikloot.Utils;

import java.nio.ByteBuffer;

public class NumberUtil {
    public static byte[] intToByteArray(int i) {
        byte[] result = new byte[4];
        for (int j = 0; j < result.length; j++) {
            result[j] = (byte) ((i >> (24 - (j * 8))) & 0xFF);
        }

        return result;
    }

    public static int byteArrayToInt(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }

    public static byte[] longToByteArray(long i) {
        byte[] result = new byte[8];
        for (int j = 0; j < result.length; j++) {
            result[j] = (byte) ((i >> (56 - (j * 8))) & 0xFF);
        }

        return result;
    }

    public static long byteArrayToLong(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getLong();
    }
}
