package net.kuomintang666.Tikloot.Utils;

import java.util.Random;
import java.util.UUID;

public class RandomUtil {
    public static String CreateGUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 
     * @param length length of bytearray
     * @return a random bytearray
     */
    public static byte[] RandomByteArray(int length) {
        byte[] result = new byte[length];
        new Random().nextBytes(result);
        return result;
    }
}
