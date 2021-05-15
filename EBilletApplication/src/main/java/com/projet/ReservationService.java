package com.projet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService {
	
	 @Autowired
	    private ReservationRepo repo;
	     
	    public List<Reservation> findAll() {
	        return repo.findAll();
	    }
	    
	   
	     
	    public void save(Reservation ev) {
	        repo.save(ev);
	    }

}
