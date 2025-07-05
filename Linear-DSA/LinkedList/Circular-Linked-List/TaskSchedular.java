class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    public Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    Task head = null;

    public void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            return;
        }
        Task temp = head;
        while (temp.next != head)
            temp = temp.next;
        temp.next = newTask;
        newTask.next = head;
    }

    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            return;
        }
        Task temp = head;
        while (temp.next != head)
            temp = temp.next;
        newTask.next = head;
        temp.next = newTask;
        head = newTask;
    }

    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos <= 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }
        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;
        newTask.next = temp.next;
        temp.next = newTask;
    }

    public void removeById(int id) {
        if (head == null) return;
        if (head.id == id && head.next == head) {
            head = null;
            return;
        }
        Task temp = head, prev = null;
        do {
            if (temp.id == id) {
                if (temp == head) {
                    Task last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void viewCurrentAndNext() {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }
        System.out.println("Current Task: " + head.name);
        head = head.next;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks in scheduler.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.id + ", Name: " + temp.name + ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        Task temp = head;
        boolean found = false;
        if (head == null) return;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task: " + temp.name + " | Priority: " + priority);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No task with given priority.");
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        ts.addAtEnd(1, "Code", 1, "2025-07-10");
        ts.addAtBeginning(2, "Sleep", 3, "2025-07-05");
        ts.addAtPosition(2, 3, "Dance", 2, "2025-07-06");
        ts.displayAll();
        ts.searchByPriority(2);
        ts.viewCurrentAndNext(); 
        ts.displayAll();
        ts.removeById(2);
        ts.displayAll();
    }
}
