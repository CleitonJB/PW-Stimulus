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
	
	public Long getId() {
		return this.id;
	}
	
//	public void setId(Long id) {
//		this.id = id;
//	}
	
	public UserTypes getType() {
		return this.type;
	}
	
	public void setType(UserTypes type) {
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPicture() {
		return this.picture;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public String getWallpaper() {
		return this.wallpaper;
	}
	
	public void setWallpaper(String wallpaper) {
		this.wallpaper = wallpaper;
	}
	
	@Override
	public String toString() {
		return "User [id: " + id + ", type: " + type + ", name: " + name + ", username:" + username + ", email: " + email + ", picture: " + picture + ", wallpaper: " + wallpaper + "]";
	}
}