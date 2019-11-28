package com.bookshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.service.NewLoginService;

@RestController
public class NewLoginController {
	
	@Autowired
	private NewLoginService loginService;

	public NewLoginController() {
		super();
	}

	public NewLoginController(NewLoginService loginService) {
		super();
		this.loginService = loginService;
	}
	
	
	
	

}
