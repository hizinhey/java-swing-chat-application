package Validate;

public class UserValidate {
    public static boolean validatePassword(String pass){
        if (pass.length() < 6) return false;
        return true;
    }

    public static boolean validateUsername(String user){
        if(user.contains(",") || user.contains(".") || user.contains(":") || user.contains(" ")) return false;
        if (user.length() < 6 || user.length() > 50) return false;
        return true;
    }
}
