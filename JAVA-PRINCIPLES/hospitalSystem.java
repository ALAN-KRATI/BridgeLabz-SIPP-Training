abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private String[] records = new String[5];
    private int recordCount = 0;

    public InPatient(String patientId, String name, int age, int daysAdmitted) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
    }

    public double calculateBill() {
        return daysAdmitted * 2000;
    }

    public void addRecord(String record) {
        if (recordCount < records.length) records[recordCount++] = record;
    }

    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String r : records) {
            if (r != null) System.out.println("- " + r);
        }
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private int consultations;
    private String[] records = new String[5];
    private int recordCount = 0;

    public OutPatient(String patientId, String name, int age, int consultations) {
        super(patientId, name, age);
        this.consultations = consultations;
    }

    public double calculateBill() {
        return consultations * 500;
    }

    public void addRecord(String record) {
        if (recordCount < records.length) records[recordCount++] = record;
    }

    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String r : records) {
            if (r != null) System.out.println("- " + r);
        }
    }
}

public class hospitalSystem {
    public static void main(String[] args) {
        Patient[] patients = {
            new InPatient("P001", "Aditi", 25, 3),
            new OutPatient("P002", "Karan", 30, 2)
        };

        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Total Bill: ₹" + p.calculateBill());

            if (p instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord) p;
                mr.addRecord("Diagnosis: Flu");
                mr.addRecord("Medication: Paracetamol");
                mr.viewRecords();
            }

            System.out.println();
        }
    }
}
