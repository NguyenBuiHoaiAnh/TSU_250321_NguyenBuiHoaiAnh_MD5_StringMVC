package ra.edu.service;

import ra.edu.model.Seed;
import ra.edu.model.User;
import ra.edu.repo.GameRepository;

import java.util.List;

public class GameService {
    public boolean register(User user) throws Exception {
        if (GameRepository.usernameExists(user.getUsername())) return false;
        GameRepository.saveUser(user);
        return true;
    }

    public User login(String username, String password) throws Exception {
        return GameRepository.checkLogin(username, password);
    }

    public List<Seed> getSeeds() throws Exception {
        return GameRepository.getAllSeeds();
    }
}
