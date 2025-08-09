package ra.edu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.Category;
import ra.edu.repo.CategoryRepo;
import ra.edu.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.getAllCategory();
    }

    @Override
    public boolean checkExistCategoryName(String name) {
        return categoryRepo.checkExistCategoryName(name);
    }

    @Override
    public boolean saveCategory(Category category) {
        return categoryRepo.saveCategory(category);
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryRepo.updateCategory(category);
    }

    @Override
    public boolean deleteCategory(int id) {
        return categoryRepo.deleteCategory(id);
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepo.getCategoryById(id);
    }
}
