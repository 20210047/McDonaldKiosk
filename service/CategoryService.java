package service;

import entity.Category;
import repository.CategoryRepository;

import java.util.List;

public class CategoryService {
    private CategoryRepository categoryRepository;

    public List<Category> getCategoryAll() {
        categoryRepository = new CategoryRepository();
        List<Category> categoryList = categoryRepository.findAll();

        return categoryList;
    }
}
