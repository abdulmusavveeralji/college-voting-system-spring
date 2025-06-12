package com.sawam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sawam.Service.UserService;
import com.sawam.entity.User;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class UserController {
    
    @Autowired
    private UserService userService;


    @PostMapping("/validateUser")
    public ResponseEntity<Boolean> postMethodName(@RequestBody User entity) {
        System.out.println(entity.toString());
        return ResponseEntity.ok(userService.validateUser(entity));
    }
    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody User entity) {
        System.out.println(entity.toString());
        return ResponseEntity.ok(userService.addUser(entity));
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User entity) {
        //TODO: process PUT request
        User user = userService.updateUser(entity);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id) {
        //TODO: process PUT request
        userService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    
    
    
}
