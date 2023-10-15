package net.kuomintang666.Tikloot.Utils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import net.kuomintang666.Tikloot.Encryption.BASE64util;

public class ArrayUtil {
    public static <T> T getlast(T[] input) {
        return input[input.length - 1];
    }
    
    public static <E> Object[] removelast(E[] input) {
        Object[] result = new Object[input.length - 1];
        for (int i = 0; i < result.length - 2; i++) {
            result[i] = input[i];
        }
        return result;
    }

    public static <E> Object[] removefirst(E[] input) {
        Object[] result = new Object[input.length - 1];
        for (int i = 1; i < result.length - 1; i++) {
            result[i] = input[i];
        }
        return result;
    }

}
