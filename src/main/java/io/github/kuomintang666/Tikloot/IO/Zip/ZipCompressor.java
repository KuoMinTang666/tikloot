package io.github.kuomintang666.Tikloot.IO.Zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import io.github.kuomintang666.Tikloot.IO.FileUtil;
import io.github.kuomintang666.Tikloot.IO.Stream.StreamUtil;

public class ZipCompressor {
    /**
     * 
     * @param file   file or folder need compress
     * @param output output zipped content
     * @throws IOException when the zip file not found
     */
    public static void compress(File file, OutputStream output) throws IOException {
        if (file.exists()) {
            ZipOutputStream zipOutputStream = new ZipOutputStream(output);
            if (file.isFile()) {
                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                StreamUtil.moveContent(new FileInputStream(file), zipOutputStream);
            } else {
                for (String filename : FileUtil.getFileAbsolutePathList(file)) {
                    zipOutputStream.putNextEntry(new ZipEntry(filename));
                    StreamUtil.moveContent(new FileInputStream(file.getAbsolutePath() + "\\" + filename),
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
     * @param file target zip file
     * @param dir  target dir save zip file's content
     * @throws IOException when the target dir isn't a dir
     */
    public static void uncompress(ZipFile file, File dir) throws IOException {
        if (!dir.exists())
            dir.mkdir();
        if (dir.isDirectory()) {
            Enumeration<? extends ZipEntry> entries = file.entries();
            ZipEntry entry;
            while (entries.hasMoreElements()) {
                entry = entries.nextElement();
                File unzipped = new File(dir.getAbsolutePath() + "\\" + entry.getName().replaceAll("/", "\\\\"));
                System.out.println(unzipped.getAbsolutePath());
                if (entry.isDirectory()) {
                    unzipped.mkdir();
                    System.out.println("mkdir");
                } else {
                    unzipped.createNewFile();
                    StreamUtil.moveContent(file.getInputStream(entry), new FileOutputStream(unzipped));
                    System.out.println("mkf");
                }
            }
        } else {
            throw new IOException("%s isn't a directory".formatted(file.getName()));
        }

    }
}
