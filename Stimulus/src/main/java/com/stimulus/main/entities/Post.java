package com.stimulus.main.entities;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Post extends Publication implements Serializable {
    @Valid
	@ElementCollection
	private Collection<Comment> commentsList;
    @NotBlank(message = "O campo 'url_image' informado está inválido.")
	private String url_image;
    @NotBlank(message = "O campo 'description' informado está inválido.")
	private String description;
	
	public Collection<Comment> getCommentsList() {
		return this.commentsList;
	}
	public void setCommentsList(Collection<Comment> commentsList) {
		this.commentsList = commentsList;
	}
	
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