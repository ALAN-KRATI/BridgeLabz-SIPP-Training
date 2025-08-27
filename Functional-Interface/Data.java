interface SensitiveData {}

class UserCredentials implements SensitiveData {
    String password;
    UserCredentials(String password) { this.password = password; }
}

public class SensitiveDataDemo {
    public static void main(String[] args) {
        UserCredentials uc = new UserCredentials("secret");
        if (uc instanceof SensitiveData) {
            System.out.println("This class holds sensitive data.");
        }
    }
}
