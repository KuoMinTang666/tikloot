package io.github.kuomintang666.Tikloot.IO.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
     * @throws IOException when the zip file not found
     */
    public static void compress(File file, OutputStream output) throws IOException {
        if (file.exists()) {
            ZipOutputStream zipOutputStream = new ZipOutputStream(output);
            if (file.isFile()) {
                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                streamutil.moveContent(new FileInputStream(file), zipOutputStream);
            } else {
                for (String filename : fileutil.getFileRelativePathList(file)) {
                    zipOutputStream.putNextEntry(new ZipEntry(filename));
                    streamutil.moveContent(new FileInputStream(file.getAbsolutePath() + "\\" + filename),
                            zipOutputStream);
                    zipOutputStream.flush();
                }
            }
            zipOutputStream.finish();
        } else {
            throw new IOException("File not found %s".formatted(file.getName()));
        }

    }

    /**
     * 
     * @param inputstream target zip inputstream
     * @param dir         target dir to save zip file's content
     * @throws IOException when the target dir isn't a dir
     */
    public static void uncompress(ZipInputStream inputstream, File dir) throws IOException {
        if (!dir.exists())
            dir.mkdir();
        if (dir.isDirectory()) {
            ZipEntry entry;
            while ((entry = inputstream.getNextEntry()) != null) {

                File unzipped = new File(dir.getAbsolutePath() + "\\" + entry.getName().replaceAll("/", "\\\\"));
                System.out.println(unzipped.getAbsolutePath());
                if (entry.isDirectory()) {
                    unzipped.mkdir();
                    System.out.println("mkdir");
                } else {
                    unzipped.createNewFile();
                    streamutil.moveContent(inputstream, new FileOutputStream(unzipped));
                    System.out.println("mkf");
                }
            }
        } else {
            throw new IOException("%s isn't a directory".formatted(dir.getName()));
        }

    }
}
