package com.sawam.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sawam.Repository.UserRepository;
import com.sawam.Service.UserService;
import com.sawam.entity.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean validateUser(User user) {
        Optional<User> findByUsername = userRepository.findByUsername(user.getUsername());

        if (!findByUsername.isPresent()) return false;
        User userData = findByUsername.get();
        return userData.getPassword().equals(user.getPassword());
    }

    @Override
    public User addUser(User user) {
        User userData = userRepository.save(user);
        return userData;
    }

    @Override
    public User getUser() {
        // TODO Auto-generated method stub
        return userRepository.findAll().get(0);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User entity) {

        Optional<User> get = userRepository.findById(entity.getId());
        User user = get.get();
        user.setFirstname(entity.getFirstname());
        user.setLastname(entity.getLastname());
        user.setUsername(entity.getUsername());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
    
}
