package com.sawam.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sawam.Repository.CategoryRepository;
import com.sawam.Service.CategoryService;
import com.sawam.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> getAllCategory() {
        return repository.findAll();
    }

    @Override
    public Category addategory(Category category) {
        return repository.save(category);
    }

    @Override
    public void deleteategory(int id) {
        repository.deleteById(id);
    }

    @Override
    public Category updateategory(int id, Category category) {
        return repository.save(category);
    }
    
}
