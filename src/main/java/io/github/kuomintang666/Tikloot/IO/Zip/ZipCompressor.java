package io.github.kuomintang666.Tikloot.IO.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.NotDirectoryException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import io.github.kuomintang666.Tikloot.IO.fileutil;
import io.github.kuomintang666.Tikloot.IO.stream.streamutil;

public class ZipCompressor {

    /**
     * 
     * @param file   file or directory need compress
     * @param output output zipped content
     * @throws IOException
     */
    public static void compress(File file, ZipOutputStream zipOutputStream) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File not found %s".formatted(file));
        }
        if (file.isFile()) {
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            streamutil.moveContent(new FileInputStream(file), zipOutputStream, 4096);
        } else {
            for (String filename : fileutil.getFileRelativePathList(file)) {
                zipOutputStream.putNextEntry(new ZipEntry(filename));
                streamutil.moveContent(new FileInputStream(file.getAbsolutePath() + "\\" + filename),
                        zipOutputStream, 4096);
                zipOutputStream.flush();
            }
        }
        zipOutputStream.finish();

    }

    public static void compress(File file, OutputStream OutputStream) throws IOException {
        compress(file, new ZipOutputStream(OutputStream));
    }

    /**
     * 
     * @param zipinputstream target zip inputstream
     * @param dir            target dir to save zip file's content
     * @throws IOException when the target dir isn't a dir
     */
    public static void uncompress(File dir, ZipInputStream zipInputStream) throws IOException {
        if (!dir.exists())
            dir.mkdir();
        if (dir.isDirectory()) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {

                File unzipped = new File(dir.getAbsolutePath() + "\\" + entry.getName().replaceAll("/", "\\\\"));
                System.out.println(unzipped.getAbsolutePath());
                if (entry.isDirectory()) {
                    unzipped.mkdir();
                    System.out.println("mkdir");
                } else {
                    unzipped.createNewFile();
                    streamutil.moveContent(zipInputStream, new FileOutputStream(unzipped), 4096);
                    System.out.println("mkf");
                }
            }
        } else {
            throw new NotDirectoryException("%s isn't a directory".formatted(dir.getName()));
        }

    }

    public static void uncompress(File dir, InputStream inputstream) throws IOException {
        uncompress(dir, new ZipInputStream(inputstream));
    }
}
