class Parcel {
    double weight;
    double length, width, height;
    Parcel(double weight, double length, double width, double height) {
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
    }
    double calculateShippingCost() {
        return 0;
    }
}
class StandardParcel extends Parcel {
    StandardParcel(double w, double l, double b, double h) {
        super(w, l, b, h);
    }
    double calculateShippingCost() {
        return weight * 10;
    }
}
class ExpressParcel extends Parcel {
    ExpressParcel(double w, double l, double b, double h) {
        super(w, l, b, h);
    }
    double calculateShippingCost() {
        return weight * 20;
    }
}
class InternationalParcel extends Parcel {
    InternationalParcel(double w, double l, double b, double h) {
        super(w, l, b, h);
    }
    double calculateShippingCost() {
        return weight * 50;
    }
}
class ShippingService {
    public static void main(String[] args) {
        Parcel[] parcels = {
            new StandardParcel(5, 10, 10, 10),
            new ExpressParcel(3, 8, 8, 8),
            new InternationalParcel(2, 15, 10, 5)
        };
        for (Parcel p : parcels) {
            System.out.println("Shipping Cost: " + p.calculateShippingCost());
        }
    }
}
