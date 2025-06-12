package com.sawam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sawam.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}