package com.projet;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.projet.model.Users;
@Entity
public class Billet implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id_billet;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="id")
	private Users user;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_event")
	private Event event;
	
	public Billet() {
		// TODO Auto-generated constructor stub
	}

	public Billet(Users user, Event event) {
		super();
		this.user = user;
		this.event = event;
	}

	public Long getId_billet() {
		return id_billet;
	}

	public void setId_billet(Long id_billet) {
		this.id_billet = id_billet;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	
	
	

}
