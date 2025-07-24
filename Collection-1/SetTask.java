class SetTask {
    public static boolean areEqual(Set<Integer> a, Set<Integer> b) {
        return a.equals(b);
    }

    public static Set<Integer> union(Set<Integer> a, Set<Integer> b) {
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        return union;
    }

    public static Set<Integer> intersection(Set<Integer> a, Set<Integer> b) {
        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        return intersection;
    }

    public static Set<Integer> symmetricDifference(Set<Integer> a, Set<Integer> b) {
        Set<Integer> diff = new HashSet<>(a);
        diff.addAll(b);
        Set<Integer> tmp = new HashSet<>(a);
        tmp.retainAll(b);
        diff.removeAll(tmp);
        return diff;
    }

    public static List<Integer> sortedListFromSet(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static boolean isSubset(Set<Integer> a, Set<Integer> b) {
        return b.containsAll(a);
    }
}