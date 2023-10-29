package io.github.kuomintang666.Tikloot.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {

    public static long getFileSize(String file) {
        return new File(file).length();
    }

    public static long getFileSize(File file) {
        return file.length();
    }

    public static String readAllFileContent(String location) throws IOException {
        return readAllFileContent(location, StandardCharsets.UTF_8);
    }

    public static String readAllFileContent(String location, Charset charset) throws IOException {
        return readAllFileContent(new File(location), charset);
    }

    public static String readAllFileContent(File file) throws IOException {
        return readAllFileContent(file, StandardCharsets.UTF_8);
    }

    public static String readAllFileContent(File file, Charset charset) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream(file), charset);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine() + "\n");

        }
        builder.deleteCharAt(builder.length() - 1);
        scanner.close();
        return builder.toString();
    }

    public static List<String> getFileAbsolutePathList(File files, String dir) throws IOException {
        if (!files.exists()) {
            throw new IOException("File not found %s".formatted(files.getName()));
        }
        String praseddir = dir.contains("/") ? dir.replaceAll("/", "\\") : dir;
        List<String> nameList = new ArrayList<>();
        for (File file : files.listFiles()) {
            if (file.isDirectory()) {
                nameList.addAll(getFileAbsolutePathList(file, praseddir));
            } else {
                nameList.add(file.getAbsolutePath().replace(praseddir + "\\", ""));
            }
        }
        return nameList;
    }

    public static List<String> getFileAbsolutePathList(File files) throws IOException {
        return getFileAbsolutePathList(files, files.getAbsolutePath());
    }
}
