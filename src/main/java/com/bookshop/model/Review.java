package com.bookshop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;



//Set it a unique ID, 
//Associate a book object and customer object 
//to the review written

//In addition, the system automatically associates the book and the customer with the review, and assigns
//a unique ID.

@Entity
@Table(name = "review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long reviewId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.EAGER)  //How to use these annotations. is it many reviews to one book?
	private Book book;
	
	
	private float rating;
	private String headline;
	private String comments;
	private Date reviewTime;
	
	
	public Review(long reviewId, Customer customer, Book book, float rating, String headline, String comments,
			Date reviewTime) {
		super();
		this.reviewId = reviewId;
		this.customer = customer;
		this.book = book;
		this.rating = rating;
		this.headline = headline;
		this.comments = comments;
		this.reviewTime = reviewTime;
	}


	public Review(Customer customer, Book book, float rating, String headline, String comments, Date reviewTime) {
		super();
		this.customer = customer;
		this.book = book;
		this.rating = rating;
		this.headline = headline;
		this.comments = comments;
		this.reviewTime = reviewTime;
	}


	public Review(long reviewId) {
		super();
		this.reviewId = reviewId;
	}


	public Review() {
		super();
	}


	public long getReviewId() {
		return reviewId;
	}


	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public String getHeadline() {
		return headline;
	}


	public void setHeadline(String headline) {
		this.headline = headline;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public Date getReviewTime() {
		return reviewTime;
	}


	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
	
	
	
	
}