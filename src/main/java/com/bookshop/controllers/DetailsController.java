package com.bookshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.model.Detail;
import com.bookshop.service.DetailService;

@RestController
public class DetailsController {
	
	@Autowired
	private DetailService detailService;

	public DetailsController() {
		super();
	}

	@Autowired
	public DetailsController(DetailService detailService) {
		super();
		this.detailService = detailService;
	}
	
	@GetMapping(path = "/details")  //Works
	public List<Detail> getAllDetails(){
		return detailService.getAllDetails();
	}
	
	@PutMapping(path = "/details/{detailId}")  
	public Detail updateDetail(@RequestBody Detail detail, @PathVariable long detailId) {
		return detailService.updateDetail(detailId, detail);
	}
	
	@GetMapping(path = "/details/{detailId}") //Works
	public Detail getDetail(@PathVariable long detailId) {
		return detailService.getDetail(detailId);
	}
	
	@PostMapping("/details")  //works
	public Detail saveDetail(@RequestBody Detail detail) {
		return detailService.saveDetail(detail, detail.getId());
	}
	
	@DeleteMapping(path = "/details/{detailId}") //Works
	public Detail removeDetail(@PathVariable long detailId) {
		return detailService.removeDetail(detailId);
	}

}
