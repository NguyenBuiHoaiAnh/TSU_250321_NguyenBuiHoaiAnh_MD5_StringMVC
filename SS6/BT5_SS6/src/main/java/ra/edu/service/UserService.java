package ra.edu.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ra.edu.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            users.add(new User("Người dùng " + i, 20 + i, new Date(), "user" + i + "@gmail.com", "090123456" + i));
        }
        return users;
    }
}
