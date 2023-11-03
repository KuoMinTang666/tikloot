package io.github.kuomintang666.Tikloot.IO.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomAccessFileOutputStream extends OutputStream {
    final RandomAccessFile randomAccessFile;

    public RandomAccessFileOutputStream(RandomAccessFile raf) {
        randomAccessFile = raf;
    }

    public void seek(long position) throws IOException {
        randomAccessFile.seek(position);
    }

    public void close() throws IOException {
        randomAccessFile.close();
    }

    public RandomAccessFile getRandomAccessFile() {
        return randomAccessFile;
    }

    @Override
    public void write(int b) throws IOException {
        randomAccessFile.write(b);
    }

}