package com.stimulus.main.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PostCounterPK implements Serializable {
	private Long postId;
	private Long counterId;
}