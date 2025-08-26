import java.util.*;
import java.util.stream.*;

public class Names {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("riya", "amit", "tina", "karan");
        names.stream()
             .map(String::toUpperCase)
             .sorted()
             .forEach(System.out::println);
    }
}
