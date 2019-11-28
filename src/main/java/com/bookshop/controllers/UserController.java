package com.bookshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.model.Customer;
import com.bookshop.model.User;
import com.bookshop.service.CustomerService;
import com.bookshop.service.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 30)  //Check again
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserController() {
		super();
	}

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping(path = "/users")   //Works 
	public List<User> getAllUsers(){
		return userService.findAllUsers();
	}
	
	@PutMapping(path = "/users/{userId}")  //Works
	public User updateUser(@RequestBody User user, @PathVariable long userId) {
		return userService.updateUser(userId, user);
	}
	
	@GetMapping(path = "/users/{userId}")  //Works
	public User getUser(@PathVariable long userId) {
		return userService.findById(userId);
	}
	
	@PostMapping("/users")  //Works
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user, user.getUserId());
	}
	
	/*@PostMapping("/users/auth")
	public User checkUser(@RequestBody User user) {
		return userService.findById()
	}*/
	
	@DeleteMapping(path = "/users/{userId}")  //Works
	public User removeUser(@PathVariable long userId) {
		return userService.removeUser(userId);
	}
	
	
		
	

}
