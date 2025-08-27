import java.util.*;
import java.util.stream.*;

class Claim {
    String type;
    double amount;
    Claim(String type, double amount) {
        this.type = type; this.amount = amount;
    }
}

public class Insurance {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("Health", 10000),
            new Claim("Health", 20000),
            new Claim("Vehicle", 15000),
            new Claim("Vehicle", 25000),
            new Claim("Home", 30000)
        );
        Map<String, Double> avgClaims = claims.stream()
                .collect(Collectors.groupingBy(c -> c.type, Collectors.averagingDouble(c -> c.amount)));
        avgClaims.forEach((type, avg) -> System.out.println(type + " -> " + avg));
    }
}
