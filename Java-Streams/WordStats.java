import java.io.*;
import java.util.*;

public class WordStats {
    public static void main(String[] args) {
        Map<String, Integer> freq = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("essay.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        freq.put(word, freq.getOrDefault(word, 0) + 1);
                    }
                }
            }

            freq.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(5)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        } catch (IOException e) {
            System.out.println("Failed to read file.");
        }
    }
}
