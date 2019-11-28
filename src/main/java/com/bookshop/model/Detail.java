package com.bookshop.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail")
public class Detail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long detailId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Order order;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Book book;
	
	
	private int quantity;
	private float subtotal;
	
	
	public Detail() {
		super();
	}


	public Detail(long detailId) {
		super();
		this.detailId = detailId;
	}


	public Detail(Order order, Book book, int quantity, float subtotal) {
		super();
		this.order = order;
		this.book = book;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}


	public Detail(long detailId, Order order, Book book, int quantity, float subtotal) {
		super();
		this.detailId = detailId;
		this.order = order;
		this.book = book;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}


	public long getId() {
		return detailId;
	}


	public void setId(long detailId) {
		this.detailId = detailId;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public float getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
	

	
	
	
	
	
	

}
