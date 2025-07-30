import java.io.*;

public class StudentBinaryStorage {
    public static void main(String[] args) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("students.dat"))) {
            out.writeInt(1001);
            out.writeUTF("Kritika");
            out.writeDouble(9.1);
        } catch (IOException e) {
            System.out.println("Write failed: " + e.getMessage());
        }

        try (DataInputStream in = new DataInputStream(new FileInputStream("students.dat"))) {
            int roll = in.readInt();
            String name = in.readUTF();
            double gpa = in.readDouble();

            System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
        } catch (IOException e) {
            System.out.println("Read failed: " + e.getMessage());
        }
    }
}
