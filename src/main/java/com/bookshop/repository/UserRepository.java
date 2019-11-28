package com.bookshop.repository;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.bookshop.model.Customer;
import com.bookshop.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
