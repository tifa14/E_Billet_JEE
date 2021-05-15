package com.projet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.lastName = :lastName")
	    public User getUserByUsername(@Param("lastName") String username);
	

}
