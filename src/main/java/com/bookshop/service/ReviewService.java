package com.bookshop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.model.Book;
import com.bookshop.model.Review;
import com.bookshop.repository.ReviewRepository;

@Service
@Transactional
public class ReviewService {
	
	private ReviewRepository reviewRepo;
	
	//Constructors
	public ReviewService() {
		super();
	}
	
	@Autowired
	public ReviewService(ReviewRepository reviewRepo) {
		super();
		this.reviewRepo = reviewRepo;
	}
	
	//Methods
	public List<Review> getAllReviews() {
		return reviewRepo.findAll();
	}
	
	// Deleting off a Review
	public Review removeReview(long reviewId) {
		Optional<Review> optionalReview = reviewRepo.findById(reviewId);
		if (optionalReview.isPresent()) {
			reviewRepo.delete(optionalReview.get());
			return optionalReview.get();
		} else
			return null;
	}
	
	//Saving in a Review
	public Review saveReview(Review review, long reviewId) {
		return reviewRepo.save(review);
	}
	
	//Find Review By Particular ID
	public Review findById(Long reviewId) {
		Optional<Review> optionalReview = reviewRepo.findById(reviewId);
		if(optionalReview.isPresent()) {
			return optionalReview.get();
		}
		else return null;
	}
	
	//Updating a Review
	public Review updateReview(Review review, long reviewId) {
		Optional<Review> optionalReview = reviewRepo.findById(reviewId);
		if(optionalReview.isPresent()) {
			Review reviewToBeUpdated = optionalReview.get();
			reviewToBeUpdated.setBook(review.getBook());
			reviewToBeUpdated.setComments(review.getComments());
			reviewToBeUpdated.setCustomer(review.getCustomer());
			reviewToBeUpdated.setHeadline(review.getHeadline());
			reviewToBeUpdated.setRating(review.getRating());
			reviewToBeUpdated.setReviewId(review.getReviewId());
			reviewToBeUpdated.setReviewTime(review.getReviewTime());
			
			
			return reviewToBeUpdated;
			
		} else return null;
		
	}
	
	

}
