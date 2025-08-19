package edu.service.impl;

import edu.model.entity.User;
import edu.repo.UserRepo;
import edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User findByUserNameAndPassword(String name, String password) {
        return userRepo.findByUserNameAndPassword(name, password)
                .orElse(null);
    }
}
