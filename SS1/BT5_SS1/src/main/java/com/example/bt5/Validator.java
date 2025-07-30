package com.example.bt5;

import java.util.regex.Pattern;

public class Validator {
    private static String emailregex = "^\\w{3,}@\\w{3,}.(com|vn)$";
    private static String passregex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&^#()_+=\\-])[A-Za-z\\d@$!%*?&^#()_+=\\-]{8,}";

    public static boolean isEmpty(String data) {
        if (data == null || data.trim().isEmpty()) return true;
        else return false;
    }

    public static boolean validateEmail(String email){
        if (Pattern.matches(emailregex, email)) return true;
        else return false;
    }

    public static boolean validatePassword(String password){
        if (Pattern.matches(passregex, password)) return true;
        else return false;
    }
}
