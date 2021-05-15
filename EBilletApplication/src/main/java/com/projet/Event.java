package com.projet;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Event implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id_event;
	private String name;
	private String localisation;
	private String date;
	private String type;
	private String description;
	
//	@OneToMany(mappedBy="event",fetch=FetchType.LAZY )
//	private Collection<Reservation> reservations;

	
	 public Event() {
		// TODO Auto-generated constructor stub
	}

public Event(String name, String localisation, String date, String type, String details) {
	super();
	this.name = name;
	this.localisation = localisation;
	this.date = date;
	this.type = type;
	this.description = details;
}

public Long getId_event() {
	return id_event;
}

public void setId_event(Long id_event) {
	this.id_event = id_event;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLocalisation() {
	return localisation;
}

public void setLocalisation(String localisation) {
	this.localisation = localisation;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getDetails() {
	return description;
}

public void setDetails(String details) {
	this.description = details;
}
	

	

}
