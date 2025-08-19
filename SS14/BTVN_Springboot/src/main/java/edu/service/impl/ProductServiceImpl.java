package edu.service.impl;

import edu.model.entity.Category;
import edu.model.entity.Product;
import edu.repo.CategoryRepo;
import edu.repo.ProductRepo;
import edu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> searchAndFilter(String keyword, Long categoryId) {
        // Nếu cả keyword và categoryId đều null -> trả hết
        if ((keyword == null || keyword.isEmpty()) && categoryId == null) {
            return productRepo.findAll();
        }

        // Nếu chỉ tìm theo keyword
        if (categoryId == null) {
            return productRepo.findByProductNameContainingIgnoreCase(keyword);
        }

        // Nếu chỉ lọc theo category
        Category category = categoryRepo.findById(categoryId).orElse(null);
        if (category == null) {
            return List.of();
        }

        if (keyword == null || keyword.isEmpty()) {
            return productRepo.findByCategory(category);
        }

        // Có cả keyword + category
        return productRepo.findByProductNameContainingIgnoreCaseAndCategory(keyword, category);
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }


    @Override
    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }
}
