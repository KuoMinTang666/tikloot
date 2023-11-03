package io.github.kuomintang666.Tikloot.utils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import io.github.kuomintang666.Tikloot.IO.encryption.BASE64util;

public class arrayutil {
    public static <T> T getlast(T[] input) {
        return input[input.length - 1];
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> cloneList(List<T> arg0) {
        return (List<T>) Arrays.asList(arg0.toArray());
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
