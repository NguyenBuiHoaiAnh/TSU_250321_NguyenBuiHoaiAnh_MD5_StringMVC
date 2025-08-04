package com.example.btvn.dao;

import com.example.btvn.model.Category;

import java.util.List;

public interface CategoryDAO {
    // Display
    List<Category> getAllCategories();

    // Add
    boolean addCategory(Category category);

    // Update And Delete
    Category getCategoryById(int id);

    boolean updateCategory(Category category);

    boolean deleteCategory(int id);
}
