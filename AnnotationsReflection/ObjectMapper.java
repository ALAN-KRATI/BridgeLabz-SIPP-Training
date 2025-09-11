

class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> props) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> entry : props.entrySet()) {
            try {
                Field f = clazz.getDeclaredField(entry.getKey());
                f.setAccessible(true);
                f.set(obj, entry.getValue());
            } catch (NoSuchFieldException ignored) {}
        }
        return obj;
    }

    static class User {
        String name;
        int age;
        public String toString() { return "User{name='" + name + "', age=" + age + "}"; }
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> props = new HashMap<>();
        props.put("name", "Alice");
        props.put("age", 22);

        User u = toObject(User.class, props);
        System.out.println(u);
    }
}

class JsonGeneratorExample {
    static class Car {
        String brand = "Tesla";
        int year = 2025;
    }

    public static String toJson(Object obj) throws Exception {
        StringBuilder sb = new StringBuilder("{");
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            sb.append("\"").append(f.getName()).append("\":\"").append(f.get(obj)).append("\",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Car car = new Car();
        System.out.println(toJson(car));
    }
}


interface Greeting {
    void sayHello(String name);
}

class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

class LoggingProxyExample {
    public static void main(String[] args) {
        Greeting g = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                (proxy, method, methodArgs) -> {
                    System.out.println("Invoking method: " + method.getName());
                    return method.invoke(new GreetingImpl(), methodArgs);
                }
        );
        g.sayHello("Alankrati");
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class Service {
    void serve() { System.out.println("Service is running..."); }
}

class Client {
    @Inject
    private Service service;

    public void doWork() { service.serve(); }
}

class DI {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        for (Field f : Client.class.getDeclaredFields()) {
            if (f.isAnnotationPresent(Inject.class)) {
                f.setAccessible(true);
                f.set(client, new Service());
            }
        }
        client.doWork();
    }
}


class Task {
    public void fastTask() throws InterruptedException { Thread.sleep(100); }
    public void slowTask() throws InterruptedException { Thread.sleep(500); }
}

class ExecutionTimeExample {
    public static void main(String[] args) throws Exception {
        Task t = new Task();
        for (Method m : Task.class.getDeclaredMethods()) {
            long start = System.nanoTime();
            m.invoke(t);
            long end = System.nanoTime();
            System.out.println(m.getName() + " executed in " + (end - start) + " ns");
        }
    }
}
