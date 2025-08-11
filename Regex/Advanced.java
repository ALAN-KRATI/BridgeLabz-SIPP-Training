import java.util.*;

public class Advanced {

    public static boolean validateIPv4(String ip) {
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        return ip.matches(regex);
    }

    public static boolean validateCreditCard(String card) {
        String visa = "^4\\d{15}$";
        String master = "^5\\d{15}$";
        return card.matches(visa) || card.matches(master);
    }

    public static List<String> extractLanguages(String text) {
        List<String> result = new ArrayList<>();
        Matcher m = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b").matcher(text);
        while (m.find()) result.add(m.group());
        return result;
    }

    public static List<String> extractCurrency(String text) {
        List<String> result = new ArrayList<>();
        Matcher m = Pattern.compile("\\$\\d+(\\.\\d{2})?|\\d+\\.\\d{2}").matcher(text);
        while (m.find()) result.add(m.group());
        return result;
    }

    public static Set<String> findRepeatingWords(String text) {
        Set<String> repeats = new HashSet<>();
        Matcher m = Pattern.compile("\\b(\\w+)\\s+\\1\\b", Pattern.CASE_INSENSITIVE).matcher(text);
        while (m.find()) repeats.add(m.group(1));
        return repeats;
    }

    public static boolean validateSSN(String text) {
        String regex = "^(\\d{3}-\\d{2}-\\d{4})$";
        return text.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println(validateIPv4("192.168.0.1"));
        System.out.println(validateIPv4("256.100.50.25"));
        System.out.println(validateCreditCard("4111111111111111"));
        System.out.println(validateCreditCard("5111111111111111"));
        System.out.println(validateCreditCard("6111111111111111"));
        System.out.println(extractLanguages("I love Java, Python, and JavaScript, but I haven't tried Go yet."));
        System.out.println(extractCurrency("The price is $45.99, and the discount is 10.50."));
        System.out.println(findRepeatingWords("This is is a repeated repeated word test."));
        System.out.println(validateSSN("123-45-6789"));
        System.out.println(validateSSN("123456789"));
    }
}
