import java.util.*;
import java.time.*;
import java.util.stream.*;

class Member {
    String name;
    LocalDate expiry;
    Member(String name, LocalDate expiry) {
        this.name = name; this.expiry = expiry;
    }
    public String toString() { return name + " | " + expiry; }
}

public class Membership {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("Amit", LocalDate.now().plusDays(10)),
            new Member("Riya", LocalDate.now().plusDays(40)),
            new Member("Karan", LocalDate.now().plusDays(20)),
            new Member("Tina", LocalDate.now().plusDays(5))
        );
        LocalDate now = LocalDate.now();
        members.stream()
               .filter(m -> !m.expiry.isBefore(now) && m.expiry.isBefore(now.plusDays(30)))
               .forEach(System.out::println);
    }
}
