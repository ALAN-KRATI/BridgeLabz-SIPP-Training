import java.util.*;

class MapTask {
    public static Map<String, Integer> wordFreq(String text) {
        Map<String, Integer> map = new HashMap<>();
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = text.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }

    public static Map<Integer, List<String>> invertMap(Map<String, Integer> map) {
        Map<Integer, List<String>> inv = new HashMap<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            int val = e.getValue();
            String key = e.getKey();
            if (!inv.containsKey(val)) {
                inv.put(val, new ArrayList<String>());
            }
            List<String> list = inv.get(val);
            list.add(key);
        }
        return inv;
    }

    public static String maxValueKey(Map<String, Integer> map) {
        String maxKey = "";
        int maxVal = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String key = e.getKey();
            int val = e.getValue();
            if (val > maxVal) {
                maxVal = val;
                maxKey = key;
            }
        }
        return maxKey;
    }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> m1, Map<String, Integer> m2) {
        Map<String, Integer> res = new HashMap<>();
        for (String key : m1.keySet()) {
            res.put(key, m1.get(key));
        }
        for (String key : m2.keySet()) {
            if (res.containsKey(key)) {
                int newVal = res.get(key) + m2.get(key);
                res.put(key, newVal);
            } else {
                res.put(key, m2.get(key));
            }
        }
        return res;
    }

    static class Employee {
        String name;
        String dept;

        public Employee(String name, String dept) {
            this.name = name;
            this.dept = dept;
        }
    }

    public static Map<String, List<Employee>> groupByDept(List<Employee> employees) {
        Map<String, List<Employee>> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            String dept = e.dept;
            if (!map.containsKey(dept)) {
                map.put(dept, new ArrayList<Employee>());
            }
            List<Employee> list = map.get(dept);
            list.add(e);
        }
        return map;
    }
}
