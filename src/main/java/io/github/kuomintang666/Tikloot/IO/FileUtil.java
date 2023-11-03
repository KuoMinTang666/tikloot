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

public class fileutil {

    /**
     * 
     * @param location target file location
     * @return file contents as string
     * @throws IOException
     */
    public static String readAllFileContent(String location) throws IOException {
        return readAllFileContent(location, StandardCharsets.UTF_8);
    }

    /**
     * 
     * @param file    target file
     * @param charset file charset
     * @return file contents as string
     * @throws IOException
     */

    public static String readAllFileContent(String location, Charset charset) throws IOException {
        return readAllFileContent(new File(location), charset);
    }

    /**
     * 
     * @param file target file
     * @return file contents as string
     * @throws IOException
     */
    public static String readAllFileContent(File file) throws IOException {
        return readAllFileContent(file, StandardCharsets.UTF_8);
    }

    /**
     * 
     * @param file    target file
     * @param charset file charset
     * @return file contents as string
     * @throws IOException
     */
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

    /**
     * Of course,this method is for compressing zip file
     * 
     * @param files folder of files
     * @param dir   directory of files
     * @return list of file relative path
     * @throws IOException
     */
    public static List<String> getFileRelativePathList(File files, String dir) throws IOException {
        if (!files.exists()) {
            throw new IOException("File not found %s".formatted(files.getName()));
        }
        String praseddir = dir.contains("/") ? dir.replaceAll("/", "\\") : dir;
        List<String> nameList = new ArrayList<>();
        for (File file : files.listFiles()) {
            nameList.add(file.getAbsolutePath().replace(praseddir + "\\", ""));
            if (file.isDirectory()) {

                nameList.addAll(getFileRelativePathList(file, praseddir));
            }

        }
        return nameList;
    }

    /**
     * 
     * @param files folder of files
     * @return list of file relative path
     * @throws IOException
     */
    public static List<String> getFileRelativePathList(File files) throws IOException {
        return getFileRelativePathList(files, files.getAbsolutePath());
    }
}
