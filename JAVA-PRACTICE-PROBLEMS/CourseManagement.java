class User {
    void showDashboard() {
        System.out.println("Generic User Dashboard");
    }
}
class Student extends User {
    void showDashboard() {
        System.out.println("Student Dashboard: Assignments, Grades");
    }
}
class Instructor extends User {
    void showDashboard() {
        System.out.println("Instructor Dashboard: Courses, Submissions");
    }
}
class CourseManagement {
    public static void main(String[] args) {
        User[] users = {
            new Student(),
            new Instructor()
        };
        for (User u : users) {
            u.showDashboard();
        }
    }
}