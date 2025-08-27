import java.util.*;
import java.util.stream.*;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "hello world hello java world hello streams";
        List<String> words = Arrays.asList(paragraph.split(" "));
        Map<String, Long> frequency = words.stream()
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println(frequency);
    }
}
