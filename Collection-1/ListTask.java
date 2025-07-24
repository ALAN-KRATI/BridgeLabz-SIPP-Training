import java.util.*;

class ListTask {
    public static List<Integer> reverseList(List<Integer> list) {
        List<Integer> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) reversed.add(list.get(i));
        return reversed;
    }

    public static Map<String, Integer> frequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) map.put(s, map.getOrDefault(s, 0) + 1);
        return map;
    }

    public static List<Integer> rotate(List<Integer> list, int k) {
        int n = list.size();
        List<Integer> rotated = new ArrayList<>();
        for (int i = 0; i < n; i++) rotated.add(list.get((i + k) % n));
        return rotated;
    }

    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }

    public static String findNthFromEnd(LinkedList<String> list, int n) {
        Iterator<String> first = list.iterator();
        Iterator<String> second = list.iterator();
        for (int i = 0; i < n; i++) if (first.hasNext()) first.next();
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        return second.next();
    }
}

