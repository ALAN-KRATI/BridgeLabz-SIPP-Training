@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class BugTracker {
    @BugReport(description = "Null pointer issue")
    @BugReport(description = "Memory leak detected")
    public void process() {}
}

class Main5 {
    public static void main(String[] args) throws Exception {
        Method method = BugTracker.class.getMethod("process");
        BugReport[] reports = method.getAnnotationsByType(BugReport.class);
        for (BugReport br : reports) {
            System.out.println("Bug: " + br.description());
        }
    }
}
