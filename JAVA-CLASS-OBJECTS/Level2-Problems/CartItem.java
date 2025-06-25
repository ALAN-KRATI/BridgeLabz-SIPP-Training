class CartItem {
    String itemName;
    double price;
    int quantity;

    void addItem(String name, double p, int q) {
        itemName = name;
        price = p;
        quantity = q;
    }

    void removeItem() {
        itemName = null;
        price = 0;
        quantity = 0;
        System.out.println("Item removed.");
    }

    double calculateTotal() {
        return price * quantity;
    }

    void displayCartDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: ₹" + calculateTotal());
    }

    public static void main(String[] args) {
        CartItem cart = new CartItem();
        cart.addItem("Earbuds", 1999, 2);
        cart.displayCartDetails();
        cart.removeItem();
        cart.displayCartDetails();
    }
}
