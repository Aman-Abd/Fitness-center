package com.example.fitness_center.service;

import com.example.fitness_center.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User findByUsername(String username);
    void createUser(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
    List<User> allUsers();
    List<User> userGetList(Long id);
}
