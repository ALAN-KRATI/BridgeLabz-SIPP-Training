public class BackgroundJob {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Executing background task");
        new Thread(task).start();
    }
}
