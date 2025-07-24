class Policy {
    String number, name, coverage;
    Date expiry;
    double premium;

    public Policy(String number, String name, Date expiry, String coverage, double premium) {
        this.number = number;
        this.name = name;
        this.expiry = expiry;
        this.coverage = coverage;
        this.premium = premium;
    }
}

class PolicyManagement {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>(Comparator.comparing(p -> p.expiry));
    Map<String, Policy> map = new HashMap<>();
    Map<String, Policy> linkedMap = new LinkedHashMap<>();
    Map<Date, Policy> treeMap = new TreeMap<>();

    public void addPolicy(Policy p) {
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
        map.put(p.number, p);
        linkedMap.put(p.number, p);
        treeMap.put(p.expiry, p);
    }

    public Policy getByNumber(String num) {
        return map.get(num);
    }

    public List<Policy> expiringSoon() {
        List<Policy> res = new ArrayList<>();
        Date now = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(Calendar.DATE, 30);
        Date limit = c.getTime();
        for (Policy p : map.values())
            if (p.expiry.before(limit)) res.add(p);
        return res;
    }

    public List<Policy> byHolder(String name) {
        List<Policy> res = new ArrayList<>();
        for (Policy p : map.values())
            if (p.name.equals(name)) res.add(p);
        return res;
    }

    public void removeExpired() {
        Date now = new Date();
        map.values().removeIf(p -> p.expiry.before(now));
    }
}