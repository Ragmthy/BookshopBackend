package com.bookshop.model;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customId;  //Default is AUTO strategy
	//private String role;
	private String name;
	private String email;
	private String address;
	private String city;
	private String country;
	private Date customerRegisterOn;
	private String password;
	private String phoneNumber;
	private String zipcode;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Review> reviews;
	
	/*@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Order> orders;*/
	
	public Customer() {
		super();
	}
	
	

	public Customer(long customId) {
		super();
		this.customId = customId;
	}

	//Without ID
	public Customer(String name, String email, String address, String city, String country,
			Date customerRegisterOn, String password, String phoneNumber, String zipcode) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.city = city;
		this.country = country;
		this.customerRegisterOn = customerRegisterOn;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.zipcode = zipcode;
	}
	
	//With ID
	public Customer(long customId, String name, String email, String address, String city, String country,
			Date customerRegisterOn, String password, String phoneNumber, String zipcode) {
		super();
		this.customId = customId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.city = city;
		this.country = country;
		this.customerRegisterOn = customerRegisterOn;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.zipcode = zipcode;
	}
	//Getters and Setters
	public long getCustomId() {
		return customId;
	}
	public void setCustomId(long customId) {
		this.customId = customId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getCustomerRegisterOn() {
		return customerRegisterOn;
	}
	public void setCustomerRegisterOn(Date customerRegisterOn) {
		this.customerRegisterOn = customerRegisterOn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
}