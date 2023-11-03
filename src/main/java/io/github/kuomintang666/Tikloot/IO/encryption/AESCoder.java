package io.github.kuomintang666.Tikloot.IO.encryption;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class AESCoder {
    Cipher encryptcipher = Cipher.getInstance("AES"), decryptcipher = Cipher.getInstance("AES");
    Key key;

    /**
     * 
     * @param keybyte key seed bytes
     * @return aes key
     * @throws Exception
     */
    public static Key getkey(byte[] keybyte) throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(new SecureRandom(keybyte));
        return generator.generateKey();
    }

    public AESCoder(byte[] k) throws Exception {
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
