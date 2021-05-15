package com.projet;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EventService {
	
	 @Autowired
	    private EventRepository repo;
	     

	 
	    public List<Event> findAll() {
	        return repo.findAll();
	    }
	    
	    public List<Event> listAll(String keyword) {
	        if (keyword != null) {
	            return repo.search(keyword);
	        }
	        return repo.findAll();
	    }

	    public Event detail(Long id_event) {
	    	Event e = repo.findById(id_event).orElse(null);		
			if(e == null ) throw new RuntimeException("L'évenemnt n existe pas");
			return e;
		}
	    
	    public List<Event> listEventDate(LocalDate date1,LocalDate date2) {
	        if (date1 != null && date2!=null) {
	            return repo.searchDate(date1, date2);
	        }
	        return repo.findAll();
	    }
	    
	    public List<Event> listEventDat(String date1,String date2) {
	        if (date1 != null && date2!=null) {
	            return repo.searchDat(date1, date2);
	        }
	        return repo.findAll();
	    }
	    
	     
	    public void save(Event ev) {
	        repo.save(ev);
	    }
	     
	    public Event get(Long id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(Long id) {
	        repo.deleteById(id);
	    }

}
