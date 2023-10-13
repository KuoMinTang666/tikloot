package net.kuomintang666.Tikloot.Encryption;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class HASHutil {
    public static final String SHA256 = "sha-256", MD5 = "MD5", SHA1 = "sha-1", SHA384 = "sha-384", SHA512 = "sha-512",
            MD2 = "MD2";

    public static String ToHexStr(byte[] input) {
        StringBuilder sb = new StringBuilder();
        for (byte b : input) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String GetFileHash(File file, String type) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        MessageDigest mg = MessageDigest.getInstance(type);
        long length = file.length();
        long chunknum = length / 4096;
        for (int i = 0; i < chunknum; i++) {
            mg.update(fis.readNBytes(4096));
        }
        mg.update(fis.readAllBytes());
        fis.close();
        return ToHexStr(mg.digest());
    }
}
