package com.bookshop.repository;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookshop.model.Customer;
//import com.bookshop.model.User;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	
	//Customer findByEmail(String email);
	//List<Customer> findAll();
	//Optional<Customer> findById(long userId);

}
