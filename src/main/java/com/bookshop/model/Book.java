package com.bookshop.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



//Make a unique ID each time a book goes up 
//Set the last update time for a new book
@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) long bookId;
	private String title;
	private String author;
	private String description;
	private String isbnNum;
	private String image; 
	
	private float price;
	private Date publishDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category; 	//One Category to one movie
	
	@OneToMany(mappedBy="book", cascade = CascadeType.ALL)
	@JsonBackReference(value = "review")
	private List<Review> reviews;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	@JsonBackReference(value = "details")
	private List<Detail> details;
	
	//Plain old Constructor
	public Book() {
		super();
	}
	
	//Constructor of book with all the fields
	public Book(Category category, String title, String author, String description, String isbnNum, String image, float price,
			Date publishDate) {
		super();
		this.category = category;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbnNum = isbnNum;
		this.image = "Bookshop/src/main/resources/static/BB8.jpg";
		this.price = price;
		this.publishDate = publishDate;
	}
	
	
	//Constructor with ID
	public Book(long bookId, String title, String author, String description, String isbnNum, float price, Date publishDate,
			Category category) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbnNum = isbnNum;
		this.image = "Bookshop/src/main/resources/static/images/BB8.jpg";
		this.price = price;
		this.publishDate = publishDate;
		this.category = category;
	}
	
	//Plain Constructor with ID alone
	public Book(long bookId) {
		super();
		this.bookId = bookId;
	}
	
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getIsbnNum() {
		return isbnNum;
	}
	public void setIsbnNum(String isbnNum) {
		this.isbnNum = isbnNum;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	
	

}
