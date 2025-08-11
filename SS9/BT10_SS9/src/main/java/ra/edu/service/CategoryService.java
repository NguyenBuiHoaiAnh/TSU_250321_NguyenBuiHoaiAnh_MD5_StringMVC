package ra.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.Category_EN;
import ra.edu.model.Category_VI;
import ra.edu.repo.CategoryRepo;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category_EN> getCategoriesEN() {
        return categoryRepo.findAllEN();
    }

    public List<Category_VI> getCategoriesVI() {
        return categoryRepo.findAllVI();
    }

    public boolean addCategory(Category_VI categoryVi,Category_EN category) {
        return categoryRepo.addCategory(categoryVi,category);
    }
}
