class Item {
    int itemCode;
    String itemName;
    double price;

    void displayItemDetails() {
        System.out.println("Code: " + itemCode);
        System.out.println("Name: " + itemName);
        System.out.println("Price: ₹" + price);
    }

    double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        Item item = new Item();
        item.itemCode = 123;
        item.itemName = "Notebook";
        item.price = 25.50;
        item.displayItemDetails();
        System.out.println("Total Cost for 4: ₹" + item.calculateTotalCost(4));
    }
}
