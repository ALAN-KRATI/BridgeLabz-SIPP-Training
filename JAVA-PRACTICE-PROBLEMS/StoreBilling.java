abstract class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    abstract double calculateDiscount();
}
class Electronics extends Product {
    Electronics(String name, double price) {
        super(name, price);
    }
    double calculateDiscount() {
        return price * 0.10;
    }
}
class Clothing extends Product {
    Clothing(String name, double price) {
        super(name, price);
    }
    double calculateDiscount() {
        return price * 0.20;
    }
}
class Grocery extends Product {
    Grocery(String name, double price) {
        super(name, price);
    }
    double calculateDiscount() {
        return 0;
    }
}
class StoreBilling {
    public static void main(String[] args) {
        Product[] products = {
            new Electronics("Laptop", 60000),
            new Clothing("T-shirt", 1000),
            new Grocery("Rice", 500)
        };
        for (Product p : products) {
            System.out.println(p.name + " discount: " + p.calculateDiscount());
        }
    }
}