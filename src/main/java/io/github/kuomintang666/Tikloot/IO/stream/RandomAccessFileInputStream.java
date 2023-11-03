package io.github.kuomintang666.Tikloot.IO.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomAccessFileInputStream extends InputStream {
    final RandomAccessFile randomAccessFile;

    public RandomAccessFileInputStream(RandomAccessFile raf) {
        randomAccessFile = raf;
    }

    public void seek(long position) throws IOException {
        randomAccessFile.seek(position);
    }

    public int read() throws IOException {
        return randomAccessFile.read();
    }

    public void close() throws IOException {
        randomAccessFile.close();
    }

    public long getRemaining() throws IOException {
        return randomAccessFile.length() - 1 - randomAccessFile.getFilePointer();
    }

    public RandomAccessFile getRandomAccessFile() {
        return randomAccessFile;
    }

}