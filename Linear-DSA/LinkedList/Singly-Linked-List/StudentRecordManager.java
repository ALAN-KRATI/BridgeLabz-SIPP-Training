class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManager {
    Student head = null;

    public void addAtBeginning(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newStudent;
    }

    public void addAtPosition(int pos, int roll, String name, int age, char grade) {
        if (pos <= 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        Student newStudent = new Student(roll, name, age, grade);
        Student temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++)
            temp = temp.next;
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteByRoll(int roll) {
        if (head == null) return;
        if (head.rollNumber == roll) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != roll)
            temp = temp.next;
        if (temp.next == null) {
            System.out.println("Roll number not found.");
            return;
        }
        temp.next = temp.next.next;
    }

    public void searchByRoll(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Found: " + temp.name + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Roll number not found.");
    }

    public void updateGrade(int roll, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public void displayAll() {
        Student temp = head;
        if (temp == null) {
            System.out.println("No records.");
            return;
        }
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StudentRecordManager srm = new StudentRecordManager();
        srm.addAtEnd(1, "Alankrati", 20, 'A');
        srm.addAtBeginning(2, "Shivang", 21, 'B');
        srm.addAtPosition(2, 3, "Muskaan", 20, 'A');
        srm.displayAll();
        srm.updateGrade(3, 'S');
        srm.searchByRoll(3);
        srm.deleteByRoll(2);
        srm.displayAll();
    }
}