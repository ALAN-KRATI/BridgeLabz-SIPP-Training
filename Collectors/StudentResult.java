import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    String grade;
    Student(String name, String grade) {
        this.name = name; this.grade = grade;
    }
}

public class StudentResult {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Amit", "A"),
            new Student("Riya", "B"),
            new Student("Karan", "A"),
            new Student("Tina", "C"),
            new Student("Meena", "B")
        );
        Map<String, List<String>> grouped = students.stream()
            .collect(Collectors.groupingBy(s -> s.grade, Collectors.mapping(s -> s.name, Collectors.toList())));
        System.out.println(grouped);
    }
}
