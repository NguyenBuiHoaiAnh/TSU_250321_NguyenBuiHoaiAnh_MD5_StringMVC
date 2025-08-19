package edu.repo;

import edu.model.entity.Category;
import edu.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    // Tìm theo tên (không phân biệt hoa thường)
    List<Product> findByProductNameContainingIgnoreCase(String keyword);

    // Tìm theo category
    List<Product> findByCategory(Category category);

    // Tìm theo cả tên và category
    List<Product> findByProductNameContainingIgnoreCaseAndCategory(String keyword, Category category);
}
