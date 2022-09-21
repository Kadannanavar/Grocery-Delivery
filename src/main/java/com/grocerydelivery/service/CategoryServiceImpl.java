package com.grocerydelivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerydelivery.entity.Category;
import com.grocerydelivery.exception.CategoryNotFoundException;
import com.grocerydelivery.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
    private CategoryRepository categoryRepo;



   @Override
    public Category addCategory(Category category) throws CategoryNotFoundException {
        
        return this.categoryRepo.save(category);
    }


    @Override
    public Category updateCategory(Category category) throws CategoryNotFoundException {
        Optional<Category> categoryOpt = this.categoryRepo.findById(category.getCategoryId());
        if (categoryOpt.isEmpty())
            throw new CategoryNotFoundException("Category id does not exist to update.");



       Category updateCategory = categoryOpt.get();
        updateCategory.setCategoryName(category.getCategoryName());
        return this.categoryRepo.save(updateCategory);
    }


    @Override
    public Category getCategoryById(Integer id) throws CategoryNotFoundException {



       Optional<Category> categoryOpt = this.categoryRepo.findById(id);
        if (categoryOpt.isEmpty())
            throw new CategoryNotFoundException("Category Not Found");



       return categoryOpt.get();
    }

    @Override
    public void deleteCategoryById(Integer categoryId) throws CategoryNotFoundException {
          Optional<Category> categoryOpt1 = this.categoryRepo.findById(categoryId);
          if(categoryOpt1.isEmpty())
              throw new CategoryNotFoundException("Category Not Found");
        this.categoryRepo.deleteById(categoryId);
    }

    @Override
    public List<Category> getAllCategory() {
        return this.categoryRepo.findAll();
       
    }
}

