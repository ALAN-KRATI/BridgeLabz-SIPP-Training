import java.time.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;
import java.util.stream.*;

public class SmartCityTransportDemo {

    interface EmergencyService {}

    @FunctionalInterface
    interface FareCalculator {
      double calculateFare(double baseFare, double distanceKm, boolean isPeak);
    }

    interface GeoUtils {
      static double calculateDistanceKm(Location a, Location b) {
        double R = 6371.0;
        double dLat = Math.toRadians(b.lat - a.lat);
        double dLon = Math.toRadians(b.lon - a.lon);
        double sLat = Math.toRadians(a.lat);
        double sLat2 = Math.toRadians(b.lat);
        double h = Math.pow(Math.sin(dLat/2), 2) + Math.cos(sLat) * Math.cos(sLat2) * Math.pow(Math.sin(dLon/2), 2);
        double c = 2 * Math.asin(Math.min(1, Math.sqrt(h)));
        return R * c;
      }
    }

    interface TransportService {
      String id();
      String type();
      String route();
      Location from();
      Location to();
      LocalDateTime departure();
      double baseFare();
      boolean isPeakWindow();
      FareCalculator farePolicy();

      default String displayName() { return type() + "-" + id(); }

      default void printServiceDetails() {
        System.out.println(String.format(Locale.US,
          "%s | route=%s | dep=%s | base=%.2f | peak=%s",
          displayName(), route(), departure(), baseFare(), isPeakWindow()));
      }

      default double currentFare() {
        double km = GeoUtils.calculateDistanceKm(from(), to());
        return farePolicy().calculateFare(baseFare(), km, isPeakWindow());
      }

      default ServiceSnapshot toSnapshot() {
        return new ServiceSnapshot(displayName(), type(), route(), departure(), currentFare(), isPeakWindow());
      }
    }

    static abstract class BaseService implements TransportService {
      final String id, type, route;
      final Location from, to;
      final LocalDateTime dep;
      final double base;
      final boolean peak;
      final FareCalculator calc;

      BaseService(String id, String type, String route, Location from, Location to, LocalDateTime dep,
                  double base, boolean peak, FareCalculator calc) {
        this.id = id; this.type = type; this.route = route;
        this.from = from; this.to = to; this.dep = dep;
        this.base = base; this.peak = peak; this.calc = calc;
      }

      public String id() { return id; }
      public String type() { return type; }
      public String route() { return route; }
      public Location from() { return from; }
      public Location to() { return to; }
      public LocalDateTime departure() { return dep; }
      public double baseFare() { return base; }
      public boolean isPeakWindow() { return peak; }
      public FareCalculator farePolicy() { return calc; }
    }

    static class BusService extends BaseService {
      BusService(String id, String route, Location from, Location to, LocalDateTime dep,
                 double base, boolean peak, FareCalculator calc) {
        super(id, "Bus", route, from, to, dep, base, peak, calc);
      }
    }

    static class MetroService extends BaseService {
      MetroService(String id, String route, Location from, Location to, LocalDateTime dep,
                   double base, boolean peak, FareCalculator calc) {
        super(id, "Metro", route, from, to, dep, base, peak, calc);
      }
    }

    static class TaxiService extends BaseService {
      TaxiService(String id, String route, Location from, Location to, LocalDateTime dep,
                  double base, boolean peak, FareCalculator calc) {
        super(id, "Taxi", route, from, to, dep, base, peak, calc);
      }
    }

    static class FerryService extends BaseService {
      FerryService(String id, String route, Location from, Location to, LocalDateTime dep,
                   double base, boolean peak, FareCalculator calc) {
        super(id, "Ferry", route, from, to, dep, base, peak, calc);
      }
    }

    static class AmbulanceService extends BaseService implements EmergencyService {
      AmbulanceService(String id, String route, Location from, Location to, LocalDateTime dep,
                       double base, boolean peak, FareCalculator calc) {
        super(id, "Ambulance", route, from, to, dep, base, peak, calc);
      }

      @Override public String displayName() { return "🚨 " + super.displayName(); }
    }

    static class Location {
      final double lat, lon; final String name;
      Location(String name, double lat, double lon) { this.name = name; this.lat = lat; this.lon = lon; }
      public String toString() { return name; }
    }

    static class Trip {
      final String serviceId, route, serviceType;
      final double fareCharged;
      final boolean peak;
      Trip(String serviceId, String route, String serviceType, double fareCharged, boolean peak) {
        this.serviceId = serviceId; this.route = route; this.serviceType = serviceType;
        this.fareCharged = fareCharged; this.peak = peak;
      }
    }

    static class ServiceSnapshot {
      final String name, type, route; final LocalDateTime dep; final double fare; final boolean peak;
      ServiceSnapshot(String name, String type, String route, LocalDateTime dep, double fare, boolean peak) {
        this.name = name; this.type = type; this.route = route; this.dep = dep; this.fare = fare; this.peak = peak;
      }
      @Override public String toString() {
        return String.format(Locale.US, "%s | %s | %s | dep %s | ₹%.2f | peak=%s",
          name, type, route, dep.toLocalTime(), fare, peak);
      }
    }

