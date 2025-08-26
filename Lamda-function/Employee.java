import java.util.*;
import java.util.stream.Collectors;

public class EmployeeNameUppercase {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Riya", "Karan", "Tanya");
        List<String> upperNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperNames);
    }
}
