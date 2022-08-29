package com.mytv.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mytv.app.model.User;

public interface UserRepository extends CrudRepository<User, String> {
	
	@Query("SELECT u FROM User u WHERE u.id = :id")
	 Optional<User> getUserById(int id);
	
	@Query("SELECT u FROM User u WHERE u.email = :email")
	List<User> getUserByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.fname = :fname")
	List<User> getUserByfName(String fname);
	
	@Query("SELECT u FROM User u WHERE u.lname = :lname")
	List<User> getUserBylName(String lname);
	
	@Query("SELECT u FROM User u WHERE u.service = :service")
	List<User> getUserByService(String service);

}
