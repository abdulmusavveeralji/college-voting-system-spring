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
    public User updateUSer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUSer'");
    }

    @Override
    public User getUser() {
        // TODO Auto-generated method stub
        return userRepository.findAll().get(0);
    }

    @Override
    public User deleteUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
}
