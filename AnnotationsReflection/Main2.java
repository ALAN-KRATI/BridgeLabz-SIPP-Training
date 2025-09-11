class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("Old feature - don’t use this anymore!");
    }

    void newFeature() {
        System.out.println("New feature - use this instead!");
    }
}

class Main2 {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();  // Shows warning
        api.newFeature();
    }
}