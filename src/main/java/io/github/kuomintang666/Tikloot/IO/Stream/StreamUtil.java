package io.github.kuomintang666.Tikloot.IO.Stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtil {
    /**
     * 
     * @param inputStream  target inputstream contains all contents need move
     * @param outputStream target outputstream need contents
     * @throws IOException
     */
    public static void moveContent(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[4096];
        while (inputStream.available() >= buffer.length) {
            inputStream.read(buffer);
            outputStream.write(buffer);
        }
        outputStream.write(inputStream.readAllBytes());
    }
}
