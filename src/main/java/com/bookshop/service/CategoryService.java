package com.bookshop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.model.Category;
import com.bookshop.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {
	
	private CategoryRepository catrepo;
	
	public CategoryService() {
		super();
	}
	
	@Autowired
	public CategoryService(CategoryRepository catrepo) {
		super();
		this.catrepo = catrepo;
	}

	//Listing all available Categories
	public List<Category> getAllCategorys() {
		return catrepo.findAll();
	}
	
	public Category findById(long CategoryId) {
		Optional<Category> optionalCategory =  catrepo.findById(CategoryId);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else return null;
	}
	
	public Category saveCategory(Category Category, long CategoryId) {
		return catrepo.save(Category);
	}
	
	//Deleting off a Category
	public Category removeCategory(long CategoryId) {
		Optional<Category> optionalCategory =  catrepo.findById(CategoryId);
		if(optionalCategory.isPresent()) {
			catrepo.delete(optionalCategory.get());
			return optionalCategory.get();
		}else return null;
	}
	
	//Adding/Editing a category
	public Category updateCategory(long CategoryId, Category Category) {
		Optional<Category> optionalCategory =  catrepo.findById(CategoryId);
		if(optionalCategory.isPresent()) {
			Category CategoryToBeUpdated = optionalCategory.get();
			CategoryToBeUpdated.setName(Category.getName());
			
			return CategoryToBeUpdated;
		}else return null;
	}

}
