class Friend {
    String name;
    Friend next;

    public Friend(String name) {
        this.name = name;
        this.next = null;
    }
}

public class FriendCircle {
    Friend head = null;

    public void addFriend(String name) {
        Friend newFriend = new Friend(name);
        if (head == null) {
            head = newFriend;
            newFriend.next = head;
        } else {
            Friend temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newFriend;
            newFriend.next = head;
        }
        System.out.println("Added to circle: " + name);
    }

    public void removeFriend(String name) {
        if (head == null) return;

        Friend current = head, prev = null;

        do {
            if (current.name.equals(name)) {
                if (current == head && head.next == head) {
                    head = null;
                } else {
                    if (current == head) {
                        Friend last = head;
                        while (last.next != head)
                            last = last.next;
                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = current.next;
                    }
                }
                System.out.println("Removed: " + name);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void displayFriends() {
        if (head == null) {
            System.out.println("Circle empty.");
            return;
        }
        Friend temp = head;
        do {
            System.out.println("👥 " + temp.name);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        FriendCircle fc = new FriendCircle();
        fc.addFriend("Alankrati");
        fc.addFriend("Muskaan");
        fc.addFriend("Shivang");
        fc.displayFriends();
        fc.removeFriend("Muskaan");
        fc.displayFriends();
    }
}
