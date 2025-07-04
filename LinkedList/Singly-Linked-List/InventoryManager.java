class Product {
    int id;
    String name;
    int quantity;
    double price;
    Product next;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManager {
    Product head = null;

    public void addProduct(int id, String name, int quantity, double price) {
        Product newProduct = new Product(id, name, quantity, price);
        if (head == null) {
            head = newProduct;
        } else {
            Product temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newProduct;
        }
    }

    public void removeProduct(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Product temp = head;
        while (temp.next != null && temp.next.id != id)
            temp = temp.next;
        if (temp.next != null)
            temp.next = temp.next.next;
    }

    public void updateStock(int id, int newQty) {
        Product temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                System.out.println("Stock updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Product not found.");
    }

    public void displayInventory() {
        Product temp = head;
        while (temp != null) {
            System.out.println(temp.id + " | " + temp.name + " | Qty: " + temp.quantity + " | Price: ₹" + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryManager im = new InventoryManager();
        im.addProduct(101, "Pen", 50, 10.0);
        im.addProduct(102, "Notebook", 30, 25.0);
        im.displayInventory();
        im.updateStock(101, 60);
        im.removeProduct(102);
        im.displayInventory();
    }
}