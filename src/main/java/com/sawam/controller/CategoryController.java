package com.sawam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sawam.Service.CategoryService;
import com.sawam.entity.Category;

@RestController
@RequestMapping("/api")
public class CategoryController {


    @Autowired
    private CategoryService service;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllVoterss() {
        List<Category> Voters =  service.getAllCategory();
        return ResponseEntity.ok(Voters);
    }

    @PostMapping("/category")
    public ResponseEntity<Category> addVoters(@RequestBody Category Voters) {
        Category response =  service.addategory(Voters);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateVoters(@PathVariable("id") int id, @RequestBody Category Voters) {
        Category response =  service.updateategory(id, Voters);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/category/{id}")
    public ResponseEntity<HttpStatus> deleteVoters(@PathVariable("id") int id) {
        service.deleteategory(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}