package com.bookshop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.model.Detail;
import com.bookshop.repository.DetailsRepository;



@Service
@Transactional
public class DetailService {
	
	private DetailsRepository detailRepo;

	public DetailService() {
		super();
	}
	
	@Autowired
	public DetailService(DetailsRepository detailRepo) {
		super();
		this.detailRepo = detailRepo;
	}
	

	// Listing all available Categories
	public List<Detail> getAllDetails() {
		return detailRepo.findAll();
	}

	public Detail getDetail(long detailId) {
		Optional<Detail> optionalDetail = detailRepo.findById(detailId);
		if (optionalDetail.isPresent()) {
			return optionalDetail.get();
		} else
			return null;
	}

	public Detail saveDetail(Detail detail, long detailId) {
		return detailRepo.save(detail);
	}

	// Deleting off a Detail
	public Detail removeDetail(long detailId) {
		Optional<Detail> optionalDetail = detailRepo.findById(detailId);
		if (optionalDetail.isPresent()) {
			detailRepo.delete(optionalDetail.get());
			return optionalDetail.get();
		} else
			return null;
	}

	// Adding/Editing a Detail
	public Detail updateDetail(long detailId, Detail detail) {
		Optional<Detail> optionalDetail = detailRepo.findById(detailId);
		if (optionalDetail.isPresent()) {
			Detail detailToBeUpdated = optionalDetail.get();
			detailToBeUpdated.setBook(detail.getBook());
			
			detailToBeUpdated.setId(detail.getId());
		
			detailToBeUpdated.setOrder(detail.getOrder());
			detailToBeUpdated.setQuantity(detail.getQuantity());
			detailToBeUpdated.setSubtotal(detail.getSubtotal());
			return detailToBeUpdated;

		} else
			return null;

	}

}
