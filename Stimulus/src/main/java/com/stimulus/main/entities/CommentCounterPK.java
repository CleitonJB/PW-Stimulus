package com.stimulus.main.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class CommentCounterPK implements Serializable {
	private Long commentId;
	private Long counterId;
}