    public static void main(String[] args) {
      FareCalculator busFare = (base, km, peak) -> base + km * (peak ? 1.8 : 1.2);
      FareCalculator metroFare = (base, km, peak) -> base + Math.ceil(km / 5) * (peak ? 12 : 8);
      FareCalculator taxiFare = (base, km, peak) -> base + km * (peak ? 20 : 15);
      FareCalculator ferryFare = (base, km, peak) -> base + km * (peak ? 10 : 7);
      FareCalculator emergencyFree = (base, km, peak) -> 0.0;

      Location A = new Location("Central", 28.6139, 77.2090);
      Location B = new Location("Airport", 28.5562, 77.1000);
      Location C = new Location("TechPark", 28.4595, 77.0266);
      LocalDate today = LocalDate.now();

      List<TransportService> services = Arrays.asList(
        new BusService("B12", "CEN-AIR", A, B, LocalDateTime.of(today, LocalTime.of(9, 15)), 20, true, busFare),
        new BusService("B22", "CEN-TPK", A, C, LocalDateTime.of(today, LocalTime.of(9, 30)), 20, true, busFare),
        new MetroService("M03", "CEN-AIR", A, B, LocalDateTime.of(today, LocalTime.of(9, 20)), 15, true, metroFare),
        new MetroService("M11", "CEN-TPK", A, C, LocalDateTime.of(today, LocalTime.of(9, 25)), 15, true, metroFare),
        new TaxiService("T7",  "CEN-AIR", A, B, LocalDateTime.of(today, LocalTime.of(9, 10)), 50, true, taxiFare),
        new TaxiService("T9",  "CEN-TPK", A, C, LocalDateTime.of(today, LocalTime.of(9, 05)), 50, true, taxiFare),
        new FerryService("F1", "CEN-AIR", A, B, LocalDateTime.of(today, LocalTime.of(9, 40)), 30, false, ferryFare),
        new AmbulanceService("EM1", "ANY-PRIO", C, B, LocalDateTime.of(today, LocalTime.of(9, 00)), 0, true, emergencyFree)
      );

      System.out.println("\nPassenger search results:\n");
      LocalTime desiredAfter = LocalTime.of(9, 0);
      List<ServiceSnapshot> options = services.stream()
        .filter(s -> s.departure().toLocalTime().isAfter(desiredAfter))
        .filter(s -> s.route().equals("CEN-AIR"))
        .sorted(Comparator
          .comparing(TransportService::departure)
          .thenComparingDouble(TransportService::currentFare))
        .map(TransportService::toSnapshot)
        .collect(Collectors.toList());

      options.forEach(System.out::println);

      System.out.println("\nDashboard view:\n");
      services.stream()
        .sorted((a,b) -> {
          int pa = (a instanceof EmergencyService) ? 0 : 1;
          int pb = (b instanceof EmergencyService) ? 0 : 1;
          int cmp = Integer.compare(pa, pb);
          return (cmp != 0) ? cmp : a.departure().compareTo(b.departure());
        })
        .map(TransportService::toSnapshot)
        .forEach(snap -> System.out.println("- " + snap));

      System.out.println("\nRevenue report:\n");
      List<Trip> trips = simulateTrips(services, 50);

      Map<String, List<Trip>> byRoute = trips.stream()
        .collect(Collectors.groupingBy(t -> t.route));

      Map<Boolean, List<Trip>> byPeak = trips.stream()
        .collect(Collectors.partitioningBy(t -> t.peak));

      DoubleSummaryStatistics fareStats = trips.stream()
        .collect(Collectors.summarizingDouble(t -> t.fareCharged));

      Map<String, Double> revenueByType = trips.stream()
        .collect(Collectors.groupingBy(t -> t.serviceType, Collectors.summingDouble(t -> t.fareCharged)));

      System.out.println("Trips by route: " + byRoute.keySet());
      System.out.println("Peak vs Non-peak counts: peak=" + byPeak.get(true).size() + ", off=" + byPeak.get(false).size());
      System.out.println(String.format(Locale.US, "Fare stats: count=%d min=%.2f avg=%.2f max=%.2f sum=%.2f",
        fareStats.getCount(), fareStats.getMin(), fareStats.getAverage(), fareStats.getMax(), fareStats.getSum()));
      System.out.println("Revenue by service type: " + revenueByType);
    }

    static List<Trip> simulateTrips(List<TransportService> services, int n) {
      ThreadLocalRandom r = ThreadLocalRandom.current();
      return IntStream.range(0, n).mapToObj(i -> {
        TransportService s = services.get(r.nextInt(services.size()));
        double fare = Math.round(s.currentFare() * (0.8 + r.nextDouble(0.6)) * 100.0) / 100.0;
        return new Trip(s.id(), s.route(), s.type(), fare, s.isPeakWindow());
      }).collect(Collectors.toList());
    }
}
