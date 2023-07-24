package com.stimulus.main.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Counters {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
	@EmbeddedId
	private PostCounterPK fk_post;
	@EmbeddedId
	private CommentCounterPK fk_comment;
	private Integer c_likes;
	private Integer c_comments;
}