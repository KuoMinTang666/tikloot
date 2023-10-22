package io.github.kuomintang666.Tikloot.Encryption;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.crypto.Cipher;

import io.github.kuomintang666.Tikloot.Utils.NumberUtil;

public class RSAutil {
    public static class RSACoder {
        Cipher coder = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        public RSACoder(byte[] k, int mode, int keymode) throws Exception {
            coder.init(mode, GetRSAKeyByKeyMode(keymode, k));
        }

        public byte[] code(byte[] input) throws Exception {
            return coder.doFinal(input);
        }
    }

    /**
     * @param k       key
     * 
     * @param mode    code mode(encrypt or decrypt)
     * 
     * @param keymode key mode(public or private)
     */

    public static Map<Integer, byte[]> GetKeyMap(int keysize, byte[] keyseed) throws Exception {
        Map<Integer, byte[]> keymap = new HashMap<Integer, byte[]>();
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(keysize, new SecureRandom(keyseed));
        KeyPair keypair = generator.genKeyPair();
        keymap.put(Cipher.PRIVATE_KEY, keypair.getPrivate().getEncoded());
        keymap.put(Cipher.PUBLIC_KEY, keypair.getPublic().getEncoded());
        return keymap;
    }

    public static Map<Integer, byte[]> GetRandomKey(int keysize) throws Exception {
        return GetKeyMap(keysize, NumberUtil.longToByteArray(new Random().nextLong()));
    }

    /**
     * @return Key
     */
    public static Key GetRSAKeyByKeyMode(int mode, byte[] encoded) throws Exception {
        KeyFactory factory = KeyFactory.getInstance("RSA");
        switch (mode) {
            case Cipher.PRIVATE_KEY:
                return (RSAPrivateKey) factory.generatePrivate(new PKCS8EncodedKeySpec(encoded));
            case Cipher.PUBLIC_KEY:
                return (RSAPublicKey) factory.generatePublic(new X509EncodedKeySpec(encoded));
            default:
                throw new IllegalStateException("wrong value for mode");
        }
    }

}
