package com.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookshop.model.NewLogin;

public interface NewLoginRepository extends JpaRepository<NewLogin, Long> {

}
