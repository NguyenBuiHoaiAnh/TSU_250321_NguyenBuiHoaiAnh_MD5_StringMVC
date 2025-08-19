package edu.service;

import edu.model.entity.User;

import java.util.Optional;

public interface UserService {

    // Login
    User findByUserNameAndPassword(String name, String password);
}
