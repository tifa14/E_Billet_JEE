package com.projet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	 @Autowired
	 	private UserRepository userRepo;
	 
	 
	 
	 public void saveUserWithDefaultRole(User user) {
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	     String encodedPassword = passwordEncoder.encode(user.getPassword());
	     user.setPassword(encodedPassword);
	      
	    
	    
	     
	     userRepo.save(user);
	      
	    
	 }
	 
	 public void save(User user) {
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	     String encodedPassword = passwordEncoder.encode(user.getPassword());
	     user.setPassword(encodedPassword);
	     
	     userRepo.save(user);
	 }
	 
	 public List<User> listAll() {
		 return userRepo.findAll();		
	}
	 
	 
	 public User get(Long id)
	 {
		 return userRepo.findById(id).get();
	 }
	 
	
}
