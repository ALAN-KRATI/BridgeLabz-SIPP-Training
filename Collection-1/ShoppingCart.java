class ShoppingCart {
    Map<String, Integer> prices = new HashMap<>();
    Map<String, Integer> cart = new LinkedHashMap<>();

    public void addItem(String item, int price) {
        prices.put(item, price);
        cart.put(item, price);
    }

    public Map<String, Integer> getSortedByPrice() {
        return new TreeMap<>(prices);
    }
}