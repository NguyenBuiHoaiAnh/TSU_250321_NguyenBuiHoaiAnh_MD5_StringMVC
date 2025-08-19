package edu.service;

import edu.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category save(Category category);

}
