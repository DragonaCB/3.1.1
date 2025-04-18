package com.example.demo.dao;

import com.example.demo.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUserById(int id);

    void createUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
