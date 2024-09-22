package com.ccallazans.springlambda.service;

import com.ccallazans.springlambda.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final DynamoClient dynamoClient;

    public User createUser(String email) {
        log.info("Creating user with email: {}", email);
        var user = new User(
                UUID.randomUUID(),
                email,
                LocalDateTime.now());

        dynamoClient.saveUser(user);

        return user;
    }

    public List<User> getAll() {
        log.info("Getting all users");
        return dynamoClient.getAllUsers();
    }
}
