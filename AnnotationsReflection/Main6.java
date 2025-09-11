@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class DemoImportant {
    @ImportantMethod
    public void method1() {}

    @ImportantMethod(level = "LOW")
    public void method2() {}
}

class Main6 {
    public static void main(String[] args) throws Exception {
        for (Method m : DemoImportant.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = m.getAnnotation(ImportantMethod.class);
                System.out.println(m.getName() + " -> Level: " + im.level());
            }
        }
    }
}