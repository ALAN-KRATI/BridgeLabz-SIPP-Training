import java.util.*;
import java.util.regex.*;

public class TextCleaner {

    public static String removeExtraSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    
    public static String censorBadWords(String sentence, List<String> badWords) {
        for (String bad : badWords) {
            sentence = sentence.replaceAll("(?i)\\b" + Pattern.quote(bad) + "\\b", "****");
        }

        return sentence;
    }

    public static void main(String[] args) {
      
        String extraSpaces = "This   is    an   example   with   multiple   spaces.";
        System.out.println(removeExtraSpaces(extraSpaces));

        String text = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");
        System.out.println(censorBadWords(text, badWords));
    }
}
