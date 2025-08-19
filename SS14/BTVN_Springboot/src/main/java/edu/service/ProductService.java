package edu.service;

import edu.model.entity.Category;
import edu.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    List<Product> searchAndFilter(String keyword, Long categoryId);

    Product findById(Long id);

    Product save(Product product);

    void deleteProduct(Product product);
}
