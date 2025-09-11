@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class PerformanceTest {
    @LogExecutionTime
    public void task1() throws InterruptedException {
        Thread.sleep(200);
    }

    @LogExecutionTime
    public void task2() throws InterruptedException {
        Thread.sleep(500);
    }
}

class Main8 {
    public static void main(String[] args) throws Exception {
        PerformanceTest pt = new PerformanceTest();
        for (Method m : PerformanceTest.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                m.invoke(pt);
                long end = System.nanoTime();
                System.out.println(m.getName() + " executed in " + (end - start) + " ns");
            }
        }
    }
}
