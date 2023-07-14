package com.stimulus.main.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Enumerated
	private UserTypes type;
	private String name;
	private String username;
	private String email;
	private String password;
	private String picture;
	private String wallpaper;
	
	private User() {
	}
	
	public Long getId() {
		return this.id;
	}
	
	public UserTypes getType() {
		return this.type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPicture() {
		return this.picture;
	}
	
	public String getWallpaper() {
		return this.wallpaper;
	}
}