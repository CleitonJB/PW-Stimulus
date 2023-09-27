package com.stimulus.main.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@MappedSuperclass
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Column(name="date", insertable=false, updatable=false, columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp date;
	@NotNull
	@ManyToOne
    @JoinColumn(name = "user_id")
	private User user;
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
	
	public Timestamp getDate() {
		return this.date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
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