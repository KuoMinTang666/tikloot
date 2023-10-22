package io.github.kuomintang666.Tikloot.Encryption;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class AESutil {
    Cipher encryptcipher = Cipher.getInstance("AES"), decryptcipher = Cipher.getInstance("AES");
    Key key;

    public static Key getkey(byte[] keybyte) throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(new SecureRandom(keybyte));
        return generator.generateKey();
    }

    public AESutil(byte[] k) throws Exception {
        key = getkey(k);
        encryptcipher.init(Cipher.ENCRYPT_MODE, key);
        decryptcipher.init(Cipher.DECRYPT_MODE, key);
    }

    public void setkey(byte[] k) throws Exception {
        key = getkey(k);
        encryptcipher.init(Cipher.ENCRYPT_MODE, key);
        decryptcipher.init(Cipher.DECRYPT_MODE, key);
    }

    public byte[] encode(byte[] input) throws Exception {
        return encryptcipher.doFinal(input);
    }

    public byte[] decode(byte[] input) throws Exception {
        return decryptcipher.doFinal(input);
    }
}
