class QueueTask {
    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) s.push(q.remove());
        while (!s.isEmpty()) q.add(s.pop());
        return q;
    }

    public static List<String> generateBinary(int n) {
        Queue<String> q = new LinkedList<>();
        List<String> res = new ArrayList<>();
        q.add("1");
        while (n-- > 0) {
            String s = q.remove();
            res.add(s);
            q.add(s + "0");
            q.add(s + "1");
        }
        return res;
    }

    static class Patient {
        String name;
        int severity;

        public Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }
    }

    public static List<String> triage(List<Patient> patients) {
        PriorityQueue<Patient> pq = new PriorityQueue<>((a, b) -> b.severity - a.severity);
        pq.addAll(patients);
        List<String> order = new ArrayList<>();
        while (!pq.isEmpty()) order.add(pq.poll().name);
        return order;
    }

    static class StackUsingQueues {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) q2.add(q1.remove());
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            return q1.remove();
        }

        public int top() {
            return q1.peek();
        }
    }

    static class CircularBuffer {
        int[] buffer;
        int size, start = 0, count = 0;

        public CircularBuffer(int size) {
            this.size = size;
            buffer = new int[size];
        }

        public void insert(int x) {
            buffer[(start + count) % size] = x;
            if (count < size) count++;
            else start = (start + 1) % size;
        }

        public List<Integer> getBuffer() {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < count; i++) res.add(buffer[(start + i) % size]);
            return res;
        }
    }
}
