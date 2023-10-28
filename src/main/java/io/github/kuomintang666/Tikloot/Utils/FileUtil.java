package io.github.kuomintang666.Tikloot.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

}