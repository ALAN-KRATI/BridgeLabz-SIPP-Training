@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement login", assignedTo = "Ravi", priority = "HIGH")
    public void feature1() {}

    @Todo(task = "Optimize database", assignedTo = "Neha")
    public void feature2() {}
}

class Main7 {
    public static void main(String[] args) throws Exception {
        for (Method m : Project.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo todo = m.getAnnotation(Todo.class);
                System.out.println(m.getName() + " -> Task: " + todo.task() + ", Assigned: " + todo.assignedTo() + ", Priority: " + todo.priority());
            }
        }
    }
}
