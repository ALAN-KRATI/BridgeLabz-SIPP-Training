class Employee {
    void generateTimetable() {
        System.out.println("Generic timetable");
    }
}
class Teacher extends Employee {
    void generateTimetable() {
        System.out.println("Teacher: Maths, Science periods.");
    }
}
class LabAssistant extends Employee {
    void generateTimetable() {
        System.out.println("Lab Assistant: Physics Lab schedule.");
    }
}
class Coach extends Employee {
    void generateTimetable() {
        System.out.println("Coach: PE and Sports schedule.");
    }
}
class TimeTableGenerator {
    public static void main(String[] args) {
        Employee[] staff = {
            new Teacher(),
            new LabAssistant(),
            new Coach()
        };
        for (Employee emp : staff) {
            emp.generateTimetable();
        }
    }
}