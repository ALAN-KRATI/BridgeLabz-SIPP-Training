class Task {
    String description;
    boolean completed;
    Task next;

    public Task(String description) {
        this.description = description;
        this.completed = false;
        this.next = null;
    }
}

public class TodoList {
    Task head = null;

    public void addTask(String desc) {
        Task newTask = new Task(desc);
        if (head == null) head = newTask;
        else {
            Task temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newTask;
        }
        System.out.println("Added: " + desc);
    }

    public void completeTask(String desc) {
        Task temp = head;
        while (temp != null) {
            if (temp.description.equals(desc)) {
                temp.completed = true;
                System.out.println("Completed: " + desc);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }

    public void removeTask(String desc) {
        if (head == null) return;
        if (head.description.equals(desc)) {
            head = head.next;
            return;
        }
        Task temp = head;
        while (temp.next != null && !temp.next.description.equals(desc)) temp = temp.next;
        if (temp.next != null)
            temp.next = temp.next.next;
    }

    public void showTasks() {
        Task temp = head;
        while (temp != null) {
            System.out.println((temp.completed ? "[✔] " : "[ ] ") + temp.description);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        TodoList tl = new TodoList();
        tl.addTask("Java practice");
        tl.addTask("Dance rehearsal");
        tl.addTask("Call Muskaan");
        tl.showTasks();
        tl.completeTask("Dance rehearsal");
        tl.removeTask("Call Muskaan");
        tl.showTasks();
    }
}