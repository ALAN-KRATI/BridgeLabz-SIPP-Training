import java.io.*;

public class TextFileCopy {
    public static void main(String[] args) {
        File sourceFile = new File("source.txt");
        File targetFile = new File("copy.txt");

        if (!sourceFile.exists()) {
            System.out.println("Bruh... source file not found.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(targetFile)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied successfully 🎯");
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
