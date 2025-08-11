import java.util.*;

public class Validate {

    public static boolean isValidUsername(String username){
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        return username.matches(regex);
    }

    public static boolean isValidLincensePlate(String plate){
        String regex = "^[A-Z]{2}\\d{2}[A-Z][0-9]{4}$";
        return plate.matches(regex);
    }

    public static boolean isValidHexColor(String hex){
        String regex - "^[#][A-fa-f0-9]{6}$";
        return hex.matches(regex);
    }

    public static void main(String[] args) {
       
        System.out.println(isValidUsername("user_123")); 
        System.out.println(isValidUsername("123user")); 
        System.out.println(isValidUsername("us"));       

     
        System.out.println(isValidLicensePlate("AB1234")); 
        System.out.println(isValidLicensePlate("A12345")); 

      
        System.out.println(isValidHexColor("#FFA500")); 
        System.out.println(isValidHexColor("#ff4500")); 
        System.out.println(isValidHexColor("#123"));    
    }
}