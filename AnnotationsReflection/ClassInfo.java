import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

class ClassInfo {
    public static void main(String[] args) throws Exception {
        String className = "java.util.ArrayList"; /
        Class<?> clazz = Class.forName(className);

        System.out.println("Class: " + clazz.getName());

        System.out.println("\n--- Methods ---");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(m);
        }

        System.out.println("\n--- Fields ---");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println(f);
        }

        System.out.println("\n--- Constructors ---");
        for (Constructor<?> c : clazz.getDeclaredConstructors()) {
            System.out.println(c);
        }
    }
}

class Person {
    private int age = 25;
}

class PrivateFieldExample {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);

        System.out.println("Old Age: " + field.get(p));
        field.set(p, 30);
        System.out.println("New Age: " + field.get(p));
    }
}

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

class PrivateMethodExample {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);

        int result = (int) method.invoke(calc, 6, 7);
        System.out.println("Multiply Result: " + result);
    }
}


class Student {
    String name;
    public Student() { this.name = "Default Student"; }
    public String toString() { return "Student{name='" + name + "'}"; }
}

class DynamicObjectExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Student");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        System.out.println(obj);
    }
}


