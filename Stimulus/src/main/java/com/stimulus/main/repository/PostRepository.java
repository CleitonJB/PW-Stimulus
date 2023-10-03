package com.stimulus.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stimulus.main.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>  {
}