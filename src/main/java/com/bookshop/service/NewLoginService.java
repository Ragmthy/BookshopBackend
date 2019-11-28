package com.bookshop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.model.NewLogin;

import com.bookshop.repository.NewLoginRepository;

@Service
@Transactional
public class NewLoginService {
	
	private NewLoginRepository loginRepo;
	
	//Generate out the Constructors
	public NewLoginService() {
		super();
	}
	
	@Autowired
	public NewLoginService(NewLoginRepository loginRepo) {
		super();
		this.loginRepo = loginRepo;
	}
	
	//Functionalities: find the logins, getlogin by table id, get login by ISBN unique string
	//adding or updating login details, saving login and deleting login
	public List<NewLogin> findAllNewLogins(){
		List<NewLogin> logins = loginRepo.findAll();
		return logins;
	}
	
	public NewLogin findById(Long loginid) {
		Optional<NewLogin> optionalLogin = loginRepo.findById(loginid);
		if(optionalLogin.isPresent()) {
			return optionalLogin.get();
		}
		else return null;
	}
	
	
	public NewLogin addOrUpdateNewLogin(NewLogin login, long loginId) {
		Optional<NewLogin> optionalLogin = loginRepo.findById(loginId);
		if(optionalLogin.isPresent()) {
			NewLogin loginToBeUpdated = optionalLogin.get();
			
			loginToBeUpdated.setEmail(login.getEmail());
			loginToBeUpdated.setLoginId(login.getLoginId());
			loginToBeUpdated.setLoginTime(login.getLoginTime());
			loginToBeUpdated.setLogoutTime(login.getLogoutTime());
			
			return loginToBeUpdated;
		}
		
		return null;
	}
	
	public NewLogin saveNewLogin(NewLogin login, long id) {
		return loginRepo.save(login);
	}
	
	public NewLogin deleteNewLogin(long id) {
		Optional<NewLogin> optionalLogin =  loginRepo.findById(id);
		if(optionalLogin.isPresent()) {
			loginRepo.delete(optionalLogin.get());
			return optionalLogin.get();
		}
		else return null;
	}

}
