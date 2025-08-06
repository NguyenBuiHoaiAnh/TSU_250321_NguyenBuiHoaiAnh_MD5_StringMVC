package ra.edu.model;

public class UserLogin {
    private static User user = null;

    public static User getUser() {
        return user;
    }

    public static void setUser(User u) {
        user = u;
    }

    public static boolean isLoggedIn() {
        return user != null;
    }

    public static void logout() {
        user = null;
    }
}
