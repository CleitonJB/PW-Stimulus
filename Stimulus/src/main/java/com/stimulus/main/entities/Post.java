package com.stimulus.main.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
	private String url_image;
	private String description;
	@EmbeddedId
	private PostCounterPK fk_counters;
	@EmbeddedId
	private PostCommentPK fk_comments;
}