package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.projet.User;
import com.projet.model.Admin;
import com.projet.model.Role;
import com.projet.model.Users;
import com.projet.repo.AdminRepo;
import com.projet.repo.RoleRepository;
import com.projet.repo.UsersRepo;



@Service
public class Uservice {

	@Autowired
	private UsersRepo repo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	public List<Users> listAll(){
		return (List<Users>) repo.findAll();
	}
	
	
	
	 public void saveUserWithDefaultRole(Users user) {
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	     String encodedPassword = passwordEncoder.encode(user.getPassword());
	     user.setPassword(encodedPassword);
	      
	     Role roleUser = roleRepo.findByName("User");
	     user.addRole(roleUser);
	     
	     repo.save(user);
	      
	    
	 }
	 
	
	public Users get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
}

