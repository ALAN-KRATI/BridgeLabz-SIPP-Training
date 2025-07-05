class Node {
    int val;
    Node next, random;
    Node(int val) { this.val = val; }
}

class DeepCopyRandomList {
    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while (current != null) {
            Node copy = map.get(current);
            copy.next = map.get(current.next);
            copy.random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node copied = copyRandomList(node1);
        while (copied != null) {
            System.out.print("Value: " + copied.val);
            if (copied.random != null)
                System.out.print(", Random: " + copied.random.val);
            System.out.println();
            copied = copied.next;
        }
    }
}
