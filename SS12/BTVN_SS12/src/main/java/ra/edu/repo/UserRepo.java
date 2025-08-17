package ra.edu.repo;

import ra.edu.model.User;

import java.util.List;

public interface UserRepo {

    void save(User user);

    User findById(Long id);

    User findByEmail(String email);

    List<User> findAll();

    void update(User user);

    List<User> findAllFriend(Long id);
}
