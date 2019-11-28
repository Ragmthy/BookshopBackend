package com.bookshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.model.Category;
import com.bookshop.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	public CategoryController() {
		super();
	}

	@Autowired
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@GetMapping(path = "/categorys") //works
	public List<Category> getAllCategorys(){
		return categoryService.getAllCategorys();
	}
	
	@PutMapping(path = "/categorys/{categoryId}") //works
	public Category updateCategory(@RequestBody Category category, @PathVariable long categoryId) {
		return categoryService.updateCategory(categoryId, category);
	}
	
	@GetMapping(path = "/categorys/{categoryId}") //works
	public Category getCategory(@PathVariable long categoryId) {
		return categoryService.findById(categoryId);
	}
	
	@PostMapping("/categorys") //works
	public Category saveCategory(@RequestBody Category category) {
		return categoryService.saveCategory(category, category.getId());
	}
	
	@DeleteMapping(path = "/categorys/{categoryId}") //works
	public Category removeCategory(@PathVariable long categoryId) {
		return categoryService.removeCategory(categoryId);
	}
		
	

}
