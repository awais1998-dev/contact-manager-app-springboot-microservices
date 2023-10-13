package com.tech.user_service.service;

import com.tech.user_service.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public User createUser(User user);
    public User getUserById(Long id);
}
