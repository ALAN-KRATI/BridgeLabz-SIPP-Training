
class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}

class DynamicMethodInvocationExample {
    public static void main(String[] args) throws Exception {
        MathOperations math = new MathOperations();
        String methodName = "multiply"; // change to "add" or "subtract"
        Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
        Object result = method.invoke(math, 10, 5);
        System.out.println(methodName + " result: " + result);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "Alankrati")
class Book {}

class AnnotationExample {
    public static void main(String[] args) {
        if (Book.class.isAnnotationPresent(Author.class)) {
            Author author = Book.class.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        }
    }
}

class Configuration {
    private static String API_KEY = "OLD_KEY";
}

class StaticField {
    public static void main(String[] args) throws Exception {
        Field field = Configuration.class.getDeclaredField("API_KEY");
        field.setAccessible(true);

        System.out.println("Old API_KEY: " + field.get(null));
        field.set(null, "NEW_SECRET_KEY");
        System.out.println("Updated API_KEY: " + field.get(null));
    }
}
