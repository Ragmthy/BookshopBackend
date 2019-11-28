package com.bookshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookshop.model.Customer;
import com.bookshop.service.CustomerService;

public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	public CustomerController() {
		super();
	}

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping(path = "/customers")  //Works
	public List<Customer> getAllCustomers(){
		return customerService.findAllCustomers();
	}
	
	@PutMapping(path = "/customers/{customId}")  //Works
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable long customId) {
		return customerService.updateCustomer(customId, customer);
	}
	
	@GetMapping(path = "/customers/{customId}")  //works
	public Customer getCustomer(@PathVariable long customId) {
		return customerService.findById(customId);
	}
	
	@PostMapping("/customers") //works
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@DeleteMapping(path = "/customers/{customId}")
	public Customer removeCustomer(@PathVariable long customId) {
		return customerService.removeCustomer(customId);
	}
		
}
