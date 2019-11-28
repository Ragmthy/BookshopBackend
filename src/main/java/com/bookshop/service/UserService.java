package com.bookshop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.model.User;
import com.bookshop.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	private UserRepository userRepo;
	
	//Constructors
	public UserService() {
		super();
	}
	
	@Autowired
	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	// Listing all available Categories
	public List<User> findAllUsers() {
		List<User> users = userRepo.findAll();
		return users;
	}

	public User findById(long UserId) {
		Optional<User> optionalUser = userRepo.findById(UserId);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else
			return null;
	}

	public User saveUser(User user, long UserId) {
		return userRepo.save(user);
	}

	// Deleting off a User
	public User removeUser(long UserId) {
		Optional<User> optionalUser = userRepo.findById(UserId);
		if (optionalUser.isPresent()) {
			userRepo.delete(optionalUser.get());
			return optionalUser.get();
		} else
			return null;
	}

	// Adding/Editing a User
	public User updateUser(long userId, User user) {
		Optional<User> optionalUser = userRepo.findById(userId);
		if (optionalUser.isPresent()) {
			User userToBeUpdated = optionalUser.get();
			
			userToBeUpdated.setEmail(user.getEmail());
			userToBeUpdated.setName(user.getName());
			userToBeUpdated.setPassword(user.getPassword());
			userToBeUpdated.setUserId(user.getUserId());

			return userToBeUpdated;

		} else
			return null;

	}
	
	

}
