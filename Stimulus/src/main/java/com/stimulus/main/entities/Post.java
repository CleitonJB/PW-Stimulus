package com.stimulus.main.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post extends Publication implements Serializable  {
	private String url_image;
	private String description;
	
	public String getUrl_image() {
		return this.url_image;
	}
	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}