package com.demo.gamescores_rootcode.service;

import com.demo.gamescores_rootcode.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
}
