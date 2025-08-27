import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Alert {
    String type;
    String message;

    Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String toString() {
        return type + ": " + message;
    }
}

public class NotificationFilter {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("Critical", "Patient heart rate abnormal."),
            new Alert("Reminder", "Time for daily check-up."),
            new Alert("Info", "System maintenance tonight.")
        );

        Predicate<Alert> criticalOnly = alert -> alert.type.equalsIgnoreCase("Critical");

        List<Alert> filtered = alerts.stream()
                                     .filter(criticalOnly)
                                     .collect(Collectors.toList());

        System.out.println("Filtered Alerts:\n" + filtered);
    }
}
