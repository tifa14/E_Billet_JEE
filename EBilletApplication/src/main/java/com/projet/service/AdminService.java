package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.model.Admin;
import com.projet.repo.AdminRepo;



@Service
public class AdminService {

	@Autowired
	private AdminRepo repo;
	
	public List<Admin> listAll(){
		return repo.findAll();
	}
	
	public void save(Admin ad) {
		repo.save(ad);
	}
	
	public Admin get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
}

