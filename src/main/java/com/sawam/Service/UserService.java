package com.sawam.Service;

import java.util.List;

import com.sawam.entity.User;

public interface UserService {

    public boolean validateUser(User user);
    public User addUser(User user); // Create
    public User getUser(); // Read
    public List<User> getAllUsers();
    public User updateUser(User entity);
    public void deleteUser(int id);
    
}