package com.stimulus.main.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comment {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
	private String message;
	@EmbeddedId
	private PostCommentPK fk_post;
	@EmbeddedId
	private CommentCounterPK fk_counters;
}