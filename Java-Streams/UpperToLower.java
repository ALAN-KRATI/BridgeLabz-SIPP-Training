import java.io.*;

public class UpperToLower {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("upper.txt"), "UTF-8"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("lower.txt"), "UTF-8"))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }

            System.out.println("All caps downshifted 🧢➡️👒");
        } catch (IOException e) {
            System.out.println("Conversion fail: " + e.getMessage());
        }
    }
}
