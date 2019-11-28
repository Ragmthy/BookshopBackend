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

import com.bookshop.model.Review;

import com.bookshop.service.ReviewService;

@RestController
@CrossOrigin(origins = "http://10.127.149.182:4200")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;

	public ReviewController() {
		super();
	}

	@Autowired
	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}
	
	@GetMapping(path = "/reviews") //Works
	public List<Review> getAllReviews(){
		return reviewService.getAllReviews();
	}
	
	@PutMapping(path = "/reviews/{reviewId}") //Works
	public Review updateReview(@RequestBody Review review, @PathVariable long reviewId) {
		return reviewService.updateReview(review, reviewId);
	}
	
	@GetMapping(path = "/reviews/{reviewId}")  //Works
	public Review getReview(@PathVariable long reviewId) {
		return reviewService.findById(reviewId);
	}
	
	@PostMapping("/reviews") //Works
	public Review saveReview(@RequestBody Review review) {
		return reviewService.saveReview(review, review.getReviewId());
	}
	
	@DeleteMapping(path = "/reviews/{reviewId}") //Works
	public Review removeReview(@PathVariable long reviewId) {
		return reviewService.removeReview(reviewId);
	}
		
	

}
