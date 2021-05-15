package com.projet.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "user")
public class Users {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private boolean enabled;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name ="users_roles", joinColumns = @JoinColumn (name="user_id"), inverseJoinColumns = @JoinColumn (name="role_id"))
	private Set<Role> roles=new HashSet<>();

	
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Users(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public Users() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	

	public boolean isEnabled() {
		return true;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	   public void addRole(Role role) {
	    	this.roles.add(role);
	    }

}

