package com.projet;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface EventRepository extends  JpaRepository<Event, Long>{
	@Query("SELECT e FROM Event e WHERE CONCAT(e.name,' ', e.localisation,' ', e.date,' ', e.type) LIKE %?1%")
	public List<Event> search(String keyword);
	
	@Query("SELECT e FROM Event e WHERE e.date between :x and :y")
	public List<Event> searchDate(@Param("x") LocalDate date1,@Param("y") LocalDate date2);
	
	@Query("SELECT e FROM Event e WHERE e.date between :x and :y")
	public List<Event> searchDat(@Param("x") String date1,@Param("y") String date2);

	

	
	
}
