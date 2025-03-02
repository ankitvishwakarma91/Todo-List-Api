package com.softworkshub.todolistapi.controller;



import com.softworkshub.todolistapi.dto.AuthResponse;
import com.softworkshub.todolistapi.model.Users;
import com.softworkshub.todolistapi.service.AuthService;
import com.softworkshub.todolistapi.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    private final UserService userService;

    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public AuthResponse loginUser(@RequestBody Users user) {
        return authService.authenticate(user.getUsername(), user.getPassword());
    }

}
