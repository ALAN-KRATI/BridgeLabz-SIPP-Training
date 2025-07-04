class FlattenMultilevelDoublyLinkedList {
    static class Node {
        int val;
        Node prev, next, child;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node flatten(Node head) {
        if (head == null) return null;
        Node pseudoHead = new Node(0);
        pseudoHead.next = head;
        flattenDFS(pseudoHead, head);
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    private static Node flattenDFS(Node prev, Node curr) {
        if (curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;

        Node tempNext = curr.next;
        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;
        return flattenDFS(tail, tempNext);
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.child = new Node(3);
        head.next.child.next = new Node(4);
        head.next.child.next.prev = head.next.child;

        Node flat = flatten(head);
        printList(flat);
    }
}
