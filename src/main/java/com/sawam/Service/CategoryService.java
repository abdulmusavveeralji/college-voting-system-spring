package com.sawam.Service;

import java.util.List;

import com.sawam.entity.Category;

public interface CategoryService {
    List<Category> getAllCategory();
    Category addategory(Category category);
    void deleteategory(int id);
    Category updateategory(int id, Category category);
}
