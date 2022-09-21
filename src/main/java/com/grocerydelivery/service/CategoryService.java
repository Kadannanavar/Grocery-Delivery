package com.grocerydelivery.service;

import java.util.List;

import com.grocerydelivery.entity.Category;
import com.grocerydelivery.exception.CategoryNotFoundException;

public interface CategoryService {

	public Category addCategory(Category category) throws CategoryNotFoundException;
    public Category updateCategory(Category category) throws CategoryNotFoundException;
    public Category getCategoryById(Integer id)throws CategoryNotFoundException;
    public void  deleteCategoryById(Integer categoryId)throws CategoryNotFoundException;
    public List<Category> getAllCategory();
}
