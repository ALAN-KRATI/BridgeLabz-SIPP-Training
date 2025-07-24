class VotingSystem {
    Map<String, Integer> votes = new HashMap<>();
    Map<String, Integer> voteOrder = new LinkedHashMap<>();

    public void vote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, votes.get(candidate));
    }

    public Map<String, Integer> getResultsSorted() {
        return new TreeMap<>(votes);
    }

    public Map<String, Integer> getVoteOrder() {
        return voteOrder;
    }