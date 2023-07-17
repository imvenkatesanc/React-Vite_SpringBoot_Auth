package com.venkycode.auth.Service;

import com.venkycode.auth.Model.User;
import com.venkycode.auth.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String email, String password) {
        // Check if the user with the given email already exists
        if (userRepository.findByEmail(email) != null) {
            throw new IllegalArgumentException("User with this email already exists");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        // Check if the user exists and the password is correct
        if (user == null || !user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        return user;
    }
}

