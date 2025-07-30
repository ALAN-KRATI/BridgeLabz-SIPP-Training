import java.util.*;

public class StudentManagementApp {

    static class Student {
        private int id;
        private String name;
        private int age;
        private Set<String> subjects;
        private Map<String, Double> grades;

        public Student(int id, String name, int age, Set<String> subjects, Map<String, Double> grades) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.subjects = subjects;
            this.grades = grades;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public Set<String> getSubjects() { return subjects; }
        public Map<String, Double> getGrades() { return grades; }

        public double getAverageGrade() {
            double total = 0;
            for (Double grade : grades.values()) {
                total += grade;
            }
            return grades.size() > 0 ? total / grades.size() : 0;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Name: " + name + " | Age: " + age +
                   " | Avg Grade: " + String.format("%.2f", getAverageGrade());
        }
    }

    static class StudentManagementSystem {
        private HashMap<Integer, Student> studentMap = new HashMap<>();

        public void addStudent(Student student) {
            if (!studentMap.containsKey(student.getId())) {
                studentMap.put(student.getId(), student);
                System.out.println("Student added successfully.");
            } else {
                System.out.println("Student with this ID already exists!");
            }
        }

        public void removeStudent(int id) {
            if (studentMap.remove(id) != null) {
                System.out.println("Student removed.");
            } else {
                System.out.println("Student not found.");
            }
        }

        public Student searchById(int id) {
            return studentMap.get(id);
        }

        public List<Student> searchByName(String name) {
            List<Student> result = new ArrayList<>();
            for (Student s : studentMap.values()) {
                if (s.getName().equalsIgnoreCase(name)) {
                    result.add(s);
                }
            }
            return result;
        }

        public List<Student> sortByName() {
            List<Student> list = new ArrayList<>(studentMap.values());
            Collections.sort(list, new Comparator<Student>() {
                public int compare(Student s1, Student s2) {
                    return s1.getName().compareToIgnoreCase(s2.getName());
                }
            });
            return list;
        }

        public List<Student> sortByGrade() {
            List<Student> list = new ArrayList<>(studentMap.values());
            Collections.sort(list, new Comparator<Student>() {
                public int compare(Student s1, Student s2) {
                    return Double.compare(s2.getAverageGrade(), s1.getAverageGrade());
                }
            });
            return list;
        }

        public List<Student> findBySubject(String subject) {
            List<Student> result = new ArrayList<>();
            for (Student s : studentMap.values()) {
                if (s.getSubjects().contains(subject)) {
                    result.add(s);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        Set<String> sub1 = new HashSet<>();
        sub1.add("Math");
        sub1.add("Science");
        Map<String, Double> grades1 = new HashMap<>();
        grades1.put("Math", 85.0);
        grades1.put("Science", 90.0);
        Student s1 = new Student(101, "Alankrati", 20, sub1, grades1);
        sms.addStudent(s1);

        Set<String> sub2 = new HashSet<>();
        sub2.add("English");
        sub2.add("Math");
        Map<String, Double> grades2 = new HashMap<>();
        grades2.put("English", 78.0);
        grades2.put("Math", 88.0);
        Student s2 = new Student(102, "Ravi", 21, sub2, grades2);
        sms.addStudent(s2);

        System.out.println("\n Search by ID 101:");
        Student found = sms.searchById(101);
        if (found != null) System.out.println(found);
        else System.out.println("Student not found!");

        System.out.println("\n Search by name 'Ravi':");
        List<Student> foundByName = sms.searchByName("Ravi");
        if (foundByName.isEmpty()) {
            System.out.println("No student found.");
        } else {
            for (Student s : foundByName) System.out.println(s);
        }

        System.out.println("\n Students in subject 'Math':");
        for (Student s : sms.findBySubject("Math")) {
            System.out.println(s);
        }

        System.out.println("\n Sorted by Name:");
        for (Student s : sms.sortByName()) {
            System.out.println(s);
        }

        System.out.println("\n Sorted by Average Grade:");
        for (Student s : sms.sortByGrade()) {
            System.out.println(s);
        }
    }
}
