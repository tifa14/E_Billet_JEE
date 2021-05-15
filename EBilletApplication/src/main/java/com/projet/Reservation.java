package com.projet;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import net.bytebuddy.implementation.bind.annotation.Default;



@Entity
public class Reservation implements Serializable {

	@Id
	@GeneratedValue
	private Long id_reserv;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="id")
	private User user;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_event")
	private Event event;
	private String civilite;
	private String nom;
	private String prenom;
	private int age;
	private double prix;
	@Column( nullable = false, columnDefinition = "boolean default false")
	private boolean etat;
	
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation( User user, Event event) {
		super();
		
		this.user = user;
		this.event = event;
	}
	
	

	public Reservation(Event event, String civilite, String nom, String prenom, int age) {
		super();
		this.event = event;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public Long getId_reserv() {
		return id_reserv;
	}

	public void setId_reserv(Long id_reserv) {
		this.id_reserv = id_reserv;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	

	

}
