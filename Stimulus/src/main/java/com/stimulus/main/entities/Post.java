package com.stimulus.main.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String url_image;
	private String description;
	
	public Long getId() {
		return this.id;
	}
	
//	public void setId(Long id) {
//		this.id = id;
//	}
	
	public String getURLImage() {
		return url_image;
	}
	
	public void setURLImage(String url_image) {
		this.url_image = url_image;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}