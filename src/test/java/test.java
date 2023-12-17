import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import io.github.kuomintang666.Tikloot.IO.zip.ZipCompressor;
import io.github.kuomintang666.Tikloot.IO.zip.ZipDecompressor;

public class test {
    public static void main(String[] args) throws Exception {
        t11();
        t1();
    }

    public static void t1() throws Exception {
        ZipDecompressor<String> zipDecompressor = new ZipDecompressor<>(131072, "ccec");

        zipDecompressor.decompress("fuck", new ZipFile("ddw.zip")).run();
        System.out.println(zipDecompressor.getTaskMap().size());
    }

    public static void t8238() throws Exception {

    }

    public static void t11() throws Exception {
        ZipCompressor<String> zipCompressor = new ZipCompressor<String>(131072);

        zipCompressor.compress("fuck", new ZipOutputStream(new FileOutputStream("ddw.zip")), new File("dfdfs"))
                .run();
        System.out.println(zipCompressor.getTaskMap().size());
    }
}
