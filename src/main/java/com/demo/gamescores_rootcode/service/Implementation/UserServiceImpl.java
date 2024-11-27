package com.demo.gamescores_rootcode.service.Implementation;

import com.demo.gamescores_rootcode.Repository.UserRepository;
import com.demo.gamescores_rootcode.model.User;
import com.demo.gamescores_rootcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    private static final String emailRegex = "^\\S+@\\S+\\.\\S+$";

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        if(user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("User should have an email.");
        }

        Pattern pattern = Pattern.compile(emailRegex);
        if(!pattern.matcher(user.getEmail()).matches()) {
            throw new IllegalArgumentException("Invalid email provided.");
        }

        userRepository.findByEmail(user.getEmail()).ifPresent(u -> {
            throw new IllegalArgumentException("User with email already exists.");
        });

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        //Pagination can be done here to optimize responses
        return userRepository.findAll();
    }
}
