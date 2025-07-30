import java.io.*;

public class BufferedVsUnbufferedCopy {
    public static void main(String[] args) throws IOException {
        File input = new File("bigdata.bin");

        long start = System.nanoTime();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(input));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("buffered.bin"))) {
            byte[] chunk = new byte[4096];
            int len;
            while ((len = in.read(chunk)) != -1) {
                out.write(chunk, 0, len);
            }
        }
        long end = System.nanoTime();
        System.out.println("Buffered copy took: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        try (FileInputStream in = new FileInputStream(input);
             FileOutputStream out = new FileOutputStream("unbuffered.bin")) {
            byte[] chunk = new byte[4096];
            int len;
            while ((len = in.read(chunk)) != -1) {
                out.write(chunk, 0, len);
            }
        }
        end = System.nanoTime();
        System.out.println("Unbuffered copy took: " + (end - start) / 1e6 + " ms");
    }
}
