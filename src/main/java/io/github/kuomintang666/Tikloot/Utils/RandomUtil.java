package io.github.kuomintang666.Tikloot.utils;

import java.util.Random;
import java.util.UUID;

public class randomutil {
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
