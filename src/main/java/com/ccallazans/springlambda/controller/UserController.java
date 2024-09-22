package com.ccallazans.springlambda.controller;

import com.ccallazans.springlambda.controller.dto.UserDTO;
import com.ccallazans.springlambda.model.User;
import com.ccallazans.springlambda.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        var users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDto) {
        var user = userService.createUser(userDto.email());
        return ResponseEntity.ok(user);
    }
}
