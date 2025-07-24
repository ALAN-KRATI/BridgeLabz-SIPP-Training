class BankingSystem {
    Map<String, Integer> accounts = new HashMap<>();
    TreeMap<Integer, List<String>> sortedByBalance = new TreeMap<>();
    Queue<String> withdrawQueue = new LinkedList<>();

    public void addAccount(String acc, int bal) {
        accounts.put(acc, bal);
        sortedByBalance.computeIfAbsent(bal, k -> new ArrayList<>()).add(acc);
    }

    public void requestWithdraw(String acc) {
        withdrawQueue.add(acc);
    }

    public void processWithdrawals() {
        while (!withdrawQueue.isEmpty()) withdrawQueue.poll();
    }
}