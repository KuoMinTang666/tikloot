package io.github.kuomintang666.Tikloot.IO.encryption;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class BASE64util {
    static Encoder encoder = Base64.getEncoder();
    static Decoder decoder = Base64.getDecoder();

    public static String Encode(byte[] input) {
        return new String(encoder.encode(input));
    }

    public static byte[] Decode(String input) {
        return decoder.decode(input);
    }

    public static String toSafe(String input) {
        return input.replaceAll("[/]", "#s").replaceAll("[+]", "#p").replaceAll("[=]", "#e");
    }

    public static String toUnsafe(String input) {
        return input.replaceAll("#s", "/").replaceAll("#p", "+").replaceAll("#e", "=");
    }
}
