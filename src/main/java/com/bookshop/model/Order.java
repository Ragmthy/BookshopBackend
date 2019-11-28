package com.bookshop.model;


import com.bookshop.model.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;

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

@Entity
@Table(name = "BookshopOrders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long orderId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;
	
	private Date orderDate;
	private float total;
	private String shippingStatus;
	private String shippingAddress;
	private String payment;	
	private String recipientName;
	private String recipientNum;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonBackReference(value = "detail")  //referring to the table name
	private List<Detail> orderDetails;

	public Order(long orderId, Customer customer, Date orderDate, float total, String shippingStatus, String shippingAddress,
			String payment, String recipientName, String recipientNum, List<Detail> orderDetails) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.total = total;
		this.shippingStatus = shippingStatus;
		this.shippingAddress = shippingAddress;
		this.payment = payment;
		this.recipientName = recipientName;
		this.recipientNum = recipientNum;
		this.orderDetails = orderDetails;
	}

	public Order(Customer customer, Date orderDate, float total, String shippingStatus, String shippingAddress, String payment,
			String recipientName, String recipientNum, List<Detail> orderDetails) {
		super();
		this.customer = customer;
		this.orderDate = orderDate;
		this.total = total;
		this.shippingStatus = shippingStatus;
		this.shippingAddress = shippingAddress;
		this.payment = payment;
		this.recipientName = recipientName;
		this.recipientNum = recipientNum;
		this.orderDetails = orderDetails;
	}

	public Order(long orderId) {
		super();
		this.orderId = orderId;
	}

	public Order() {
		super();
	}

	public long getOrderid() {
		return orderId;
	}

	public void setOrderid(long orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientNum() {
		return recipientNum;
	}

	public void setRecipientNum(String recipientNum) {
		this.recipientNum = recipientNum;
	}

	public List<Detail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<Detail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	
}
