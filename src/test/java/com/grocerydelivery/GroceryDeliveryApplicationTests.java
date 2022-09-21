package com.grocerydelivery;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grocerydelivery.entity.Category;
import com.grocerydelivery.exception.CategoryNotFoundException;
import com.grocerydelivery.service.CategoryService;

@SpringBootTest
class GroceryDeliveryApplicationTests {

	@Autowired
	private CategoryService categoryService;

	@Test
	void addCategoryTest() throws CategoryNotFoundException {
		Category category = new Category(7,"Mango", null);
		Category testCategory = this.categoryService.addCategory(category);
		assertNotNull(testCategory);// it should return newly added customer object
		// remove test data
	}

	@Test
	void updateCategoryTest() {
		Category category = new Category(45, "TestName", null);

		assertThrows(CategoryNotFoundException.class, () -> this.categoryService.updateCategory(category));

	}

	@Test
	void getCategoryById() {
		Category category = new Category(45, "TestName", null);

		assertThrows(CategoryNotFoundException.class, () -> this.categoryService.getCategoryById(45));
	}

	@Test
	void deleteCategoryById() {

		assertThrows(CategoryNotFoundException.class, () -> this.categoryService.deleteCategoryById(45));
	}

	@Test
	void getAllCategory() {
		this.categoryService.getAllCategory();
	}
}