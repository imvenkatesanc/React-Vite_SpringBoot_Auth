package com.venkycode.auth.Controller;

import com.venkycode.auth.Model.User;
import com.venkycode.auth.Service.UserService;
import com.venkycode.auth.UserDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO userDTO) {
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();
        return userService.registerUser(email, password);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody UserDTO userDTO) {
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();
        return userService.loginUser(email, password);
    }
}

