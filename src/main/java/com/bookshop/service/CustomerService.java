package com.bookshop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.model.Customer;
import com.bookshop.repository.CustomerRepository;


//Taps on the Book Repository
@Service
@Transactional
public class CustomerService {

	private CustomerRepository customerRepo;
	
	//Constructors
	public CustomerService() {
		super();
	}
	
	@Autowired
	public CustomerService(CustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	// Listing all available Categories
	public List<Customer> findAllCustomers() {
		List<Customer> customers = customerRepo.findAll();
		return customers;
	}



	public Customer findById(long customId) {
		Optional<Customer> optionalCustomer = customerRepo.findById(customId);
		if (optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		} else
			return null;
	}

	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	// Deleting off a Customer
	public Customer removeCustomer(long customId) {
		Optional<Customer> optionalCustomer = customerRepo.findById(customId);
		if (optionalCustomer.isPresent()) {
			customerRepo.delete(optionalCustomer.get());
			return optionalCustomer.get();
		} else
			return null;
	}

	// Adding/Editing a User
	public Customer updateCustomer(long customId, Customer customer) {
		Optional<Customer> optionalCustomer = customerRepo.findById(customId);
		if (optionalCustomer.isPresent()) {
			Customer customerToBeUpdated = optionalCustomer.get();
			customerToBeUpdated.setAddress(customer.getAddress());
			customerToBeUpdated.setCity(customer.getCity());
			customerToBeUpdated.setCountry(customer.getCountry());
			customerToBeUpdated.setCustomerRegisterOn(customer.getCustomerRegisterOn());
			customerToBeUpdated.setEmail(customer.getEmail());
			customerToBeUpdated.setName(customer.getName());
			customerToBeUpdated.setPassword(customer.getPassword());
			customerToBeUpdated.setPhoneNumber(customer.getPhoneNumber());
			customerToBeUpdated.setZipcode(customer.getZipcode());

			return customerToBeUpdated;

		} else
			return null;

	}

}
