class Student {
    int id;
    String name;
    String department;
    double cgpa;
    Student next, prev;

    public Student(int id, String name, String department, double cgpa) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.cgpa = cgpa;
        this.next = this.prev = null;
    }
}

public class StudentManager {
    Student head = null, tail = null;

    public void addStudent(int id, String name, String dept, double cgpa) {
        Student newStudent = new Student(id, name, dept, cgpa);
        if (head == null) {
            head = tail = newStudent;
            return;
        }
        tail.next = newStudent;
        newStudent.prev = tail;
        tail = newStudent;
    }

    public void removeStudent(int id) {
        Student temp = head;
        while (temp != null && temp.id != id) temp = temp.next;
        if (temp == null) return;
        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public void updateCgpa(int id, double newCgpa) {
        Student temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.cgpa = newCgpa;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayAll() {
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.id + " | " + temp.name + " | " + temp.department + " | CGPA: " + temp.cgpa);
            temp = temp.next;
        }
    }

    public void searchStudent(int id) {
        Student temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println("Found: " + temp.name + " | " + temp.department + " | CGPA: " + temp.cgpa);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        sm.addStudent(1, "Alankrati", "CSE", 9.2);
        sm.addStudent(2, "Shivang", "IT", 8.9);
        sm.displayAll();
        sm.updateCgpa(2, 9.0);
        sm.removeStudent(1);
        sm.searchStudent(2);
    }
}
