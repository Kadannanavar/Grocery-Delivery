package com.grocerydelivery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocerydelivery.entity.Category;
import com.grocerydelivery.exception.CategoryNotFoundException;
import com.grocerydelivery.service.CategoryService;

@RestController
@RequestMapping
public class CategoryController {
	
	@Autowired
    private CategoryService categoryService;
    
    @PostMapping("category")
    public Category addCategory(@Valid @RequestBody Category category) throws CategoryNotFoundException {
        return this.categoryService.addCategory(category);
    }
    @GetMapping("categories")
    public List<Category> getAllCategory(){
        return this.categoryService.getAllCategory();
    }
    @GetMapping("category/{id}")
    public Category getcategoryById(@PathVariable("id") Integer categoryId ) throws CategoryNotFoundException {
        return this.categoryService.getCategoryById(categoryId);
    }
    @PutMapping("category")
    public Category updateCategory(@Valid @RequestBody Category category) throws CategoryNotFoundException {
        return this.categoryService.updateCategory(category);

   }
    @DeleteMapping("category/{id}")
    public  String deleteCategory(@PathVariable("id") Integer categoryId) throws CategoryNotFoundException {
         this.categoryService.deleteCategoryById(categoryId);
         return "category is deleted";
    }
}

