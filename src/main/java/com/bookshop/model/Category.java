package com.bookshop.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "category")
public class Category {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	//The entity from the Book class
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonBackReference(value = "books")
	private List<Book> books;
	
	
	//Constructor without the fields
	public Category() {
		super();
	}
	
	//Without the id.
	public Category(String name, List<Book> books) {
		super();
		this.name = name;
		this.books = books;
	}
	
	//with all the fields including id
	public Category(long id, String name, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.books = books;
	}
	
	//With Id alone
	public Category(long id) {
		super();
		this.id = id;
	}

	//Getters and Setters for the field
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setCategoryid(long id) {
		this.id = id;
	}
	
}
