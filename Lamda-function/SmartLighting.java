@FunctionalInterface
interface LightAction {
    void execute();
}

public class SmartLighting {
    public static void main(String[] args) {
        LightAction motionTrigger = () -> System.out.println("Lights turned ON due to motion.");
        LightAction nightTrigger = () -> System.out.println("Lights dimmed for bedtime.");
        LightAction voiceTrigger = () -> System.out.println("Voice command: Party mode activated!");

        motionTrigger.execute();
        nightTrigger.execute();
        voiceTrigger.execute();
    }
}
