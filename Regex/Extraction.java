import java.util.*;

public class Extraction {

    public static List<String> extractEmails(String text){
        List<String> emails = new ArrayList<>();
        String regex = "[a-zA-Z0-9._%+-]@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b"
        Matcher matcher = Pattern.compile(regex).mactcher(text);

        while(matcher.find()){
            emails.add(mactcher.group());
        }
        
        return emails;
    }

    public static List<String> extractCapitalWords(String text){
        List<String> capitalWords = new ArrayList<>();
        String regex = "\\b[A-Z][a-z]*\\b";
        Matcher matcher = Pattern.compile(regex).matcher(text);

        while(matcher.find()){
            capitalWords.add(matcher.group());
        }

        return capitalWords;
    }

    public static List<String> extractDates(String text){
        List<String> Dates = new ArrayList<>();
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        
        while(matcher.find()){
            Dates.add(matcher.group());
        }
        return Dates;
    }

    public static List<String> extractLinks(String text){
        List<String> links = new ArrayList<>();
        String regex = "\\bhttps?://[a-zA-Z0-9.-]+(?:\\.[a-zA-Z]{2,})+\\b";
        Matcher matcher = Pattern.compile(regex).matcher(text); 

        while(matcher.find()){
            links.add(matcher.group());
        }   
        return links;
    }

    public static void main(String[] args) {
        String text1 = "Contact us at support@example.com and info@company.org";
        String text2 = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        String text3 = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        String text4 = "Visit https://www.google.com and http://example.org for more info.";

        System.out.println(extractEmails(text1));
        System.out.println(extractCapitalWords(text2));
        System.out.println(extractDates(text3));
        System.out.println(extractLinks(text4));
    }
}