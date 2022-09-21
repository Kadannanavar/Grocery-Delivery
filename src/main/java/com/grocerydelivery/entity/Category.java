package com.grocerydelivery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Category")
public class Category {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;
    
    @NotNull(message = " Name cannot be null.")
    @Size(min = 4, message = " Category name should be of min 4 chars.")
    
    private String categoryName;
    
	private String category;
	
	public Category(Integer categoryId, String categoryName,String category) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.category = category;
	}
	public Category() {
		super();

	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
    
    
}
