package com.stimulus.main.entities;

import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Enumerated
	private PublicationTypes type;
	private int likes;
	private int comments;
	
	public Long getId() {
		return this.id;
	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	
	public PublicationTypes getType() {
		return this.type;
	}
	public void setType(PublicationTypes type) {
		this.type = type;
	}
	
	public int getLikes() {
		return this.likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public int getComments() {
		return this.comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
}