package io.github.kuomintang666.Tikloot.IO.stream;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import io.github.kuomintang666.Tikloot.utils.numberutil;

public class ReaderPP {
    InputStream thisInputStream;

    public ReaderPP(InputStream arg0) throws Exception {
        thisInputStream = arg0;
    }

    public String readString(Charset arg0) throws IOException {
        return new String(readByteArray(), arg0);
    }

    public String readString() throws IOException {
        return readString(StandardCharsets.UTF_8);
    }

    public int readInt() throws IOException {
        byte[] cache = new byte[4];
        thisInputStream.read(cache);
        return numberutil.byteArrayToInt(cache);
    }

    public long readLong() throws IOException {
        byte[] cache = new byte[8];
        thisInputStream.read(cache);
        return numberutil.byteArrayToLong(cache);

    }

    public int readByte() throws IOException {
        return thisInputStream.read();
    }

    public byte[] readByteArray() throws IOException {
        int length = readInt();
        return thisInputStream.readNBytes(length);
    }

    public boolean readBoolean() throws IOException {
        return thisInputStream.read() == 1;
    }

    public int available() throws IOException {
        return thisInputStream.available();
    }

    public void close() throws IOException {
        thisInputStream.close();
    }

    public void clear() throws IOException {
        thisInputStream.skip(available());
    }
}
