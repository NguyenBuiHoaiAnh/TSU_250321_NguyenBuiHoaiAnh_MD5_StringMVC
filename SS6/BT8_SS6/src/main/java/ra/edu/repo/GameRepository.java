package ra.edu.repo;

import ra.edu.data.Data;
import ra.edu.model.Seed;
import ra.edu.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    public static boolean usernameExists(String username) throws Exception {
        Connection conn = Data.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public static void saveUser(User user) throws Exception {
        Connection conn = Data.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(username, password, email) VALUES (?, ?, ?)");
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.executeUpdate();
    }

    public static User checkLogin(String username, String password) throws Exception {
        Connection conn = Data.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setBalance(rs.getDouble("balance"));
            return user;
        }
        return null;
    }

    public static List<Seed> getAllSeeds() throws Exception {
        List<Seed> seeds = new ArrayList<>();
        Connection conn = Data.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM seeds");
        while (rs.next()) {
            Seed seed = new Seed();
            seed.setId(rs.getInt("id"));
            seed.setSeedsName(rs.getString("seeds_name"));
            seed.setPrice(rs.getDouble("price"));
            seed.setImageUrl(rs.getString("image_url"));
            seeds.add(seed);
        }
        return seeds;
    }
}

