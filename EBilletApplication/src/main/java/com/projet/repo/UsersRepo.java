package com.projet.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.projet.model.Users;



public interface UsersRepo extends CrudRepository<Users, Long> {
	
	@Query("SELECT u from Users u Where u.username = :username")
	public Users getUserByUsername(@Param("username") String username);

}
