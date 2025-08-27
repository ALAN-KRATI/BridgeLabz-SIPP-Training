import java.io.Serializable;

class Employee implements Serializable {
    String name;
    Employee(String name) { this.name = name; }
}

public class BackupDemo {
    public static void main(String[] args) {
        Employee e = new Employee("John");
        System.out.println("Serializable object created: " + e.name);
    }
}
