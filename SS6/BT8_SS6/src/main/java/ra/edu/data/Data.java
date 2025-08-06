package ra.edu.data;

import java.sql.Connection;
import java.sql.DriverManager;


public class Data {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/bt8_ss6";
        String user = "root";
        String pass = "12345678";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }
}
