import java.io.*;

public class ErrorLogFilter {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("server_log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Log read error");
        }
    }
}
