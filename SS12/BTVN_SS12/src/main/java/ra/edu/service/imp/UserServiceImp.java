package ra.edu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import ra.edu.model.User;
import ra.edu.repo.UserRepo;
import ra.edu.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public void register(User user) {
        userRepo.save(user);
    }

    @Override
    public User login(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void update(User user) {
        userRepo.update(user);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void addFriend(User currentUser, User friend) {
        if (!currentUser.getFriends().contains(friend)) {
            currentUser.getFriends().add(friend);
            friend.getFriends().add(currentUser);
            userRepo.update(currentUser);
            userRepo.update(friend);
        }
    }

    @Override
    public List<User> findAllFriend(Long id) {
        return userRepo.findAllFriend(id);
    }
}
