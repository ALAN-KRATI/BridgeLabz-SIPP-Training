import java.io.*;

public class ConsoleInputToFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("user_data.txt")) {

            System.out.print("Enter name: ");
            String name = reader.readLine();

            System.out.print("Enter age: ");
            String age = reader.readLine();

            System.out.print("Fav programming language: ");
            String lang = reader.readLine();

            writer.write(name + "\n" + age + "\n" + lang);
            System.out.println("Info saved ✅");
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
