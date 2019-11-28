package com.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookshop.model.Detail;

public interface DetailsRepository extends JpaRepository<Detail, Long> {

}
